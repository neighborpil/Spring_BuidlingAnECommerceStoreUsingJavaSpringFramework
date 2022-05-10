<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"	   uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <%--<link rel="icon" href="../../favicon.ico">--%>

    <title>Spring & Jun's Music Store</title>

    <!-- Angular JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/carousel.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/main.css' />" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <script>
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
    </script>
</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Spring & Juns's Music Store</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value='/'/>">Home</a></li>
                        <li><a href="<c:url value='/product/productList'/>">Products</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <c:if test="${pageContext.request.userPrincipal.name ne null}">
                            <li><a>Welcome: <c:out value="${pageContext.request.userPrincipal.name}"/></a></li>
                            <li><a id="logoutButton" href="#">Logout</a> </li>
                            <c:if test="${pageContext.request.userPrincipal.name ne 'admin'}">
                                <li><a href="<c:url value='/customer/cart' /> ">Cart</a></li>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name eq 'admin'}">
                                <li><a href="<c:url value='/admin' /> ">Admin</a></li>
                            </c:if>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name eq null}">
                            <li><a href="<c:url value='/login' /> ">Login</a></li>
                            <li><a href="<c:url value='/register' /> ">Register</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>


<div id="logout-section" class="d-none">
    <form id="logoutForm" action="${pageContext.request.contextPath}/j_spring_security_logout?${_csrf.parameterName}=${_csrf.token}" method="POST">
    </form>
</div>
<script>
    $("#logoutButton").on("click", function(e) {
        e.preventDefault();

        $("#logoutForm").submit();

        return false;
    })

</script>