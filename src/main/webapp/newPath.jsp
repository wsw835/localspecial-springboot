<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新增地址</title>
    <link rel="stylesheet" type="text/css" href="css/head.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/suercenter.css"/>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <link rel="script" type="text/html" href="layui/layui.js">
</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/Popt.js"></script>
<script type="text/javascript" src="js/city.json.js"></script>
<script type="text/javascript" src="js/citySet.js"></script>

<style type="text/css">
    * {
        -ms-word-wrap: break-word;
        word-wrap: break-word;
    }

    html {
        -webkit-text-size-adjust: none;
        text-size-adjust: none;
    }

    html, body {
        height: 99%;
        width: 99%;
    }

    .wrap {
        width: 464px;
        height: 34px;
        margin: 20px 0 20px 90px;
        border: 0;
        position: relative;
    }

    .input {
        position: absolute;
        top: 0;
        left: 0;
        width: 457px;
        margin: 0;
        padding-left: 5px;
        height: 30px;
        line-height: 30px;
        font-size: 12px;
        border: 1px solid #c9cacb;
    }

    s {
        position: absolute;
        top: 1px;
        right: 0;
        width: 32px;
        height: 32px;
        background: url("image/arrow.png") no-repeat;
    }

    ._citys span {
        color: #05920a;
        height: 15px;
        width: 15px;
        line-height: 15px;
        text-align: center;
        border-radius: 3px;
        position: absolute;
        right: 10px;
        top: 10px;
        border: 1px solid #05920a;
        cursor: pointer;
    }

    ._citys0 li {
        display: inline-block;
        line-height: 34px;
        font-size: 15px;
        color: #888;
        width: 80px;
        text-align: center;
        cursor: pointer;
    }

    ._citys1 a {
        width: 83px;
        height: 35px;
        display: inline-block;
        background-color: #f5f5f5;
        color: #666;
        margin-left: 6px;
        margin-top: 3px;
        line-height: 35px;
        text-align: center;
        cursor: pointer;
        font-size: 12px;
        border-radius: 5px;
        overflow: hidden;
    }

    ._citys1 a:hover {
        color: #fff;
        background-color: #05920a;
    }
</style>

<body>
<%@include file="head.jsp" %>
<div class="w1000 ClearFix margin_top20">
    <%@include file="left.jsp" %>
    <!--uer_top-->
    <div class="ur_location">
        <a href="">我的快乐小站</a>
        <span>&gt;</span>
        <a class="a_cur">我的地址</a>
    </div>
    <!--uer_top-->
    <div class="o_o_part">
        <div class="part_h2"><span style="font-family: 微软雅黑;color:grey">  地址管理 </span></div>
            <div style="margin : 10px 0 20px 10px">
            <table class="table">
                <thead>
                <tr>
                    <td width="10%">收货人</td>
                    <td width="15%">收货人地址</td>
                    <td width="10%">手机</td>
                    <td width="10%">操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${addressList}" var="address">
                    <tr>
                        <td width="10%">${address.aSenduser}</td>
                        <td width="15%">${address.aAddr}</td>
                        <td width="10%">${address.aSendtel}</td>
                        <td width="10%">
                            <div>
                                <p>
                                    <button onclick="modify(${address.aId})" >
                                        <i class="icon-trash"></i>删除</button>
                                </p>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div>
                <div class="new_addr">
                <form action="goods/addAddr?uname=${info}" method="post" id="form1">
                <div class="addr_item">
                    <span class="label_n"><span class="c_red">*</span>&nbsp;&nbsp;&nbsp;收货人：</span>
                    <input class="itxt" name="aSenduser" id="true_name" type="text">
                </div>
                <div class="addr_item">
                    <span class="label_n"><span class="c_red">*</span>所在地区：</span>
                    <div class="wrap">
                        <input class="input" name="aAddr" id="city" type="text" placeholder="请选择"
                               autocomplete="off" readonly="true"><s></s></div>

                </div>
                <div class="addr_item">
                    <span class="label_n"><span class="c_red">*</span>详细地址：</span>
                    <input placeholder="详细地址" name="aDetail" class="itxt itxtaddr" id="address" type="text">
                    <div class="addr_msg">
                        <span id="error_address"></span>
                    </div>
                </div>
                <div class="addr_item">
                    <span class="label_n"><span class="c_red">*</span>手机号码：</span>
                    <input placeholder="手机号码" name="aSendtel" class="itxt itxt_tel" id="tel_phone" type="text">
                    <div class="addr_msg">
                        <span id="error_tel_phone"></span>
                    </div>
                </div>
                <div class="addr_item">
                    <span class="label_n"><span class="c_red">*</span>默认地址：</span>
                    <input type="radio" value="1" name="aState"><span class="c_red">是</span>
                    <input type="radio" value="0" name="aState"><span class="c_red">否</span>
                </div>
                <div class="addr_item btn_item">
                    <a onclick="javascript:document.getElementById('form1').submit();"
                       id="bt1" class="btn_addaddr">确定</a>
                </div>
        </form>
        </div>
    </div>
</div>
</div>
</div>
<%@include file="border.jsp" %>
<script type="text/javascript">
    $("#city").click(function (e) {
        SelCity(this, e);
    });
    $("s").click(function (e) {
        SelCity(document.getElementById("city"), e);
    });

    function modify(e) {
        $.ajax({
                   dataType: "json",
                   type: "post",
                   url: "goods/deleteAddr",
                   data:{"id":e},
                   contentType: "application/json;charset=utf-8",
                   success: function (data) {
                       location.reload();
                   }
               });
    }

    $.ajax({
               dataType: "json",
               type: "post",
               url: "goods/showAddr",
               contentType: "application/json;charset=utf-8",
               success: function (data) {
               }
           });
</script>
</body>
</html>
