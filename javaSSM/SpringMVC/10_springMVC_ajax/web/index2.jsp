<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异步请求获取集合元素</title>
</head>
<body>
    <input type="button" id="btn" value="获取集合数据"/>
    <table width="100%" align="center">
        <tr>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
        </tr>

        <tbody id="content"></tbody>
    </table>

    <%--引入jquery--%>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>

    <script type="text/javascript">
       $(function (){
           $("#btn").click(function (){
               $.post("${pageContext.request.contextPath}/ajax2", function (data){
                   console.log(data);
                   let html= "";
                   for (let i = 0; i < data.length; i++) {
                       html += "<tr>" +
                           "<td>" + data[i].name + "</td>" +
                           "<td>" + data[i].age + "</td>" +
                           "<td>" + data[i].sex + "</td>" +
                           "</tr>"
                   }
                   $("#content").html(html);
               });
           })
       })
    </script>
</body>
</html>
