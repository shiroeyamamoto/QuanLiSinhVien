<%-- 
    Document   : Lop
    Created on : Sep 6, 2023, 2:34:15 PM
    Author     : anhkh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/lop" var="action" />
<section class="container mt-1">
    <h1 class="text-center text-info mt-1">Quản lí Lớp Học</h1>
    <div>
        <a href="<c:url value="/addorupdatelop" />" class="btn btn-info">Create Class</a>

    </div>

    <table class="table table-condensed">

        <thead class="table-success">
            <tr>
                <th>Id</th>
                <th>Tên Lớp</th>
                <th>Số lượng sinh viên</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lop}" var="lop">
                <tr>
                    <td style="vertical-align: middle; text-align: center;">${lop.id}</td>
                    <td style="vertical-align: middle; text-align: center;">${lop.name}</td>
                    <td style="vertical-align: middle; text-align: center;">${lop.soLuongSinhVien}</td>
                    <td style="vertical-align: middle; text-align: center;">
                        <a href="<c:url value='/addorupdatelop/${lop.id}'/>" class="btn btn-info">Update</a>
                    </td>

                    <td style="vertical-align: middle; text-align: center;">

                        <button class="btn btn-danger" onclick="del('<c:url value="/deletelop/${lop.id}/"/>')">Delete</button>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <ul>

    </ul>
</section>
<script>
    function del(path) {
        if (confirm("Bạn chắc chắn xóa không?") === true) {
            fetch(path, {
                method: "delete"
            }).then(res => {
                if (res.status === 204)
                    location.reload();
                else
                    alert("Hệ thống đang có lỗi! Vui lòng quay lại sau!");
            });
        }
    }

</script>


