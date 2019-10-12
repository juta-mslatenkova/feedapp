<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>


<head>
    <title>RSS Articles</title>

    <!-- reference css style -->
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h1>RSS Details View</h1>
    </div>
    <div id="subheader">
        <h2>Please find the list of 5 latest articles</h2>
    </div>
</div>

<div id="text">
    <h3>${feeds.feedName}</h3>
    <br>
    <b>Last updated on:</b> ${feeds.lastUpdate}
    <br>
    <b>Total article count:</b> ${items.size()}
    <br>
    <a href="${feeds.url}">${feeds.url}</a>
</div>

<table>
    <tr>
        <th>Article Title</th>
        <th>Link</th>
        <th>Date</th>
    </tr>

    <!-- loop over and print our customers -->
    <c:forEach var="tempItems" items="${items}" end="4">
        <tr>
            <td> ${tempItems.titleArticle} </td>
            <td><a href="${tempItems.link}">${tempItems.link}</a></td>
            <td> ${tempItems.published} </td>
        </tr>

    </c:forEach>

</table>
<br>

<a href="${pageContext.request.contextPath}">Back</a>
</body>

</html>









