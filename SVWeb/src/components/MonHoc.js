import React, { useState, useEffect } from 'react';

const MonHoc = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    // Thực hiện yêu cầu API để lấy danh sách môn học và điểm
    fetch('http://localhost:8080/QuanLySinhVien/api/studenScores/listscore')
      .then(response => response.json())
      .then(data => {
        setData(data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
      <h2>Danh sách môn học và điểm</h2>
      <table  striped bordered hover>
        <thead>
          <tr>
            <th>Tên Môn Học</th> {/* Thay đổi tiêu đề cột */}
            <th>Điểm Giữa Kì</th>
            <th>Điểm Cuối Kì</th>
          </tr>
        </thead>
        <tbody>
          {data.map(item => (
            <tr key={item.studentId + item.subjectName}>
              <td>{item.subjectName}</td> {/* Hiển thị tên môn học thay vì mã */}
              <td>{item.diemGiuaki}</td>
              <td>{item.diemCuoiKi}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default MonHoc;
