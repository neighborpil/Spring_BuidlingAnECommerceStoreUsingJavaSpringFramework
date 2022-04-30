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
            <h1>Product Inventory Page</h1>

            <p class="lead">This is a product inventory page!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}" varStatus="status">
                <tr>
                    <td><img src="<c:url value='/resources/images/${product.productId}.png' />" alt="image" style="width:100%;" /></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} USD</td>
                    <td>
                        <a href="<spring:url value='/productList/viewProduct/${product.productId}'/>">
                            <span class="glyphicon glyphicon-info-sign"></span>
                        </a>
                        <a href="<spring:url value='/admin/productInventory/deleteProduct/${product.productId}'/>">
                            <span class="glyphicon glyphicon-remove"></span>
                        </a>
                        <a href="<spring:url value='/admin/productInventory/editProduct/${product.productId}'/>">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <a href="<c:url value='/admin/productInventory/addProduct' />" class="btn btn-primary">Add Product</a>

<%@include file="/WEB-INF/views/template/footer.jsp"%>