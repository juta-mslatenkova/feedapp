<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>RSS List</title>
    <!-- reference css style -->
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>


<div id="wrapper">
    <div id="header">
        <h1>XML RSS Feed</h1>
    </div>
    <div id="subheader">
        <h2>Please find the list of all available feeds</h2>
    </div>


    <table>

        <c:forEach var="tempItems" items="${feeds}">
            <!-- construct a "details" link with feed_id to be passed to Controller-->
            <c:url var="detailsLink" value="/details">
                <c:param name="title" value="${tempItems.feedName}"/>
            </c:url>
            <tr>
                <td>  <!-- display the update link -->
                    <a href="${detailsLink}">${tempItems.feedName}</a>
                    <br></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <br>
    <a href="${pageContext.request.contextPath}/addRSS">Another RSS Feed</a>


</div>

</body>
</html>
