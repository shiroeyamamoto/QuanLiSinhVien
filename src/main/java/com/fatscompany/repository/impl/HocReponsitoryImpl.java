package com.fatscompany.repository.impl;
import com.fatscompany.pojo.Hoc;
import com.fatscompany.repository.HocReponsitory;
import java.util.List;


import org.hibernate.Session;


import org.springframework.stereotype.Repository;


import java.util.List;
import org.hibernate.Session;
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
}
