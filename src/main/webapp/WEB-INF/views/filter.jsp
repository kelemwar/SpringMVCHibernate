<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>

</head>
<body>
<title>Search result</title>
<c:if test="${!empty filterList}">
    <table class="tg">
        <tr>
            <th width="80">Article ID</th>
            <th width="120">Title</th>
            <th width="120">Category</th>
            <th width="120">Description</th>
        </tr>
        <c:forEach items="${filterList}" var="fList">
            <tr>
                <td>${fList.id}</td>
                <td>${fList.title}</td>
                <td>${fList.category}</td>
                <td>${fList.description}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a href="<c:url value='/' />" >Back to main page</a>
</body>

</html>
