<%-- 
    Document   : index
    Created on : Aug 8, 2023, 6:19:43 PM
    Author     : khang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/" var="action" />
<section class="container mt-1">
    <input type="submit" class="btn btn-success mt-1" value="Create account">


    <nav aria-label="Page navigation example">
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
                    <td>
                        <!--<img src="${account.avatar}" alt="${account.username}" width="120" />-->


                    </td>

                    <td><input type="submit" class="btn btn-info" value="Cập nhật"></td>
                    <td><input type="submit" class="btn btn-danger" value="Xóa"></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <ul>

    </ul>
</section>


