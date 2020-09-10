<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shares history list</title>
</head>
<body>

<%--<jsp:include page="_header.jsp"></jsp:include>--%>
<%--<jsp:include page="_menu.jsp"></jsp:include>--%>

<h3>Shares history list</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>EDRPOU</th>
        <th>Field name</th>
        <th>Old value</th>
        <th>New value</th>
    </tr>
    <c:forEach items="${historyList}" var="history" >
        <tr>
            <td>${history.idHistoryShare}</td>
            <td>${history.edrpou}</td>
            <td>${history.nameField}</td>
            <td>${history.oldValue}</td>
            <td>${history.newValue}</td>


            <%--<td>--%>
                <%--<a href="editFavour?idFavour=${favour.idFavour}">Edit</a>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<a href="deleteFavour?idFavour=${favour.idFavour}">Delete</a>--%>
            <%--</td>--%>
        </tr>
    </c:forEach>
</table>

</br>
<a href="${pageContext.request.contextPath}/">Cancel</a>

<%--<a href="createFavour" >Create Favour</a>--%>

<%--<jsp:include page="_footer.jsp"></jsp:include>--%>

</body>
</html>
