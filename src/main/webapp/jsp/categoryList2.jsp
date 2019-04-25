<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 2019/4/18
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CategoryList</title>
</head>
<body>
<div align="center">
</div>
<div style="width:500px;margin:20px auto;text-align: center">
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td align="center">id</td>
            <td align="center">name</td>
            <td align="center">edit</td>
            <td align="center">delete</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="editCategory2?id=${c.id}">edit</a></td>
                <td><a href="deleteCategory2?id=${c.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div>
        <a href="?start=1">[first page]</a>
        <a href="?start=${pageInfo.pageNum - 1}">[previous page]</a>
        <a href="?start=${pageInfo.pageNum + 1 > pageInfo.pages ? pageInfo.pages : pageInfo.pageNum + 1}">[next page]</a>
        <a href="?start=${pageInfo.pages}">[last page]</a>
    </div>
    <br>
    <form action="addCategory2" method="post">
            name:<input name="name">
           <button type="submit">add</button>
    </form>
</div>
</body>
</html>
