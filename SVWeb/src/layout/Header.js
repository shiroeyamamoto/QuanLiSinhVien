import 'bootstrap/dist/css/bootstrap.min.css';
import { useContext, useEffect, useState } from "react";
import Apis, { endpoints } from "../configs/Apis";
import { Button, Col, Container, Form, Nav, Navbar, Row } from "react-bootstrap";
import MySpinner from './MySpinner';
import { Link, useNavigate } from 'react-router-dom';
import { MyUserContext } from '../App';

const Header = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [account, setAccount] = useState(null);
    const [kw, setKw] = useState("");
    const nav = useNavigate();

    const loadAccount = async () => {

        let res = await Apis.get(endpoints['accounts'])

        setAccount(res.data);
    }

    useEffect(() => {

        loadAccount();
    }, []);

    if (account === null)
        return <MySpinner />;

    const search = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`)
    }

    const logout = () => {
        dispatch({
            "type":"logout"
        })
    }

    return (
        <>
            <Navbar bg="primary" variant="dark" expand="lg" className='py-3'>
                <Container>
                    <Navbar.Brand href="/">FatsCompany</Navbar.Brand>
                    <Nav className="me-auto">
                        <Link className='nav-link' to="/">Trang chủ</Link>
                        <Link className='nav-link' to="/forum">Diễn đàn</Link>
                        {user ===null ? <></>:
                        user.role != "ROLE_,STUDENT"?<></>:
                        <Link className='nav-link' to="/monhoc">Danh Sách Môn Học</Link>
                        }
                        
                        {user ===null ? <Link className='nav-link text-danger' to="/login">Đăng Nhập</Link>:<>
                            <Link className='nav-link text-danger' to="/">Chào  {user.username}</Link>
                            <Button variant='danger' onClick={logout}>Đăng xuất</Button> 
                        </>}
                    </Nav>
                    <Form onSubmit={search} inline>
                        <Row>
                            <Col xs="auto">
                                <Form.Control
                                    type="text"
                                    value={kw}
                                    onChange={e => setKw(e.target.value)}
                                    placeholder="Nhập từ khóa..." name='kw'
                                    className=" mr-sm-2"
                                />
                            </Col>
                            <Col xs="auto">
                                <Button type="submit" className='btn-danger'>Tìm</Button>
                            </Col>
                        </Row>
                    </Form>
                </Container >
            </Navbar >
        </>
    )
}

export default Header;