<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>唯一客蛋糕</title>
    <meta name="keywords" content="生日蛋糕，巧克力蛋糕，芝士，乳酪蛋糕，慕斯蛋糕，鲜奶蛋糕，商务蛋糕，婚庆蛋糕，提供健康" />
    <meta name="description" content="V1cake，只做新鲜的蛋糕。现已来到更多城市。在世界范围，研究蛋糕食材内涵，创造高价值单品。" />
    <link rel="stylesheet" href="/static/css/header.css"/>
    <link rel="stylesheet" href="/static/css/product.css"/>
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
<div class="cont">
    <div  style="margin-top:20px;">
        <span class=" title" >首页  >  蛋糕名录  >  <a href='#'>精品推荐</a>  >  ${cake.cakeName}</span>
    </div>
    <div class="product_img">
        <div id="bigpicarea">
            <img src="http://localhost:8080${cake.pic}" alt="蛋糕" title="大理石 · 草莓库里"/>
        </div>
    </div>
</div>
<div class="product_info">
    <ul>
        <li class="title larger bold">${cake.cakeName}</li>

        <li class="grey">${cake.cakeDetail}</li>
        <li class="line_top"><input type="hidden" value="/upload/image/20190902/20190902132944_87684.jpg" id="pic"/><input id="discount" type="hidden" value="1" /></li>
        <li style="line-height:50px">价格：<span class="larger">￥<span id="pricetxt">${cake.price}</span>元</span></li>

        <li>
            <span class="product_btn select_on" id="cbtn0" onClick="chooseSize(this,0)">1.0磅</span><script>price.push(198);</script><span class="product_btn" id="cbtn1" onClick="chooseSize(this,1)">2.0磅</span><script>price.push(298);</script><span class="product_btn" id="cbtn2" onClick="chooseSize(this,2)">3.0磅</span><script>price.push(458);</script><span class="product_btn" id="cbtn3" onClick="chooseSize(this,3)">5.0磅</span><script>price.push(758);</script><script>$(document).ready(function(){
            chooseSize($('#cbtn1'),1);
        });</script>             </li>

        <li class="clear " style="line-height:50px">
            <a href="#" class="j"><img src="/static/images/cuts.png" border="0"></a>
            <input type="text" value="1" class="order_one" name="num" id="num" readonly>
            <a href="#" class="jia"><img src="/static/images/add.png" border="0"></a>
        </li><!--是否已下架-->
        <li><button class="btn_buy " onClick="addCart();location.href='order.php'">立即购买</button>　<button class="btn_buy addcar" onClick="addCart();">加入购物车</button></li>		</ul>
</div>
<!--  -->
<div class="product_more clear">
    <table  class="table-striped ">
        <thead>
        <tr>
            <td><span class="bold title product_bt" >商品详情</span></td>

        </tr>

        <tr >
            <td class="td_left"><div class="small grey product_other" >
                <p style="color:gray">品牌： V1Cake
                    <br/>
                    保鲜条件：0－4℃保藏24小时，5℃最佳食用<br/>
                </p>
                <p>所属分类：乳酪蛋糕<br/>
                    节日：<br/>
                </p>
                <p>
                    口味：草莓<br/>
                    原材料：<br/><br/></p></div></td>
        </tr>
        </thead>
        <tbody >
        <tr >
            <td ><span class="bold title product_bt">订购说明</span><br><div class="product_other" style="color:gray">
                <strong><span style="color:red">预定5磅蛋糕需先付款。</span></strong><br>
                蛋糕规格及免费配送餐具 ：<br>
                1.0磅：约13×13(cm) 适合3-4人食用 免费配送5套餐具<br>

                2.0磅：约17×17(cm) 适合7-8人食用 免费配送10套餐具<br/>
                3.0磅：约22×22(cm) 适合11-12人食用 免费配送15套餐具<br/>
                5.0磅：约28×28(cm) 适合15-20人食用 免费配送25套餐具<br/>
                6寸：适合3-4人食用 免费配送5套餐具<br/>


                提前五个小时订购（提前一天订购享受九五折优惠），慕斯系列须提前24小时订购。<br>
                如若需要修改蛋糕品类或送货时间，送货时间将根据修改内容延后五小时内完成。<br>
                如果您在22点---8点间下单，送货时间最早为14点。

                注：所有促销活动不能同时享受


                感谢您对v1cake的支持！<br/>
                <br/>

            </div></td>

        </tr>

        </tbody>
    </table>
</div>
<!-- footer -->
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
