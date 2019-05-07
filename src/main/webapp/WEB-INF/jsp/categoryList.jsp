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
    <link rel="icon" href="${pageContext.request.contextPath}/static/ico/favicon.ico">
    <script type="text/javascript" src="js/jquery.min.js"></script>
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
        <c:forEach items="${page.content}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="category/${c.id}">edit</a></td>
                <td><a class="delete" href="category/${c.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div>
        <a href="?start=0">[first page]</a>
        <a href="?start=${page.number - 1}">[previous page]</a>
        <a href="?start=${page.number + 2 > page.totalPages ? page.totalPages - 1 : page.number + 1}">[next page]</a>
        <a href="?start=${page.totalPages - 1}">[last page]</a>
    </div>
    <br>
    <form action="category" method="post">
        <label>name:<input type="text" name="name" maxlength="16"></label>
        <button type="submit">add</button>
    </form>
    <form id="fromDelete" action="" method="post">
        <input type="hidden" name="_method" value="delete">
    </form>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $(".delete").click(function () {
            var href = $(this).attr("href");
            $("#fromDelete").attr("action", href).submit();
            return false;
        })
    })
</script>
</html>
