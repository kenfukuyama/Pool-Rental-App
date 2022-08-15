<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.Date, java.util.List, com.kb.chitchat.models.User" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--  mgiht show error-->
<%@ page isErrorPage="true" %>  



<!DOCTYPE html>
<html>

<head>
    <!-- bootstrap -->
    <!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"  crossorigin="anonymous">
    <!-- regularcss -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">

    <!-- bootstrap js -->
    <!-- <script src="/webjars/jquery/jquery.min.js"></script> -->
    <!-- <script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->

    <!-- regular js -->
    <script type="text/javascript" src="/javascript/script.js"></script>

    <meta charset="UTF-8">
    <title>Home</title>
</head>

<body>

    <div class="d-flex align-items-center justify-content-between gap-3 p-3">
        <div class="home-button"><a class="btn btn-primary" href="/home">Home</a></div>
        <div class="d-flex justify-content-end"><a class="btn btn-danger" href="/logout">Logout</a></div>
    </div>
    
    <div class="container">
        <div class="row">
            <div class="col">
                <hr>
                <div class="card">
                    <h4 class="card-header text-primary p-4">${pool.address}</h4>
                    <hr>
                    <div class="text-right">
                        <h3 >Email: ${pool.user.email}</h3>
                        <h3>Name: ${pool.user.firstName} ${pool.user.lastName} </h3>
                    </div>
                    <div class="card-body">
                        <p>Address: ${pool.address}</p>
                        <p>Description: ${pool.description}</p>
                        <p>Size: ${pool.size}</p>
                        <p>Price: ${pool.price}</p>
                    </div>
                </div>

                <hr>
                <div class="d-flex justify-content-between mb-3">
                    <div class="">
                        <h5>Reviews 
                            <c:choose>
                                <c:when test="${average.equals('N')}">
                                    N/A
                                </c:when>
                                <c:otherwise>
                                    (${average}/5) 
                                </c:otherwise>
                            </c:choose>
                            

                        </h5>
                    </div>
                    <div class="text-right"><a href="/pools/${pool.id}/review">Leave a Review</a></div>
                </div>
                <ul style="height: 200px; overflow: auto">
                    <c:forEach var="review" items="${reviews}">
                        <li class="mb-2">${review.user.firstName} Rating: ${review.rating}/5 <br/> ${review.message}</li>

                    </c:forEach>
                </ul>


            </div>
        </div>
    </div>
</body>

</html>