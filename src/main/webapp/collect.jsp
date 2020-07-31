<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的收藏</title>
    <link rel="stylesheet" type="text/css" href="css/head.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/suercenter.css"/>
</head>
<body>
<%@include file="head.jsp" %>

<div class="w1000 ClearFix margin_top20">

    <%@include file="left.jsp" %>

    <div class="ur_right ClearFix">
        <!--uer_top-->
        <div class="ur_location">
            <a href="">我的小站</a>
            <span>&gt;</span>
            <a class="a_cur">我的订单</a>
        </div>
        <!--uer_top-->
        <div class="no_data"><img src="image/no_data.png"><span>您还没有收藏任何商品!</span></div>
    </div>
    <%@include file="border.jsp" %>
</body>
</html>
