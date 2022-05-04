<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>

                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>

        <section class="container">
            <div>
                <a href="#" class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
            </div>

            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <tr>
                    <td>productName</td>
                    <td>productPrice</td>
                    <td>quantity</td>
                    <th>totalPrice</th>
                    <th>remove button</th>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Grand Total</th>
                    <th>grand total</th>
                    <th></th>
                </tr>
            </table>

            <a href="<c:url value='/productList' /> " class="">Continue Shopping</a>

        </section>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>
