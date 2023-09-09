/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.repository;

import com.fatscompany.pojo.BangDiem;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.pojo.OtherScore;
import com.fatscompany.pojo.SinhVien;
import java.util.List;

/**
 *
 * @author khang
 */
public interface BangDiemRepository {
    
    List<BangDiem> getBangDiem();
    
    public BangDiem getBangDiemForSinhVien(int monHocId, int sinhVienId);
    
    public List<OtherScore> getOtherScore();
    
    public BangDiem getBangDiemById(int id);
    
    public List<OtherScore> getOrtherScoreByBangDiemId(int id);
    
}
