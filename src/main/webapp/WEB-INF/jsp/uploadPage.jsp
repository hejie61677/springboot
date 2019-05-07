<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 2019/4/29
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    选择图片:<input type="file" name="file" accept="image/*" /> <br>
    <input type="submit" value="上传">
</form>
</body>
</html>
