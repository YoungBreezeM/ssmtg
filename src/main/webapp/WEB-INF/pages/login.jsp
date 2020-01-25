<%--
  Created by IntelliJ IDEA.
  User: yqf
  Date: 2020/1/17
  Time: 下午5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>蜂网登录界面</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="static/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/fontastic.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <link rel="stylesheet" href="static/css/style.default.css" id="theme-stylesheet">
    <link rel="stylesheet" href="static/css/custom.css">
</head>
<body onload="listenMsg()">
<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>蜂网</h1>
                            </div>
                            <p>欢迎使用蜂网后台管理系统</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form method="post" action="/login" class="form-validate">
                                <div class="form-group">
                                    <input id="login-username" type="text" name="userName" required data-msg="" class="input-material">
                                    <label for="login-username" class="label-material" >用户名</label>
                                </div>
                                <div class="form-group">
                                    <input id="login-password" type="password" name="password" required data-msg="" class="input-material">
                                    <label for="login-password" class="label-material">密码</label>
                                </div><input type="submit"  id="login" class="btn btn-primary" value="登录">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="copyrights text-center">
        <p>蜂网 <a href="#" class="external">后台管理系统</a>
        </p>
    </div>
</div>
<script src="static/vendor/jquery/jquery.min.js"></script>
<script src="static/vendor/popper.js/umd/popper.min.js"> </script>
<script src="static/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="static/vendor/jquery.cookie/jquery.cookie.js"> </script>
<script src="static/vendor/chart.js/Chart.min.js"></script>
<script src="static/vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="static/js/front.js"></script>
<script>
    function listenMsg() {
        if("${result.code}"){
            alert("${result.message}")
        }
    }
</script>
</body>
</html>

