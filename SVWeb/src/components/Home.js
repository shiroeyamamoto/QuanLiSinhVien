import React, { useState, useEffect, useContext } from "react";
import { Card, Col, Row, Spinner } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../configs/Apis";
import { Link, useSearchParams } from "react-router-dom";
import { MyUserContext } from "../App";
import MySpinner from "../layout/MySpinner";

const Home = () => {
    //const [q] = useSearchParams();
    const [user, dispatch] = useContext(MyUserContext);
    const [data, setData] = useState([]);
    useEffect(() => {
        const fetchData = async () => {
            try {
                // Gọi API danh sách môn học bằng token xác thực
                const { data } = await authApi().get(endpoints['monhoc-giangvien']);

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
        if (user) {
            fetchData();
        }
    }, [user]);
    if (data === null)
        return <MySpinner />

    return (
        <div className="container">
            <div class="d-flex align-items-center">
                {user === null ? <h2 class="mb-3 mt-3">Chào mừng vị khách vãng lai! 👋</h2> : <>
                    <h2 class="mb-3 mt-3">
                        Chào mừng quay trở lại, {user.username}! 👋
                    </h2>
                </>}
            </div>
            <Row>
                {data.map(c => {
                    let url = `/monhocs/${c.id}`;

                    return <Col xs={12} md={3} className="mt-1">
                        <Link to={url} className="btn">
                            <Card style={{ width: '18rem' }}>
                                <Card.Img variant="top" src="https://res.cloudinary.com/dfv13jmbq/image/upload/v1694010996/qyebfascjyrybwbq7a8i.png" />
                                <Card.Body>
                                    <Card.Title>{c.id} - {c.name}</Card.Title>
                                </Card.Body>
                            </Card>
                        </Link>
                    </Col>
                })}
            </Row>
        </div>
    );
}

export default Home;
