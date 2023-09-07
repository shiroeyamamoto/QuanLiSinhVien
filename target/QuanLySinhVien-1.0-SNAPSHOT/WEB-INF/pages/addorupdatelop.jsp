<%-- 
    Document   : addorupdatelop
    Created on : Sep 6, 2023, 2:35:35 PM
    Author     : anhkh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" 
           uri="http://www.springframework.org/security/tags" %>
<sec:authorize access ="hasRole(',ADMIN')">

    <c:url value="/addorupdatelop" var="action" />
    <h1 class="text-center text-info mt-1">THÊM LỚP HỌC</h1>
    <form:form method="post" action="${action}" modelAttribute="lop" >
        <form:errors path="*" element="div" cssClass="text-danger"/>
        <form:hidden path="id" />
        <div class="form-floating mb-3 mx-2">
            <form:input path="name" class="form-control" id="name"  placeholder="Tên Lớp Học"/>
            <label for="floatingInput">Tên Lớp </label>
        </div>
        <div class="form-floating mb-3">
            <form:input path="soLuongSinhVien" class="form-control" id="soLuongSinhVien" placeholder="SỐ LƯỢNG SINH VIÊN"/>
            <label for="floatingInput">Số Sinh VIÊN</label>
            <div class="form-floating mb-3 mt-3">
                <button type="submit" class="btn btn-info">
                    <c:choose>
                        <c:when test="${lop.id != null}">Cập nhật</c:when>
                        <c:otherwise>Thêm</c:otherwise>
                    </c:choose>
                </button>
            </div>
        </form:form>
    </sec:authorize>