import React, { useState, useEffect, useContext } from 'react';
import { Container } from 'react-bootstrap';
import Table from 'react-bootstrap/Table';
import { MyUserContext } from "../App";
import { authApi, endpoints } from "../configs/Apis";

const MonHoc = () => {
  const [data, setData] = useState([]);
  const [user] = useContext(MyUserContext);

  useEffect(() => {
    const fetchData = async () => {
      try {
        // Gọi API danh sách môn học bằng token xác thực
        const { data } = await authApi().get(endpoints['detailMonHoc']);

        // Xử lý dữ liệu nếu nó không phải là null
        if (data) {
          setData(data);
        } else {
          console.error('Dữ liệu là null hoặc trống');
        }
      } catch (error) {
        console.error('Lỗi khi truy xuất dữ liệu:', error);
      }
    };

    // Kiểm tra xem user đã đăng nhập hay chưa
    if (user) {
      fetchData();
    }
  }, [user]);

  return (
    <div>
      <Container>
        <h1>Danh sách môn học và điểm</h1>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>Tên Môn Học</th>
              <th>Điểm Giữa Kì</th>
              <th>Điểm Cuối Kì</th>
              <th>Điểm Khác</th> {/* Thêm cột cho điểm khác */}
            </tr>
          </thead>
          <tbody>
            {data.map(item => (
              <tr key={item.studentId + item.subjectName}>
                <td>{item.subjectName}</td>
                <td>{item.diemGiuaki}</td>
                <td>{item.diemCuoiKi}</td>
                <td>
                  {item.otherScore.map((score, index) => (
                    <div key={index}>Điểm {index + 1}: {score}</div>
                  ))}
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </Container>
    </div>
  );
  
};

export default MonHoc;
