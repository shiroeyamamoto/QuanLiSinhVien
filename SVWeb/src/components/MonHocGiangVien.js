import React, { useState, useEffect, useContext } from 'react';
import { authApi, endpoints } from '../configs/Apis';
import { Link, Navigate, useParams } from 'react-router-dom';
import { MyUserContext } from '../App';
import { Table } from 'react-bootstrap';

const MonHocGiangVien = () => {
  const [user,] = useContext(MyUserContext);
  const { monhocId } = useParams();
  const [monhoc, setMonHoc] = useState([]);
  const [sinhVienList, setsinhVienList] = useState([]);


  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data } = await authApi().get(endpoints['detailsSinhvien'](monhocId));

        // Xử lý dữ liệu nếu nó không phải là null
        if (data) {
          setsinhVienList(data);
        } else {
          console.error('Dữ liệu là null hoặc trống');
        }
      } catch (error) {
        console.error('Lỗi khi truy xuất dữ liệu:', error);
      }
    };

    if (user) {
      fetchData();
    }
  }, [user]);
  useEffect(() => {
    const fetchData2 = async () => {
      try {
        const { data } = await authApi().get(endpoints['detailsMonhoc'](monhocId));

        // Xử lý dữ liệu nếu nó không phải là null
        if (data) {
          setMonHoc(data);
        } else {
          console.error('Dữ liệu là null hoặc trống');
        }
      } catch (error) {
        console.error('Lỗi khi truy xuất dữ liệu:', error);
      }
    };

    if (user) {
      fetchData2();
    }
  }, [user]);
  console.info(monhoc);

  if (user === null)
    return <Navigate to="/login" />

  return (
    <div className='container'>
      <h1 className='my-3'>Danh sách sinh viên lớp ({monhocId} - {monhoc.name})</h1>

      <Table striped bordered hover variant="light">
        <thead>
          <tr>
            <th>Id</th>
            <th>Họ</th>
            <th>Tên</th>
            <th>Email</th>
            <th>Nhập điểm</th>
          </tr>
        </thead>
        <tbody>
          {sinhVienList.map(item => {

            let url = `/monhocs/${monhocId}/nhapdiemsinhvien/${item.id}/`;

            return <tr>
              <td>{item.id}</td>
              <td>{item.lastName}</td>
              <td>{item.firstName}</td>
              <td>{item.email}
              </td>
              <td className='fix-right'>
                <Link to={url} className='btn btn-success' key={item.id}>Nhập điểm</Link>
              </td>
            </tr>
          })}
        </tbody>
      </Table>

      <Link className='btn btn-danger'>Export PDF</Link>
    </div>

  );
};

export default MonHocGiangVien;
