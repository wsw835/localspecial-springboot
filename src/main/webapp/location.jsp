<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>自定义定位点图标</title>
</head>
<body>
<div id="container"></div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=ERNQyuzgqF1YtBicDnIxUsTwPuD22fN0"></script>
<script type="text/javascript">
    var pos = "";
    dz();

    function dz() {
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function getinfo(position) {
            city = position.address.city;
            province = position.address.province;
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
                           var arr = data.replies;
                           for (var i = 0; i < data.replies.length; i++) {
                           }
                       }, error: function (data) {
                    alert(系统错误);
                }
                   });
        }, function (e) {
            alert("获取百度定位位置信息失败");
        }, {provider: 'baidu'});
    }

</script>
</body>
</html>