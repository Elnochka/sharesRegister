<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Share create</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<h3>Share create</h3>


<form:form method="POST" action="${pageContext.request.contextPath}/shares/createShare" modelAttribute="shareForm">
    <table border="0">
        <tr>
            <td>EDRPOU</td>
            <td><form:input path="edrpou" /></td>
            <td><form:errors path="edrpou" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Comment</td>
            <td><form:input path="comment" /></td>
            <td><form:errors path="comment" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><form:input path="quantity" /></td>
            <td><form:errors path="quantity" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Value</td>
            <td><form:input path="value" /></td>
            <td><form:errors path="value" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Common value</td>
            <td><form:input path="commonValue" /></td>
            <td><form:errors path="commonValue" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Date share</td>
            <td><form:input path="dateShare" /></td>
            <td><form:errors path="dateShare" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Status</td>
            <td><form:input path="status" /></td>
            <td><form:errors path="status" cssClass="error" /></td>
        </tr>


        <tr>
            <td colspan ="2">
                <input type="submit" value= "Create share" />
                <a href="${pageContext.request.contextPath}/shares">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>

<%--<p style="color:blue;">Favour name: TV</p>--%>


</body>
</html>
