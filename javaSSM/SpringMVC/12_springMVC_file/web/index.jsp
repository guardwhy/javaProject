<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>下载与上传文件</title>
  </head>
  <body>
    <%--上传--%>
    <form action="${pageContext.request.contextPath}/upload2" enctype="multipart/form-data" method="post">
      <input type="file" name="file"/>
      <input type="submit" value="upload">
    </form>

    <%--下载图片--%>
    <a href="${pageContext.request.contextPath}/statics/timg.jpg">下载图片</a>
  </body>
</html>
