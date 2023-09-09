/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.repository.impl;

import com.fatscompany.pojo.Hoc;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.SinhVien;
import com.fatscompany.repository.StudentRepository;
import com.fatscompany.service.HocService;
import com.fatscompany.service.MonHocService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author khang
 */
@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private HocService hocService;
    
     @Autowired
    private MonHocService monHocService;

    @Override
    public List<SinhVien> getSinhVien() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("SinhVien.findAll");

        return q.getResultList();
    }

    @Override
    public SinhVien getSinhVienById(int id) {

        Session s = this.factory.getObject().getCurrentSession();
        return s.get(SinhVien.class, id);

    }

    @Override
    public boolean addOrUpdateStudent(SinhVien sv) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (sv.getId() == null) {
                s.save(sv);
            } else {
                s.update(sv);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SinhVien> getListSinhVienByHocId(List<Hoc>  hoc) {

        try {
            Session s = this.factory.getObject().getCurrentSession();

            List<SinhVien> listSinhVien = getSinhVien();

            List<SinhVien> updateListSinhVien = new ArrayList<>();

            for (int i = 0; i < listSinhVien.size(); i++) {
                for (int j = 0; j < hoc.size(); j++) {
                    if (listSinhVien.get(i).equals(hoc.get(j).getSinhvienHOCid())) {
                        updateListSinhVien.add(listSinhVien.get(i));
                    }
                }
            }

            return updateListSinhVien;

        } catch (Exception e) {
            // Xử lý lỗi ở đây, ví dụ ghi log
            e.printStackTrace();
            throw new RuntimeException("Lỗi trong quá trình truy vấn danh sách sinh vien hoc.", e);
        }

    }
    public SinhVien getSinhVienByAccountId(Account account) {
        Session session = this.factory.getObject().getCurrentSession();

        String hql = "FROM SinhVien s WHERE s.accountSVid.id = :accountId";
        Query query = session.createQuery(hql);
        query.setParameter("accountId", account.getId()); // Truyền vào account.id thay vì account

        List<SinhVien> results = query.getResultList();

        if (results != null && !results.isEmpty()) {
            return results.get(0);
        } else {
            return null;
        }
    }

}
