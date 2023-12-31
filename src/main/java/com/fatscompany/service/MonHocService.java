/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.service;

import com.fatscompany.pojo.Day;
import com.fatscompany.pojo.MonHoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anhkh
 */
public interface MonHocService {

     
    List<MonHoc> getListMonHoc(Map<String, String> params);
   List<MonHoc> getListMonHocNone();
    int countMonHoc();

  boolean addMonHoc(MonHoc tc);
   boolean updateMonHoc(int id, Map<String, String> params);

boolean updateMonHoc(MonHoc tc);

    MonHoc getMonHocById(int id);

    boolean deleteMonHoc(int id);
    
    public List<MonHoc> getListMonHocByListDay(List<Day> listDay);
}
