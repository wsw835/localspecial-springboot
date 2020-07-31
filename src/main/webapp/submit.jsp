<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户中心</title>
    <link rel="stylesheet" type="text/css" href="css/head.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/suercenter.css"/>
    <link rel="stylesheet" type="text/css" href="css/iemt.css"/>
    <script src="js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(function () {
            //添加一个点击事件
            $(".color_ul li").click(function () {
                //切换颜色
                $(this).addClass("on").siblings().removeClass("on");
            });
            //添加商品数量
            $(".wrap_input .btn-add").click(function () {
                //获得input值
                var y = $(".buy_num").val();
                //转整
                x = parseInt(y) + 1;
                $(".buy_num").val(x);

            });
            //添加商品数量
            $(".wrap_input .btn-reduce").click(function () {
                //获得input值
                var y = $(".buy_num").val();
                //转整
                x = parseInt(y) - 1;
                if (x > 0) {
                    $(".buy_num").val(x);
                }

            });
        });
    </script>
</head>
<body>
<%@include file="head.jsp" %>
<div class="w1000 ClearFix margin_top20">
    <%@include file="left.jsp" %>

    <div class="ur_right">
        <!--uer_top-->
        <div class="ur_location">
            <a href="">我的快乐购</a>
            <span>&gt;</span>
            <a class="a_cur">我的购物车</a>
        </div>
        <!--uer_top-->
        <div class="ur_r_list">
            <div class="ur_list_tab">
                <ul class="ur_tab_ul">
                    <li class="on ">
                        <a href="">全部订单</a>
                    </li>
                    <li>
                        <a href="">待付款</a>
                    </li>
                    <li>
                        <a href="">待发货</a>
                    </li>
                    <li>
                        <a href="">待评价</a>
                    </li>
                </ul>
            </div>
            <table class="order_table">
                <thead class="thead">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>商品</td>
                    <td>单价</td>
                    <td>数量</td>
                    <td>总价</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${cartList}" var="cart">
                <!--订单商品-->
                <tr class="tr_bd">
                    <td class="padding_20"><input type="checkbox"/></td>

                    <td class="goods-item">
                        <div class="p-img">
                            <a href="">
                                <img src="goods/getImage?imageName=${cart.goods.gImage}" height="60" width="60">
                            </a>
                        </div>
                        <div class="p-msg">
                            <div class="p-name">
                                <a href="" class="a-link" title=""><c:out value="${cart.goods.gName}"/></a>
                            </div>
                        </div>
                    </td>

                    <td>
                        <div class="goods_price"><c:out value="${cart.goods.gPrice}"/></div>
                    </td>
                    <td>
                        <div class="goods_price"><c:out value="${cart.sCount}"/></div>
                    </td>
                    <td>
                        <div class="goods_price"><c:out value="${cart.sTotal}"/></div>
                    </td>
                    <td rowspan="1">
                        <div class="operate">
                            <p><a href="goods/deleteCart?uname=${info}&&sId=${cart.sId}" class="btn-del"><i
                                    class="icon-trash"></i>删除</a></p>
                            <p><a href="goAlipay?orderId=${cart.sId}&flag=cart" class="btn-buy"><i class="icon-trash"></i></a>
                            </p>
                        </div>
        </div>
        </td>
        </tr>
        <!--订单商品-->
        </c:forEach>

        </tbody>
        </table>
    </div>
    <!--page-->
    <!--分页-->
    <div class="page_list margin_top20">
        <div class="page_r">
            <ul>
                <li class="pre a_btn un">
                    <a href="goods/showCart?pageNo=${pageInfo.firstPage}&&uname=${info}"><span><b><</b>首页</span></a>
                </li>
                <li class="next a_btn">
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <a href="goods/showCart?pageNo=${pageInfo.pageNum-1}&&uname=${info}"><span><b><</b>上一页</span></a>
                    </c:if>
                </li>
                <li class="next a_btn">
                    <c:if test="${pageInfo.hasNextPage}">
                        <a href="goods/showCart?pageNo=${pageInfo.pageNum+1}&&uname=${info}"><span><b><</b>下一页</span></a>
                    </c:if>
                </li>
                <li class="next a_btn">
                    <a href="goods/showCart?pageNo=${pageInfo.lastPage}&&uname=${info}"><span>末页<b>></b></span></a>
                </li>
            </ul>
        </div>
    </div>
    <!--分页end-->
    <!--pageend-->
</div>
</div>
<%@include file="border.jsp" %>
</body>
</html>