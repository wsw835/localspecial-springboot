<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商家入驻</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<div id="append">
</div>

<div class="full_sc">
    <div class="head_cent head_cwo ClearFix">
        <div class="h_logo">
            <a href="">
                <img src="image/logo.jpg"/>
            </a>
        </div>
        <div class="h_right">
            <img src="image/top_center.jpg"/>
        </div>
    </div>
</div>

<div class="w980 ClearFix">
    <div class="logo_box ClearFix">
        <div class="login_b_l ClearFix">
            <a href="" title="出发">
                <img src="image/register.jpg" alt="出发"/>
            </a>
        </div>
        <div class="login_b_r ClearFix">
            <div class="loginul ClearFix">
                <div class="login_h2 ClearFix">
                    <h2>商家入驻</h2>
                </div>

                <div class="co">
                    <div class="form">
                        <form id="register_form" method="post" action="user/userReg">
                            <div class="item">
                                <input placeholder="请输入用户名" class="itxt" autocomplete="off" tabindex="1" maxlength="11"
                                       name="uName" id="uName" type="text" onblur="checkUname()">
                                <div class="err_box">
                                    <div><input type="text" id="nameError" style="color: red"></div>
                                </div>
                            </div>
                            <div class="item">
                                <input placeholder="请输入真实姓名" class="itxt" autocomplete="off" tabindex="1" maxlength="11"
                                       name="uRealName" id="uRealName" type="text" onblur="checkURealname()">
                                <div class="err_box">
                                    <div><input type="text" id="realNameError" style="color: red"></div>
                                </div>
                            </div>

                            <div class="item">
                                <input placeholder="请输入手机号码" class="itxt" autocomplete="off" tabindex="1" maxlength="11"
                                       name="uTel" id="uTel" type="text" onblur="checkUTel()">
                                <div class="err_box">
                                    <div><input type="text" id="telError" style="color: red"></div>
                                </div>
                            </div>

                            <div class="item item2">
                                <input placeholder="请输入密码" tabindex="4" maxlength="20" class="itxt" name="password"
                                       id="password" type="password" onblur="checkUpassword()">
                                <div class="err_box">
                                    <div><input type="text" id="pwdError" style="color: red"></div>
                                </div>
                            </div>

                            <div class="item item2">
                                <input placeholder="请再次输入密码" class="itxt" tabindex="5" maxlength="20"
                                       name="checkPassword" id="checkPassword" type="password"
                                       onblur="checkUcheckpassword()">
                                <div class="err_box">
                                    <div><input type="text" id="checkPwdError" style="color: red"></div>
                                </div>
                            </div>

                            <div class="item item3">
                                <input placeholder="验证码" autocomplete="off" tabindex="6" maxlength="4" size="10"
                                       class="itxt itxt_yzm" name="code" id="code" type="text" onblur="checkCode()">
                                <a href="#" id="changeImg">
                                    <canvas class="show-captcha" id="canvas" width="150" height="40"></canvas>
                                </a>
                                <input type="hidden" name="rightCode" type="hidden" id="rightCode">
                                <div class="err_box">
                                    <div><input type="text" id="codeError" style="color: red"></div>
                                </div>
                            </div>

                            <div class="item item5">
                                <div class="login-btn">
                                    <a id="loginsubmit" tabindex="7" class="btn-img btn-entry" href="#"
                                       onclick="document.getElementById('register_form').submit();return false;">立即注册</a>
                                </div>
                                <div class="agree">
                                    <input class="jdcheckbox"
                                           tabindex="8"
                                           name="agree"
                                           id="agree"
                                           checked="checked"
                                           type="checkbox">
                                    <label for="autoLogin">注册即表示同意快乐购<span>
                                        <a href="">《用户服务协议》</a></span>条款</label>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--	ajax异步刷新注册功能实现--%>
