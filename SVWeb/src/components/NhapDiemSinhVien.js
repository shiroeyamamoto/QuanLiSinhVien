import { useContext, useEffect, useState } from "react";
import { Form, Table } from "react-bootstrap";
import { Link, Navigate, useParams } from "react-router-dom";
import { MyUserContext } from "../App";
import { authApi, endpoints } from "../configs/Apis";

const NhapDiemSinhVien = () => {
    const [user,] = useContext(MyUserContext);
    const { monhocId, sinhvienId } = useParams();
    const [sinhVien, setSinhVien] = useState([]);
    const [bangDiem, setBangDiem] = useState([]);

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

    console.info(bangDiem);

    if (user === null)
        return <Navigate to="/login" />

    return (
        <div className='container'>
            <h1 className='my-3'>Nhập điểm sinh viên {sinhVien.lastName} {sinhVien.firstName}</h1>
            <div className="row">
                <div className="col">Điểm giữa kì</div>
                <div className="col"><input type="text" id="diem-giua-ki" /></div>
            </div>
            <div className="row">
                <div className="col">Điểm cuối kì</div>
                <div className="col"><input type="text" id="diem-cuoi-ki" /></div>
            </div>
            <div className="row">
                <div className="col">Điểm 1</div>
                <div className="col"><input type="text" id="diem-1" /></div>
            </div>
            <div className="row">
                <div className="col">Điểm 2</div>
                <div className="col"><input type="text" id="diem-2" /></div>
            </div>
            <div className="row">
                <div className="col">Điểm 3</div>
                <div className="col"><input type="text" id="diem-3" /></div>
            </div>
            <div className="row">
                <div className="col">Điểm 4</div>
                <div className="col"><input type="text" id="diem-4" /></div>
            </div>
            <div className="row">
                <div className="col">Điểm 5</div>
                <div className="col"><input type="text" id="diem-5" /></div>
            </div>
            <div className="row">
                <div className="col">Trung bình tổng</div>
                <div className="col"><input type="text" id="trung-binh-tong" readonly /></div>
            </div>

        </div>

    );
}

export default NhapDiemSinhVien;