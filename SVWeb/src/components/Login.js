import { useContext, useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../configs/Apis";
import cookie from 'react-cookies'
import { MyUserContext } from "../App";
import { Navigate} from "react-router-dom";

const Login = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();


    const login = (evt) => {
        evt.preventDefault();

        const process = async () => {
            try {
                let res = await Apis.post(endpoints['login'], {
                    "username": username,
                    "password": password
                });
                cookie.save("token", res.data);

                let {data} = await authApi().get(endpoints['current-user']);

                cookie.save("user",data);

                dispatch({
                    "type":"login",
                    "payload":data
                })
            } catch (err) {
                console.error(err);
            }
        }

        process();
    }

    if(user!=null)
        return <Navigate to="/" />

    return <>
        <Container>
            <h1 className="text-center text-info">Đăng nhập</h1>
            <Form onSubmit={login}>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Username</Form.Label>
                    <Form.Control value={username} onChange={e => setUsername(e.target.value)} type="text" placeholder="Tên đăng nhập" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Password</Form.Label>
                    <Form.Control value={password} onChange={e => setPassword(e.target.value)} type="password" placeholder="Mật khẩu" />
                </Form.Group>
                <Button className="bg-success" type="submit">Đăng nhập</Button>
            </Form>
        </Container>
    </>
}

export default Login;