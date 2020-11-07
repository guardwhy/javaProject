<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
    <%--常用注解--%>
    <a href="anno/testRequestParam?name=guardwhy">RequestParam</a><br/>

    <%--请求体--%>
    <form action="anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="username" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交"/>
    </form>

    <%--用于绑定url中的占位符--%>
    <a href="anno/testPathVariable/6">testPathVariable</a><br/>
</body>
</html>
