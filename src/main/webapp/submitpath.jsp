<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>提交订单</title>
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
    <form action="" method="post">
        <div class="w1200">
            <div class="h2">确认订单信息</div>
            <!--地址选择-->
            <div class="o_o_content">
                <h2 class="part_h2">
                    1 地址选择
                    <span class="addr_errtips">
								<i class="icon_err"></i>
								您好！此地址不在该商品配送区域范围内，请选择其他收货地址！
							</span>
                </h2>
                <div class="new_addr">
                    <div class="ncc-form-default">
                        <form action="" method="post">

                            <input value="buy" name="act" type="hidden">
                            <input value="add_addr" name="op" type="hidden">
                            <input name="form_submit" value="ok" type="hidden">
                            <dl>
                                <dt><i class="required">*</i>收货人姓名：</dt>
                                <dd>
                                    <input class="text w100" name="true_name" maxlength="20" id="true_name" value=""
                                           type="text">
                                </dd>
                            </dl>
                            <dl>
                                <dt><i class="required">*</i>所在地区：</dt>
                                <dd>
                                    <div id="region">
                                        <select name="statename" id="statename">
                                            <option value="0">请选择省份</option>
                                        </select>
                                        <select name="city" id="city">
                                            <option>请选择城市</option>
                                        </select>
                                        <select name="county" id="county">
                                            <option>请选择区县</option>
                                        </select>
                                        <select name="town" id="town" style="display:none;">
                                            <option>请选择乡镇</option>
                                        </select>
                                        <input value="" name="city_id" id="city_id" type="hidden">
                                        <input name="area_id" id="area_id" class="area_ids" type="hidden">
                                        <input name="area_info" id="area_info" class="area_names" type="hidden">
                                        <input value="" name="statename_name" id="statename_name" type="hidden">
                                        <input value="" name="city_name" id="city_name" type="hidden">
                                        <input value="" name="county_name" id="county_name" type="hidden">
                                        <input value="" name="town_name" id="town_name" type="hidden">
                                        <input value="" name="transpzone_id" id="transpzone_id" type="hidden">
                                        <input value="" name="receiver_seq_id" id="receiver_seq_id" type="hidden">

                                    </div>
                                </dd>
                            </dl>
                            <dl>
                                <dt><i class="required">*</i>详细地址：</dt>
                                <dd>
                                    <input class="text w500" name="address" id="address" maxlength="80" value=""
                                           type="text">
                                    <p class="hint">请填写真实地址，不需要重复填写所在地区</p>
                                </dd>
                            </dl>
                            <dl>
                                <dt><i class="required">*</i>手机号码：</dt>
                                <dd>
                                    <input class="text w200" name="mob_phone" id="mob_phone" maxlength="15" value=""
                                           type="text"> &nbsp;&nbsp;(或)&nbsp;固定电话： <input class="text w200"
                                                                                          id="tel_phone"
                                                                                          name="tel_phone"
                                                                                          maxlength="20" value=""
                                                                                          type="text">
                                </dd>
                            </dl>
                            <div class="btn_item">
                                <a href="javascript:;" class="btn_addaddr">确定</a>　<a href="javascript:;"
                                                                                     class="btn_addaddr"
                                                                                     onclick="submitAddList();">返回</a>
                            </div>

                        </form>
                    </div>
                </div>
                <div style="display: none;" class="addr_list" id="addr_list">
                    <ul>
                        <li class="addr_new">
                            <div class="btn_new_addr" nc_type="addr" id="add_addr">添加新地址</div>
                        </li>
                    </ul>
                </div>
                <!--支付方式-->
                <div class="o_o_part o_o_part2">
                    <h2 class="part_h2">2 支付方式</h2>
                    <div class="pay_type">
                        <ul>
                            <li class="on" payment_code="online">
                                在线支付<b></b>
                            </li>
                            <li payment_code="offline">
                                货到付款<b></b>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--支付方式-->
                <!--商品-->
                <div class="o_o_part o_o_part3">
                    <h2 class="part_h2">3&nbsp;商品清单<a class="a_return_car" href=""> &lt; 返回购物车</a></h2>
                    <div class="oder_shop">
                        <!--shoptitle-->
                        <div class="shop_tit">
                            <div class="cart_checkbox">
                                <span>商品名称</span>
                            </div>
                            <div class="column cart_standard">规格</div>
                            <div class="column t_price">单价(元)</div>
                            <div class="column t_quantity">数量</div>
                            <div class="column t_sum">小计(元)</div>
                        </div>
                        <!--shoptitle-->
                        <!--shoplist-->
                        <div class="item_list">
                            <div class="item_form">
                                <div class="cell p_checkbox"></div>
                                <div class="cell p_goods">
                                    <div class="goods_item">
                                        <div class="p_imgs">
                                            <a target="_blank" href="">
                                                <img src="image/submit_shop.jpg"
                                                     alt="东菱多功能便携式果汁机（1+2） 组"></a>
                                        </div>
                                        <div class="item_msg">
                                            <div class="p_border_bottom">
                                                <div class="p_name">
                                                    <a target="_blank" href="http://www.happigo.com/item-0-174196.html">东菱多功能便携式果汁机（1+2）
                                                        组</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="cell p_standard">
                                    <p class="p_g_standard p_border_bottom"></p>
                                </div>
                                <div class="cell p_price p_border_bottom">
                                    <p class="p_prices2">199.00</p>
                                </div>
                                <div class="cell p_quantity">
                                    <div class="quantity_form p_border_bottom">x1</div>
                                </div>
                                <div class="cell p_sum p_border_bottom">
                                    <strong>199.00</strong>
                                </div>
                            </div>
                        </div>
                        <!--shoplist-->
                        <!--优惠卷-->
                        <div class="border_b">
                            <div class="user_jf_yhj">
                                <div class="user_jf_yhj_t">
                                    <b>-</b>使用积分和优惠券
                                </div>
                            </div>
                            <div class="use_jf_yhj_c">
                                <div class="order_items">
                                    <div class="yhj_show">使用优惠券：</div>
                                    <select name="">
                                        <option value="0">----不使用----</option>
                                        <option value="5285942">5(188元新人套券-5元)</option>
                                        <option value="5285943">10(188元新人套券-10元)</option>
                                        <option value="5285944">20(188元新人套券-20元)</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <!--优惠卷-->
                        <!--结算-->
                        <div class="yhxx_box">
                            <ul class="yhxx_list">
                                <li>
                                    <div class="yhxx_tit">商品总额<span class="yhxx_money">￥<span>199</span> </span>
                                    </div>
                                </li>
                                <me id="paypromotion"></me>
                                <me id="paypromotion_info"></me>
                                <li>
                                    <div class="yhxx_tit">优惠券<span class="yhxx_money"><span
                                            class="s_jian">-</span>￥<span id="voucher_price">0</span> </span>
                                    </div>
                                </li>
                                <li class="margin_top10">
                                    <div class="yhxx_tit">本单应付 <span class="yhxx_money">￥<span
                                            class="s_sum s_order_money">199</span> </span>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <!--结算-->
                        <!--发票-->
                        <div class="ask_bill">
                            <p>
                                <label class="lab_bill">
                                    <input name="fapiao" value="1" checked="" type="checkbox">
                                    <span>索要发票</span>
                                </label>
                            </p>
                            <ul class="ask_bill_ul">
                                <li fapiao_type="电子发票" class="on">电子发票<b></b></li>
                                <li fapiao_type="普通发票">普通发票<b></b></li>
                            </ul>
                            <p class="bill_c">
                                发票抬头：
                                <label class="lab_bill p_r_30">
                                    <input name="" value="1" checked="checked" type="radio"><span>个人</span>
                                </label>
                                <label class="lab_bill">
                                    <input name="" value="2" type="radio"><span>单位</span>
                                </label>
                            </p>
                            <div class="bill_c bill_unit" style="display:none;">
                                <p>
                                    <span class="bill_c_name">单位名称：  </span>
                                    <input class="bill_itxt" name="fapiao_danwei" type="text">
                                </p>
                                <p class="bill_tips">温馨提示：您填写的内容将被系统自动打印到发票上，请勿填写发票抬头无关的信息.</p>
                            </div>
                        </div>
                        <!--发票-->
                        <div class="btnsure_bg">
                            <div class="sureorder">
                                <div class="jine">应付总额：<span class="fwxh_30">￥</span><span class="span_m s_order_money">199</span>
                                </div>
                                <a class="un_btn_sure" id="btn_sure" href="javascript:void(0);">提交订单</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!--商品-->
            </div>
            <!--地址选择end-->
        </div>
    </form>
</div>
<%@include file="border.jsp" %>
</body>
</html>
