import React, { useState, useEffect, useContext } from "react";
import { Card, Col, Row } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { useSearchParams } from "react-router-dom";
import { MyUserContext } from "../App";

const Home = () => {
    const [monHocs, setMonHocs] = useState([]);
    const [days, setdays] = useState([]);
    const [q] = useSearchParams();
    const [user, dispatch] = useContext(MyUserContext);

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

    const loadDay = async () => {

        let res = await Apis.get(endpoints['days'])

        setdays(res.data);
    }

    useEffect(() => {
        loadDay();
    }, []);

    return (
        <div className="container">
            <div class="d-flex align-items-center">
                {user === null ? <h2 class="mb-3 mt-3">Chào mừng vị khách vãng lai! 👋</h2> : <>
                    <h2 class="mb-3 mt-3">
                        Chào mừng quay trở lại, {user.username}! 👋
                    </h2>
                </>}
                <div class="header-actions-container ml-auto" data-region="header-actions-container">
                </div>
            </div>


            <Row>
                <Col xs={12} md={3} className="mt-1">
                    <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src="https://res.cloudinary.com/dfv13jmbq/image/upload/v1694010996/qyebfascjyrybwbq7a8i.png" />
                        <Card.Body>
                            <Card.Title>Card Title</Card.Title>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
            {/* <h1>Danh Sách Môn Học</h1>
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
            </table> */}
        </div>
    );
}

export default Home;
