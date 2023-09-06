/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.repository.impl;

import com.fatscompany.pojo.Lop;
import com.fatscompany.repository.LopRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anhkh
 */
@Repository
@Transactional
public class LopRepositoryImpl implements LopRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Lop> getListLop(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Lop> q = b.createQuery(Lop.class);
        Root root = q.from(Lop.class);
        q.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
            }

            String soLuongSinhVien = params.get("soLuongSinhVien");
            if (soLuongSinhVien != null && !soLuongSinhVien.isEmpty()) {
                predicates.add(b.equal(root.get("tinChi"), Integer.parseInt(soLuongSinhVien)));
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean updateLop(int id, Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        try {

            if (params != null) {
                Lop tc = this.getLopById(id);
                String tmp = params.get("name");
                if (tmp != null && !tmp.isEmpty()) {
                    tc.setName(tmp);
                }
                tmp = params.get("soLuongSinhVien");
                if (tmp != null && !tmp.isEmpty()) {
                    tc.setSoLuongSinhVien(Integer.parseInt(tmp));
                }
                s.update(tc);
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateLop(Lop tc) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.update(tc);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addLop(Lop tc) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(tc);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Lop getLopById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Lop.class, id);
    }

    @Override
    public boolean deleteLop(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Lop mh = this.getLopById(id);
            s.delete(mh);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
