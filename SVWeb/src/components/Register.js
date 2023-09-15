import { useContext, useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../configs/Apis";
import cookie from 'react-cookies'
import { MyUserContext } from "../App";
import { Navigate } from "react-router-dom";

const Register = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [email, setEmail] = useState('');
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const register = async (evt) => {
        evt.preventDefault();

        const userData = {
            email: email,
            firstName: firstName,
            lastName: lastName,
            username: username,
            password: password
        };

        const process = async () => {
            try {
                // Gửi yêu cầu đăng ký đến máy chủ
                let res = await Apis.post(endpoints['register'], userData);

                // Lưu token vào cookie sau khi đăng ký thành công
                cookie.save("token", res.data);

                // Lấy thông tin người dùng sau khi đăng ký
                let { data } = await authApi().get(endpoints['current-user']);

                // Lưu thông tin người dùng vào cookie và cập nhật context
                cookie.save("user", data);
                dispatch({
                    "type": "login",
                    "payload": data
                });

                // Chuyển hướng người dùng sau khi đăng ký thành công
                // Ví dụ: chuyển hướng đến trang chính của ứng dụng
            } catch (err) {
                console.error(err);
            }
        }

        process();
    }

    if (user !== null)
        return <Navigate to="/" />

    return (
        <Container>
            <h1 className="text-center text-info">Đăng ký</h1>
            <Form onSubmit={register}>
                <Form.Group className="mb-3" controlId="formEmail">
                    <Form.Label>Email</Form.Label>
                    <Form.Control
                        type="email"
                        placeholder="Email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formFirstName">
                    <Form.Label>First Name</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="First Name"
                        value={firstName}
                        onChange={(e) => setFirstName(e.target.value)}
                        required
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formLastName">
                    <Form.Label>Last Name</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Last Name"
                        value={lastName}
                        onChange={(e) => setLastName(e.target.value)}
                        required
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formUsername">
                    <Form.Label>Username</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                        type="password"
                        placeholder="Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </Form.Group>
                <Button className="bg-success" type="submit">Đăng ký</Button>
            </Form>
        </Container>
    );
}

export default Register;
