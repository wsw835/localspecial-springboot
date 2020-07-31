<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>土味小站</title>
    <link rel="stylesheet" type="text/css" href="css/head.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //轮播图效果
            var c = 0;

            //加一个时间事件
            function timer() {
                //获得序号
                c++;
                if (c == 6) {
                    c = 0;
                }
                //让自己显示，兄弟元素隐藏
                $("#inBaner .big_eye_pic li").eq(c).stop().fadeIn(1800).siblings().fadeOut(800);
                //改变颜色
                $("#inBaner .btn ul li").eq(c).stop().addClass("cur").siblings().removeClass("cur");
            }

            time = setInterval(timer, 2000);
            //给图片添加一个移入移出效果
            $("#inBaner").hover(function () {
                //停止时间
                clearInterval(time);
            }, function () {
                //时间继续
                time = setInterval(timer, 2000);
            });
            //给色块添加一个移入移出事件
            $("#inBaner .btn ul li").mouseenter(function () {
                var n = $(this).index();
                //让第一个人图片显示 其余的隐藏
                $("#inBaner .big_eye_pic li").eq(n).stop().show().siblings().hide();
                //改变颜色
                $("#inBaner .btn ul li").eq(n).stop().addClass("cur").siblings().removeClass("cur");
            });
            //添加一个点击事件
            $(".her_top .her_title .her_menu li").click(function () {
                var n = $(this).index();
                //切换颜色
                $(".her_menu li").eq(n).addClass("current").siblings().removeClass("current");
                //切换商品
                $(".her_top .pro_con").eq(n).show().siblings(".pro_con").hide();
            })
            //搜索框下滑
            $(window).scroll(function () {
                //获得滚动条距离顶部距离
                var t = $(document).scrollTop();
                if (t > 530) {
                    $("#nav").show();
                } else {
                    $("#nav").hide();
                }
            });
        });
    </script>
    <script type="text/javascript">
        var intDiff = parseInt(3600); //倒计时总秒数量
        function timer(intDiff) {
            window.setInterval(function () {
                var day = 0,
                    hour = 0,
                    minute = 0,
                    second = 0; //时间默认值
                if (intDiff > 0) {
                    day = Math.floor(intDiff / (60 * 60 * 24));
                    hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
                    minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
                    second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
                }
                if (minute <= 9) minute = '0' + minute;
                if (second <= 9) second = '0' + second;
                $('#day_show').html(day + "天");
                $('#hour_show').html('<s id="h"></s>' + hour + '时');
                $('#minute_show').html('<s></s>' + minute + '分');
                $('#second_show').html('<s></s>' + second + '秒');
                intDiff--;
                if (intDiff == 0) {
                    $("#iu").hide();
                    $("#ig").hide();
                    $("#in").hide();
                }
            }, 1000);
        }

        $(function () {
            timer(intDiff);
        });
    </script>
    <style type="text/css">
        .time-item strong {
            background: #C71C60;
            color: #fff;
            line-height: 49px;
            font-size: 36px;
            font-family: Arial;
            padding: 0 10px;
            margin-right: 10px;
            border-radius: 5px;
            box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.2);
        }

        #day_show {
            line-height: 49px;
            color: #c71c60;
            font-size: 32px;
            margin: 0 10px;
            font-family: Arial, Helvetica, sans-serif;
        }

        .item-title .unit {
            background: none;
            line-height: 49px;
            font-size: 24px;
            padding: 0 10px;
            float: left;
        }
    </style>
</head>
<body>
<c:if test="${typeList==null}"><%response.sendRedirect("user/getInfo");%></c:if>
<!--轮播区域-->
<%@include file="head.jsp" %>


<div class="full_big_eye">
    <!--菜单-->
    <div class="index_type">
        <ul class="index_type_ul">
            <c:forEach items="${typeList}" var="type">
                <li>
                    <span>
                        <a href="goods/goodsForType?tId=${type.tId}" style="color:goldenrod;">
                            <strong style="text-align: center;font-size: 16px">${type.tName}</strong></a><b>></b>
                    </span>
                </li>
            </c:forEach>
        </ul>
    </div>
    <!--菜单-->
    <!--轮播图-->
    <div class="full_eye">
        <div id="inBaner">
            <ul class="big_eye_pic">
                <li style="display: block;">
                    <a href="" class="img_box">
                        <img src="image/web-101-101-1.jpg"/>
                    </a>
                </li>
                <li>
                    <a href="" class="tpl">
                        <img src="image/web-101-101-2.jpg"/>
                    </a>
                </li>
                <li>
                    <a href="" class="tpl">
                        <img src="image/web-101-101-3.jpg"/>
                    </a>
                </li>
                <li>
                    <a href="" class="tpl">
                        <img src="image/web-101-101-4.jpg"/>
                    </a>
                </li>
            </ul>
            <div class="btn">
                <ul>
                    <li class="cur"></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
        </div>
    </div>
    <!--轮播图-->
