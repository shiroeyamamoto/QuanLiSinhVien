/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.service.impl;

import com.fatscompany.pojo.MonHoc;
import com.fatscompany.repository.MonhocResponsitory;
import com.fatscompany.service.MonHocService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anhkh
 */
@Service
public class MonHocServiceImpl implements MonHocService {

    @Autowired
    private MonhocResponsitory monHocRepository;

    @Override
    public List<MonHoc> getListMonHoc(Map<String, String> params) {

        return monHocRepository.getListMonHoc(params);
    }

    @Override
    public int countMonHoc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addOrUpdateMonHoc(MonHoc mh) {
        return this.monHocRepository.addOrUpdateMonHoc(mh);
    }

    @Override
    public MonHoc getMonHocById(int id) {
        return this.monHocRepository.getMonHocById(id);
    }

    @Override
    public boolean deleteMonHoc(int id) {
        return this.monHocRepository.deleteMonHoc(id);
    }
}