<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${bundle.title}" /> </title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="/resources/css/custom.css" media="screen" />
    <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" style="background-color:#000000; border-color:#000000">
    <div class="container">
        <div class="navbar-header page-scroll" style="position: relative">
            <a class="navbar-brand" href="/user/home" style="padding-top: 0px; position: relative">
                <img src="/resources/img/logo.png" align="left" height="50">
                <b>
                    <h1 style="font-family: Andalus; font-size:40px; color:#eaeaea; position:absolute; align-content:center; bottom:-8; left:95">
                        PentaTours
                    </h1>
                </b>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="hidden">
                    <a href="/user/home"></a>
                </li>

                <li>
                    <a href="/logout"><span><i class="glyphicon glyphicon-log-out"></i></span></a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container body-block">
    <div class="row ">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="simple-txt-panel">
                        <c:out value="${bundle.welcome}"/> ${role} ${login}!
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>