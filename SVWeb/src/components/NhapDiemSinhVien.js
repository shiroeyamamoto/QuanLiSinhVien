import { useContext, useEffect, useState } from "react";
import { Button, Form, Modal, Table } from "react-bootstrap";
import { Link, Navigate, useParams } from "react-router-dom";
import { MyUserContext } from "../App";
import { authApi, endpoints } from "../configs/Apis";

const NhapDiemSinhVien = () => {
    const [user,] = useContext(MyUserContext);
    const { monhocId, sinhvienId } = useParams();
    const [sinhVien, setSinhVien] = useState([]);
    const [bangDiem, setBangDiem] = useState([]);
    const [showConfirmation, setShowConfirmation] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const { data } = await authApi().get(endpoints['sinhvienMonHoc'](sinhvienId));

                // Xử lý dữ liệu nếu nó không phải là null
                if (data) {
                    setSinhVien(data);
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
        const fetchData3 = async () => {
            try {
                const { data } = await authApi().get(endpoints['detailsSinhvienBangDiem'](monhocId, sinhvienId));

                // Xử lý dữ liệu nếu nó không phải là null
                if (data) {
                    setBangDiem(data);
                } else {
                    console.error('Dữ liệu là null hoặc trống');
                }
            } catch (error) {
                console.error('Lỗi khi truy xuất dữ liệu:', error);
            }
        };

        if (user) {
            fetchData3();
        }
    }, [user]);

    const handleShowConfirmation = () => setShowConfirmation(true);
    const handleCloseConfirmation = () => setShowConfirmation(false);

    const handleLockScore = () => {
        // Thực hiện xử lý khóa điểm ở đây
        // Sau khi hoàn thành, bạn có thể đóng hộp thoại xác nhận bằng cách gọi handleCloseConfirmation()
        handleCloseConfirmation();
    };


    if (user === null)
        return <Navigate to="/login" />

    return (
        <div className='container'>
            <h1 className='my-3'>Nhập điểm sinh viên {sinhVien.lastName} {sinhVien.firstName}</h1>

            {bangDiem.status===0?
            <span className="bg-danger btn text-dark">Khóa</span>:
            <span className="bg-success btn text-light">Khóa</span>    
        }

            <Table bordered hover className="mt-3">
                <thead>
                    <tr>
                        <th>Cột điểm</th>
                        <th>Điểm</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Điểm giữa kì</td>
                        <td>
                            <Form.Control
                                type="text"
                                placeholder=""
                                className=" mr-sm-2"
                                value={bangDiem.diemGiuaki}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>Điểm cuối kì</td>
                        <td>
                            <Form.Control
                                type="text"
                                placeholder=""
                                className=" mr-sm-2"
                                value={bangDiem.diemCuoiki}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>Điểm 1</td>
                        <td>
                            <Form.Control
                                type="text"
                                placeholder=""
                                className=" mr-sm-2"
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>Điểm 2</td>
                        <td>
                            <Form.Control
                                type="text"
                                placeholder=""
                                className=" mr-sm-2"
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>Điểm 3</td>
                        <td>
                            <Form.Control
                                type="text"
                                placeholder=""
                                className=" mr-sm-2"
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>Điểm 4</td>
                        <td>
                            <Form.Control
                                type="text"
                                placeholder=""
                                className=" mr-sm-2"
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>Điểm 5</td>
                        <td>
                            <Form.Control
                                type="text"
                                placeholder=""
                                className=" mr-sm-2"
                            />
                        </td>
                    </tr>
                </tbody></Table>

            <div class="row ">
                <div class="col">Trung bình tổng:</div>
                <div class="col"></div>
            </div>
            <Link className='btn btn-danger mt-3 text-dark' onClick={handleShowConfirmation} >Khóa điểm</Link>
            <br></br>
            <Link className='btn btn-success mt-3'>Save điểm</Link>

            <Modal show={showConfirmation} onHide={handleCloseConfirmation} centered>
            <Modal.Header closeButton>
                <Modal.Title>Xác nhận khóa điểm</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                Bạn có chắc chắn muốn khóa điểm không?
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleCloseConfirmation}>
                    Hủy
                </Button>
                <Button variant="danger" onClick={handleLockScore}>
                    Khóa
                </Button>
            </Modal.Footer>
        </Modal>
        </div>

    );
}

export default NhapDiemSinhVien;