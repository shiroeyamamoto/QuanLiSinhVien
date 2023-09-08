package com.fatscompany.repository.impl;

import com.fatscompany.pojo.BangDiem;
import com.fatscompany.pojo.Hoc;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.repository.HocReponsitory;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HocReponsitoryImpl implements HocReponsitory {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Hoc> getListHoc() {
        Session s = this.factory.getObject().getCurrentSession();
        org.hibernate.query.Query q = s.createQuery("FROM Hoc");

        return q.getResultList();
    }

    @Override
    public List<MonHoc> getMonHocByStu(int sinhVienId) {
        try {
            Session s = this.factory.getObject().getCurrentSession();
            String hql = "FROM Hoc h WHERE h.sinhvienHOCid.id = :sinhVienId";
            Query<Hoc> query = s.createQuery(hql, Hoc.class);
            query.setParameter("sinhVienId", sinhVienId);

            List<Hoc> danhSachHoc = query.getResultList();

            // Khởi tạo collection lazy trước khi truyền vào JSON
            List<MonHoc> lMh = new ArrayList<>();
            for (Hoc hoc : danhSachHoc) {
                MonHoc monHoc = hoc.getMonhocHOCid();
                lMh.add(monHoc);
            }

            return lMh; // Trả về danh sách Hoc (có thể trống nếu không tìm thấy)

        } catch (Exception e) {
            // Xử lý lỗi ở đây, ví dụ ghi log
            e.printStackTrace();
            throw new RuntimeException("Lỗi trong quá trình truy vấn danh sách Hoc.", e);
        }
    }

    @Override
    public List<BangDiem> getDiemBySinhVien(int sinhVienId, List<MonHoc> danhSachMonHoc) {
        try {
            Session s = this.factory.getObject().getCurrentSession();

            // Truy vấn điểm của sinh viên dựa trên danh sách môn học và sinh viên ID
            String hql = "SELECT DISTINCT d FROM BangDiem d JOIN FETCH d.sinhvienScoreid s WHERE s.id = :sinhVienId AND d.monhocScoreid IN :danhSachMonHoc";
            Query<BangDiem> query = s.createQuery(hql, BangDiem.class);
            query.setParameter("sinhVienId", sinhVienId);
            query.setParameter("danhSachMonHoc", danhSachMonHoc);

            List<BangDiem> danhSachDiem = query.getResultList();

            return danhSachDiem;

        } catch (Exception e) {
            // Xử lý lỗi ở đây, ví dụ ghi log
            e.printStackTrace();
            throw new RuntimeException("Lỗi trong quá trình truy vấn danh sách điểm.", e);
        }
    }

}


