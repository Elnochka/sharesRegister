<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit share</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>


<h3>Edit share</h3>

<p style="color: red;">${errorString}</p>

<c:if test="${not empty shareForm}">
    <form:form method="POST" action="${pageContext.request.contextPath}/shares/editShare" modelAttribute="shareForm">
        <form:input type="hidden" path="idShare" />
        <table border="0">
            <tr>
                <td>Id
                <td style="color:red;">${shareForm.idShare}</td>
            </tr>
            <tr>
                <td>Comment</td>
                <td><form:input path="comment" /></td>

            </tr>
            <tr>
                <td>EDRPOU</td>
                <td><form:input path="edrpou" /></td>
                <%--<td style="color:red;">${shareForm.edrpou}</td>--%>

            </tr>
            <tr>
                <td>Quantity</td>
                <td><form:input path="quantity" /></td>

            </tr>
            <tr>
                <td>Common value</td>
                <td><form:input path="commonValue" /></td>

            </tr>
            <tr>
                <td>Value</td>
                <td><form:input path="value" /></td>

            </tr>
            <tr>
                <td>Date share</td>
                <td><form:input path="dateShare" /> <td>


            </tr>
            <tr>
                <td>Status</td>
                <td><form:input path="status" /> <td>
                <%--<td><input type="checkbox" name="status" value="1"--%>
                           <%--<c:if test="${shareForm.status == true}">checked="checked"</c:if>/></td>--%>

            </tr>

            <tr>
                <td colspan = "2">
                    <input type="submit" value="Edit" />
                    <a href="${pageContext.request.contextPath}/shares">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
</c:if>

</body>
</html>