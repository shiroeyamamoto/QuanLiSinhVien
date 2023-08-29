<%-- 
    Document   : addAccount
    Created on : Aug 29, 2023, 1:00:31 AM
    Author     : khang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-center text-info mt-1">Thêm tài khoản</h1>
<c:url value="/addAccount" var="action" />
<form:form modelAttribute="account" method="post" action="${action}" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" path="username" id="name" placeholder="Username" />
        <label for="name">Username</label>
        <form:errors path="username" element="div" cssClass="text-danger"></form:errors>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="password" class="form-control" path="password" id="password" placeholder="Password" />
        <label for="password">Password</label>
        <form:errors path="password" element="div" cssClass="text-danger"></form:errors>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:select class="form-select" id="role" name="role" path="role">
            <option>ADMIN</option>
            <option>TEACHER</option>
            <option>STUDENT</option>
        </form:select>
        <label for="role" class="form-label">Role</label>
    </div>
    <div class="form-floating mt-3 mb-3" style="display: none;" id="giangvienDropdown">
        <select class="form-select" id="giangVienId" >
            <c:forEach items="${giangvien}" var="gv">
                <option value="${gv.id}">${gv.id} - ${gv.firstName} ${gv.lastName} - ${gv.email}</option>
            </c:forEach>
        </select>
        <label for="giangVienId" class="form-label">Teacher</label>
    </div>
    <div class="form-floating mt-3 mb-3" style="display: none;" id="sinhvienDropdown">
        <select class="form-select" id="sinhvienid" >
            <c:forEach items="${sinhvien}" var="sv">
                <option value="${sv.id}">${sv.id} - ${sv.firstName} ${sv.lastName}</option>
            </c:forEach>
        </select>
        <label for="sinhvienid" class="form-label">Student</label>
    </div>
    <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control" path="file" id="avatar" placeholder="Password" />
        <label for="avatar">Avatar</label>
        <form:errors path="file" element="div" cssClass="text-danger"></form:errors>
    </div>
        
        <div class="form-floating mt-3 mb-3">
            <input type="submit" class="btn btn-info" value="Create account">
        </div>
</form:form>

<script>
    document.getElementById('role').addEventListener('change', function () {
        var role = this.value;
        var giangvienDropdown = document.getElementById('giangvienDropdown');
        var sinhvienDropdown = document.getElementById('sinhvienDropdown');
        
        if (role === 'TEACHER') {
            giangvienDropdown.style.display = 'block';
            sinhvienDropdown.style.display = 'none';
        } else if (role === 'STUDENT') {
            giangvienDropdown.style.display = 'none';
            sinhvienDropdown.style.display = 'block';
        } else {
            giangvienDropdown.style.display = 'none';
            sinhvienDropdown.style.display = 'none';
        }
    });
</script>


