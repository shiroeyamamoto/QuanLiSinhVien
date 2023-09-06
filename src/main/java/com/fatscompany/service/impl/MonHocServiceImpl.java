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
    public boolean updateMonHoc(int id, Map<String, String> params) {
        return this.monHocRepository.updateMonHoc( id,params);
    }
   

    @Override
    public MonHoc getMonHocById(int id) {
        return this.monHocRepository.getMonHocById(id);
    }

    @Override
    public boolean deleteMonHoc(int id) {
        return this.monHocRepository.deleteMonHoc(id);
    }

    @Override
    public boolean addMonHoc(MonHoc tc) {
        return this.monHocRepository.addMonHoc(tc);
    }

    @Override
    public boolean updateMonHoc(MonHoc tc) {
       return this.monHocRepository.updateMonHoc(tc);
    }

    @Override
    public List<MonHoc> getListMonHocNone() {
 return this.monHocRepository.getListMonHocNone();
    }
}
