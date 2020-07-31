<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; utf-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<title>欢迎页面</title>
<head>
    <meta charset="UTF-8">
    <style>
        label {
            width: 300px;
            height: 200px;
            text-align: left;
            font-size: 16px;
            color: grey;
        }

        .d1 {
            width: 300px;
            background-color: darkseagreen;
        }
    </style>
</head>
<body>
<div class="d1">
    <form action="../goods/insert" method="post" class="smart-green" enctype="multipart/form-data">
        <label>
            <span>商品名称 :</span>
            <input id="name" type="text" name="name" class="error" placeholder="请输入商品名称"/>
            <div class="error-msg"></div>
        </label>

        <label>
            <span>商品价格 :</span>
            <input id="price" type="text" name="price" class="error" placeholder="请输入商品价格"/>
            <div class="error-msg"></div>
        </label>

        <label>
            <span>商品库存 :</span>
            <input id="store" type="text" name="store" class="error" placeholder="请输入商品库存"/>
            <div class="error-msg"></div>
        </label>

        <label>
            <span>商品图片 :</span>
            <br>
            <input id="image" type="file" name="image" accept=".jpg,.png" onchange="xmTanUploadImg(this)"/>
        </label>

        <label>
            <span></span>
            <div style="border: 0px solid black;"><img id="img1" alt="" style="width: 60px; height: 50px;border:0"/>
            </div>
        </label>

        <label>
            <span>商品相关 :</span>
            <input id="about" type="text" name="about" class="error" placeholder="请输入商品相关"/>
            <div class="error-msg"></div>
        </label>

        <label>
            <span>上架时间 :</span>
            <input id="date" type="date" name="date"/>
            <div class="error-msg"></div>
        </label>
        <label>
            <span>所属类别 :</span>
            <select name="typeId">
                <option>请选择</option>
                <c:forEach items="${type}" var="t">
                    <option value="${t.tId}">${t.tName}</option>
                </c:forEach>
            </select>
            <div class="error-msg"></div>
        </label>

        <label>
            <input type="submit" class="button" value="提交"/>
        </label>
    </form>
</div>
<script type="text/javascript">
    //选择图片，马上预览
    function xmTanUploadImg(obj) {
        var file = obj.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            var img = document.getElementById("img1");
            img.src = e.target.result;
        }
        reader.readAsDataURL(file);
    }
</script>
<%@include file="_footer.html" %>
</body>
</html>
