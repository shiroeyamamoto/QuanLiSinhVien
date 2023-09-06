   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.repository.impl;

import com.fatscompany.pojo.SinhVien;
import com.fatscompany.repository.StudentRepository;
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
public class StudentRepositoryImpl implements  StudentRepository{

    @Autowired
        private LocalSessionFactoryBean factory;
    
    @Override
    public List<SinhVien> getSinhVien() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("SinhVien.findAll");
        
        return q.getResultList();
    }
    
    public SinhVien getSinhVienById(int id) {
      
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(SinhVien.class, id);
   
    }
    
}
