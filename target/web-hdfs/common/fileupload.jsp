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
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/radioAndCheckBox/radioAndCheckBox.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/hadoop.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/webuploader.css">

    <link rel="stylesheet" type="text/css" href="/resources/css/select/combo.select.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/calendar/calendar.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/appModify.css"/>
    <title>浏览HDFS</title>

</head>
<body>

<header class="navbar navbar-inverse bs-docs-nav" role="banner">
    <div class="container">
        <div class="navbar-header">
            <div class="navbar-brand">Hadoop</div>
        </div>
        <ul class="nav navbar-nav" id="ui-tabs">
            <li><a href="dfshealth.jsp#tab-overview">概述</a></li>
            <li><a href="dfshealth.jsp#tab-datanode">数据节点</a></li>
            <li><a href="dfshealth.jsp#tab-snapshot">快照</a></li>
            <li><a href="dfshealth.jsp#tab-startup-progress">启动过程</a></li>
            <li><a href="explorer.jsp">HDFS文件系统</a></li>
            <li><a href="logs">日志</a></li>
            <li class="dropdown">
                <a href="##" class="dropdown-toggle" data-toggle="dropdown">文件上传<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="fileupload-group.jsp">单一文件上传</a></li>
                    <li><a href="fileupload.jsp">多组文件上传</a></li>
                </ul>
            </li>
        </ul>
    </div>
