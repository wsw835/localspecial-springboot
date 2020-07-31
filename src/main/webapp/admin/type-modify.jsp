<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="com.blog.servicesImpl.*,java.util.*,com.blog.entity.*" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="/favicon.ico">
    <link rel="Shortcut Icon" href="/favicon.ico"/>
    <link rel="stylesheet" type="text/css"
          href=" static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css"
          href=" static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css"
          href=" lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css"
          href=" static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css"
          href=" static/h-ui.admin/css/style.css"/>
    <title>修改文章-资讯管理</title>
</head>
<body>
<%

%>
<article class="page-container">
    <form class="form form-horizontal" id="form-article-modify"
          action="../TypeServlet?flay=xg&t_id=${bj.t_id}" method="post">
        <!-- 定义一个隐藏域用于传flag信号 -->
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span
                    class="c-red">*</span>类别名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${bj.t_name}"
                       placeholder="" id="atitle" name="t_name">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span
                    class="c-red">*</span>类别编号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" disabled class="input-text" value="${bj.t_id}"
                       placeholder="" id="t_id" name="t_id">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">类别简介：</label>
            <div class="formControls col-xs-8 col-sm-9">
					<textarea name="t_content" cols="" rows="" class="textarea"
                              value="" datatype="*10-100" dragonfly="true"
                              nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)"
                    >${bj.t_content}</textarea>

            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <button
                        class="btn btn-primary radius" type="submit">
                    <i class="Hui-iconfont">&#xe632;</i>保存修改
                </button>

                <button onClick="removeIframe();" class="btn btn-default radius"
                        type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;
                </button>
            </div>
        </div>
    </form>

</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src=" lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src=" lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src=" static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src=" static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"
        src=" lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
        src=" lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript"
        src=" lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript"
        src=" lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript"
        src=" lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript"
        src=" lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript"
        src=" lib/ueditor/1.4.3/ueditor.all.min.js"></script>
<script type="text/javascript"
        src="lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javas cript">


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>