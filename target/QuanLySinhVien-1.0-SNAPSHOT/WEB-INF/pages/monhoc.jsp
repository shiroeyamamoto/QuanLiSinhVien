<%-- 
    Document   : monhoc
    Created on : Aug 25, 2023, 11:27:32 PM
    Author     : anhkh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/monhoc" var="action" />

<h1 class="text-center text-info mt-1">Quản lí môn học</h1>


<table class="table table-condensed">
    <thead class="table-success">
        <tr>
            <th>Id</th>
            <th>Tên Môn Học</th>
            <th>Tín Chỉ</th>


        </tr>
    </thead>
    <tbody>
        <c:forEach items="${monhoc}" var="monHoc">
            <tr>
                <td>${monHoc.id}</td>
                <td>${monHoc.name}</td>
                <td>${monHoc.tinChi}</td>
                <td style="vertical-align: middle; text-align: center;">
                    <a href="<c:url value='/addorupdatemonhoc'/>" class="btn btn-warning">Update</a>
                </td>
                <td style="vertical-align: middle; text-align: center;">
                    <a href="<c:url value='/addorupdatemonhoc/${monHoc.id}'/>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>



    </tbody>
</table>


