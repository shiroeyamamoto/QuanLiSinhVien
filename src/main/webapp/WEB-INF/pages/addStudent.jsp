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

    <h1 class="text-center text-info mt-1">Thêm sinh viên</h1>
    <c:url value="/addStudent" var="action" />
    <form:form modelAttribute="addStu" method="post" action="${action}">
        <div class="form-floating mt-3 mb-3">
            <form:input type="text" class="form-control" path="lastName" id="lastName" placeholder="Họ" />
            <label for="lastName">Họ</label>
        </div>
        <div class="form-floating mt-3 mb-3">
            <form:input type="text" class="form-control" path="firstName" id="firstName" placeholder="Tên" />
            <label for="firstName">Tên</label>
        </div>
        <div class="form-floating mt-3 mb-3">
            <form:input type="text" class="form-control" path="email" id="email" placeholder="email" />
            <label for="email">Email</label>
        </div>
        <div class="form-floating">
            <form:select class="form-select" id="acc" name="acc" 
                         path="accountSVid">
                <c:forEach items="${selectAccount}" var="c">
                    <c:choose>
                        <c:when test="${c.role eq 'ROLE_,STUDENT'}">
                            <c:if test="${c.id == addStu.accountSVid.id}">
                                <option value="${c.id}" selected>${c.username}</option>
                            </c:if>
                            <c:if test="${c.id != addStu.accountSVid.id}">
                                <option value="${c.id}">${c.username}</option>
                            </c:if>
                        </c:when>
                    </c:choose>

                </c:forEach>
            </form:select>
            <label for="cate" class="form-label">Tài khoản muốn cấp cho đối tượng</label>
        </div>
        <div class="form-floating mt-3 mb-3">
            <input type="submit" class="btn btn-info" value="Create">
        </div>
    </form:form>
</sec:authorize>


