/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.repository.impl;

import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.GiangVien;
import com.fatscompany.pojo.SinhVien;
import com.fatscompany.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author khang
 */
@Repository
@PropertySource("classpath:configs.properties")
@Transactional
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    public List<Account> getAccount(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Account> acc = b.createQuery(Account.class);
        //CriteriaQuery<GiangVien> teacher = b.createQuery(GiangVien.class);
        //CriteriaQuery<SinhVien> student = b.createQuery(SinhVien.class);

        Root<Account> accountRoot = acc.from(Account.class);
        //Root teacherRoot = acc.from(GiangVien.class);
        //Root studentRoot = acc.from(SinhVien.class);
        Join<Account, GiangVien> giangVienJoin = accountRoot.join("giangVienSet", JoinType.LEFT);
        Join<Account, SinhVien> sinhVienJoin = accountRoot.join("sinhVienSet", JoinType.LEFT);
        //acc.select(accountRoot);

        //acc.get
        acc.multiselect(
                accountRoot.get("id"),
                accountRoot.get("username"),
                accountRoot.get("password"),
                accountRoot.get("role"),
                accountRoot.get("avatar"),
                //b.coalesce(giangVienJoin.get("firstName"), sinhVienJoin.get("firstName")),
                //b.coalesce(giangVienJoin.get("lastName"), sinhVienJoin.get("lastName"))
                giangVienJoin.get("firstName"),
                giangVienJoin.get("lastName"),
                sinhVienJoin.get("firstName"),
                sinhVienJoin.get("lastName"),
                giangVienJoin.get("email"),
                sinhVienJoin.get("email")
        );

        List<Predicate> predicates = new ArrayList<>();

        // Tìm từ khóa
//        if (params != null) {
//            String kw = params.get("kw");
//            if (kw != null && !kw.isEmpty()) {
//                Predicate p = b.like(root.get("username"), String.format("%%%s%%", kw));
//                acc.where(p);
//            }
//        }
        // Sap xep giảm dần
        //acc.orderBy(b.asc(root.get("id")));
        acc.where(predicates.toArray(new Predicate[0]));

        Query query = s.createQuery(acc);

        if (params != null) {
            String page = params.get("page");
            if (page != null) {
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
        }
        return query.getResultList();
    }

    @Override
    public int countAccount() {
        Session s = this.factory.getObject().getCurrentSession();
        Query acc = s.createQuery("SELECT COUNT(*) FROM Account");

        return Integer.parseInt(acc.getSingleResult().toString());
    }

}
