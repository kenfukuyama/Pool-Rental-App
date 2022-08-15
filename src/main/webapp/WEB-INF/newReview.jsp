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
                <h4>Review of ${pool.address}</h4>

                <div class="card">
                    <h4 class="card-header text-primary p-4">Add a new listing</h4>
                    <div class="card-body">
                        <form:form action="/reviews/add" method="post" modelAttribute="review">
                            <form:input type="hidden" path="user" value="${userId}"></form:input>
                            <form:input type="hidden" path="pool" value="${pool.id}"></form:input>
                            <div class="mb-3">
                                <form:label path="message" class="form-label">message </form:label>
                                <form:input path="message" type="text" class="form-control" />
                                <form:errors class="text-danger" path="message" />
                            </div>
                            <div class="mb-3">
                                <form:label path="rating" class="form-label">Pool rating:  </form:label>
                                <form:select class="form-select mb-2" aria-label="Default select example" path="rating">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </form:select>
                                <form:errors  class="text-danger" path="rating" />
                            </div>
                            <div class="d-flex justify-content-end">
                                <input type="submit" value="Add" class="btn btn-primary">
                            </div>
                        </form:form>
                    </div>
                </div>






            </div>
        </div>
    </div>
</body>

</html>