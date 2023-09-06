package com.fatscompany.repository.impl;

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

}
