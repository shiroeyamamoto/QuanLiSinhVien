/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.repository.impl;

import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.GiangVien;
import com.fatscompany.repository.TeacherRepository;
import com.fatscompany.service.AccountService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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
public class TeacherRepositoryImpl implements TeacherRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private AccountService accService;

    @Override
    public List<GiangVien> getGiangVien() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("GiangVien.findAll");

        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateTeacher(GiangVien gv) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (gv.getId() == null) {
                s.save(gv);
            } else {
                s.update(gv);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public GiangVien getTeacherById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(GiangVien.class, id);
    }
    
    public GiangVien getTeacherByAccountId(Account account) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(GiangVien.class, account.getId());
    }
    
    @Override
    public GiangVien getTeacherByAcc(Account account) {
        Session s = this.factory.getObject().getCurrentSession();

        if (account == null) {
            return null;
        }

        
        List<GiangVien> listGv = getGiangVien();
            
        for(int i=0; i < listGv.size(); i++){
            if(listGv.get(i).getAccountGVid().equals(account)){
               return listGv.get(i);}
        }
        
        return null;
    }
}
