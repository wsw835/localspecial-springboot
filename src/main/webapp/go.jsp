<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>地方特产</title>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/head.css"/>
    <link rel="stylesheet" type="text/css" href="css/goods.css"/>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=ERNQyuzgqF1YtBicDnIxUsTwPuD22fN0"></script>

</head>
<body>
<%@include file="head.jsp" %>
<!--图片大图end-->
<!--类容-->
<div class="w1200">
    <div style="width: 100%;height:50px">
        <p id="located" style="display: block;margin-top: 15px;margin-left: 5px;color: blue;"></p>
    </div>
    <ul class="con_list_pic" id="ul_goods">
        <c:forEach items="${goodLocatedList}" var="g">
            <li>
                <a href="goods/getOne?id=${g.gId}&&uname=${info}" class="pro">
                    <p class="p_img"><img src="goods/getImage?imageName=${g.gImage}"
                                          style="border-radius:10px;
                                          width:200px;height:150px;margin:30px 0 0 30px;padding:0;"/>
                        <span style="display: block;text-align: center;margin-top: 15px">${g.gName}
                                ￥${g.gPrice}</span></p>
                </a>
            </li>
        </c:forEach>
    </ul>
</div>

<!--类容end-->
<%@include file="border.jsp" %>
<script type="text/javascript">
    $("#ul_goods").hide();
    dz();

    function dz() {
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function getinfo(position) {
            city = position.address.city;
            province = position.address.province;
            confirm("定位成功！当前定位结果为:" + province);
            document.getElementById("located").innerHTML = "当前所在省：" + province;
                var obj = {};
                obj.province = province;
                var json = JSON.stringify(obj);
                $.ajax({
                           dataType: "json",
                           type: "post",
                           url: "goods/location",
                           contentType: "application/json;charset=utf-8",
                           data: json,
                           success: function (data) {
                               $("#ul_goods").show();
                               setInterval(function(){
                                   window.location.reload();
                               },500000)
                           }
                       });
        }, function (e) {
            alert("获取百度定位位置信息失败");
        }, {provider: 'baidu'});
    }

</script>
</body>
</html>
