<%-- 
    Document   : header
    Created on : Aug 13, 2023, 9:36:21 PM
    Author     : anhkh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" 
           uri="http://www.springframework.org/security/tags" %>
<c:url value="/" var="action" />
<nav class="navbar navbar-expand bg-primary navbar-dark">
    <div class="container-fluid ">
        <a href="#" class="navbar-brand d-none d-md-flex align-items-center m-0 mr-4 p-0 aabtn" style="color:#ffff00;font-weight:500">Fats Company</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse primary-navigation" id="collapsibleNavbar">
            <ul class="nav more-nav navbar-nav me-auto">
                <sec:authorize access = "hasRole(',ADMIN')">
                    <li class="nav-item">
                        <c:url value="/account" var="actionAccount"/>
                        <a class="nav-link active" href="${actionAccount}">Account</a>
                    </li>
                </sec:authorize>
                <li class="nav-item">
                    <a class="nav-link active" href="${action}">Trang chủ</a>
                </li>
                <sec:authorize access = "hasRole(',TEACHER')">
                    <c:url value="/giangVien" var="actionGiangVien"/>
                    <li class="nav-item">
                        <a class="nav-link active" href="${actionGiangVien}">Giảng viên</a>
                    </li>
                </sec:authorize>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Diễn đàn</a>
                </li>
                <sec:authorize access = "hasRole(',ADMIN')">
                    <c:url value="/monhoc" var="actionMonHoc"/>
                    <li class="nav-item">
                        <a class="nav-link active" href="${actionMonHoc}">Môn học</a>
                    </li>
                </sec:authorize>

            </ul>
            <form class="d-flex " action="#" method="get">
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <a class="nav-link text-danger" href="<c:url value="/" />">Chào ${pageContext.request.userPrincipal.name} !</a>
                        <a class="nav-link text-info" href="<c:url value="/logout" />">Đăng xuất</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link active text-light" href="<c:url value="/login"/>">Đăng nhập</a>
                    </c:otherwise>
                </c:choose>
            </form>
            <form class="d-flex" action="#" method="get">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                <button class="btn btn-danger" type="submit">Tìm</button>
            </form>
        </div>
    </div>
</nav>