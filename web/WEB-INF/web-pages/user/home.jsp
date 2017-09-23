<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home - PentaTours</title>
</head>
<body>
    <h3>
        Welcome home, user <u>${sessionScope.get('login')}</u>!
    </h3>
<br>
<a href="/logout">logout</a>
</body>
</html>