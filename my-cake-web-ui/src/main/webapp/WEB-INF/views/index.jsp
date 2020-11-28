<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>唯一客蛋糕</title>
    <meta name="keywords" content="生日蛋糕，巧克力蛋糕，芝士，乳酪蛋糕，慕斯蛋糕，鲜奶蛋糕，商务蛋糕，婚庆蛋糕，提供健康" />
    <meta name="description" content="V1cake，只做新鲜的蛋糕。现已来到更多城市。在世界范围，研究蛋糕食材内涵，创造高价值单品。" />
    <link href="/static/css/swiper-bundle.min.css" rel="stylesheet">
    <link href="/static/css/index.css" rel="stylesheet">
</head>
<body>
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
                        <a href="/login">${User.username}，欢迎回来！</a> | <a href="/logout">注销</a>  | </span>
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
<div class="index_tab clear">
    <!-- 代码开始 轮播图 -->
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <c:forEach items="${pptList}" var="ppt">
                <div class="swiper-slide"><a href="/products/${ppt.id}"><img src="http://localhost:8080${ppt.pic}"style="height:400px"/></a></div>
            </c:forEach>
        </div>
        <!-- 如果需要分页器 -->
        <div id="custom-pagination" class="swiper-pagination"></div>
    </div>
    <!-- 如果需要导航按钮 -->
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
    <!-- 导航等组件可以放在container之外 -->
    <script src="js/swiper-bundle.min.js"></script>
    <script src="js/jquery.js"></script>
    <!-- 代码结束 -->
</div>
<!--/.index_tab-->
<div>
    <div style="background:#f7f7f7;" class="clear">
        <div class="tabCon ">
            <dt class="cur" id="con_one_1">
                <div class="index_main clear" style="padding-top:30px">
                    <ul class="roll_box ">
                        <c:forEach items="${tabList}" var="tab">
                            <li>
                                <div class="roll_img">
                                    <img src="http://localhost:8080${tab.pic}" />
                                    <a href="/products/${tab.id}">
                                        <div class="roll_blank"></div>
                                        <div class="roll_info">
                                            <p>${tab.cakeName}<br>￥${tab.price}/2.0磅</p><i class="buy"></i>
                                        </div>
                                    </a>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </dt>
        </div>
    </div>

</div>

<!-- tab标签代码end -->
<footer>
    <div class="server">
        <ul>
            <li style="border-right:1px #EFEFEF solid"><i class="server_one"></i><h2 >当天制作新鲜直达</h2> <h3 class="clear">选用新鲜材料当天制作，让您当日就能体验新鲜食材，最快速的让您感受健康品质享受。</h3></li>
            <li style="border-right:1px #EFEFEF solid"><i class="server_two"></i><h2>精选世界好原料</h2> <h3 class="clear">全部使用来自世界各国优等原料，严格遵守经典蛋糕制作工艺，为您提供最纯正的味道。</h3></li>
            <li style="border-right:1px #EFEFEF solid"><i class="server_three"></i><h2>100%无添加</h2> <h3 class="clear">百分百纯天然食材，不含人工香料，不含色素，不添加防腐剂。只为让您品尝到最健康的美味。</h3></li>
            <li><i class="server_four"></i><h2>无缝冷链生产与配送</h2> <h3>全面净化的无菌生产环境，无缝对接的冷链过程，确保您的健康与安全。</h3></li>
        </ul>

    </div>
    <div class="footer">
        <style>
            .qrcode{width:100px;height:100px; border:1px #f1f1f1 solid; position:absolute;bottom:0px}
        </style>
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
<script src="/static/js/swiper-bundle.min.js"></script>
<script src="/static/js/jquery.js"></script>
<script>
    const mySwiper = new Swiper('.swiper-container', {
        autoplay: {
            delay: 2000,
            disableOnInteraction: false
        },//可选选项，自动滑动
        loop: true, // 循环模式选项，true 循环播放
        observer: true,//实时检测，动态更新
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
            autoplayDisableOnInteraction: false
        },
        // 如果需要前进后退按钮
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },

    });
</script>
</body>
</html>
