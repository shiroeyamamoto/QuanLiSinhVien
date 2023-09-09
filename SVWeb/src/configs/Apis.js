import axios from "axios";
import cookie from 'react-cookies'

const SERVER_CONTEXT = "QuanLySinhVien";
const SERVER = "http://localhost:8080";

export const endpoints = {
    "accounts": `${SERVER_CONTEXT}/api/accounts`,
    "days": `${SERVER_CONTEXT}/api/days`,
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "current-detail-user": `${SERVER_CONTEXT}/api/current-detail-user/`,
    "monhoc-giangvien": `${SERVER_CONTEXT}/api/monhoc-giangvien/`,
    "detailsMonhoc":(monhocId) => `${SERVER_CONTEXT}/api/monhocs/${monhocId}/`,
    "detailsSinhvien":(monhocId) => `${SERVER_CONTEXT}/api/sinhviens/list-sinhvien-hoc-monhoc/${monhocId}/`,
    "detailsSinhvienBangDiem":(monhocId, sinhvienId) => `${SERVER_CONTEXT}/api/sinhviens/list-sinhvien-hoc-monhoc/${monhocId}/sinhvien/${sinhvienId}/`,
    "sinhvienMonHoc":(sinhvienId) => `${SERVER_CONTEXT}/api/sinhviens/${sinhvienId}/`,
    "detailMonHoc": `${SERVER_CONTEXT}/api/studenScores/listscore`
}

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers:{
            "Authorization": cookie.load("token") 
        }
    })
}

export default axios.create({
    baseURL: SERVER
})