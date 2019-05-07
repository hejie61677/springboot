<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 2019/5/6
  Time: 16:52
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
    <form action="../phone/${phone.id}" method="post">
        <input type="hidden" name="_method" value="put">
        <label>
            name:<input type="text" name="name" value="${phone.name}" maxlength="16">
            price:<input type="number" name="price" value="${phone.price}" maxlength="5">
        </label>
        <input name="id" type="hidden" value="${phone.id}">
        <button type="submit">modify</button>
    </form>
</div>

</body>
</html>
