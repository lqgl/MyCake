<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>蛋糕商城 登陆</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/static/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/register.css">
</head>
<body class="no-padding">
<div class="sign">
    <div class="main">
        <h4 class="title">
            <div>
                <a  href="/login">登录</a>
                <b>·</b>
                <a class="active" href="/register">注册</a>
            </div>
        </h4>
        <div class="">
            <c:if test="${baseResult != null}">
                <div  id="alert" class="alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="$('#alert').hide()">&times;</button>
                        ${baseResult.message}
                </div>
            </c:if>
            <form action="/register" accept-charset="UTF-8" method="post">
                <div class="input-style">
                    <input type="username" name="username" placeholder="用户名">
                </div>
                <div class="input-style">
                    <input type="email" name="email" placeholder="邮箱">
                </div>
                <div class="input-style" style="height: 50px;">
                    <input placeholder="验证码" type="text"  name="verification" style="float: left;width: 65%;">
                    <img id="verification" src="/verification" style="cursor: pointer;width: 30%; float:  right; height: 45px; background: #42c02e; color: #fff;" title="看不清？换一张" />
                </div>
                <div class="input-style">
                    <input type="password" name="password"  placeholder="密码" >
                </div>
                <input type="submit" name="commit" value="注册" class="sign-in-button" />
            </form>
        </div>
    </div>
</div>
<script src="/static/js/jquery.js"></script>
<script>
    $(function () {
        // 刷新验证码
        $("#verification").bind("click", function () {
            $(this).hide().attr('src', '/verification?random=' + Math.random()).fadeIn();
        });
    });
</script>
</body>
</html>
