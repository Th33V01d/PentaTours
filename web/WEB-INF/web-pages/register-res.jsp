<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${bundle.title}" /></title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="/resources/css/custom.css" media="screen" />
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" style="background-color:#000000; border-color:#000000">
    <div class="container">
        <div class="navbar-header page-scroll" style="position: relative">
            <a class="navbar-brand" href="/home" style="padding-top: 0px; position: relative">
                <img src="/resources/img/logo.png" align="left" height="50">
                <b>
                    <h1 style="font-family: Andalus; font-size:40px; color:#eaeaea; position:absolute; align-content:center; bottom:-8; left:95">
                        PentaTours
                    </h1>
                </b>
            </a>
        </div>
    </div>
</nav>

<div class="container body-block">
    <div class="row ">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="simple-txt-panel">
                        <c:if test="${requestScope.get('reg') == true}">
                            <p><c:out value="${bundle.success_lbl}" /></p>
                            <p><a href="/home"><c:out value="${bundle.success_but}" /></a></p>
                        </c:if>
                        <c:if test="${requestScope.get('reg') == false}">
                            <p><c:out value="${bundle.failure_lbl}" /></p>
                            <p><a href="/home"><c:out value="${bundle.failure_but}" /></a></p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
