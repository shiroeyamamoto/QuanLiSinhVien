/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.repository;

import com.fatscompany.pojo.Hoc;
import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.SinhVien;
import java.util.List;

/**
 *
 * @author khang
 */
public interface StudentRepository {
    List<SinhVien> getSinhVien();
    public SinhVien getSinhVienByAccountId(Account account);
    boolean addOrUpdateStudent(SinhVien sv);
    
    public SinhVien getSinhVienById(int id);
    
    public List<SinhVien> getListSinhVienByHocId(List<Hoc> id);
}
