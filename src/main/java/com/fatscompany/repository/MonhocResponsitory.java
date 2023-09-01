/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.repository;

import com.fatscompany.pojo.MonHoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anhkh
 */
public interface MonhocResponsitory {
  
    List<MonHoc> getListMonHoc( Map<String, String> params);

    int countMonHoc();

    boolean addOrUpdateMonHoc(MonHoc mh);



    MonHoc getMonHocById(int id);

    boolean deleteMonHoc(int id);
}
