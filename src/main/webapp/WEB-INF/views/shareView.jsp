<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Share list</title>
</head>
<body>

<h3>Register of shares</h3>

<p style="color: red;">${errorString}</p>


<form method="GET" action="${pageContext.request.contextPath}/shares">
    <c:set value="${shareList}" var="shareL" />
    <table border="1" cellpadding="5" cellspacing="1" >

        <p>
            Filter EDRPOU
            <input type="text" name="findEdrpou" id="findEdrpou"/>

            Filter status
            <input type="text" name="findStatus" id="findStatus"/>
            <input type="submit" value="Filter">

        </p>

    <tr>
        <th>Id</th>
        <th>Comment</th>
        <th>EDRPOU</th>
        <th>Quantity</th>
        <th>Common value</th>
        <th>Value</th>
        <th>Date share</th>
        <th>Status</th>
        <th>Edit</th>
        <th>Delete</th>

    </tr>
    <c:forEach items="${shareL.pageList}" var="share" >
        <tr>
            <td>${share.idShare}</td>
            <td>${share.comment}</td>
            <td>${share.edrpou}</td>
            <td>${share.quantity}</td>
            <td>${share.commonValue}</td>
            <td>${share.value}</td>
            <td>${share.dateShare}</td>
            <td>${share.status}</td>


            <td>
                <a href="editShare?idShare=${share.idShare}">Edit</a>
            </td>
            <td>
                <a href="deleteShare?idShare=${share.idShare}">Delete</a>
            </td>

        </tr>

    </c:forEach>
</table>

</form>
<br/>
<c:choose>

    <c:when test="${shareL.firstPage}">
        <span>Prev</span>
    </c:when>
    <c:otherwise>
        <c:url value="/shares/prev" var="url" />
        <a href='<c:out value="${url}" />'>Prev</a>
    </c:otherwise>
</c:choose>
<c:forEach begin="1" end="${shareL.pageCount}" step="1"  varStatus="tagStatus">
    <c:choose>

        <c:when test="${(shareL.page + 1) == tagStatus.index}">
            <span>${tagStatus.index}</span>
        </c:when>
        <c:otherwise>
            <c:url value="/shares/${tagStatus.index}" var="url" />
            <a href='<c:out value="${url}" />'>${tagStatus.index}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:choose>

    <c:when test="${shareL.lastPage}">
        <span>Next</span>
    </c:when>
    <c:otherwise>
        <c:url value="/shares/next" var="url" />
        <a href='<c:out value="${url}" />'>Next</a>
    </c:otherwise>
</c:choose>

<br/>
<a href="createShare" >Create share</a>
</br>
<a href="${pageContext.request.contextPath}/">Cancel</a>

</body>
</html>
