<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
  -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <link rel="stylesheet" type="text/css" href="/resources/js/bootstrap-3.0.2/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/js/hadoop.css" />
    <title>Browsing HDFS</title>
</head>
<body>

<header class="navbar navbar-inverse bs-docs-nav" role="banner">
    <div class="container">
        <div class="navbar-header">
            <div class="navbar-brand">WEB-HDFS</div>
        </div>

        <ul class="nav navbar-nav" id="ui-tabs">
            <li><a href="dfshealth.jsp#tab-overview">概述</a></li>
            <li><a href="dfshealth.jsp#tab-datanode">数据节点</a></li>
            <li><a href="dfshealth.jsp#tab-snapshot">快照</a></li>
            <li><a href="dfshealth.jsp#tab-startup-progress">启动过程</a></li>
            <li><a href="explorer.jsp">HDFS文件系统</a></li>
            <li><a href="logs">日志</a></li>
            <li><a href="fileupload.jsp">文件上传</a></li>
        </ul>
    </div>
</header>

<div class="modal" id="file-info" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="file-info-title">文件信息</h4>
            </div>
            <div class="modal-body" id="file-info-body">
                <a id="file-info-download">下载</a>
                <!--<a id="file-info-preview" style="cursor:pointer">Tail the file (last 32K)</a>-->
                <hr />
                <div class="panel panel-success" id="file-info-blockinfo-panel">
                    <div class="panel-heading">
                        块信息 --
                        <select class="btn btn-default" id="file-info-blockinfo-list">
                        </select>
                    </div>
                    <div class="panel-body" id="file-info-blockinfo-body"></div>
                </div>
                <div class="panel panel-info" id="file-info-tail" style="display:none">
                    <div class="panel-heading">文件内容</div>
                    <div class="panel-body">
                        <div class="input-group-sm">
                            <textarea class="form-control" style="height: 150px" id="file-info-preview-body"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer"><button type="button" class="btn btn-success"
                                              data-dismiss="modal">关闭</button></div>
        </div>
    </div>
</div>
<div class="container">
    <div class="page-header">
        <h1>浏览目录</h1>
    </div>
    <div class="alert alert-danger" id="alert-panel" style="display:none">
        <button type="button" class="close" onclick="$('#alert-panel').hide();">&times;</button>
        <div class="alert-body" id="alert-panel-body"></div>
    </div>
    <div class="row">
        <form onsubmit="return false;">
            <div class="input-group">
                <input type="text" class="form-control" id="directory" />
                <span class="input-group-btn">
              <button class="btn btn-default" type="submit" id="btn-nav-directory">
                  <span class="input-group-btn">查询</span>
              </button>
          </span>
            </div>
            <!--</form>-->
            <!--action="simpleFileupload"-->
            <!--<form  action="FileUpload" method="post" enctype="multipart/form-data">-->
            <!--<div class="input-group">-->
            <!--<h3>Local File Path</h3>-->
            <!--<input type="file" name="fileupload" value="/home" id="upload-file-name"/>-->
            <!--<h3>Remote File Path</h3>-->
            <!--<input type="text" class="form-control" value="/" id="upload-directory" />-->
            <!--<span class="input-group-btn">-->
            <!--<button class="btn btn-default" type="submit" id="btn-upload-directory">-->
            <!--<span class="input-group-btn">Upload!</span>-->
            <!--</button>-->
            <!--</span>-->
            <!--</div>-->
            <!--</form>-->

    </div>
    <br />
    <div id="panel"></div>


    <div class="row">
        <hr />
        <div class="col-xs-2"><p>Hadoop, 2016.</p></div>
    </div>

</div>

<script type="text/x-dust-template" id="tmpl-explorer">
    <table class="table">
        <thead>
        <tr>
            <th>权限</th>
            <th>所有者</th>
            <th>组</th>
            <th>大小</th>
            <th>最后修改</th>
            <th>副本数量</th>
            <th>块大小</th>
            <th>名称</th>
        </tr>
        </thead>
        <tbody>
        {#FileStatus}
        <tr>
            <td>{type|helper_to_directory}{permission|helper_to_permission}{aclBit|helper_to_acl_bit}</td>
            <td>{owner}</td>
            <td>{group}</td>
            <td>{length|fmt_bytes}</td>
            <td>{#helper_date_tostring value="{modificationTime}"/}</td>
            <td>{replication}</td>
            <td>{blockSize|fmt_bytes}</td>
            <td><a style="cursor:pointer" inode-type="{type}" class="explorer-browse-links" inode-path="{pathSuffix}">{pathSuffix}</a></td>
        </tr>
        {/FileStatus}
        </tbody>
    </table>
</script>

<script type="text/x-dust-template" id="tmpl-block-info">
    {#block}
    <p>Block ID: {blockId}</p>
    <p>Block Pool ID: {blockPoolId}</p>
    <p>Generation Stamp: {generationStamp}</p>
    <p>Size: {numBytes}</p>
    {/block}
    <p>Availability:
    <ul>
        {#locations}
        <li>{hostName}</li>
        {/locations}
    </ul>
    </p>
</script>
<script type="text/javascript" src="/resources/js/jquery-1.10.2.min.js">
</script><script type="text/javascript" src="/resources/js/bootstrap-3.0.2/js/bootstrap.min.js">
</script><script type="text/javascript" src="/resources/js/dust-full-2.0.0.min.js">
</script><script type="text/javascript" src="/resources/js/dust-helpers-1.1.1.min.js">
</script><script type="text/javascript" src="/resources/js/dfs-dust.js">
</script><script type="text/javascript" src="/resources/js/explorer.js">
</script>
</body>
</html>