</header>
<div class="container">
    <div class="page-header">
        <h1>图像上传</h1>
        <p>1、支持图像类型格式包括:gif,jpg,jpeg,bmp,png,tif。</p>
        <p>2、请先选择要上传的图像，并点击开始上传；随后填写下方表单。</p>
        <p>3、界面提示上传成功后，方可提交表单信息。</p>
        <p>4、成组上传+单一图片上传。</p>
        <p>5、每次操作只可以上传一张图像。</p>
    </div>
    <%--<button id="add">克隆</button>--%>

    <div id="uploader" class="wu-example">
        <!--用来存放文件信息-->
        <p class="necessary">*</p>
        <p class="title">图像上传</p>
        <div class="clearfix"></div>
        <div id="thelist" class="uploader-list"></div>
        <div class="btns">
            <div id="picker" style="clear:left;float:left">选择图像</div>
            <button id="ctlBtn" class="btn btn-default"style="float:left;margin-left:20px;height:40px;width:85px">开始上传</button>
        </div>
        <div id="addRadio" style="clear: left;margin-top:20px;">

        </div>
    </div>
    <div id="addNew" style="float: left">
        <div id="chineseName" class="input-group" style="clear :left">
            <p class="necessary">*</p>
            <p id="chineseNameTitle" class="title">图片名称</p>



            <div class="clearfix"></div>
            <input id="chineseNameContent" type="text" class="form-control"
                   value=""style="width: 170px"
                   placeholder="2到20个字节之间，一个中文占两个字节" maxlength="32"/>
        </div>
        <div class="clearfix"></div>

        <div id="category">
            <p class="necessary">*</p>
            <p id="categoryTitle" class="title">图像类型</p>

            <div class="clearfix"></div>
            <select id="file-type-list" class="form-control" style="width:180px;" onclick="setTypeAttrSelect()">
                <option value="Daily">每日一图</option>
                <option value="Standard">标准产品</option>
                <option value="Advanced">高级产品</option>
                <option value="Others">其他</option>
            </select>
            <p class="necessary">*</p>
            <p id="categoryTitle" class="title">图像类型扩展字段</p>

            <div class="clearfix"></div>
            <select id="type-attr-list" class="form-control" style="width:180px;">
                <option value="Default">请优先选择图片分类</option>
            </select>

        </div>

        <div id="introduce" class="input-group">
            <p class="necessary">*</p>
            <p id="introduceTitle" class="title">图像介绍(若有)</p>

            <div class="clearfix"></div>
            <textarea id="introduceContent" type="text" class="form-control" style="width: 170px"
                      placeholder="最多500个字..." maxlength="500"></textarea>
        </div>
        <div class="clearfix"></div>

        <div class="input-group">
            <p class="necessary">*</p>
            <p id="imageRemotePath" class="title">图像存储路径</p></br>

            <input type="text" class="form-control" value="/user/hadoop/uploadFiles" id="upload-directory" style="width: 170px"/>
        </div>
        <div class="clearfix"></div>
    </div>
    <div id="addNew1"style="float: left;margin-left:20px" >
        <div id="chineseName1" class="input-group" style="clear :left">
            <p class="necessary">*</p>
            <p id="chineseNameTitle1" class="title">图片名称</p>

            <div class="clearfix"></div>
            <input id="chineseNameContent1" type="text" class="form-control"
                   value="" style="width: 170px"
                   placeholder="2到20个字节之间，一个中文占两个字节" maxlength="32"/>
        </div>
        <div class="clearfix"></div>

        <div id="category1">
            <p class="necessary">*</p>
            <p id="categoryTitle1" class="title">图像类型</p>

            <div class="clearfix"></div>
            <select id="file-type-list1" class="form-control" style="width:180px;" onclick="setTypeAttrSelect1()">
                <option value="Daily">每日一图</option>
                <option value="Standard">标准产品</option>
                <option value="Advanced">高级产品</option>
                <option value="Others">其他</option>
            </select>
            <p class="necessary">*</p>
            <p id="categoryTitle1" class="title">图像类型扩展字段</p>

            <div class="clearfix"></div>
            <select id="type-attr-list1" class="form-control" style="width:180px;">
                <option value="Default">请优先选择图片分类</option>
            </select>

        </div>

        <div id="introduce1" class="input-group">
            <p class="necessary">*</p>
            <p id="introduceTitle1" class="title">图像介绍(若有)</p>

            <div class="clearfix"></div>
            <textarea id="introduceContent1" type="text" class="form-control" style="width: 170px"
                      placeholder="最多500个字..." maxlength="500"></textarea>
        </div>
        <div class="clearfix"></div>

        <br class="input-group">
        <p class="necessary">*</p>
        <p id="imageRemotePath1" class="title">图像存储路径</p></br>

        <input type="text" class="form-control" value="/user/hadoop/uploadFiles" id="upload-directory1"style="width: 170px" />
    </div>
    <div id="addNew2"style="float: left;margin-left:20px" >
        <div id="chineseName2" class="input-group" style="clear :left">
            <p class="necessary">*</p>
            <p id="chineseNameTitle2" class="title">图片名称</p>

            <div class="clearfix"></div>
            <input id="chineseNameContent2" type="text" class="form-control"
                   value="" style="width: 170px"
                   placeholder="2到20个字节之间，一个中文占两个字节" maxlength="32"/>
        </div>
        <div class="clearfix"></div>

        <div id="category2">
            <p class="necessary">*</p>
            <p id="categoryTitle2" class="title">图像类型</p>

            <div class="clearfix"></div>
            <select id="file-type-list2" class="form-control" style="width:180px;" onclick="setTypeAttrSelect2()">
                <option value="Daily">每日一图</option>
                <option value="Standard">标准产品</option>
                <option value="Advanced">高级产品</option>
                <option value="Others">其他</option>
            </select>
            <p class="necessary">*</p>
            <p id="categoryTitle2" class="title">图像类型扩展字段</p>

            <div class="clearfix"></div>
            <select id="type-attr-list2" class="form-control" style="width:180px;">
                <option value="Default">请优先选择图片分类</option>
            </select>

        </div>

        <div id="introduce2" class="input-group">
            <p class="necessary">*</p>
            <p id="introduceTitle2" class="title">图像介绍(若有)</p>

            <div class="clearfix"></div>
            <textarea id="introduceContent2" type="text" class="form-control" style="width: 170px"
                      placeholder="最多500个字..." maxlength="500"></textarea>
        </div>
        <div class="clearfix"></div>

        <br class="input-group">
        <p class="necessary">*</p>
        <p id="imageRemotePath2" class="title">图像存储路径</p></br>

        <input type="text" class="form-control" value="/user/hadoop/uploadFiles" id="upload-directory2"style="width: 170px" />
    </div>
    <div id="addNew3"style="float: left;margin-left:20px" >
        <div id="chineseName3" class="input-group" style="clear :left">
            <p class="necessary">*</p>
            <p id="chineseNameTitle3" class="title">图片名称</p>

            <div class="clearfix"></div>
            <input id="chineseNameContent3" type="text" class="form-control"
                   value="" style="width: 170px"
                   placeholder="2到20个字节之间，一个中文占两个字节" maxlength="32"/>
        </div>
        <div class="clearfix"></div>

        <div id="category3">
            <p class="necessary">*</p>
            <p id="categoryTitle3" class="title">图像类型</p>

            <div class="clearfix"></div>
            <select id="file-type-list3" class="form-control" style="width:180px;" onclick="setTypeAttrSelect3()">
                <option value="Daily">每日一图</option>
                <option value="Standard">标准产品</option>
                <option value="Advanced">高级产品</option>
                <option value="Others">其他</option>
            </select>
            <p class="necessary">*</p>
            <p id="categoryTitle3" class="title">图像类型扩展字段</p>

            <div class="clearfix"></div>
            <select id="type-attr-list3" class="form-control" style="width:180px;">
                <option value="Default">请优先选择图片分类</option>
            </select>

        </div>

        <div id="introduce3" class="input-group">
            <p class="necessary">*</p>
            <p id="introduceTitle3" class="title">图像介绍(若有)</p>

            <div class="clearfix"></div>
            <textarea id="introduceContent3" type="text" class="form-control" style="width: 170px"
                      placeholder="最多500个字..." maxlength="500"></textarea>
        </div>
        <div class="clearfix"></div>

        <br class="input-group">
        <p class="necessary">*</p>
        <p id="imageRemotePath3" class="title">图像存储路径</p></br>

        <input type="text" class="form-control" value="/user/hadoop/uploadFiles" id="upload-directory3"style="width: 170px" />
    </div>
    <div id="addNew4"style="float: left;margin-left:20px" >
        <div id="chineseName4" class="input-group" style="clear :left">
            <p class="necessary">*</p>
            <p id="chineseNameTitle4" class="title">图片名称</p>

            <div class="clearfix"></div>
            <input id="chineseNameContent4" type="text" class="form-control"
                   value="" style="width: 170px"
                   placeholder="2到20个字节之间，一个中文占两个字节" maxlength="32"/>
        </div>
        <div class="clearfix"></div>

        <div id="category4">
            <p class="necessary">*</p>
            <p id="categoryTitle4" class="title">图像类型</p>

            <div class="clearfix"></div>
            <select id="file-type-list4" class="form-control" style="width:180px;" onclick="setTypeAttrSelect4()">
                <option value="Daily">每日一图</option>
                <option value="Standard">标准产品</option>
                <option value="Advanced">高级产品</option>
                <option value="Others">其他</option>
            </select>
            <p class="necessary">*</p>
            <p id="categoryTitle4" class="title">图像类型扩展字段</p></br>

            <div class="clearfix"></div>
            <select id="type-attr-list4" class="form-control" style="width:180px;">
                <option value="Default">请优先选择图片分类</option>
            </select>

        </div>

        <div id="introduce4" class="input-group">
            <p class="necessary">*</p>
            <p id="introduceTitle4" class="title">图像介绍(若有)</p>
            <div class="clearfix"></div>
            <textarea id="introduceContent4" type="text" class="form-control" style="width: 170px"
                      placeholder="最多500个字..." maxlength="500"></textarea>
        </div>
        <div class="clearfix"></div>

        <br class="input-group">
        <p class="necessary">*</p>
        <p id="imageRemotePath4" class="title">图像存储路径</p></br>

        <input type="text" class="form-control" value="/user/hadoop/uploadFiles" id="upload-directory4"style="width: 170px" />
    </div>
    <div class="clearfix"></div>
