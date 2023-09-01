/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.repository.impl;

import com.fatscompany.pojo.MonHoc;
import com.fatscompany.repository.MonhocResponsitory;
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
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author anhkh
 */
@Repository
@Transactional
public class MonHocResponsitoryImpl implements MonhocResponsitory {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<MonHoc> getListMonHoc(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<MonHoc> q = b.createQuery(MonHoc.class);
        Root root = q.from(MonHoc.class);
        q.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
            }

            String tinChi = params.get("tinChi");
            if (tinChi != null && !tinChi.isEmpty()) {
                predicates.add(b.equal(root.get("tinChi"), Integer.parseInt(tinChi)));
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public int countMonHoc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addOrUpdateMonHoc(MonHoc mh) {

        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (mh.getId() == null) {
                s.save(mh);
            } else {
                s.update(mh);
            }

            return true;
        } catch (HibernateException ex) {

            return false;
        }

    }

    @Override
    public MonHoc getMonHocById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(MonHoc.class, id);
    }

    @Override
    public boolean deleteMonHoc(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            MonHoc mh = this.getMonHocById(id);
            s.delete(mh);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

