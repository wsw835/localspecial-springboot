<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/head.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
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
                var y = $("#buy_num").val();
                //转整
                x = parseInt(y) + 1;
                $("#buy_num").val(x);

            });
            //添加商品数量
            $(".wrap_input .btn-reduce").click(function () {
                //获得input值
                var y = $("#buy_num").val();
                //转整
                x = parseInt(y) - 1;
                if (x > 0) {
                    $("#buy_num").val(x);
                }
            });
        });
    </script>
</head>
<body>
<%@include file="head.jsp" %>
<c:if test="${goodOne==null}"><%response.sendRedirect("index.jsp");%></c:if>
<div class="w1200">
    <!--分类导航-->
    <div class="con_content">
        <!--提交区域-->
        <div class="con_top">
            <div class="con_top_l">
                <div class="tab-w">
                    <!--放大镜-->
                    <div class="divw">
                        <a href="">
                            <span class="zoomPad">
                                <img src="goods/getImage?imageName=${goodOne.gImage}"
                                     style="width: 300px;height: 250px;margin: 50px 20px 0px 100px"/>
                                <div style="top: 148px; left: 153.5px; width: 180px; height: 180px; position: absolute; border-width: 1px; display: none;"
                                     class="zoomPup"></div>
                                <div style="position: absolute; z-index: 500; left: 390px; top: 0px; display: none;"
                                     class="zoomWindow">
                                    <div style="width: 380px;" class="zoomWrapper"><div
                                            style="width: 100%; position: absolute; display: block;"
                                            class="zoomWrapperTitle"></div>
	    									    <div style="width: 100%; height: 380px;" class="zoomWrapperImage"><img
                                                        src="image/con_c_2.png"
                                                        style="position: absolute; border: 0px none; display: block; left: -5000px; top: 0px; width: 800px; height: 800px;">
	    									    </div>
	    									</div>
	    								</div>
                                    </span>
                        </a>
                    </div>
                    <!--放大镜-->
                </div>
            </div>
            <div class="con_top_r">
                <div class="detail_top">
                    <h1 class="detail_tit"><b>${goodOne.gName}</b></h1>
                    <div class="price_wrap">
                        <div class="detail_price">
									<span class="price_now">
	    								<b class="em_sign">价格￥</b>
	    								${goodOne.gPrice}
	    							</span>/斤
                        </div>
                        <div class="d_bh">编号：919779${goodOne.gId}</div>
                    </div>
                    <div class="model_wrap count_wrap">
                        <span class="pop_tit">数量：</span>
                        <div class="wrap_input">
                            <a href="javascript://" data-param="0" class="btn-add">-</a>
                            <a href="javascript://" data-param="0" class="btn-reduce">+</a>
                            <input value="1" id="buy_num" class="text"
                                   onkeyup="this.value=this.value.replace(/\D/g, '');">
                        </div>
                    </div>
                </div>
                <div class="model_wrap count_wrap">
                    <span class="pop_tit"> 商品详情:</span>
                    <div style="width:600px;height:35px;margin-top:20px;color:blueviolet;font-size: 14px">${goodOne.gAbout}</div>
                </div>
                <div class="model_wrap count_wrap">
                    <span class="pop_tit">选择地址:</span>
                    <select name="aId" style="width:200px;height:35px;margin-top:16px">
                        <c:forEach var="list" items="${addressList}">
                            <option value="${list.aId}">${list.aAddr}/${list.aDetail}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="hidden" value="${info}" id="uname">
                <div class="model_wrap">
                    <a onclick="window.location.href='goods/addCart?name=${info}&&id=${goodOne.gId}&&gNum='+$('#buy_num').val()"
                       class="gwc" style="margin-right: 500px;margin-top:0px"></a>
                    <div class="model_submilt">
                        <div class="btn_goods_remind">
                            <a onclick="window.location.href='goods/addOrder?name=${info}&&id=${goodOne.gId}&&gNum='+$('#buy_num').val()">下单</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="appraise_box">
    <div class="detail_lists ">
        <div class="d_h2 ">
            <h2>用户评价</h2>
        </div>
        <div style="width:300px;margin-left: 180px;float: left;">
            <form id="comment" action="comments/addComments?id=${goodOne.gId}&&uname=${info}" method="post">
                <p style="color:indianred;font-size: 14px"><span style="color:darkslateblue">${user.uName}</span></p>
                <input type="hidden" name="gId" value="${goodOne.gId}"/>
                <input type="hidden" name="uId" value="${user.uId}"/>
                <textarea name="cComment" rows="" cols="" placeholder="请输入评论内容"
                          style="width: 220px; height:130px;border: 1px solid pink;"></textarea>
                <p style="margin-top:10px; line-height:20px ">
                    <input type="button" onclick="document.getElementById('comment').submit();" value="提交评论">
                </p>
            </form>
        </div>
        <div style="width:500px;margin: 0 0 0 50px;float: left">
            <ul>
                <c:forEach items="${commentsList}" var="com">
                    <li>
                        <div style="border: dashed 1px lightpink;width:600px;height:50px"><p><span
                                style="color:darkslateblue;font-size: 16px">#${com.user.uName}</span><span
                                style="margin:10px 0 0 80px;font-size: 12px;color:darkgrey"><fmt:formatDate
                                value="${com.cDate}" pattern="yyyy-MM-dd"/></span></p>
                            <span style="color:grey;font-size: 14px">#${com.cComment}</span></div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</div>
</div>
</div>
<%@include file="border.jsp" %>
</body>
</html>