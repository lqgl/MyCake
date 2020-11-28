<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 商品管理</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="/static/plugins/treeTable/themes/vsStyle/treeTable.min.css"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">
    <jsp:include page="../includes/menu.jsp"/>
    <jsp:include page="../includes/nav.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                商品管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">分类列表</h3>
                            <div class="box-body">
                                <a href="/cake/category/form" type="button" class="btn btn-sm  btn-default "><i class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;
                                <a href="#" type="button" class="btn btn-sm  btn-default "><i class="fa fa-download"></i> 导入</a>&nbsp;&nbsp;
                                <a href="#" type="button" class="btn btn-sm  btn-default "><i class="fa fa-upload"></i> 导出</a>&nbsp;&nbsp;
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="treeTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>名称</th>
                                    <th>排序</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${cakeCategories}" var="cakeCategory">
                                    <tr id="${cakeCategory.id}" pId="${cakeCategory.parent.id}">
                                        <td>${cakeCategory.id}</td>
                                        <td>${cakeCategory.name}</td>
                                        <td>${cakeCategory.sortOrder}</td>
                                        <td>
                                            <a href="/cake/category/form?id=${cakeCategory.id}" type="button" class="btn btn-sm  btn-primary "><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;
                                            <a href="/cake/category/delete?id=${cakeCategory.id}"  type="button" class="btn btn-sm  btn-danger "><i class="fa fa-trash-o"></i> 删除</a>&nbsp;&nbsp;&nbsp;
                                            <a href="/cake/category/form?parent.id=${cakeCategory.id}&parent.name=${cakeCategory.name}" type="button" class="btn btn-sm  btn-default "><i class="fa fa-plus"></i> 新增下级菜单</a>&nbsp;&nbsp;&nbsp;
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"/>
</div>

<jsp:include page="../includes/footer.jsp"/>
<script src = "/static/plugins/treeTable/jquery.treeTable.min.js"></script>
<!-- 自定义模态框 -->
<sys:modal />

<script>
    $(function () {
        $('#treeTable').treeTable({
            expandLevel : 2,
            column:1
        });
    });
</script>
</body>
</html>
