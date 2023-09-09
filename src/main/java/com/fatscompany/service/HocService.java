/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.service;

import com.fatscompany.pojo.BangDiem;
import com.fatscompany.pojo.Hoc;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.pojo.OtherScore;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anhkh
 */
public interface HocService {

    public List<Hoc> getListHoc();

    public List<MonHoc> getMonHocByStu(int sinhVienId);

    public List<BangDiem> getDiemBySinhVien(int sinhVienId, List<MonHoc> danhSachMonHoc);
    
    public List<Hoc>  getHocByMonHocId(int id);
     public List<OtherScore> getListOScroceByBangDiem(int bangDiemid);
}
