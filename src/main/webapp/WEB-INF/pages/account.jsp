<%-- 
    Document   : account
    Created on : Aug 8, 2023, 6:19:43 PM
    Author     : khang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/account" var="action" />
<section class="container mt-1">

    <h1 class="text-center text-info mt-1">Quản lý tài khoản</h1>


    <a class="btn btn-success mt-1" href="<c:url value="/addAccount"/>" >Create account</a>


    <nav aria-label="Page navigation example" class="mt-1">
        <ul class="pagination">
            <c:forEach begin="1" end="${pages}" var="i">
                <c:url value="/" var="pageUrl">
                    <c:param name="page" value="${i}" /> 
                </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>

        </ul>
    </nav>
    <table class="table table-condensed">

        <thead class="table-success">
            <tr>
                <th>Id</th>
                <th>Username</th>
                <th>Password</th>
                <th>Loại tài khoản</th>
                <th>Tên</th>
                <th>Họ</th>
                <th>Email</th>
                <th>Avatar</th>
                <th>Edit</th>
                <th>DELETE</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${acc}" var="account">
                <tr>
                    <td style="vertical-align: middle; text-align: center;">${account.id}</td>
                    <td style="vertical-align: middle; text-align: center;">${account.username}</td>
                    <td style="vertical-align: middle; text-align: center;">${account.password}</td>
                    <td style="vertical-align: middle; text-align: center;">${account.role}</td>

                    <td style="vertical-align: middle; text-align: center;">
                        <c:choose>
                            <c:when test="${account.role eq 'TEACHER'}">

                                <c:forEach items="${giangvien}" var="gv">
                                    <c:if test="${gv.accountGVid.id eq account.id}">
                                        ${gv.lastName}
                                    </c:if>
                                </c:forEach>

                            </c:when>
                            <c:when test="${account.role eq 'SINHVIEN'}">
                                <c:forEach items="${sinhvien}" var="sv">
                                    <c:if test="${sv.accountSVid.id eq account.id}">
                                        ${sv.lastName}
                                    </c:if>
                                </c:forEach>
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
                    </td>
                    <td style="vertical-align: middle; text-align: center;">
                        <c:choose>
                            <c:when test="${account.role eq 'TEACHER'}">
                                <c:forEach items="${giangvien}" var="gv">
                                    <c:if test="${gv.accountGVid.id eq account.id}">
                                        ${gv.firstName}
                                    </c:if>
                                </c:forEach>
                            </c:when>
                            <c:when test="${account.role eq 'SINHVIEN'}">
                                <c:forEach items="${sinhvien}" var="sv">
                                    <c:if test="${sv.accountSVid.id eq account.id}">
                                        ${sv.firstName}
                                    </c:if>
                                </c:forEach>
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
                    </td>
                    <td style="vertical-align: middle; text-align: center;">
                        <c:choose>
                            <c:when test="${account.role eq 'TEACHER'}">
                                <c:forEach items="${giangvien}" var="gv">
                                    <c:if test="${gv.accountGVid.id eq account.id}">
                                        ${gv.email}
                                    </c:if>
                                </c:forEach>
                            </c:when>
                            <c:when test="${account.role eq 'SINHVIEN'}">
                                <c:forEach items="${sinhvien}" var="sv">
                                    <c:if test="${sv.accountSVid.id eq account.id}">
                                        ${sv.email}
                                    </c:if>
                                </c:forEach>
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
                    </td>
                    <td style="vertical-align: middle; text-align: center;">
                        <img src="${account.avatar}" alt="${account.username}" height="60" width="60" />
                    </td>
                    <td style="vertical-align: middle; text-align: center;"><input type="submit" class="btn btn-info" value="Cập nhật"></td>
                    <td style="vertical-align: middle; text-align: center;"><input type="submit" class="btn btn-danger" value="Xóa"></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <ul>

    </ul>
</section>


