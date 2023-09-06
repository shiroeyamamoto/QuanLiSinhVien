import React, { useState, useEffect } from "react";

const Home = () => {
    const [monHocs, setMonHocs] = useState([]);

    useEffect(() => {
        // Gửi yêu cầu GET đến API để lấy danh sách môn học
        fetch('http://localhost:8080/QuanLySinhVien/api/StuHoc')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setMonHocs(data);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    }, []);

    return (
        <div className="container">
            <h1>Danh Sách Môn Học</h1>
            <table className="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên Môn Học</th>
                        <th>Tín Chỉ</th>
                        <th>Xem Điểm Chi Tiết</th>
                    </tr>
                </thead>
                <tbody>
                    {monHocs.map(monHoc => (
                        <tr key={monHoc.id}>
                            <td>{monHoc.id}</td>
                            <td>{monHoc.name}</td>
                            <td>{monHoc.tinChi}</td>
                            <td>
                                <button className="btn btn-primary">Xem Điểm Chi Tiết</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Home;
