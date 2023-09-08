/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.service.impl;

import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.GiangVien;
import com.fatscompany.repository.TeacherRepository;
import com.fatscompany.service.TeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khang
 */
@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;
    
    @Override
    public List<GiangVien> getGiangVien() {
        return this.teacherRepository.getGiangVien();
    }

    @Override
    public boolean addOrUpdateTeacher(GiangVien gv) {
        return this.teacherRepository.addOrUpdateTeacher(gv);
    }

    @Override
    public GiangVien getTeacherById(int id) {
        return this.teacherRepository.getTeacherById(id);
    }

    @Override
    public GiangVien getTeacherByAcc(Account account) {
        return this.teacherRepository.getTeacherByAcc(account);
    }
    
}
