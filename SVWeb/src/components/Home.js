import React, { useState, useEffect, useContext } from "react";
import { Card, Col, Row } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { Link, useSearchParams } from "react-router-dom";
import { MyUserContext } from "../App";

const Home = () => {
    //const [q] = useSearchParams();
    const [user, dispatch] = useContext(MyUserContext);

    const [userData, setUserData] = useState(null);

    const loadUserData = async () => {
        let res = await Apis.get(endpoints['current-detail-user']);

        setUserData(res.data)

    }

    useEffect(() => {
        loadUserData();
        
        console.info(userData);
    }, []); // [] để chỉ chạy một lần khi component được mount
    
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


            <Link to="">
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
            </Link>
        </div>
    );
}

export default Home;
