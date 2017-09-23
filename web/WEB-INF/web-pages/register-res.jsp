<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Info - PentaTours</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css" media="screen" />
</head>
<body>

<c:if test="${requestScope.get('reg') == true}">
    <form action="/home">
        <p>User successfully registered.</p>
        <input type="submit" value="Go to login form">
    </form>
</c:if>

<c:if test="${requestScope.get('reg') == false}">
    <form action="/register">
        <p>An error occurred while registering. Try again.</p>
        <input type="submit" value="Go to register form">
    </form>
</c:if>
<p>
    bla-bla-bla.
</p>
</body>
</html>
