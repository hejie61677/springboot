<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 2019/4/18
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>CategoryList</title>
</head>
<body>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${list}" var="list" varStatus="st">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
