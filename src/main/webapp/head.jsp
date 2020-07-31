<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script src="js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
<!--顶部公用-->
<div class="header">
    <!--顶部导航-->
    <div class="header_top">
        <div class="w1200">
            <div class="h_t_l">
                <div class="login_l">
                    <c:if test="${info==null}">
                        <span>欢迎来到快乐小站!</span>
                        <a class="a_login" href="login.jsp">[登录]</a>
                        <span class="line"></span>
                        <a class="" href="register.jsp">[注册]</a>
                    </c:if>
                    <c:if test="${info!=null}">
                        <span>欢迎${info}来到快乐小站!</span>
                    </c:if>
                </div>
            </div>
            <div class="h_t_r">
                <ul>
                    <li>
                        <a href="goods/showOrder?uname=${info}">订单查询</a>
                        <span class="line"></span>
                    </li>
                    <li>
                        <a href="goods/showOrder?uname=${info}">我的小站</a>
                        <span class="line"></span>
                    </li>
                    <li>
                        <i class="tel_icon"></i>
                        <a href="">400-705-1111</a>
                        <span class="line"></span>
                    </li>
                    <li class="cus_c_box">
                        <a href="">客服中心</a>
                        <div class="cus_center">
                            <a href="">帮助中心</a>
                            <a href="">会员反馈</a>
                        </div>
                    </li>
                    <li>
                        <a href="user/exit?flag=exit">退出</a>
                        <span class="line"></span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--搜索-->
    <div class="full_sc">
        <div class="w1200 header_conter">
            <div class="h_c_logo">
                <a href="index.jsp">
                    <img src="image/logo.png"/>
                </a>
            </div>
            <div class="h_c_bz">
                <img src="image/top_center.jpg" style="width: 467px;height:29px"/>
            </div>
            <div class="h_c_search">
                <div class="search_input">
                    <input type="hidden" value="${info}" name="uname" id="uname"/>
                    <input type="text" style="color: rgb(102, 102, 102);" name="keyword" id="keyword"
                           class="text_search"
                           placeholder="土鸡蛋"/>
                    <%-- <ul id="alist">
                         <c:forEach var="g" items="${goods}">
                         <li>${g.gName}</li>
                         </c:forEach>
                     </ul>
                 <script type="text/javascript">
                     $(function() {
                         $("#keyword").keyup(function() {
                             var value = $(this).val();
                             $("#alist li").each(function() {
                                 $(this).hide();
                                 if ($(this).text().indexOf($.trim(value)) >= 0) {
                                     alert("hello"+$(this).val());
                                     $(this).show();
                                 }
                             });
                         });
                     });
                 </script>--%>
                    <input type="button" class="btn_search" value="搜索"
                           onclick="javascript:document.location.href='goods/searchInfo?keyword='+$('#keyword').val();"/>
                </div>
                <%--    <div class="search_key">
                        <ul>
                            <li>
                                <a href="iemt.jsp">太阳镜</a>
                            </li>
                        </ul>
                    </div>--%>
            </div>
            <div class="h_c_right">
                <a href="goods/showCart?uname=${info}" class="h_c_r_car">
                    <span><i class="ci-count">
                    </i>我的购物车</span>
                    <b class="b_car2"></b>
                </a>
            </div>
        </div>
    </div>
    <!--菜单-->
    <div class="full_nav">
        <div class="w1200">
            <ul class="nav">
                <li class="li_all_type">
                    <a href="">全部分类</a>
                    <b class="b_down"></b>
                </li>
                <li class="home">
                    <a href="index.jsp" style="color: #C41F3A;">首页</a>
                </li>
                <li>
                    <a href="go.jsp">地方特产</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!--头部end-->
<script type="text/javascript">

    function getmyHistory() {
        var keyword = $("#keyword").val();
        var uname = $("#uname").val();
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
                alert(data.houseVO.list);
            }
        })
    }
</script>
</html>