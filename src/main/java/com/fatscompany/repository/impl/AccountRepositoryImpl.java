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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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

        Root<Account> accountRoot = acc.from(Account.class);

        Join<Account, GiangVien> giangVienJoin = accountRoot.join("giangVienSet", JoinType.LEFT);
        Join<Account, SinhVien> sinhVienJoin = accountRoot.join("sinhVienSet", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        if (params != null) {
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate usernamePredicate = b.like(accountRoot.get("username"), String.format("%%%s%%", kw));
                Predicate rolePredicate = b.like(accountRoot.get("role"), String.format("%%%s%%", kw));
                Predicate lastNamePredicateGV = b.like(giangVienJoin.get("firstName"), String.format("%%%s%%", kw));
                Predicate firstNamePredicateGV = b.like(giangVienJoin.get("lastName"), String.format("%%%s%%", kw));
                Predicate lastNamePredicateSV = b.like(sinhVienJoin.get("firstName"), String.format("%%%s%%", kw));
                Predicate firstNamePredicateSV = b.like(sinhVienJoin.get("lastName"), String.format("%%%s%%", kw));

                Predicate combinedPredicate = b.or(usernamePredicate, rolePredicate, lastNamePredicateGV, firstNamePredicateGV, lastNamePredicateSV, firstNamePredicateSV);
                predicates.add(combinedPredicate);
            }
        }
        acc.multiselect(
                accountRoot.get("id"),
                accountRoot.get("username"),
                accountRoot.get("password"),
                accountRoot.get("role"),
                accountRoot.get("avatar")
//                ,
//                giangVienJoin.get("firstName"),
//                giangVienJoin.get("lastName"),
//                sinhVienJoin.get("firstName"),
//                sinhVienJoin.get("lastName"),
//                giangVienJoin.get("email"),
//                sinhVienJoin.get("email")
        );

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
    public List<Map<String, Object>> getAccountDetails(String keyword) {

//        Session session = this.factory.getObject().getCurrentSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Tuple> query = cb.createTupleQuery();
//
//        Root<Account> accountRoot = query.from(Account.class);
//        Join<Account, GiangVien> giangVienJoin = accountRoot.join("giangVienSet", JoinType.LEFT);
//        Join<Account, SinhVien> sinhVienJoin = accountRoot.join("sinhVienSet", JoinType.LEFT);
//
//        query.multiselect(
//                accountRoot.get("id"),
//                accountRoot.get("username"),
//                accountRoot.get("role"),
//                giangVienJoin.get("firstName"),
//                giangVienJoin.get("lastName"),
//                giangVienJoin.get("email"),
//                sinhVienJoin.get("firstName"),
//                sinhVienJoin.get("lastName"),
//                sinhVienJoin.get("email")
//        );
//
//        if (keyword != null && !keyword.isEmpty()) {
//            Predicate usernamePredicate = cb.like(accountRoot.get("username"), "%" + keyword + "%");
//            Predicate rolePredicate = cb.like(accountRoot.get("role"), "%" + keyword + "%");
//            Predicate lastNamePredicateGV = cb.like(giangVienJoin.get("lastName"), "%" + keyword + "%");
//            Predicate firstNamePredicateGV = cb.like(giangVienJoin.get("firstName"), "%" + keyword + "%");
//            Predicate lastNamePredicateSV = cb.like(sinhVienJoin.get("lastName"), "%" + keyword + "%");
//            Predicate firstNamePredicateSV = cb.like(sinhVienJoin.get("firstName"), "%" + keyword + "%");
//
//            Predicate combinedPredicate = cb.or(usernamePredicate, rolePredicate, lastNamePredicateGV, firstNamePredicateGV, lastNamePredicateSV, firstNamePredicateSV);
//            query.where(combinedPredicate);
//        }
//
//        TypedQuery<Tuple> typedQuery = session.createQuery(query);
//        List<Tuple> tuples = typedQuery.getResultList();
//
//        List<Map<String, Object>> result = new ArrayList<>();
//        for (Tuple tuple : tuples) {
//            Map<String, Object> resultMap = new HashMap<>();
//            resultMap.put("id", tuple.get(0, Integer.class));
//            resultMap.put("username", tuple.get(1, String.class));
//            resultMap.put("role", tuple.get(2, String.class));
//            resultMap.put("gvFirstName", tuple.get(3, String.class));
//            resultMap.put("gvLastName", tuple.get(4, String.class));
//            resultMap.put("gvEmail", tuple.get(5, String.class));
//            resultMap.put("svFirstName", tuple.get(6, String.class));
//            resultMap.put("svLastName", tuple.get(7, String.class));
//            resultMap.put("svEmail", tuple.get(8, String.class));
//            result.add(resultMap);
//        }
        return null;
    }

    @Override
    public boolean addOrUpdateAccount(Account acc) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (acc.getId() == null) {
                s.save(acc);
            } else {
                s.update(acc);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int countAccount() {
        Session s = this.factory.getObject().getCurrentSession();
        Query acc = s.createQuery("SELECT COUNT(*) FROM Account");

        return Integer.parseInt(acc.getSingleResult().toString());
    }

}
