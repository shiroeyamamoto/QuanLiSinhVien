/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.repository;

import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.GiangVien;
import java.util.List;

/**
 *
 * @author khang
 */
public interface TeacherRepository {
    List<GiangVien> getGiangVien();
    
    boolean addOrUpdateTeacher(GiangVien gv);
    
    public GiangVien getTeacherById(int id);
    
    public GiangVien getTeacherByAcc(Account account);
}