<script type="text/javascript">
    function checkUname() {
        var uname = $("#uName").val();
        var obj = {};
        obj.uName = uname;
        var json = JSON.stringify(obj);
        $.ajax({
                type: "post",
                url: "user/checkUname",
                contentType: "application/json;charset=utf-8",
                data: json,
                success: function (data) {
                    $("#nameError").val(data.message);
                }
            }
        )
    }

    function checkURealname() {
        var uRealname = $("#uRealName").val();
        var obj = {};
        obj.uRealName = uRealname;
        var json = JSON.stringify(obj);
        $.ajax({
                type: "post",
                url: "user/checkURelname",
                contentType: "application/json;charset=utf-8",
                data: json,
                success: function (data) {
                    $("#realNameError").val(data.message);
                }
            }
        )
    }

    function checkUTel() {
        var uTel = $("#uTel").val();
        var obj = {};
        obj.uTel = uTel;
        var json = JSON.stringify(obj);
        $.ajax({
                type: "post",
                url: "user/checkUTel",
                contentType: "application/json;charset=utf-8",
                data: json,
                success: function (data) {
                    $("#telError").val(data.message);
                }
            }
        )
    }

    function checkUpassword() {
        var pas = $("#password").val();
        var obj = {};
        obj.password = pas;
        var json = JSON.stringify(obj);
        $.ajax({
                type: "post",
                url: "user/checkPassword",
                contentType: "application/json;charset=utf-8",
                data: json,
                success: function (data) {
                    $("#pwdError").val(data.message);
                }
            }
        )
    }

    function checkUcheckpassword() {
        var pas = $("#password").val();
        var cpas = $("#checkPassword").val();
        var obj = {};
        obj.password = pas;
        obj.checkPassword = cpas;
        var json = JSON.stringify(obj);
        $.ajax({
                type: "post",
                url: "user/checkCpwd",
                contentType: "application/json;charset=utf-8",
                data: json,
                success: function (data) {
                    $("#checkPwdError").val(data.message);
                }
            }
        )
    }

    var data = "";

    jQuery(function ($) {
        /**生成一个随机数**/
        function randomNum(min, max) {
            return Math.floor(Math.random() * (max - min) + min);
        }

        /**生成一个随机色**/
        function randomColor(min, max) {
            var r = randomNum(min, max);
            var g = randomNum(min, max);
            var b = randomNum(min, max);
            return "rgb(" + r + "," + g + "," + b + ")";
        }

        var code = drawPic();
        document.getElementById("changeImg").onclick = function (e) {
            e.preventDefault();
            code = drawPic();
        }

        /**绘制验证码图片**/
        function drawPic() {
            var canvas = document.getElementById("canvas");
            var width = canvas.width;
            var height = canvas.height;
            //获取该canvas的2D绘图环境
            var ctx = canvas.getContext('2d');
            ctx.textBaseline = 'bottom';
            /**绘制背景色**/
            ctx.fillStyle = randomColor(180, 240);
            //颜色若太深可能导致看不清
            ctx.fillRect(0, 0, width, height);
            /**绘制文字**/
            var str = 'ABCEFGHJKLMNPQRSTWXY123456789';

            var code = "";
            //生成四个验证码
            for (var i = 1; i <= 4; i++) {
                var txt = str[randomNum(0, str.length)];
                code = code + txt;
                ctx.fillStyle = randomColor(50, 160);
                //随机生成字体颜色
                ctx.font = randomNum(15, 40) + 'px SimHei';
                //随机生成字体大小
                var x = 10 + i * 25;
                var y = randomNum(25, 35);
                var deg = randomNum(-45, 45);
                //修改坐标原点和旋转角度
                ctx.translate(x, y);
                ctx.rotate(deg * Math.PI / 180);
                ctx.fillText(txt, 0, 0);
                //恢复坐标原点和旋转角度
                ctx.rotate(-deg * Math.PI / 180);
                ctx.translate(-x, -y);
            }

            /**绘制干扰线**/
            for (var i = 0; i < 3; i++) {
                ctx.strokeStyle = randomColor(40, 180);
                ctx.beginPath();
                ctx.moveTo(randomNum(0, width / 2), randomNum(0, height / 2));
                ctx.lineTo(randomNum(0, width / 2), randomNum(0, height));
                ctx.stroke();
            }
            /**绘制干扰点**/
            for (var i = 0; i < 50; i++) {
                ctx.fillStyle = randomColor(255);
                ctx.beginPath();
                ctx.arc(randomNum(0, width), randomNum(0, height), 1, 0, 2 * Math.PI);
                ctx.fill();
            }
            $("#rightCode").val(code);
            return code;
        }
    });

    function checkCode() {
        var a = $("#rightCode").val();
        var b = $("#code").val();
        if (a != b) {
            $("#codeError").val("验证码不一致!");
        }
    }

</script>
</body>
</html>
