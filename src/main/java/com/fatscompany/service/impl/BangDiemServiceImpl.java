/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.service.impl;

import com.fatscompany.pojo.BangDiem;
import com.fatscompany.pojo.OtherScore;
import com.fatscompany.repository.BangDiemRepository;
import com.fatscompany.service.BangDiemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khang
 */
@Service
public class BangDiemServiceImpl implements BangDiemService{

    @Autowired
    private BangDiemRepository bangDiemRepo;
    
    @Override
    public List<BangDiem> getBangDiem() {
        return this.bangDiemRepo.getBangDiem();
    }

    @Override
    public BangDiem getBangDiemForSinhVien(int monHocId, int sinhVienId) {
        return this.bangDiemRepo.getBangDiemForSinhVien(monHocId, sinhVienId);
    }

    @Override
    public BangDiem getBangDiemById(int id) {
        return this.bangDiemRepo.getBangDiemById(id);
    }

    @Override
    public List<OtherScore> getOrtherScoreByBangDiemId(int id) {
        return this.bangDiemRepo.getOrtherScoreByBangDiemId(id);
    }
    
    
}
