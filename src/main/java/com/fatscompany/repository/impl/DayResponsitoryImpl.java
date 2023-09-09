/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.repository.impl;

import com.fatscompany.pojo.Day;
import com.fatscompany.pojo.GiangVien;
import com.fatscompany.repository.DayResponsitory;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class DayResponsitoryImpl implements DayResponsitory{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Day> getListDay() {
        Session s = this.factory.getObject().getCurrentSession();
        org.hibernate.query.Query q = s.createQuery("FROM Day");

        return q.getResultList();
    }
    
    @Override
    public List<Day> getDayByTea(GiangVien gv) {
        Session s = this.factory.getObject().getCurrentSession();

        if (gv == null) {
            return null;
        }
        
        List<Day> listDay = getListDay();
        
        List<Day> updateListDay = new ArrayList<>();
        for(int i=0; i < listDay.size(); i++){
            if(listDay.get(i).getGiangvienId().equals(gv)){
            updateListDay.add(listDay.get(i));
            }
        }
        
        if(updateListDay==null)
            return null;
        
        return updateListDay;
        //return updateListDay;
    }
    
}