</div>
<!--轮播区域-->
<!--商品区-->
<div class="w1200">
    <div class="her_top">
        <div class="pro_con" style="display: block;">
            <div class="P_left">
                <div class="groDiv">
                    <div style="/*position: relative;*//*overflow: hidden;*/">
                        <h2 style="color:hotpink">猜您喜欢</h2>
                        <ul class="groUlOut">
                            <c:forEach items="${goodList}" var="g">
                                <li style="float: left;width: 224px;">
                                    <a href="goods/getOne?id=${g.gId}&&uname=${info}" class="pro">
                                        <img src="goods/getImage?imageName=${g.gImage}"
                                             style="border-radius:10px;width:200px;height:150px;margin:30px 0 0 15px;padding:0;"/>
                                    </a>
                                    <p class="box_glay">
                                        <a href="goods/getOne?id=${g.gId}&&uname=${info}" class="pro_text">
                                            <span>${g.gName}</span>
                                        </a>
                                    </p>
                                    <p class="p_num">
                                        No.10654332${g.gId}
                                    </p>
                                    <div class="now_price">
                                        <div class="price">
	    	    								<span class="bigfont">
	    	    									<span class="f_14">￥</span><span>${g.gPrice}</span>
	    	    								</span>
                                            <a href="goods/addCart?id=${g.gId}&&name=${info}&&gNum=1" class="gwc"></a>
                                        </div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <h2 style="color:hotpink" id="in">限时抢购</h2>
    <div class="time-item" align="center" ID="iu">
        <span id="day_show">0天</span>
        <strong id="hour_show">0时</strong>
        <strong id="minute_show">0分</strong>
        <strong id="second_show">0秒</strong>
    </div>
    <!--倒计时模块-->
    <ul class="jinpin_ul" id="ig">
        <c:forEach items="${goodsNew}" var="n">
            <li>
                <a href="goods/getOne?id=${n.gId}&&uname=${info}"><img src="goods/getImage?imageName=${n.gImage}"
                                                                       style="margin:25px 20px 20px 160px;width:300px;height:200px;vertical-align: center;border: hidden;border-radius: 20px"/></a>
                <a href="goods/getOne?id=${n.gId}&&uname=${info}" class="ppsx_tc">
                    <div class="ppsx_tc_xx">
                        <div class="ppsx_tc_xx1">
                            <div class="ppsx_xx_zk"><span>${n.gPrice}</span>元起</div>
                            <div class="ppsx_xx_qg">立即抢购</div>
                        </div>
                    </div>
                </a>
            </li>
        </c:forEach>
    </ul>
</div>
<!--商品区-->
<!--下拉搜索-->
<div id="nav" class="search_fixed">
    <div class="w1200">
        <div class="s_fixed_l"><img src="image/logo.png" style="width: 50px;height: 50px"/></div>
        <div class="s_fixed_r">
            <input type="hidden" value="${info}" name="uName" id="uname"/>
            <input type="text" style="color: rgb(102, 102, 102);" name="keyWord" id="keyword" class="text_search"
                   placeholder="土鸡蛋" onblur="getmyHistory()" autocomplete="off"/>
            <input type="button" class="btn_search" value="搜索"
                   onclick="javascript:document.location.href='goods/searchInfo?keyword='+$('#keyword').val();"/>
        </div>
    </div>
</div>
<%@include file="border.jsp" %>
<!--下拉搜索end-->

<script type="text/javascript">

    function getmyHistory() {
        var keyword = $("#keyword").val();
        var uname = $("#uname").val();
        if (uname == null) {
            uname = "123";
        }
        var obj = {};
        obj.keyword = keyword;
        obj.uname = uname;
        var json = JSON.stringify(obj);

        $.ajax({
            type: "post",
            url: "goods/history",
            contentType: "application/json;charset=utf-8",
            data: json,
            success: function (data) {
                alert(data.list);
            }
        })
    }
</script>
</body>
</html>
