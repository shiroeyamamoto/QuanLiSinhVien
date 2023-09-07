<%-- 
    Document   : addAccount
    Created on : Aug 29, 2023, 1:00:31 AM
    Author     : khang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" 
           uri="http://www.springframework.org/security/tags" %>
<sec:authorize access ="hasRole(',ADMIN')">

    <h1 class="text-center text-info mt-1">Thêm tài khoản</h1>
    <c:url value="/addAccount" var="action" />
    <form:form modelAttribute="account" method="post" action="${action}" enctype="multipart/form-data" id="formAddAccount">
        <form:hidden path="id"/>
        <form:hidden path="avatar"/>
        <form:hidden path="role"/>
        <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
            <div class="form-floating mt-3 mb-3">
            <form:input type="text" class="form-control" path="username" id="name" placeholder="Username" />
            <label for="name">Username</label>
            <form:errors path="username" element="div" cssClass="text-danger"></form:errors>
            </div>

        <c:choose>
            <c:when test="${account.id != null}">
                <div class="form-floating mt-3 mb-3">
                    <label>${account.role}</label>
                </div>
            </c:when>
            <c:otherwise>
                <div class="form-floating mt-3 mb-3">
                    <form:input type="password" class="form-control" path="password" id="password" placeholder="Password" />
                    <label for="password">Password</label>
                    <form:errors path="password" element="div" cssClass="text-danger"></form:errors>
                    </div>
                <form:select class="form-select" id="role" name="role" path="role">
                    <option>ADMIN</option>
                    <option>TEACHER</option>
                    <option>STUDENT</option>
                </form:select></c:otherwise>
        </c:choose>
        <div class="form-floating mt-3 mb-3">
            <form:input type="file" class="form-control" path="file" id="avatar" placeholder="Avatar" />
            <label for="avatar">Avatar</label>
        </div>
        <c:forEach items="${giangvien}" var="gv">
            <c:if test="${account.id eq gv.accountGVid.id}">
                <div class="form-floating mt-3 mb-3">
                    <input type="text" class="form-control" id="lastName" placeholder="Họ" />
                    <label for="lastName">${gv.lastName}</label>
                </div>
                <div class="form-floating mt-3 mb-3">
                    <input type="text" class="form-control" id="firstName" placeholder="Tên" />
                    <label for="firstName">${gv.firstName}</label>
                </div>
                <div class="form-floating mt-3 mb-3">
                    <input type="text" class="form-control" id="email" placeholder="email" />
                    <label for="email">${gv.email}</label>
                </div>
            </c:if>
        </c:forEach>

        <c:forEach items="${sinhvien}" var="sv">
            <c:if test="${account.id eq sv.accountSVid.id}">
                <div class="form-floating mt-3 mb-3">
                    <input type="text" class="form-control" id="lastName" placeholder="Họ" />
                    <label for="lastName">${sv.lastName}</label>
                </div>
                <div class="form-floating mt-3 mb-3">
                    <input type="text" class="form-control" id="firstName" placeholder="Tên" />
                    <label for="firstName">${sv.firstName}</label>
                </div>
                <div class="form-floating mt-3 mb-3">
                    <input type="text" class="form-control" id="email" placeholder="email" />
                    <label for="email">${sv.email}</label>
                </div>
            </c:if>
        </c:forEach>
        <div class="form-floating mb-3 mt-3">
            <button type="submit" class="btn btn-info" >
                <c:choose>
                    <c:when test="${account.id != null}">Cập nhật tài khoản</c:when>
                    <c:otherwise>Thêm tài khoản</c:otherwise>
                </c:choose>

            </button>
        </div>
    </form:form>
</sec:authorize>
