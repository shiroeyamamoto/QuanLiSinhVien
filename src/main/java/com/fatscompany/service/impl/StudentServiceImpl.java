/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.service.impl;

import com.fatscompany.pojo.SinhVien;
import com.fatscompany.repository.StudentRepository;
import com.fatscompany.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khang
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository StudentRepo;
    
    @Override
    public List<SinhVien> getSinhVien() {
        return this.StudentRepo.getSinhVien();
    }
    
}
