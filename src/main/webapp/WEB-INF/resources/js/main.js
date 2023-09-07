
function delAcc(path, id) {
    var confirmed = confirm("Bạn chắc chắn muốn xóa không?");
    if (confirmed) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                location.reload();
            } else {
                alert("Lỗi!!!");
            }
        });
    }
}