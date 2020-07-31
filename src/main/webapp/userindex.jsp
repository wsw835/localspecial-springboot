<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的快乐购</title>
    <link rel="stylesheet" type="text/css" href="css/head.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/suercenter.css"/>
</head>
<body>
<%@include file="head.jsp" %>

<div class="w1000 ClearFix margin_top20">

    <%@include file="left.jsp" %>

    <!--右侧top-->
    <div class="ur_right">
        <div class="uc_top ClearFix">
            <div class="seufe">
                <div class="d_h2"><h2><span></span>我的收藏</h2></div>
                <div class="detail_l_con4">
                    <div class="no_data"><img src="image/no_data.png"><span>您还没有收藏任何商品!</span></div>
                </div>
            </div>
        </div>
    </div>
    <!--右侧top-->
</div>
<%@include file="border.jsp" %>
</body>
</html>
