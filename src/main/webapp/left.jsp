<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--左侧end-->
<div class="ur_left">
    <div class="ur_slide">
        <a href=""><h2 class="slide_h2"><b></b>我的订单</h2></a>
        <ul class="slide_list">
            <li class="no">
                <a href="goods/showOrder?uname=${info}">我的订单</a>
            </li>
        </ul>
    </div>
    <div class="ur_slide">
        <a href=""><h2 class="slide_h2"><b></b>个人中心</h2></a>
        <ul class="slide_list">
            <li class="no">
                <a href="user/update?uname=${info}">个人资料</a>
            </li>
            <li>
                <a href="newPath.jsp">地址管理</a>
            </li>
            <li>
                <a href="userindex.jsp">我的收藏</a>
            </li>
        </ul>
    </div>
</div>
<!--左侧end-->