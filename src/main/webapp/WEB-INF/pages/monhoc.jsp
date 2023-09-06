<%-- 
    Document   : monhoc
    Created on : Aug 25, 2023, 11:27:32 PM
    Author     : anhkh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/monhoc" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-1">Quản lí môn học</h1>
    <div>
        <a href="<c:url value="/addorupdatemonhoc" />" class="btn btn-info">Thêm Môn Học</a>

    </div>
    <table class="table table-condensed mx-2">
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
                        <a href="<c:url value='/addorupdatemonhoc/${monHoc.id}'/>" class="btn btn-warning">Update</a>
                    </td>

                    <td style="vertical-align: middle; text-align: center;">
                    

                        <button onclick="del('<c:url value="/deletemonhoc/${monHoc.id}/"/>')" class="btn btn-danger">Delete</button>

                    </td>
                </tr>
            </c:forEach>



        </tbody>
    </table>
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
