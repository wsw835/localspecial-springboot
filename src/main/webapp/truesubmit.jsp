<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>提交订单成功</title>
    <link rel="stylesheet" type="text/css" href="css/head.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/go.css"/>
</head>
<body>
<div class="header">
    <div class="header_top">
        <div class="w1200">
            <div class="h_t_l">
                <div class="login_l">
                    <span>欢迎来到快乐购!</span>
                    <a class="a_login" href="">[登录]</a>
                    <span class="line"></span>
                    <a class="" href="">[注册]</a>
                </div>
            </div>
            <div class="h_t_r">
                <ul>
                    <li>
                        <a href="">订单查询</a>
                        <span class="line"></span>
                    </li>
                    <li>
                        <a href="">我的快乐购</a>
                        <span class="line"></span>
                    </li>
                    <li>
                        <i class="tel_icon"></i>
                        <a href="">400-705-1111</a>
                        <span class="line"></span>
                    </li>
                    <li>
                        <a href="">下载快乐购app</a>
                        <span class="line"></span>
                    </li>
                    <li>
                        <a href="">客服中心</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--图片-->
    <div class="full_sc order_bottom">
        <div class="w1200 header_conter ">
            <div class="h_c_logo">
                <a href="index.html">
                    <img src="image/logo.jpg"/>
                </a>
            </div>
            <div class="h_c_right">
                <div class="order_Status os_oredr"></div>
            </div>
        </div>
    </div>
    <!--end-->
</div>
<div class="public_b">
    <div class="w1200">
        <h2 class="payfor_h2"><i></i>在线支付</h2>
        <div class="payfo_tips"><i></i>订单已提交成功，现在就去付款吧</div>
        <div class="oder_me">
            <div class="o_n_t1">
                <div class="o_n_l">您的订单号<span>310517395876931757</span></div>
                <div class="o_n_m">应付金额：<span>￥199.00</span></div>
                <div class="o_n_r">支付方式：在线支付</div>
            </div>
            <div class="o_n_t2">
                <span class="s_fs_12">WEB9B9CE1E0D4,请于</span>
                <span class="s_fs_14" data="3060">
                        	<span class="s_fs_18" id="t_h">00</span>时 <span class="s_fs_18" id="t_m">34</span>分 <span
                        class="s_fs_18" id="t_s">26</span>
                        	秒 内完成付款,否则系统会将您的订单取消
                        </span>
            </div>
            <div class="choose_pay">
                <div class="choose_pay_box">
                    <div class="choose_agin">
                        <span class="s_radio"><label for="type_01" class="r_txt s_fs_18">支付宝/微信</label></span>
                        <div class="agin_radio">
                                    <span class="s_a_radio l_t_pay">
                                        <input id="type_02" name="s_radio" value="alipay" type="radio">
                                        <label for="type_02" class="r_txt"><i class="i_zfb"></i>支付宝支付</label>
                                    </span>
                            <span class="s_a_radio l_t_pay">
                                        <input id="type_03" name="s_radio" value="zxwx" type="radio">
                                        <label for="type_03" class="r_txt"><i class="i_wx"></i>微信支付</label>
                                    </span>
                        </div>
                    </div>
                </div>
                <form action="index.php?act=payment&amp;op=real_order" method="POST" id="buy_form">
                    <input name="pay_sn" value="310517395876931757" type="hidden">
                    <input id="payment_code" name="payment_code" value="" type="hidden">
                </form>
                <div class="btnsure_bg">
                    <div class="sureorder">
                        <div class="jine">应付总额：<span class="fwxh_30">￥</span><span class="span_m">199.00</span></div>
                        <a class="btn_sure" href="javascript:;" id="next_button">去付款&gt;</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="border.jsp" %>
</body>
</html>
