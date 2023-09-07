<%-- 
    Document   : giangVien
    Created on : Sep 3, 2023, 3:20:02 PM
    Author     : khang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" 
           uri="http://www.springframework.org/security/tags" %>
<c:url value="/giangVien" var="action" />
<!DOCTYPE html>
<sec:authorize access ="hasRole(',TEACHER')">
    <section class="container mt-1">

        <h1 class="text-center text-info mt-1">Chào mừng ...</h1>

    </section>
</sec:authorize>


