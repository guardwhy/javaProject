<%--用户登录--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录验证</title>
    <%--引入Jquery--%>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        function fun1(){
            $.post({
                url:"${pageContext.request.contextPath}/ajax3",
                data:{'name':$("#name").val()},
                success:function (data){
                    if(data.toString()=='ok'){
                        $("#userInfo").css("color","green");
                    }else {
                        $("#userInfo").css("color","red");
                    }
                    $("#userInfo").html(data);
                }
            });
        }

        function fun2(){
            $.post({
                url:"${pageContext.request.contextPath}/ajax3",
                data:{'pwd':$("#pwd").val()},
                success:function (data){
                    if(data.toString()=='ok'){
                        $("#pwdInfo").css("color","green");
                    }else {
                        $("#pwdInfo").css("color","red");
                    }
                    $("#pwdInfo").html(data);
                }
            });
        }
    </script>
</head>
<body>
    <p>
        用户名:<input type="text" id="name" onblur="fun1()">
        <span id="userInfo"></span>
    </p>
    <p>
        密码:<input type="text" id="pwd" onblur="fun2()">
        <span id="pwdInfo"></span>
    </p>
</body>
</html>
