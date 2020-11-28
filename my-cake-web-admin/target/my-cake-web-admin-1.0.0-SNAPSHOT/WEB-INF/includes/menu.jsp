<%--
  Created by IntelliJ IDEA.
  User: Monoya
  Date: 2020/11/22
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Monoya</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">功能管理</li>
            <li class="treeview">
                <a href="#"><i class="fa fa-dashboard"></i> <span>用户管理</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/user/list"><i class="fa fa-circle-o"></i> 用户列表</a></li>
                    <li><a href="/user/form"><i class="fa fa-circle-o"></i> 新增用户</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-dashboard"></i> <span>商品管理</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/cake/category/list"><i class="fa fa-circle-o"></i> 商品分类</a></li>
                    <li><a href="/cake/list"><i class="fa fa-circle-o"></i> 商品列表</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
