<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>
            用户登录
        </title>
    </head>
<body>
    <form action="/user/login" method="post">
        <p>Name:<input type="text" name="name" /></p>
        <p>Password:<input type="text" name="password" /></p>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
