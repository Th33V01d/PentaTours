<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title><c:out value="${bundle.title}" /></title>
        <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css" media="screen" />
    </head>
    <body>

    <div class="container" style="margin-top:30px">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <strong><c:out value="${bundle.sign_in}" /> </strong>
                    </h3>
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

    </body>
</html>
