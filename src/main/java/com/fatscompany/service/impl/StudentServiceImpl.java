/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.service.impl;

import com.fatscompany.pojo.Hoc;
import com.fatscompany.pojo.Account;
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
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository StudentRepo;

    @Override
    public List<SinhVien> getSinhVien() {
        return this.StudentRepo.getSinhVien();
    }

    @Override
    public boolean addOrUpdateStudent(SinhVien sv) {
        return this.StudentRepo.addOrUpdateStudent(sv);
    }

    @Override
    public SinhVien getSinhVienById(int id) {
        return this.StudentRepo.getSinhVienById(id);
    }

    @Override
    public List<SinhVien> getListSinhVienByHocId(List<Hoc> hoc) {
        return this.StudentRepo.getListSinhVienByHocId(hoc);
    }

    public SinhVien getSinhVienByAccountId(Account account) {
        return this.StudentRepo.getSinhVienByAccountId(account);
    }

    @Override
    public SinhVien createSinhVien(String firstName, String lastName, String email, String userNameAccount) {
        return this.StudentRepo.createSinhVien(firstName, lastName, email, userNameAccount);
    }

}
