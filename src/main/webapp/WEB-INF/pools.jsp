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
                <h4>Welcome! ${user.firstName} ${user.lastName}</h4>
                
                <form class="my-2 mt-4" action="/pools/search" method="get">
                    <input class="form-control mr-sm-2" type="search" placeholder="New Search" aria-label="Search" name="q" >
                    <div class="d-flex justify-content-end mt-3"><button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button></div>
                </form>

                <table class="table">
                    <thead>
                        <tr>
                            <th>Address</th>
                            <th>Pool Size</th>
                            <th>Cost Per Night</th>
                            <th>Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <c:forEach var="pool" items="${pools}">
                                <tr>
                                    <td>${pool.address}</td>
                                    <td>${pool.size}</td>
                                    <td>${pool.price}</td>
                                    <td><a href="/pools/${pool.id}/show">See More</a></td>
                                </tr>

                            </c:forEach>
                        </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</body>

</html>