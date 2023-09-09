/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.repository.impl;

import com.fatscompany.pojo.BangDiem;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.pojo.SinhVien;
import com.fatscompany.repository.BangDiemRepository;
import com.fatscompany.service.MonHocService;
import com.fatscompany.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
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
public class BangDiemRepositoryImpl implements BangDiemRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private MonHocService monhocService;

    @Override
    public List<BangDiem> getBangDiem() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("BangDiem.findAll");

        return q.getResultList();
    }

    @Override
    public BangDiem getBangDiemForSinhVien(int monHocId, int sinhVienId) {
        try {
            Session s = this.factory.getObject().getCurrentSession();

            SinhVien sv = this.studentService.getSinhVienById(sinhVienId);
            
            MonHoc mh = this.monhocService.getMonHocById(monHocId);

            List<BangDiem> getListBangDiem = getBangDiem();

            for (int i = 0; i < getListBangDiem.size(); i++) {
                if(getListBangDiem.get(i).getSinhvienScoreid().equals(sv) && getListBangDiem.get(i).getMonhocScoreid().equals(mh)){
                    return getListBangDiem.get(i);
                }
            }
            return null;

        } catch (Exception e) {
            // Xử lý lỗi ở đây, ví dụ ghi log
            e.printStackTrace();
            throw new RuntimeException("Lỗi trong quá trình truy vấn danh sách sinh vien hoc.", e);
        }
    }
    
    
}
