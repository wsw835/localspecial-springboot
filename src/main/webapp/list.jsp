<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>分类页面</title>
    <link rel="stylesheet" type="text/css" href="css/head.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/list.css"/>
</head>
<body>
<%@include file="head.jsp" %>
<div class="w1200">
    <!--分类导航-->
    <div class="top_nv">
        <span><a href="index.jsp">首页</a></span>
        <span>></span>
        <span>${type.tName}</span>
    </div>
    <!--分类导航-->
    <div class="box_list">
        <div class="sl_list">
            <ul>
                <c:forEach items="${typeGoods}" var="goods">
                    <li>
                        <a href="goods/getOne?id=${goods.gId}&&uname=${info}">
                            <span class="list_img"><img src="goods/getImage?imageName=${goods.gImage}"
                                                        style="border-radius:10px;width:200px;height:150px;margin:30px 0 0 15px;padding:0;"/></span>
                            <span class="sl_list_con">
	    							<span class="sl_price">
	    								<b class="sl_price1"><span>￥${goods.gPrice}</span></b>
	    							</span>
	    						</span>
                            <span class="sl_title">${goods.gName}</span>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <%--    <!--分页-->
        <div class="page_list margin_top20">
            <div class="page_r">
                <ul>
                    <li class="pre a_btn un">
                        <a href="goods/showOrder?pageNo=${pageInfo.firstPage}&&uname=${info}"><span><b><</b>首页</span></a>
                    </li>
                    <li class="next a_btn">
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <a href="goods/showOrder?pageNo=${pageInfo.pageNum-1}&&uname=${info}"><span><b><</b>上一页</span></a>
                        </c:if>
                    </li>
                    <li class="next a_btn">
                        <c:if test="${pageInfo.hasNextPage}">
                            <a href="goods/showOrder?pageNo=${pageInfo.pageNum+1}&&uname=${info}"><span><b><</b>下一页</span></a>
                        </c:if>
                    </li>
                    <li class="next a_btn">
                        <a href="goods/showOrder?pageNo=${pageInfo.lastPage}&&uname=${info}"><span>末页<b>></b></span></a>
                    </li>
                </ul>
            </div>
        </div>
        <!--分页end-->--%>
</div>
<%@include file="border.jsp" %>
</body>
</html>
