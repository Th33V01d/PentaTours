<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title><c:out value="${bundle.title}" /></title>
        <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="/resources/css/custom.css" media="screen" />
        <script src="/resources/js/bootstrap.js"></script>
        <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    </head>
    <body>

    <div class="wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <header id="header">

                        <div class="slider">
                            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner" role="listbox">
                                    <div class="item active">
                                        <img src="/resources/img/header/02.jpg">
                                    </div>
                                    <div class="item">
                                        <img src="/resources/img/header/01.jpg">
                                    </div>
                                    <div class="item">
                                        <img src="/resources/img/header/03.jpg">
                                    </div>
                                </div>

                                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                                    <span class="fa fa-angle-left" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                </a>
                                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                                    <span class="fa fa-angle-right" aria-hidden="true"></span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div>
                        </div>
                    </header>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row  equal-panels">
            <div class="col-md-8">
                <div class="panel panel-default" style="border: 1px #000000">
                    <div class="panel-heading" style="background-color:#000000; position:relative">
                        <img src="/resources/img/logo.png" align="left">
                        <b>
                            <h1 style="font-family: Andalus; font-size:70px; color:#eaeaea; position:absolute; bottom:20; left:210">
                                <c:out value="${bundle.title}" />
                            </h1>
                        </b>
                    </div>
                    <div class="panel-body" style="font-size: 18px">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent quis sem dui.
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong><c:out value="${bundle.sign_in}" /></strong>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="/login" method="post">
                            <c:if test="${param.get('err') != null}">
                                <div class="alert alert-danger">
                                    <a class="close" data-dismiss="alert" href="#">×</a><c:out value="${bundle.err}" />
                                </div>
                            </c:if>

                            <div style="margin-bottom: 12px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="login-username" type="text" class="form-control" name="login" placeholder='<c:out value="${bundle.login}" />' required="required">
                            </div>

                            <div style="margin-bottom: 12px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="login-password" type="password" class="form-control" name="password" placeholder='<c:out value="${bundle.password}" />' required="required">
                            </div>

                            <center>
                                <div style="width:68.4px;" class="input-group">
                                    <button type="submit" class="btn btn-success"><c:out value="${bundle.sign_in}" /></button>
                                </div>
                            </center>
                            <hr style="margin-top:10px;margin-bottom:10px;" >

                            <div class="form-group">
                                <div style="font-size:85%">
                                    <c:out value="${bundle.acc}" />
                                    <a href="/register"><c:out value="${bundle.regref}" /></a>.
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>







    </body>
</html>
