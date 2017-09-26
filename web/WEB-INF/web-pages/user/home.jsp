<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home - PentaTours</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="/resources/css/custom.css" media="screen" />
    <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" style="background-color:#000000; border-color:#000000">
    <div class="container">
        <div class="navbar-header page-scroll" style="position: relative">
            <a class="navbar-brand" href="#page-top" style="padding-top: 0px; position: relative">
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
                <li class="page-scroll">
                    <a href="/user/home">Catalog</a>
                </li>
                <li class="page-scroll">
                    <a href="#about">Orders</a>
                </li>
                <li class="page-scroll">
                    <a href="#contact">Profile</a>
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
        <div class="col-md-4">
            <div class="panel panel-default" style="border: 1px #000000">
                <div class="panel-heading">
                    <strong>Парамерты сортировки</strong>
                </div>
                <div class="panel-body">
                    <form>

                    </form>
                </div>
            </div>
        </div>

        <div class="col-md-8">

            <div class="panel panel-default">
                <div class="panel-body">
                    <p class="tour-notfound">
                        Не найдено туров по указанным критериям.
                    </p>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading" style="text-align: center">
                    <a class="tour-link" href="#"><strong>__TOUR_NAME</strong></a>
                </div>
                <div class="panel-body">
                    <form role="form" action="/login" method="post" class="tour-block">
                        <img class="tour-img" src="http://cdn.newsapi.com.au/image/v1/9fdbf585d17c95f7a31ccacdb6466af9">
                        <p class="tour-desc">
                            Some description;
                            <br>
                            Some description;
                            <br>
                            Some description;
                            <br>
                            Some description;
                            <br>
                            Some description;
                            <br>
                            Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;Some description;
                            <br>
                            Some description;
                            <br>
                            Some description;
                            <br>
                        </p>


                        <hr style="margin-top:10px;margin-bottom:10px;" >

                        <div class="tour-main">
                            <ul class="tour-list">
                                <li>
                                    <div class="tour-main-elem">
                                        <img class="tour-main-icon" src="http://download.seaicons.com/icons/custom-icon-design/flatastic-9/512/Yin-Yang-True-false-icon.png">
                                        <span>Desc1.</span>
                                    </div>
                                </li>
                                <li>
                                    <div class="tour-main-elem">
                                        <img class="tour-main-icon" src="http://download.seaicons.com/icons/custom-icon-design/flatastic-9/512/Yin-Yang-True-false-icon.png">
                                        <span>Descbbuiniu.</span>
                                    </div>
                                </li>
                                <li>
                                    <div class="tour-main-elem">
                                        <img class="tour-main-icon" src="http://download.seaicons.com/icons/custom-icon-design/flatastic-9/512/Yin-Yang-True-false-icon.png">
                                        <span>D1.</span>
                                    </div>
                                </li>
                                <li class="helper"></li>
                            </ul>
                        </div>

                        <button type="submit" class="btn btn-success btn-primary btn-block">Заказать за: </button>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>

<br>
<a href="/logout">logout</a>

</body>
</html>