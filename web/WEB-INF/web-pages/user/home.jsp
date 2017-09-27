<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ua.nure.stepanenko.SummaryTask4.db.entity.Tour" %>
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
                <li class="page-scroll">
                    <a href="/user/home">${bundle.catalog}</a>
                </li>
                <li class="page-scroll">
                    <a href="/coming-soon">${bundle.orders}</a>
                </li>
                <li class="page-scroll">
                    <a href="/coming-soon">${bundle.profile}</a>
                </li>
                <li>
                    <a href="/logout"><span><i class="glyphicon glyphicon-log-out"></i></span></a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div id="err_pr" data-txt='<c:out value="${bundle.err_pr}"/>'></div>
<div id="err_quant" data-txt='<c:out value="${bundle.err_quant}"/>'></div>

<div class="container body-block">
    <div class="row ">
        <div class="col-md-4">
            <div class="panel panel-default" style="border: 1px #000000">
                <div class="panel-heading">
                    <strong><c:out value="${bundle.sort_pars}"/> </strong>
                </div>
                <div class="panel-body">
                    <form name="queryForm" action="/user/home" style="margin-bottom: 0px;">
                        <b>
                            <p>
                                <c:out value="${bundle.city_lbl}"/>
                            </p>
                        </b>
                        <select class="sort-elem" name="city">
                            <option value=""></option>
                        <c:forEach items="${cities}" var="city">
                            <option value="${city}"><c:out value="${city}"/></option>
                        </c:forEach>
                        </select>
                        <br>
                        <b>
                            <p>
                                <c:out value="${bundle.transport_lbl}"/>
                            </p>
                        </b>
                        <select class="sort-elem" name="transport">
                            <option value=""></option>
                            <c:forEach items="${transports}" var="transport">
                                <option value="${transport}"><c:out value="${transport}"/></option>
                            </c:forEach>
                        </select>
                        <br>
                        <b>
                            <p>
                                <c:out value="${bundle.accomm_lbl}"/>
                            </p>
                        </b>
                        <select class="sort-elem" name="accommodation">
                            <option value=""></option>
                            <c:forEach items="${accomms}" var="accomm">
                                <option value="${accomm}"><c:out value="${accomm}"/></option>
                            </c:forEach>
                        </select>
                        <br>
                        <b>
                            <p>
                                <c:out value="${bundle.price_lbl}"/>
                            </p>
                        </b>
                        <input class="sort-elem" type="text" name="price_min"> -
                        <input class="sort-elem" type="text" name="price_max">
                        <br>
                        <b>
                            <p>
                                <c:out value="${bundle.quant_lbl}"/>
                            </p>
                        </b>
                        <input class="sort-elem" type="text" name="quant" min="1">
                        <br>
                        <center><input type="button" onclick="validateNumFields()" class="btn btn-success" value="${bundle.search_btn}" style="margin-top: 10px"></center>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-md-8">
            <c:if test="${found == false}">
            <div class="panel panel-default">
                <div class="panel-body">
                    <p class="simple-txt-panel">
                        <c:out value="${bundle.not_found}"/>
                    </p>
                </div>
            </div>
            </c:if>

            <c:if test="${found == true}">
            <c:forEach items="${tours}" var="tour">
            <div class="panel panel-default">
                <div class="panel-heading" style="text-align: center">
                    <strong>${tour.name}</strong>
                </div>
                <div class="panel-body">
                    <form role="form" action="/buy" method="get" class="tour-block">
                        <img class="tour-img" src="${tour.image_link}">
                        <p class="tour-desc">
                            <c:out value="${tour.description}"/>
                            <br>
                            <br>
                            <c:out value="${bundle.dates}"/><c:out value="${tour.date_begin.date}.${tour.date_begin.month}.${tour.date_begin.year + 1900}"/> - <c:out value="${tour.date_end.date}.${tour.date_end.month}.${tour.date_end.year + 1900}"/>
                            <br>
                            <c:out value="${bundle.quant}"/><c:out value="${tour.quantity}"/>
                            <br>
                            <c:out value="${bundle.price}"/><c:out value="${tour.price}"/>
                        </p>
                        <input type="hidden" name="tourId" value="${tour.id}">
                        <input type="hidden" name="quant" value="1">
                        <button type="submit" class="btn btn-success btn-primary btn-block"><c:out value="${bundle.book}"/></button>
                    </form>
                </div>
            </div>
            </c:forEach>
            </c:if>
        </div>
    </div>
</div>

<script>
    function validateNumFields(tourid) {
        var validated = true;

        var price_min = document.forms["queryForm"]["price_min"].value;
        var price_max = document.forms["queryForm"]["price_max"].value;
        var quant = document.forms["queryForm"]["quant"].value;

        var regex = /^\d+\.\d+$/;
        var regex2 = /^\d+$/;

        if (price_min.length > 0) {
            if (!regex.test(price_min)) {
                validated = false;
                alert(document.getElementById("err_pr").getAttribute("data-txt"));
            }
        }
        if (price_max.length > 0) {
            if (!regex.test(price_max)) {
                validated = false;
                alert(document.getElementById("err_pr").getAttribute("data-txt"));
            }
        }
        if (quant.length > 0) {
            if (!regex2.test(quant)) {
                validated = false;
                alert(document.getElementById("err_quant").getAttribute("data-txt"));
            }
        }

        if (validated) {
            document.forms["queryForm"].submit();
        }
    }
</script>

</body>
</html>