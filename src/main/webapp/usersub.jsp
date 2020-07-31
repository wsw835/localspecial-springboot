<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人资料</title>
    <link rel="stylesheet" type="text/css" href="css/head.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/suercenter.css"/>
    <style>
        input {
            border: 1px solid #ccc;
            padding: 7px 0px;
            border-radius: 3px;
            padding-left: 5px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
            -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
            -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
            transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
        }

        input:focus {
            border-color: #66afe9;
            outline: 0;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, .6);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, .6)
        }
    </style>
</head>
<body>
<%@include file="head.jsp" %>
<div class="w1000 ClearFix margin_top20">
    <%@include file="left.jsp" %>
    <div class="ur_right ClearFix">
        <!--uer_top-->
        <div class="ur_location">
            <a href="">我的快乐购</a>
            <span>&gt;</span>
            <a class="a_cur">个人资料</a>
        </div>
        <!--uer_top-->
        <div class="base_info">
            <div class="info_top">
                <div class="bi_l">
                    <div class="m_img">
                        <div class="hg_box">
                            <img src="image/hg_img_0.png">
                        </div>
                        <img src="image/user_center_img4.jpg">
                    </div>
                    <!--<a class="" href="">修改头像</a>-->
                </div>
            </div>
            <form action="user/doUpdate?id=${user.uId}" method="post" id="form1">
                <div class="base_item">
                    <span class="label_name"><span>*</span>用户名：</span>
                    <input maxlength="20" id="member_truename" name="uRealname" class="itxt" value="${user.uRealname}"
                           type="text">
                    <div class="addr_msg">
                        <span id="error_member_truename"></span>
                    </div>
                </div>
                <div class="base_item">
                    <span class="label_name"><span>*</span>昵称：</span>
                    <input maxlength="20" id="member_truename2" name="uName" class="itxt" value="${user.uName}"
                           type="text">
                    <div class="addr_msg">
                        <span id="error_member_truename2"></span>
                    </div>
                </div>
                <div class="base_item">
                    <span class="label_name"><span>*</span>手机号：</span>
                    <input maxlength="20" id="member_truename3" name="uTelephone" class="itxt"
                           value="${user.uTelephone}"
                           type="text">
                    <div class="addr_msg">
                        <span id="error_member_truename3"></span>
                    </div>
                </div>
                <div class="base_item">
                    <span class="label_name"><span>*</span>修改密码：</span>
                    <input maxlength="20" id="member_truename4" name="uPassword" class="itxt" value="${user.uPassword}"
                           type="text">
                    <div class="addr_msg">
                        <span id="error_member_truename4"></span>
                    </div>
                </div>

                <div class=" base_btn">
                    <a class="base_btn_save" id="profilesubmit"
                       onclick="document.getElementById('form1').submit();">修改</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="border.jsp" %>
</body>
</html>