<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<div id="append"></div>
<div class="full_sc">
    <div class="head_cent head_cwo ClearFix">
        <div class="h_logo">
            <a href="">
                <img src="image/logo.png"/>
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
            <a href="" title="日光生活">
                <img style="width: 560px;height: 360px;" src="image/logo_img.jpg" alt="日光生活"/>
            </a>
        </div>
        <div class="login_b_r ClearFix">
            <div class="loginul ClearFix">
                <div class="login_h2 ClearFix">
                    <h2>登录</h2>
                    <div class="lognrtop">
                        还没有账号<a href="register.jsp">快速注册</a>
                    </div>
                </div>
                <div class="co">
                    <div class="from">
                        <form id="form1" action="user/userLogin" method="post">

                            <div class="item">
                                <input class="text" name="uTel" placeholder="请输入用户名或手机号">
                                <div class="err_box">
                                    <div class="err_msg2" style="display: none;">登录名可能是您的手机号、邮箱或用户名
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <input class="text" placeholder="请输入密码" name="password" id="password" type="password">
                                <div class="err_box">
                                    <div class="err_msg2" style="display: none;">您的密码可能为字母、数字或符号的组合</div>
                                </div>
                            </div>

                            <div class="item">
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

                            <div class="item item4">
                                <div class="safe ClearFix">
                                            <span>
                                            <input tabindex="4" class="jdcheckbox" name="autoLogin" id="autoLogin"
                                                   checked="checked" type="checkbox">
                                            <label for="autoLogin">记住用户名</label>
                                            </span>
                                    <span class="forget-pw-safe">
                                                <a target="_blank" class="" href="">忘记密码？</a>
                                            </span>
                                </div>
                            </div>
                            <div class="item">
                                <div class="login-btn">
                                    <a tabindex="6" id="loginsubmit"
                                       class="btn-img btn-entry"
                                       href="#" onclick="document.getElementById('form1').submit();">
                                        立即登录</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
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
            $("#password").val("");
        }
    }
</script>
</body>
</html>
