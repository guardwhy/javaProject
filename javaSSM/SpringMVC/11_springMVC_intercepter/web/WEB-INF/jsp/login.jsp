<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <%--在WEB-INF下的所有页面或者资源，只能通过controller或者servlet进行访问--%>
    <h3>登录页面</h3>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        用户名:<input type="text" name="username"/>
        密码:<input type="text" name="password"/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
