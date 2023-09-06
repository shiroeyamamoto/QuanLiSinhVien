/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.service.impl;

import com.fatscompany.pojo.Lop;
import com.fatscompany.repository.LopRepository;
import com.fatscompany.service.LopService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anhkh
 */
@Service
public class LopServieceImpl implements LopService {

    @Autowired
    private LopRepository lRep;

    @Override
    public List<Lop> getListLop(Map<String, String> params) {
        return this.lRep.getListLop(params);

    }

    @Override
    public boolean deleteLop(int id) {
        return this.lRep.deleteLop(id);
    }

    @Override
    public Lop getLopById(int id) {
        return this.lRep.getLopById(id);
    }

    @Override
    public boolean addLop(Lop tc) {
        return this.lRep.addLop(tc);
    }

    @Override
    public boolean updateLop(int id, Map<String, String> params) {
        return this.lRep.updateLop(id, params);
    }

    @Override
    public boolean updateLop(Lop tc) {
        return this.lRep.updateLop(tc);
    }

}
