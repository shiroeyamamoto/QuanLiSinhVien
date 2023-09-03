<%-- 
    Document   : addorupdatemonhoc
    Created on : Sep 1, 2023, 5:21:03 PM
    Author     : anhkh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/addorupdatemonhoc" var="action" />
<h1 class="text-center text-info mt-1">THÊM MÔN HỌC</h1>
<form:form method="post" action="${action}" modelAttribute="monhoc" >
      <form:errors path="*" element="div" cssClass="text-danger"/>
      <form:hidden path="id" />
    <div class="form-floating mb-3 mx-2">
        <form:input path="name" class="form-control" id="name"  placeholder="Tên Môn Học"/>
        <label for="floatingInput">Tên Môn Học</label>
    </div>
    <div class="form-floating mb-3">
        <form:input path="tinChi" class="form-control" id="tinChi" placeholder="Tín Chỉ Môn Học"/>
        <label for="floatingInput">Số Tín Chỉ</label>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">
            <c:choose>
                <c:when test="${monhoc.id != null}">Cập nhật</c:when>
                <c:otherwise>Thêm</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>