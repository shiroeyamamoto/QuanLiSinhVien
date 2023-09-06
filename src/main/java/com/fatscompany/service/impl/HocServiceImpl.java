/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.service.impl;

import com.fatscompany.pojo.Hoc;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.repository.HocReponsitory;
import com.fatscompany.service.HocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author anhkh
 */
@Service
public class HocServiceImpl implements HocService {
    @Autowired
    private  HocReponsitory hocRepon;

    @Override
    public List<Hoc> getListHoc() {
        return this.hocRepon.getListHoc();
    }

    @Override
    public List<MonHoc> getMonHocByStu(int sinhVienId) {
        return this.hocRepon.getMonHocByStu(sinhVienId);
    }

    

}
