/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.service;

import com.fatscompany.pojo.BangDiem;
import com.fatscompany.pojo.OtherScore;
import java.util.List;

/**
 *
 * @author khang
 */
public interface BangDiemService {
    List<BangDiem> getBangDiem();
    
    public BangDiem getBangDiemForSinhVien(int monHocId, int sinhVienId);
    
    public BangDiem getBangDiemById(int id);
    
    public List<OtherScore> getOrtherScoreByBangDiemId(int id);
}
