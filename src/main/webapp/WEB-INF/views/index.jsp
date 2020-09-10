<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 04.09.2020
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register of shares</title>
</head>
<body>
<div style="padding: 5px;">


    <a href="${pageContext.request.contextPath}/shares">Shares list</a>
    |
    <a href="${pageContext.request.contextPath}/histories">Shares history list</a>


</div>

<form method="Get" action="${pageContext.request.contextPath}/shares/loadJson">
    <table border="0">
        <input type="submit" value="Create from json" />

    </table>
</form>

</body>
</html>
