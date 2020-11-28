<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>MyCake 登陆</title>
    <jsp:include page="../includes/header.jsp"/>
    <link href="/static/loginCss/login.css" type="text/css" rel="stylesheet"/>
</head>
<body class="no-padding">
<div class="sign">
    <div class="main">
        <h4 class="title">
            <div>
                <a class="active" href="/login">登录</a>
                <b>·</b>
                <a class href="#">注册</a>
            </div>
        </h4>
        <div class="">
            <c:if test="${message != null}">
                <div  id="alert" class="alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="$('#alert').hide()">&times;</button>
                        ${message}
                </div>
            </c:if>
            <form action="/login" accept-charset="UTF-8" method="post">
                <div class="input-style">
                    <input type="email" name="email" placeholder="邮箱">
                </div>
                <div class="input-style">
                    <input type="password" name="password"  placeholder="密码" >
                </div>
                <br/>
                <input type="submit" name="commit" value="登录" class="sign-in-button" />
            </form>
        </div>
    </div>
</div>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>
