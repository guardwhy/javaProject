<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功页面</title>
</head>
<body>
    <h3>恭喜你，登入成功</h3>
    <p>${username}</p>

    <%--注销--%>
    <a href=${pageContext.request.contextPath}/user/logout>注销</a>

</body>
</html>