</div>
<div id="stepOneOperationButton"style="clear: left">
    <button class="btn btn-default" onclick="" id="btn-file-info-submit">提交表单</button>
</div>


<div class="row">
    <hr />
    <div class="col-xs-2"><p>Hadoop, 2016.</p></div>
</div>
</div>

<script type="text/javascript" src="/resources/js/static/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/resources/js/webuploader/webuploader.js"></script>
<script type="text/javascript" src="/resources/js/static/bootstrap-3.0.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/static/dust-full-2.0.0.min.js"></script>
<script type="text/javascript" src="/resources/js/static/dust-helpers-1.1.1.min.js"></script>
<script type="text/javascript" src="/resources/js/static/dfs-dust.js"></script>
<script type="text/javascript" src="/resources/js/static/jquery.form.min.js"></script>
<script type="text/javascript" src="/resources/js/layer/layer.js"></script>
<script type="text/javascript" src="/resources/js/fileuploadgroup.js"></script>
<script type="text/javascript" src="/resources/js/radioAndCheckBox.js"></script>
<script type="text/javascript" >
    function setTypeAttrSelect(){
        var operation = document.getElementById("file-type-list");
        var index = operation.selectedIndex;
        var imageType = operation.options[index].value;
        if (imageType == 'Daily') {
            $("#type-attr-list").empty();
            $("#type-attr-list").append("<option value='nongye'>农业</option>");
            $("#type-attr-list").append("<option value='linye'>林业</option>");
            $("#type-attr-list").append("<option value='chengshi'>城市</option>");
            $("#type-attr-list").append("<option value='Others'>其他</option>");
        }
        if (imageType == 'Standard') {
            $("#type-attr-list").empty();
            $("#type-attr-list").append("<option value='nongye'>标准1</option>");
            $("#type-attr-list").append("<option value='linye'>标准2</option>");
            $("#type-attr-list").append("<option value='chengshi'>标准3</option>");
            $("#type-attr-list").append("<option value='Others'>标准4</option>");
        }
        if (imageType == 'Advanced') {
            $("#type-attr-list").empty();
            $("#type-attr-list").append("<option value='nongye'>高级1</option>");
            $("#type-attr-list").append("<option value='linye'>高级2</option>");
            $("#type-attr-list").append("<option value='chengshi'>高级3</option>");
            $("#type-attr-list").append("<option value='Others'>高级4</option>");
        }
        if (imageType == 'Others') {
            $("#type-attr-list").empty();
            $("#type-attr-list").append("<option value='nongye'>其他1</option>");
            $("#type-attr-list").append("<option value='linye'>其他2</option>");
            $("#type-attr-list").append("<option value='chengshi'>其他3</option>");
            $("#type-attr-list").append("<option value='Others'>其他4</option>");
        }

    }     //根据用户选择的图片类型动态加载类型扩展字段
    function setTypeAttrSelect1(){
        var operation = document.getElementById("file-type-list1");
        var index = operation.selectedIndex;
        var imageType = operation.options[index].value;
        if (imageType == 'Daily') {
            $("#type-attr-list1").empty();
            $("#type-attr-list1").append("<option value='nongye'>农业</option>");
            $("#type-attr-list1").append("<option value='linye'>林业</option>");
            $("#type-attr-list").append("<option value='chengshi'>城市</option>");
            $("#type-attr-list").append("<option value='Others'>其他</option>");
        }
        if (imageType == 'Standard') {
            $("#type-attr-list1").empty();
            $("#type-attr-list1").append("<option value='nongye'>标准1</option>");
            $("#type-attr-list1").append("<option value='linye'>标准2</option>");
            $("#type-attr-list1").append("<option value='chengshi'>标准3</option>");
            $("#type-attr-list1").append("<option value='Others'>标准4</option>");
        }
        if (imageType == 'Advanced') {
            $("#type-attr-list1").empty();
            $("#type-attr-list1").append("<option value='nongye'>高级1</option>");
            $("#type-attr-list1").append("<option value='linye'>高级2</option>");
            $("#type-attr-list1").append("<option value='chengshi'>高级3</option>");
            $("#type-attr-list1").append("<option value='Others'>高级4</option>");
        }
        if (imageType == 'Others') {
            $("#type-attr-list1").empty();
            $("#type-attr-list1").append("<option value='nongye'>其他1</option>");
            $("#type-attr-list1").append("<option value='linye'>其他2</option>");
            $("#type-attr-list1").append("<option value='chengshi'>其他3</option>");
            $("#type-attr-list1").append("<option value='Others'>其他4</option>");
        }

    }     //根据用户选择的图片类型动态加载类型扩展字段
    function setTypeAttrSelect2(){
        var operation = document.getElementById("file-type-list2");
        var index = operation.selectedIndex;
        var imageType = operation.options[index].value;
        if (imageType == 'Daily') {
            $("#type-attr-list2").empty();
            $("#type-attr-list2").append("<option value='nongye'>农业</option>");
            $("#type-attr-list2").append("<option value='linye'>林业</option>");
            $("#type-attr-list2").append("<option value='chengshi'>城市</option>");
            $("#type-attr-list2").append("<option value='Others'>其他</option>");
        }
        if (imageType == 'Standard') {
            $("#type-attr-list2").empty();
            $("#type-attr-list2").append("<option value='nongye'>标准1</option>");
            $("#type-attr-list2").append("<option value='linye'>标准2</option>");
            $("#type-attr-list2").append("<option value='chengshi'>标准3</option>");
            $("#type-attr-list2").append("<option value='Others'>标准4</option>");
        }
        if (imageType == 'Advanced') {
            $("#type-attr-list2").empty();
            $("#type-attr-list2").append("<option value='nongye'>高级1</option>");
            $("#type-attr-list2").append("<option value='linye'>高级2</option>");
            $("#type-attr-list2").append("<option value='chengshi'>高级3</option>");
            $("#type-attr-list2").append("<option value='Others'>高级4</option>");
        }
        if (imageType == 'Others') {
            $("#type-attr-list2").empty();
            $("#type-attr-list2").append("<option value='nongye'>其他1</option>");
            $("#type-attr-list2").append("<option value='linye'>其他2</option>");
            $("#type-attr-list2").append("<option value='chengshi'>其他3</option>");
            $("#type-attr-list2").append("<option value='Others'>其他4</option>");
        }

    }     //根据用户选择的图片类型动态加载类型扩展字段
    function setTypeAttrSelect3(){
        var operation = document.getElementById("file-type-list3");
        var index = operation.selectedIndex;
        var imageType = operation.options[index].value;
        if (imageType == 'Daily') {
            $("#type-attr-list3").empty();
            $("#type-attr-list3").append("<option value='nongye'>农业</option>");
            $("#type-attr-list3").append("<option value='linye'>林业</option>");
            $("#type-attr-list3").append("<option value='chengshi'>城市</option>");
            $("#type-attr-list3").append("<option value='Others'>其他</option>");
        }
        if (imageType == 'Standard') {
            $("#type-attr-list3").empty();
            $("#type-attr-list3").append("<option value='nongye'>标准1</option>");
            $("#type-attr-list3").append("<option value='linye'>标准2</option>");
            $("#type-attr-list3").append("<option value='chengshi'>标准3</option>");
            $("#type-attr-list3").append("<option value='Others'>标准4</option>");
        }
        if (imageType == 'Advanced') {
            $("#type-attr-list3").empty();
            $("#type-attr-list3").append("<option value='nongye'>高级1</option>");
            $("#type-attr-list3").append("<option value='linye'>高级2</option>");
            $("#type-attr-list3").append("<option value='chengshi'>高级3</option>");
            $("#type-attr-list3").append("<option value='Others'>高级4</option>");
        }
        if (imageType == 'Others') {
            $("#type-attr-list3").empty();
            $("#type-attr-list3").append("<option value='nongye'>其他1</option>");
            $("#type-attr-list3").append("<option value='linye'>其他2</option>");
            $("#type-attr-list3").append("<option value='chengshi'>其他3</option>");
            $("#type-attr-list3").append("<option value='Others'>其他4</option>");
        }

    }     //根据用户选择的图片类型动态加载类型扩展字段
    function setTypeAttrSelect4(){
        var operation = document.getElementById("file-type-list4");
        var index = operation.selectedIndex;
        var imageType = operation.options[index].value;
        if (imageType == 'Daily') {
            $("#type-attr-list4").empty();
            $("#type-attr-list4").append("<option value='nongye'>农业</option>");
            $("#type-attr-list4").append("<option value='linye'>林业</option>");
            $("#type-attr-list4").append("<option value='chengshi'>城市</option>");
            $("#type-attr-list4").append("<option value='Others'>其他</option>");
        }
        if (imageType == 'Standard') {
            $("#type-attr-list4").empty();
            $("#type-attr-list4").append("<option value='nongye'>标准1</option>");
            $("#type-attr-list4").append("<option value='linye'>标准2</option>");
            $("#type-attr-list4").append("<option value='chengshi'>标准3</option>");
            $("#type-attr-list4").append("<option value='Others'>标准4</option>");
        }
        if (imageType == 'Advanced') {
            $("#type-attr-list4").empty();
            $("#type-attr-list4").append("<option value='nongye'>高级1</option>");
            $("#type-attr-list4").append("<option value='linye'>高级2</option>");
            $("#type-attr-list4").append("<option value='chengshi'>高级3</option>");
            $("#type-attr-list4").append("<option value='Others'>高级4</option>");
        }
        if (imageType == 'Others') {
            $("#type-attr-list4").empty();
            $("#type-attr-list4").append("<option value='nongye'>其他1</option>");
            $("#type-attr-list4").append("<option value='linye'>其他2</option>");
            $("#type-attr-list4").append("<option value='chengshi'>其他3</option>");
            $("#type-attr-list4").append("<option value='Others'>其他4</option>");
        }

    }     //根据用户选择的图片类型动态加载类型扩展字段

    $(document).ready(function(){

        $("#addNew1").hide();
        $("#addNew2").hide();
        $("#addNew3").hide();
        $("#addNew4").hide();


    });
</script>

</body>
</html>
