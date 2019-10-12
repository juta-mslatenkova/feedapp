<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Add List</title>
    <!-- reference css style -->
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>


<body>

<div id="wrapper">
    <div id="header">
        <h1>Add XML RSS Feed</h1>
    </div>
    <div id="subheader">
        <h2>Please provide new XML RSS Feed information</h2>
    </div>
</div>

<div id="container">


    <form:form action="saveFeed" modelAttribute="feeds" method="POST">

        <table>
            <tbody>
            <tr></tr>
            <tr>
                <td><label>XML RSS Feed URL:</label></td>
                <td><form:input path="url"/></td>
            </tr>
            <tr></tr>
            <tr>
                <td><label>XML RSS Feed Name:</label></td>
                <td><form:input path="feedName"/></td>
            </tr>

            </tbody>

        </table>
        <input type="submit" value="Add Feed" class="add-button"/>

    </form:form>

</div>

</body>

</html>










