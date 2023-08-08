/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.repository.impl;

import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.BangDiem;
import com.fatscompany.pojo.GiangVien;
import com.fatscompany.pojo.Lop;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.pojo.SinhVien;
import com.fatscompany.repository.StatsRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class StatsRepositoryImpl implements StatsRepository{

    @Autowired
    private LocalSessionFactoryBean factory;

    public List<Object[]> infoGiangVien() {

        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rAcc = q.from(Account.class);
        Root rGiangVien = q.from(GiangVien.class);
        q.where(b.equal(rGiangVien.get("accountGVid"), rAcc.get("id")));
        // Đếm coi trong account có bao nhiêu giảng viên
        q.multiselect(rGiangVien.get("id"), rGiangVien.get("firstName"), rGiangVien.get("lastName"),
                rAcc.get("username"), rGiangVien.get("email"));
        q.groupBy(rGiangVien.get("id"));

        Query query = s.createQuery(q);
        return query.getResultList();

    }

    public List<Object[]> infoSinhVien() {

        List<Predicate> predicate = new ArrayList<>();

        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rAcc = q.from(Account.class);
        Root rSinhVien = q.from(SinhVien.class);
        Root rLop = q.from(Lop.class);

        // Tạo liên kết giữa rSinhVien và rAcc dựa trên accountSVid
        predicate.add(b.equal(rSinhVien.get("accountSVid"), rAcc.get("id")));

        // Tạo liên kết giữa rSinhVien và rAcc dựa trên accountSVid
        predicate.add(b.equal(rSinhVien.get("lopId"), rLop.get("id")));

        q.where(predicate.toArray(Predicate[]::new));

        // Đếm coi trong account có bao nhiêu giảng viên
        q.multiselect(rSinhVien.get("id"), rSinhVien.get("firstName"), rSinhVien.get("lastName"), rAcc.get("username"),
                rSinhVien.get("email"), rLop.get("name"));

        q.groupBy(rSinhVien.get("id"));

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    public List<Object[]> traCuuDiem() {

        List<Predicate> predicate = new ArrayList<>();

        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rDiem = q.from(BangDiem.class);
        Root rMonHoc = q.from(MonHoc.class);
        Root rSinhVien = q.from(SinhVien.class);

        // Tạo liên kết giữa rSinhVien và rAcc dựa trên accountSVid
        predicate.add(b.equal(rDiem.get("sinhvienScoreid"), rSinhVien.get("id")));

        // Tạo liên kết giữa rSinhVien và rAcc dựa trên accountSVid
        predicate.add(b.equal(rDiem.get("monhocScoreid"), rMonHoc.get("id")));

        q.where(predicate.toArray(Predicate[]::new));

        // Đếm coi trong account có bao nhiêu giảng viên
        q.multiselect(rSinhVien.get("id"), rSinhVien.get("firstName"), rSinhVien.get("lastName"), rDiem.get("diemGiuaki"),
                 rDiem.get("diemCuoiki"), rDiem.get("diemkhac1"), rDiem.get("diemkhac2"), rDiem.get("diemkhac3"),
                rDiem.get("diemkhac4"), rDiem.get("diemkhac5"));

        //q.groupBy(rSinhVien.get("id"));
        Query query = s.createQuery(q);
        return query.getResultList();
    }
}
