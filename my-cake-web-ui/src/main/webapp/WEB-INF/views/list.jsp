<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>唯一客蛋糕</title>
    <meta name="keywords" content="生日蛋糕，巧克力蛋糕，芝士，乳酪蛋糕，慕斯蛋糕，鲜奶蛋糕，商务蛋糕，婚庆蛋糕，提供健康" />
    <meta name="description" content="V1cake，只做新鲜的蛋糕。现已来到更多城市。在世界范围，研究蛋糕食材内涵，创造高价值单品。" />
    <link rel="stylesheet" href="/static/css/header.css"/>
    <link rel="stylesheet" href="/static/css/list.css"/>
</head>
<body>
<div>
    <div class="header">
        <div class="logo"></div>
        <div class="nav">
            <ul>
                <li class="home_ico" style="background:url(/static/images/line.png) no-repeat right center"><a href="/index">首页</a></li>
                <li style="background:url(/static/images/line.png) no-repeat right center"><a href="/list">蛋糕名录</a></li>
                <li style="background:url(/static/images/line.png) no-repeat right center"><a href="/list">精品推荐</a></li>
                <li style="background:url(/static/images/line.png) no-repeat right center"><a href="/list">新品上市</a></li>
                <li ><a href="#">订购指南</a></li>
                <li class="phone_right">
                            <span class="top_left">
                                <c:if test="${User!=null}">
                                    <a href="/login">${User.username}</a> | <a href="/logout">注销</a>  | </span>
                                </c:if>
                                <c:if test="${User==null}">
                                    <a href="/login">登录</a> | <a href="/register">注册</a>  | </span>
                                </c:if>

                    <span class="trolley " ID="cartNum" onclick="location.href='#'">0</span></li>
            </ul>
        </div>
    </div>
    <!-- /.logo -->
</div>
<!--/.header-->
<div class="line_top"></div>
</div>
<!--content-->
<div class="content">
    <div class="cont">
        <div  style="margin:20px 0 0 30px">
            <span class=" title" >首页  >  蛋糕名录</span>
        </div>
        <div class="nav_more">
            <ul>
                <li><a href="/categoryCakes/1">全部蛋糕</a></li>
                <c:forEach items="${cakeCategoryList}" var="cakeCategory">
                    <li><a href="/categoryCakes/${cakeCategory.id}">${cakeCategory.name}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="line_top"></div>
    <div class="order_table">
        <table  class="table-striped table">
            <tbody>
            <c:forEach items="${cakeList!=null?cakeList:allCakesList}" var="cake">
                <tr>
                    <td width="200"><a href="/products/${cake.id}"><img src="http://localhost:8080${cake.pic}" width="160" border="0" ></a></td>
                    <td width="500"  class="td_left" style="text-align:left"> <span class="title larger"><a href="/products/${cake.id}">${cake.cakeName}</a></span><br>
                        <span class="grey">口味：${cake.cakeTaste}<br>${cake.cakeDetail}</span></td>
                    <td valign="top">￥${cake.price}<br></td>
                    <td width="200"> <a href="/products/${cake.id}" class="btn btn-default ">查看详情</a> <a onClick="addCart('279','大理石 · 草莓库里','1.0磅','/upload/image/20190902/20190902132944_87684.jpg',1,198,1)" class="btn  btn-danger addcar">加入购物车</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!--/.content-->
<!--footer-->
<footer>
    <div class="footer">
        <div class="footer_t">
            订购专线：<span style='font-size:1.5em;font-family:"Arial Black", Gadget, sans-serif'>4000-588-199</span>（服务时间09:00-20:30）<br />
            <!-- 世茂广场店：红谷滩世茂广场一楼大厅内（必胜客旁）电话：18046809961 营业时间：周一至周四10:00-21:00  周五至周日10:00-22:00<br /> -->
            恒茂店：西湖区广场南路恒茂商业街A-193室 电话：0791-86629797（10:00-21:00）<!-- <br />  -->
            <!-- 红谷滩店：红谷滩丰泽路万达写字楼b2栋1-28铺（万达嘉华酒店旁）电话：0791-86299797（10:00-18:00） -->
            <span class="right">

                    <a class="weixin" title='微信下单' href='javascript:openCards("add_wx")'>
                    </a>

                     <a class="sina" href="#" title='微博下单'></a></span>

            <br>
            CopyRight © 2020-2020 v1cake.com All right reserviced │ 赣ICP备14007077号-1
            <br>
            <a href="#" target="_blank">信息产业部备案管理系统</a>
        </div>
    </div>
</footer>
</body>
</html>
