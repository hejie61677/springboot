<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 2019/4/19
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="icon" href="${pageContext.request.contextPath}/static/ico/favicon.ico">
</head>
<body>
<div style="margin:auto; width:500px">
    <form action="../category/${category.id}" method="post">
        <input type="hidden" name="_method" value="put">
        <label>name:<input name="name" value="${category.name}" maxlength="16"></label>
        <input name="id" type="hidden" value="${category.id}">
        <button type="submit">modify</button>
    </form>
</div>

</body>
</html>
