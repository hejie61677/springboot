<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 2019/4/19
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin:0px auto; width:500px">
    <form action="updateCategory1" method="post">
        name: <input name="name" value="${category.name}">
        <input name="id" type="hidden" value="${category.id}">
        <button type="submit">modify</button>
    </form>
</div>

</body>
</html>
