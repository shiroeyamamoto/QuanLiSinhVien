/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.service.impl;

import com.fatscompany.pojo.Day;
import com.fatscompany.repository.DayResponsitory;
import com.fatscompany.service.DayService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khang
 */
@Service
public class DayServiceImpl implements DayService{
    
    @Autowired
    private DayResponsitory dayRepo;

    @Override
    public List<Day> getListDay() {
        return this.dayRepo.getListDay();
    }
    
}
