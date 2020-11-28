<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>我的商城-商品管理</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="/static/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" href="/static/plugins/dropzone/dropzone.css" type="text/css"/>
    <link rel="stylesheet" href="/static/plugins/dropzone/min/basic.min.css" type="text/css"/>
    <link rel="stylesheet" href="/static/plugins/wangEditor/wangEditor.min.css" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                商品管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${cake.id == null? "新增": "编辑"}商品</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form cssClass="form-horizontal" action="/cake/save" method="post" modelAttribute="cake">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">父级类目</label>
                                    <div class="col-sm-10">
                                        <form:hidden id="categoryId" path="cakeCategory.id"/>
                                        <input id="categoryName" class="form-control require" placeholder="请选择" readonly="true" data-toggle="modal" data-target="#modal-default" value="${cake.cakeCategory.name}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="cakeName" class="col-sm-2 control-label">商品名称</label>

                                    <div class="col-sm-10">
                                        <form:input path="cakeName" cssClass="form-control required" placeholder="商品名称"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="cakeTaste" class="col-sm-2 control-label">口味</label>

                                    <div class="col-sm-10">
                                        <form:input path="cakeTaste" cssClass="form-control required" placeholder="商品口味"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="price" class="col-sm-2 control-label">价格</label>

                                    <div class="col-sm-10">
                                        <form:input path="price" cssClass="form-control required" placeholder="商品价格"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="url" class="col-sm-2 control-label">链接</label>

                                    <div class="col-sm-10">
                                        <form:input path="url" cssClass="form-control required" placeholder="链接"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="pic" class="col-sm-2 control-label">图片</label>

                                    <div class="col-sm-10">
                                        <form:input path="pic" cssClass="form-control required" placeholder="图片"/>
                                        <div id="dropz" class="dropzone">

                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">详情</label>

                                    <div class="col-sm-10">
                                        <form:hidden path="cakeDetail"/>
                                        <div id="editor">${cake.cakeDetail}</div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                <button id="btnE" type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
        <!-- /.Main content -->
    </div>
    <!-- /.content-wrapper-->
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<!-- /.wrapper -->
<jsp:include page="../includes/footer.jsp"/>
<script type="text/javascript" src="/static/plugins/jquery-ztree/js/jquery.ztree.core-3.5.js"></script>
<sys:modal title="请选择" message="<ul id='myTree' class='ztree'></ul>"/>
<script src="/static/plugins/dropzone/min/dropzone.min.js"></script>
<script src="/static/plugins/wangEditor/wangEditor.min.js"></script>
<script>
    $(function () {
      App.initZTree('/cake/category/tree/data',["id"],function (nodes) {
          const node = nodes[0];
          $('#categoryId').val(node.id);
          $('#categoryName').val(node.name);
          $('#modal-default').modal("hide");
      });

        initWangEditor();
    });
    /**
     * 初始化 wangEditor富文本编辑器
     */
    function initWangEditor(){
        const E = window.wangEditor;
        editor = new E('#editor');
        editor.create();
        // 配置 server 接口地址
        editor.config.uploadImgServer = '/upload';
        editor.config.uploadFileName = 'editorFile';
        $("#btnE").bind("click",function () {
            const contentHtml = editor.txt.html();
            $("#cakeDetail").val(contentHtml);
        });
    };
    /**
     * DropZone
     */
    App.initDropzone({
                id: "#dropz",
                url: "/upload",
                init: function (){
                    this.on("success", function (file,data) {
                        $("#pic").val(data.fileName)
                    });
                },
            });
</script>
</body>
</html>

