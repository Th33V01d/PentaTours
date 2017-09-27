<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${bundle.title}" /></title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="/resources/css/custom.css" media="screen" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
    <script src="/resources/js/register-validation.js"></script>
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

<div id="err" data-txt='<c:out value="${bundle.err}"/>'></div>
<div id="bigfielderr" data-txt='<c:out value="${bundle.bigfielderr}"/>'></div>
<div id="passmatcherr" data-txt='<c:out value="${bundle.passmatcherr}"/>'></div>
<div id="phoneoremailerr" data-txt='<c:out value="${bundle.phoneoremailerr}"/>'></div>
<div id="emailerr" data-txt='<c:out value="${bundle.emailerr}"/>'></div>

<div class="container body-block">
    <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <strong><c:out value="${bundle.register}" /></strong>
                </h3>
            </div>

            <div class="panel-body">
                <form role="form" action="/register" method="post">
                    <div style="margin-bottom: 12px" class="form-group col-lg-12">
                        <div>
                            <label class="text-left" for="login"><c:out value="${bundle.login}" /></label>
                            <input id="login" type="text" class="form-control input-md" name="login">
                        </div>
                    </div>
                    <div style="margin-bottom: 12px" class="form-group col-lg-12">
                        <div>
                            <label class="text-left" for="password"><c:out value="${bundle.password}" /></label>
                            <input id="password" type="password" class="form-control input-md" name="password">
                        </div>
                    </div>
                    <div style="margin-bottom: 12px" class="form-group col-lg-12">
                        <div>
                            <label class="text-left" for="password2"><c:out value="${bundle.rep_pass}" /></label>
                            <input id="password2" type="password" class="form-control input-md" name="password2">
                        </div>
                    </div>
                    <div style="margin-bottom: 12px" class="form-group col-lg-12">
                        <div>
                            <label class="text-left" for="name"><c:out value="${bundle.name}" /></label>
                            <input id="name" type="text" class="form-control input-md" name="name">
                        </div>
                    </div>
                    <div style="margin-bottom: 12px" class="form-group col-lg-12">
                        <div>
                            <label class="text-left" for="lastname"><c:out value="${bundle.lastname}" /></label>
                            <input id="lastname" type="text" class="form-control input-md" name="lastname">
                        </div>
                    </div>
                    <div style="margin-bottom: 12px" class="form-group col-lg-12">
                        <div>
                            <label class="text-left" for="phone"><c:out value="${bundle.phone}" /></label>
                            <input id="phone" type="text" class="form-control input-md" name="phone">
                        </div>
                    </div>
                    <div style="margin-bottom: 25px" class="form-group col-lg-12">
                        <div>
                            <label class="text-left" for="email"><c:out value="${bundle.email}" /></label>
                            <input id="email" type="text" class="form-control input-md" name="email">
                        </div>
                    </div>

                    <center>
                        <div style="width:68.4px;" class="input-group">
                            <button type="button" onclick="validate(this.form, this)" class="btn btn-success"><c:out value="${bundle.register}" /></button>
                        </div>
                    </center>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
