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


  var TAIL_CHUNK_SIZE = 32768;

  var server_url_head = 'http://10.10.90.111:50070';

  var current_directory = "";
  var current_file_name = "";

  function show_err_msg(msg) {
    $('#alert-panel-body').html(msg);
    $('#alert-panel').show();
  }

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

  function browse_directory(dir) {

    var HELPERS = {
      'helper_date_tostring' : function (chunk, ctx, bodies, params) {
        var value = dust.helpers.tap(params.value, chunk, ctx);
        return chunk.write('' + new Date(Number(value)).toLocaleString());
      }
    };
    var url = server_url_head + '/webhdfs/v1' + encode_path(dir) + '?op=LISTSTATUS';
    $.get(url, function(data) {
      var d = get_response(data, "FileStatuses");
      if (d === null) {
        console.log("error");
        show_err_msg(get_response_err_msg(data));
        return;
      }
      console.log(data);
      current_directory = dir;
      $('#directory').val(dir);
      window.location.hash = dir;
      var base = dust.makeBase(HELPERS);
      dust.render('explorer', base.push(d), function(err, out) {
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

  function file_info_collect(){

    console.log(current_file_name);    //本地图片名称

    if (!current_file_name){
      alert('请先选择要上传的图片，并点击上传按钮！');
      return ;
    }


    $.ajax({
      type: "POST",
      url: "/FileInfoSubmit/SubmitAction.htmls",
      data: {
        "uploadFileName": current_file_name,  //.split("\\")[2]
        "uploadDirectory": $('#upload-directory').val(),
        "fileType": $('#file-type-list').val(),
        "typeAttr" : $('#type-attr-list').val(),
        "introduceContent": $('#introduceContent').val(),
      },
      dataType: "json",
      success: function (data) {
        if(data.result == "success") {
          console.log("success");
          layer.msg("上传成功");
          setTimeout("window.location.href='fileupload.jsp'", 3000);
          //alert("上传成功");
          //window.location.href="fileupload.jsp";
        }else {
          console.log("failed");
          layer.alert("上传失败");
          //alert("上传失败");
        }
      }
    });
  }

  function file_upload(){
    var formData = new FormData($( "#form-file-upload" )[0]);

    $.ajax({
      type: "POST",
      url: "/FileUpload",
      enctype: 'multipart/form-data',
      dataType:'json',
      data : formData,
      async: false,
      cache: false,
      contentType: false,
      processData: false,
    });

  }

  function initWebLoader(){
    var $ = jQuery,
        $list = $('#thelist'),
        $btn = $('#ctlBtn'),
        state = 'pending',
        uploader;
    var thumbnailWidth = 100;
    var thumbnailHeight = 100;
    uploader = WebUploader.create({
      //auto : true,
      resize: false,
      swf: '/resources/js/webuploader/Uploader.swf',
      server: '/FileUpload',
      pick: '#picker',
      accept: {
        title: 'Images',
        extensions: 'gif,jpg,jpeg,bmp,png,tif',
        mimeTypes: 'image/*'
      }
    });

    uploader.on( 'fileQueued', function( file ) {
      $list.append( '<div id="' + file.id + '" class="item">' +
          '<h4 class="info">' + file.name + '</h4>' +
          '<p class="state">等待上传...</p>' +
          '</div>' );
      current_file_name = file.name;
    });

    uploader.on( 'uploadProgress', function( file, percentage ) {
      var $li = $( '#'+file.id ),
          $percent = $li.find('.progress .progress-bar');


      if ( !$percent.length ) {
        $percent = $('<div class="progress progress-striped active">' +
            '<div class="progress-bar" role="progressbar" style="width: 0%">' +
            '</div>' +
            '</div>').appendTo( $li ).find('.progress-bar');
      }

      $li.find('p.state').text('上传中...');

      $percent.css( 'width', percentage * 100 + '%' );
    });

    uploader.on( 'uploadSuccess', function( file ) {
      $( '#'+file.id ).find('p.state').text('上传成功');
    });

    uploader.on( 'uploadError', function( file ) {
      $( '#'+file.id ).find('p.state').text('上传出错');
    });

    uploader.on( 'uploadComplete', function( file ) {
      $( '#'+file.id ).find('.progress').fadeOut();
    });

    uploader.on( 'all', function( type ) {
      if ( type === 'startUpload' ) {
        state = 'uploading';
      } else if ( type === 'stopUpload' ) {
        state = 'paused';
      } else if ( type === 'uploadFinished' ) {
        state = 'done';
      }

      if ( state === 'uploading' ) {
        $btn.text('上传中');
      } else {
        $btn.text('开始上传');
      }
    });

    $btn.on( 'click', function() {
      if ( state === 'uploading' ) {
        uploader.stop();
      } else {
        uploader.upload();
      }
    });
  }

  function init() {

    /*为文件上传按钮绑定了一个事件,事件的响应函数为b */
    //var a = function() { file_upload(); };
    //$('#btn-file-upload').click(a);

    /*为文件信息上传按钮绑定了一个事件,事件的响应函数为b */
    var b = function() { file_info_collect(); };
    $('#btn-file-info-submit').click(b);

    //初始化文件上传模块
    initWebLoader();
  }

  init();
})();


