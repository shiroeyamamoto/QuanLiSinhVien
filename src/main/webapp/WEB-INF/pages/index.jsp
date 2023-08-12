<%-- 
    Document   : index
    Created on : Aug 8, 2023, 6:19:43 PM
    Author     : khang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand bg-primary navbar-dark">
            <div class="container-fluid ">
                <a href="#" class="navbar-brand d-none d-md-flex align-items-center m-0 mr-4 p-0 aabtn" style="color:#ffff00;font-weight:500">Fats Company</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse primary-navigation" id="collapsibleNavbar">
                    <ul class="nav more-nav navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Account</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Diễn đàn</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Môn học</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Lớp học</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <section class="container mt-1">
            <input type="submit" class="btn btn-success mt-1" value="Create account">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Loại tài khoản</th>
                        <th>Tên</th>
                        <th>Họ</th>
                        <th>Email</th>
                        <th>Avatar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${acc}" var="account">
                        <tr>
                            <td>${account.id}</td>
                            <td>${account.username}</td>
                            <td>${account.password}</td>
                            <td>${account.role}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${account.role eq 'TEACHER'}">
                                        ${account.giangVienFirstName}
                                    </c:when>
                                    <c:when test="${account.role eq 'SINHVIEN'}">
                                        ${account.sinhVienFirstName}
                                    </c:when>
                                    <c:otherwise></c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${account.role eq 'TEACHER'}">
                                        ${account.giangVienLastName}
                                    </c:when>
                                    <c:when test="${account.role eq 'SINHVIEN'}">
                                        ${account.sinhVienLastName}
                                    </c:when>
                                    <c:otherwise></c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${account.role eq 'TEACHER'}">
                                        ${account.giangVienEmail}
                                    </c:when>
                                    <c:when test="${account.role eq 'SINHVIEN'}">
                                        ${account.sinhVienEmail}
                                    </c:when>
                                    <c:otherwise></c:otherwise>
                                </c:choose>
                            </td>
                            <td>${account.avatar}</td>
                            <td><input type="submit" class="btn btn-primary" value="Edit"></td>
                            <td><input type="submit" class="btn btn-danger" value="Delete"></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <ul>

            </ul>
        </section>

    </body>
</html>
