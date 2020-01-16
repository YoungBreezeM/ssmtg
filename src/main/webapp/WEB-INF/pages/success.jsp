<%--
  Created by IntelliJ IDEA.
  User: yqf
  Date: 2020/1/16
  Time: 下午6:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <c:forEach items="${students}" var="student">
     ${student.name}<br>
 </c:forEach>
</body>
</html>
