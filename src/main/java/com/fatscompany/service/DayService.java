/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.service;

import com.fatscompany.pojo.Day;
import com.fatscompany.pojo.GiangVien;
import java.util.List;

/**
 *
 * @author khang
 */
public interface DayService {
    public List<Day> getListDay();
    
    public List<Day> getDayByTea(GiangVien gv);
}
