<%--
  Created by IntelliJ IDEA.
  User: yqf
  Date: 2020/1/19
  Time: 下午3:46
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
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="/favicon.ico">
    <link rel="Shortcut Icon" href="/favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/lib/html5shiv.js"></script>
    <script type="text/javascript" src="/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>新建网站角色 - 管理员管理 - H-ui.admin v3.1</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
</head>
<body onload="listenMsg()">
<article class="page-container">
    <form action="/role/update" method="post" class="form form-horizontal" id="form-admin-role-add">
        <div class="row cl">
            <input type="text" name="role.rid" value="${role.rid}" hidden>
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${role.roleName}" placeholder="" id="roleName" name="role.roleName" readonly>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>权重值:</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="number" class="input-text" value="${role.power}" placeholder="" name="role.power" min="1" max="5">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">备注：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${role.roleDescribe}" placeholder="" id="" name="role.roleDescribe">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">网站权限：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <dl class="permission-list">
                    <dt>
                        <label>权限设置</label>
                    </dt>
                    <dd>
                        <c:set var="count" value="0" scope="page"></c:set>
                        <c:forEach items="${spaces}" var="space">
                            <dl class="cl permission-list2">
                                <dt>
                                    <label class="">
                                        <input type="text" value="${space.sid}" name="spaces[${count }].sid" hidden>
                                        <c:choose>
                                            <c:when test="${roleSpaceBases[count].sid==space.sid}">
                                               <input type="checkbox" value="${space.spaceName}"
                                               name="spaces[${count}].spaceName" checked>
                                            ${space.spaceName}</label>
                                            </c:when>
                                            <c:otherwise>
                                                <input type="checkbox" value="${space.spaceName}"
                                                       name="spaces[${count}].spaceName">
                                                ${space.spaceName}</label>
                                            </c:otherwise>
                                        </c:choose>
                                </dt>
                                <dd>
                                    <c:if test="${space.hasSelect}">
                                        <c:choose >
                                            <c:when test="${roleSpaceBases[count].hasSelect}">
                                                <label class="">
                                                    <input type="checkbox" value="true" name="spaces[${count}].hasSelect"
                                                           checked>
                                                    查看
                                                </label
                                            </c:when>
                                            <c:otherwise>
                                                <label class="">
                                                    <input type="checkbox" value="true" name="spaces[${count}].hasSelect">
                                                    查看
                                                </label
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>

                                    <c:if test="${space.hasUpdate}">
                                        <c:choose >
                                            <c:when test="${roleSpaceBases[count].hasUpdate}">
                                                <label class="">
                                                    <input type="checkbox" value="true" name="spaces[${count}].hasUpdate" checked>
                                                    更新
                                                </label
                                            </c:when>
                                            <c:otherwise>
                                                <label class="">
                                                    <input type="checkbox" value="true" name="spaces[${count}].hasUpdate">
                                                    更新
                                                </label
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>

                                    <c:if test="${space.hasInsert}">
                                        <c:choose>
                                            <c:when test="${roleSpaceBases[count].hasInsert}">
                                                <label class="">
                                                    <input type="checkbox" value="true" name="spaces[${count}].hasInsert" checked>
                                                    插入
                                                </label
                                            </c:when>
                                            <c:otherwise>
                                                <label class="">
                                                    <input type="checkbox" value="true" name="spaces[${count}].hasInsert">
                                                    插入
                                                </label
                                            </c:otherwise>
                                        </c:choose>

                                    </c:if>

                                    <c:if test="${space.hasDelete}">
                                        <c:choose>
                                            <c:when test="${roleSpaceBases[count].hasDelete}">
                                                <label class=" ">
                                                    <input type="checkbox" value="true" name="spaces[${count}].hasDelete" checked>
                                                    删除
                                                </label
                                            </c:when>
                                            <c:otherwise>
                                                <label class=" ${roleSpaceBases[count].hasDelete}">
                                                    <input type="checkbox" value="true" name="spaces[${count}].hasDelete">
                                                    删除
                                                </label
                                            </c:otherwise>
                                        </c:choose>

                                    </c:if>
                                </dd>
                            </dl>
                            <c:set value="${count = count+1}" var="count" scope="page"></c:set>
                        </c:forEach>
                    </dd>
                </dl>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <button type="submit" class="btn btn-success radius" id="admin-role-save" name="admin-role-save"><i
                        class="icon-ok"></i> 确定
                </button>
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
    $(function () {
        $(".permission-list dt input:checkbox").click(function () {
            $(this).closest("dl").find("dd input:checkbox").prop("checked", $(this).prop("checked"));
        });
        $(".permission-list2 dd input:checkbox").click(function () {
            var l = $(this).parent().parent().find("input:checked").length;
            var l2 = $(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
            if ($(this).prop("checked")) {
                $(this).closest("dl").find("dt input:checkbox").prop("checked", true);
                $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked", true);
            } else {
                if (l == 0) {
                    $(this).closest("dl").find("dt input:checkbox").prop("checked", false);
                }
                if (l2 == 0) {
                    $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked", false);
                }
            }
        });

        $("#form-admin-role-add").validate({
            rules: {//配置提醒信息
                roleName: {
                    required: true,
                },
                weight: {
                    required: true,
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
        });
    });

</script>
<!--/请在上方写此页面业务相关的脚本-->
<script>
    function listenMsg() {
        if ("${result.code}") {
            alert("${result.message}")
            window.parent.location.reload();
        }
    }
</script>

</body>
</html>

