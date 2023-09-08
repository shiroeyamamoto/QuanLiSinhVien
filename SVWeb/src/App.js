import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./components/Home";
import Header from "./layout/Header";
import Footer from "./layout/Footer";
import MonHoc from "./components/MonHoc";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<MonHoc />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </>
  );
};

export default App;
