<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>AJAX技术</title>
    <%--引入jquery--%>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>

    <script type="text/javascript">
        function ajax1(){
          $.post({
            url:"${pageContext.request.contextPath}/ajax1",
            data:{'name':$("#username").val()},
            success: function (data, status){
              console.log(data);
              console.log(status);
            }
          });
        }
    </script>
  </head>
  <body>
      <%--onblur:失去焦点触发事件--%>
      用户名:<input type="text" id="username" onblur="ajax1()"/>
  </body>
</html>
