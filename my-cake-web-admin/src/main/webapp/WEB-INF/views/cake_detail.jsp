<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 商品详情</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="box-body">
    <table id="dataTable" class="table">
        <tbody>
        <tr>
            <td>商品名称:</td>
            <td>${cake.cakeName}</td>
        </tr>
        <tr>
            <td>商品口味:</td>
            <td>${cake.cakeTaste}</td>
        </tr>
        <tr>
            <td>价格:</td>
            <td>${cake.price}</td>
        </tr>
        <tr>
            <td>商品描述:</td>
            <td>${cake.cakeDetail}</td>
        </tr>
        <tr>
            <td>创建时间:</td>
            <td><fmt:formatDate value="${user.created}" type="both"/> </td>
        </tr>
        <tr>
            <td>更新时间:</td>
            <td><fmt:formatDate value="${user.updated}" type="both"/> </td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>