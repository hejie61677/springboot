<%--
  Created by IntelliJ IDEA.
  User: 何杰
  Date: 2019/4/16
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored ="false" %>
<html>
<head>
    <title>errorPage</title>
    <link rel="icon" href="${pageContext.request.contextPath}/static/ico/favicon.ico">
    <script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
    <div style="width:500px;border:1px solid lightgray;margin:200px auto;padding:80px">
        系统 出现了异常，异常原因是：
        ${exception}
        <br><br>
        出现异常的地址是：
        ${url}
    </div>
</body>
<script type="text/javascript">
    $(function(){
        alert("aaaaaaaaa");
    });
</script>
</html>
