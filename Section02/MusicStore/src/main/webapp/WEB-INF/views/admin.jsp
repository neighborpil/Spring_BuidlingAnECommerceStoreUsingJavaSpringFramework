<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"	   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div></div>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is a administrator page!</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcom: ${pageContext.request.userPrincipal.name} | <button id="logoutButton" type="button" class="btn btn-default">Logout</button>
            </h2>
        </c:if>

        <h3>
            <a href="<c:url value='/admin/productInventory'/>">Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify the product inventory!</p>

        <div id="logout-section" class="d-none">
            <form:form id="logoutForm" action="${pageContext.request.contextPath}/j_spring_security_logout" method="POST">
            </form:form>
        </div>

<script>
$(function() {
    $("#logoutButton").on("click", function() {
        $("#logoutForm").submit();
    });
});
</script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>