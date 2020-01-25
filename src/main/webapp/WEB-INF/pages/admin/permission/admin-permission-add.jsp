<%--
  Created by IntelliJ IDEA.
  User: yqf
  Date: 2020/1/18
  Time: 上午11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="/favicon.ico" >
    <link rel="Shortcut Icon" href="/favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/lib/html5shiv.js"></script>
    <script type="text/javascript" src="/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>新建网站角色 - 管理员管理 - H-ui.admin v3.1</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
</head>
<body onload="listenMsg()">
<article class="page-container">
    <form action="/space/insert" method="post" class="form form-horizontal" id="form-admin-role-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>模块名称：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box col-xs-8 col-sm-9" >
			<select class="select demoName" name="spaceName" style="width:100%;padding-bottom: 5px;">
                <optgroup label="管理员管理" >
                    <c:forEach items="${spaces}" var="space">
                        <option value="${space.spaceName}" >&nbsp;&nbsp;├${space.spaceName}</option>
                    </c:forEach>
                </optgroup>
			</select>
			</span> </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">网站权限：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <dl class="permission-list">
                    <dt>
                        <label>
                            权限集合
                        </label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <label class="">
                                <input type="checkbox" value="true" name="hasInsert" id="user-Character-0-0-0">
                                添加</label>
                            <label class="">
                                <input type="checkbox" value="true" name="hasUpdate" id="user-Character-0-0-1">
                                修改</label>
                            <label class="">
                                <input type="checkbox" value="true" name="hasDelete" id="user-Character-0-0-2">
                                删除</label>
                            <label class="">
                                <input type="checkbox" value="true" name="hasSelect" id="user-Character-0-0-3">
                                查看</label>
<%--                            <label class="c-orange"><input type="checkbox" value="true" name="只能操作自己的" id="user-Character-0-0-5"> 只能操作自己发布的</label>--%>
                        </dl>
                    </dd>
                </dl>

            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button type="submit" class="btn btn-success radius" id="submitDemo"><i class="icon-ok"></i> 确定</button>
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    $(function(){
        $(".permission-list dt input:checkbox").click(function(){
            $(this).closest("dl").find("dd input:checkbox").prop("checked",$(this).prop("checked"));
        });
        $(".permission-list2 dd input:checkbox").click(function(){
            var l =$(this).parent().parent().find("input:checked").length;
            var l2=$(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
            if($(this).prop("checked")){
                $(this).closest("dl").find("dt input:checkbox").prop("checked",true);
                $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",true);
            }
            else{
                if(l==0){
                    $(this).closest("dl").find("dt input:checkbox").prop("checked",false);
                }
                if(l2==0){
                    $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",false);
                }
            }
        });

        $("#form-admin-role-add").validate({
            rules:{
                demoName:{
                    required:true,
                },
            },
            onkeyup:true,
            focusCleanup:true,
            success:"valid",
            click:true,
        });
    });

</script>
<!--/请在上方写此页面业务相关的脚本-->
<script>
    function listenMsg() {
        if("${result.code}"){
            alert("${result.message}")
            window.parent.location.reload();
        }
    }
</script>
</body>
</html>

