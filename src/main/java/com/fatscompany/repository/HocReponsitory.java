/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.repository;

import com.fatscompany.pojo.Hoc;
import com.fatscompany.pojo.MonHoc;
import java.util.List;

/**
 *
 * @author anhkh
 */
public interface HocReponsitory {

    public List<Hoc> getListHoc();

    public List<MonHoc> getMonHocByStu(int sinhVienId);
}
