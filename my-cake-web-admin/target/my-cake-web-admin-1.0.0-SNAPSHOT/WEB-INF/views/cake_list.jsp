<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城-商品列表</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
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
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box box-info box-info-search" style="display: none;">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <div class="box-body">
                            <div class="row form-horizontal" >
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="cakeName" class="col-sm-4 control-label">名称</label>
                                        <div class="col-sm-8">
                                            <input id="cakeName" class="form-control" placeholder="名称">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="cakeTaste" class="col-sm-4 control-label">口味</label>
                                        <div class="col-sm-8">
                                            <input id="cakeTaste" class="form-control" placeholder="口味">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="cakeDetail" class="col-sm-4 control-label">详情</label>
                                        <div class="col-sm-8">
                                            <input id="cakeDetail" class="form-control" placeholder="详情">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <button type="button" class="btn btn-info pull-right" onclick="search();">搜索</button>
                        </div>
                        <!-- /.box-footer -->
                    </div>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">商品列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="/cake/form" type="button" class="btn  btn-default"><i class="fa fa-plus"> 新增</i></a>&nbsp;&nbsp;
                            <button type="button" class="btn  btn-danger" onclick="App.handlerDeleteMulti('/cake/delete')"><i class="fa fa-trash-o"> 删除</i></button>&nbsp;&nbsp;
                            <a href="#" type="button" class="btn  btn-default"><i class="fa fa-download"> 导入</i></a>&nbsp;&nbsp;
                            <a href="#" type="button" class="btn  btn-default"><i class="fa fa-upload"> 导出</i></a>&nbsp;&nbsp;
                            <a type="button" class="btn  btn-primary" onclick="$('.box-info-search').css('display') == 'none'?$('.box-info-search').show():$('.box-info-search').hide()"><i class="fa fa-search"> 搜索</i></a>&nbsp;&nbsp;
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_control"></th>
                                    <th>ID</th>
                                    <th>所属类别</th>
                                    <th>名字</th>
                                    <th>口味</th>
                                    <th>价格</th>
                                    <th>链接</th>
                                    <th>图片</th>
                                    <th>详情</th>
                                    <th>创建时间</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<!-- /.wrapper -->
<jsp:include page="../includes/footer.jsp"/>
<script src="/static/dist/js/moment.js"></script>
<sys:modal/>
<script>
    let _dataTable;
    $(function () {
        const columns = [
            {"data": function ( row, type, val, meta ) {
                    return '<input id= "'+row.id+'" type="checkbox" class="minimal">';
                }
            },
            { "data": "id" },
            { "data": "cakeCategory.name" },
            { "data": "cakeName" },
            { "data": "cakeTaste" },
            { "data": "price" },
            { "data": function (row, type, val, meta) {
                    if(row.url == null)
                        return null;
                    else
                        return '<a href="'+row.url+'"target="_blank">查看</a>';
                }},
            { "data": function (row, type, val, meta) {
                    if(row.pic == null)
                        return null;
                    else
                        return '<a href="'+row.pic+'"target="_blank">查看</a>';
                }},
            { "data": function (row, type, val, meta) {
                    if(row.cakeDetail == null)
                        return null;
                    else
                        return '<a href="'+row.cakeDetail+'"target="_blank">查看</a>';
                } },
            { "data": function ( row, type, val, meta ) {
                    return moment(row.created).format("YYYY-MM-DD HH:mm:ss");
                } },
            { "data": function ( row, type, val, meta ) {
                    return moment(row.updated).format("YYYY-MM-DD HH:mm:ss");
                } },
            {"data": function ( row, type, val, meta ) {
                    const detailUrl = '/cake/detail?id=' + row.id;
                    const deleteUrl = '/cake/delete?id=' + row.id;
                    return '<button type="button" class="btn  btn-default" onclick="App.handlerShowDetail(\''+detailUrl+'\')"><i class="fa fa-search">查看</i></button>&nbsp;&nbsp;' +
                        '<a href="/cake/form?id='+row.id+'" type="button" class="btn  btn-primary"><i class="fa fa-edit"> 编辑</i></a>&nbsp;&nbsp;' +
                        '<button type="button" class="btn  btn-danger" onclick="App.handlerDeleteMulti(\''+deleteUrl+'\')"><i class="fa fa-trash-o"> 删除</i></button>';
                }
            },
        ];
        const url = '/cake/page'
        _dataTable = App.handlerDataTable(url, columns);
        console.log(_dataTable)
    });

    function search() {
        const cakeName = $("#cakeName").val();
        const cakeTaste = $("#cakeTaste").val();
        const cakeDetail = $("#cakeDetail").val();
        const param = {
            "cakeName": cakeName,
            "cakeTaste": cakeTaste,
            "cakeDetail": cakeDetail
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }
</script>
</body>
</html>
