/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
(function() {
  "use strict";

  // The chunk size of tailing the files, i.e., how many bytes will be shown
  // in the preview.
  var TAIL_CHUNK_SIZE = 32768;

  var server_url_head = 'http://10.10.90.111:50070';

  var current_directory = "";

  function show_err_msg(msg) {
    $('#alert-panel-body').html(msg);
    $('#alert-panel').show();
  }

  $(window).bind('hashchange', function () {
    $('#alert-panel').hide();

    var dir = window.location.hash.slice(1);
    if(dir == "") {
      dir = "/";
    }
    if(current_directory != dir) {

      browse_directory(dir);
    }
  });

  function network_error_handler(url) {
    return function (jqxhr, text, err) {
      switch(jqxhr.status) {
        case 401:
          var msg = '<p>Authentication failed when trying to open ' + url + ': Unauthorized.</p>';
          break;
        case 403:
          if(jqxhr.responseJSON !== undefined && jqxhr.responseJSON.RemoteException !== undefined) {
            var msg = '<p>' + jqxhr.responseJSON.RemoteException.message + "</p>";
            break;
          }
          var msg = '<p>Permission denied when trying to open ' + url + ': ' + err + '</p>';
          break;
        case 404:
          var msg = '<p>Path does not exist on HDFS or WebHDFS is disabled.  Please check your path or enable WebHDFS</p>';
          break;
        default:
          var msg = '<p>Failed to retrieve data from ' + url + ': ' + err + '</p>';
        }
      show_err_msg(msg);
    };
  }

  function append_path(prefix, s) {
    var l = prefix.length;
    var p = l > 0 && prefix[l - 1] == '/' ? prefix.substring(0, l - 1) : prefix;
    return p + '/' + s;
  }

  function get_response(data, type) {
    return data[type] !== undefined ? data[type] : null;
  }

  function get_response_err_msg(data) {
    return data.RemoteException !== undefined ? data.RemoteException.message : "";
  }

  function encode_path(abs_path) {
    abs_path = encodeURIComponent(abs_path);
    var re = /%2F/g;
    return abs_path.replace(re, '/');
  }
    /*
      当该类型为文件时，动态显示文件的属性和相关字段
      path:文件名称
      abs_path:文件在HDFS中的绝对路径
    */
  function view_file_details(path, abs_path) {

    /*file-info-blockinfo-list为该文件被划分成的物理块列表(block-list)*/
    function show_block_info(blocks) {
      var menus = $('#file-info-blockinfo-list');
      menus.empty();

      menus.data("blocks", blocks);
      menus.change(function() {
        var d = $(this).data('blocks')[$(this).val()];
        if (d === undefined) {
          return;
        }

        dust.render('block-info', d, function(err, out) {
          $('#file-info-blockinfo-body').html(out);
        });

      });

      for (var i = 0; i < blocks.length; ++i) {
        var item = $('<option value="' + i + '">Block ' + i + '</option>');
        menus.append(item);
      }

      menus.change();
    }

    abs_path = encode_path(abs_path);

    var url = server_url_head + '/webhdfs/v1' + abs_path + '?op=GET_BLOCK_LOCATIONS';

    $.get(url).done(function(data) {

      var d = get_response(data, "LocatedBlocks");
      if (d === null) {
        show_err_msg(get_response_err_msg(data));
        return;
      }

      $('#file-info-tail').hide();
      $('#file-info-title').text("File information - " + path);

      var download_url = server_url_head + '/webhdfs/v1' + abs_path + '?op=OPEN';

      $('#file-info-download').attr('href', download_url);

      /*查找文件末尾32K数据，并下载。该接口在HTML界面中注释了，暂时没开放该功能*/
      $('#file-info-preview').click(function() {
        var offset = d.fileLength - TAIL_CHUNK_SIZE;
        var url = offset > 0 ? download_url + '&offset=' + offset : download_url;
        $.get(url, function(t) {
          $('#file-info-preview-body').val(t);
          $('#file-info-tail').show();
        }, "text").error(network_error_handler(url));
      });

      /*
        如果文件大小大于0:
        1、显示block list 通过  show_block_info
        2、$('#file-info').modal()
      */
      if (d.fileLength > 0) {
        show_block_info(d.locatedBlocks);
        $('#file-info-blockinfo-panel').show();
      } else {
        $('#file-info-blockinfo-panel').hide();
      }
      $('#file-info').modal();
    }).error(network_error_handler(url));
  }


  /*每次上传HDFS都会调用upload_file函数*/
  function upload_file(dst_dir,src_file) {

    console.log(dst_dir);
    console.log(src_file);

    var file_name = "user/hadoop/test.xml";
    var abs_path = append_path(dst_dir, file_name);
    abs_path = encode_path(abs_path);
    var upload_url = server_url_head + '/webhdfs/v1' + abs_path + '?user.name=hadoop&op=CREATE';
    //var upload_url = server_url_head + '/webhdfs/v1/user/hadoop/images/test.tif?op=GET_BLOCK_LOCATIONS';
    console.log(upload_url);

    $.ajax({
      type: 'PUT',
      url: upload_url ,
      //dataType: "jsonp",
      //contentType: 'application/octet-stream',
      headers : {'Access-Control-Allow-Origin':'*'},
      success: function(data, status, xhr){
        console.log(xhr.getResponseHeader("Content-Type"));
        console.log(xhr.getResponseHeader("Location"));
        console.log(data);
        console.log(upload_url);
      },
      error: function(data, status, xhr){

        //console.log(xhr.getResponseHeader("Content-Type"));
        //console.log(xhr.getResponseHeader("Location"));
        console.log(data);
        console.log(upload_url);
        alert(2);
      }
    });


    //$.get(upload_url).done(function(data) {
    //  console.log(data);
   // }).error(network_error_handler(url));


  }
  /*每次检索HDFS都会调用browse_directory函数*/
  function browse_directory(dir) {

    var HELPERS = {
      'helper_date_tostring' : function (chunk, ctx, bodies, params) {
        var value = dust.helpers.tap(params.value, chunk, ctx);
        return chunk.write('' + new Date(Number(value)).toLocaleString());
      }
    };
    console.log(HELPERS);
    var url = server_url_head + '/webhdfs/v1' + encode_path(dir) + '?op=LISTSTATUS';
    $.get(url, function(data) {
      var d = get_response(data, "FileStatuses");
      if (d === null) {
        console.log("error");
        show_err_msg(get_response_err_msg(data));
        return;
      }
      console.log(data);
      console.log(d);
      current_directory = dir;
      $('#directory').val(dir);
      window.location.hash = dir;
      var base = dust.makeBase(HELPERS);
      dust.render('explorer', base.push(d), function(err, out) {   //此处解析jason字符串并生成界面显示信息，提交html.out
        console.log(out);
        $('#panel').html(out);

        $('.explorer-browse-links').click(function() {
          var type = $(this).attr('inode-type');
          var path = $(this).attr('inode-path');
          var abs_path = append_path(current_directory, path);
          if (type == 'DIRECTORY') {
            browse_directory(abs_path);
          } else {
            view_file_details(path, abs_path);
          }
        });
      });
    }).error(network_error_handler(url));
  }

  function init() {

    dust.loadSource(dust.compile($('#tmpl-explorer').html(), 'explorer'));
    dust.loadSource(dust.compile($('#tmpl-block-info').html(), 'block-info'));

    /*为查询按钮绑定了一个事件,事件的响应函数为b */
    var b = function() { browse_directory($('#directory').val()); };
    $('#btn-nav-directory').click(b);

    /*为上传按钮绑定了一个事件,事件的响应函数为b */
    //var c = function() { upload_file($('#upload-directory').val(),"F:\\wangty\\workspace\\hadoop\\pom.xml"); };
    //$('#btn-upload-directory').click(c);


    var dir = window.location.hash.slice(1);
    if(dir == "") {
      window.location.hash = "/";
    } else {
      /*界面HTML初始化调用一次，不是每次点击查询都会调用此处的代码*/
      browse_directory(dir);
    }
  }

  init();
})();


