<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="java.util.Date" %>

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
    <div class="container">
        <div class="row mt-2">
            <h2>Hello, Welcome!</h2>
        </div>
        <div class="row mt-2">
            <!-- ! Edit -->
            <div class="col">
                <div class="card">
                    <h4 class="card-header text-primary p-4">Edit User</h4>
                    <div class="card-body">
                                                
                        <form action="/users/${user.id}" method="post">
                            <input type="hidden" name="_method" value="put">
                            <div class="mb-3">
                                <label for="firstName" class="form-label">First Name </label>
                                <input name="firstName" type="text" class="form-control" value="${user.firstName}" />
                                
                            </div>
                            <div class="mb-3">
                                <label for="lastName" class="form-label">Last Name </label>
                                <input name="lastName" type="text" class="form-control" value="${user.lastName}" />
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Email </label>
                                <input name="email" type="text" class="form-control" value="${user.email}" />
                            </div>
                            <div class="d-flex justify-content-end">
                                <input type="submit" value="Update" class="btn btn-primary">
                            </div>
                        </form>

                        
                    </div>
                </div>
            </div>
        </div>


        
    </div>

</body>

</html>