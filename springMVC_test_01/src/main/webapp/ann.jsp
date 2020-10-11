<%--
  Created by IntelliJ IDEA.
  User: caijijun
  Date: 2020/9/22
  Time: 10:24 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="anno/testRequestParam?name=haha">RequestParam</a>
    <br/>
    <br/>
    <form action="anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="uname" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交"/><br/>
    </form>
    <br/>
    <br/>
    <a href="anno/testPathVariable/10">testPathVariable</a>
</body>
</html>
