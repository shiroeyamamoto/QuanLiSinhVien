import { BrowserRouter, Routes, Route } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import cookie from 'react-cookies'
import Home from "./components/Home";
import Header from "./layout/Header";
import Footer from "./layout/Footer";
import Login from "./components/Login";
import Forum from "./components/Forum";
import MonHoc from "./components/MonHoc";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import MonHocGiangVien from "./components/MonHocGiangVien";
import NhapDiemSinhVien from "./components/NhapDiemSinhVien";


export const MyUserContext = createContext();

export const MyUserDetail = createContext();

const App = () => {

  const [user, dispatch] = useReducer(MyUserReducer,cookie.load("user") || null);

  //const [userDetail, dispatch] = useReducer(MyUserReducer,cookie.load("user") || null);

  return (
    <MyUserContext.Provider value={[user,dispatch]}>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/monhoc" element={<MonHoc/>} />
          <Route path="/monhocGV" element={<MonHocGiangVien/>} />
          <Route path="/forum" element={<Forum />} />
          <Route path="/monhocs/:monhocId" element={<MonHocGiangVien />} />
          <Route path="/monhocs/:monhocId/nhapdiemsinhvien/:sinhvienId" element={<NhapDiemSinhVien />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </MyUserContext.Provider>
  );
};

export default App;
