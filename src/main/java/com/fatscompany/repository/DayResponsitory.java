/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.repository;

import com.fatscompany.pojo.Day;
import com.fatscompany.pojo.GiangVien;
import java.util.List;

/**
 *
 * @author khang
 */
public interface DayResponsitory {
    public List<Day> getListDay();
    
    public List<Day> getDayByTea(GiangVien gv);
}
