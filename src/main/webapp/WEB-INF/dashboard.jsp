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
                <h4>Welcome! Host: ${user.firstName} ${user.lastName} <a href="/users/${user.id}/edit">Edit Account</a></h4>
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
                                    <td><a href="/pools/${pool.id}/edit">Edit</a></td>
                                </tr>

                            </c:forEach>
                        </tr>
                    </tbody>
                </table>
                <h3>New Listings</h3>
                <hr>
                <div class="card">
                    <h4 class="card-header text-primary p-4">Add a new listing</h4>
                    <div class="card-body">
                        <form:form action="/pools/add" method="post" modelAttribute="pool">
                            <form:input type="hidden" path="user" value="${user.id}"></form:input>
                            <div class="mb-3">
                                <form:label path="address" class="form-label">address </form:label>
                                <form:input path="address" type="text" class="form-control" placeholder="address" />
                                <form:errors class="text-danger" path="address" />
                            </div>
                            <div class="mb-3">
                                <form:label path="description" class="form-label">description </form:label>
                                <form:input path="description" type="text" class="form-control" />
                                <form:errors class="text-danger" path="description" />
                            </div>

                            <div class="mb-3">
                                <form:label path="size" class="form-label">Pool Size:  </form:label>
                                <form:select class="form-select mb-2" aria-label="Default select example" path="size">
                                    <option value="small">small</option>
                                    <option value="medium">medium</option>
                                    <option value="large">large</option>
                                </form:select>
                                <form:errors  class="text-danger" path="size" />
                            </div>

                            <div class="mb-3">
                                <form:label path="price" class="form-label">price </form:label>
                                <form:input path="price" type="number" class="form-control" step="0.01"/>
                                <form:errors class="text-danger" path="price" />
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