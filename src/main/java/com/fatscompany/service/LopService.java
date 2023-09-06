/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.service;

import com.fatscompany.pojo.Lop;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anhkh
 */
public interface LopService {
  public List<Lop> getListLop(Map<String, String> params) ;
      public boolean deleteLop(int id);
       public Lop getLopById(int id);
       public boolean addLop(Lop tc);
       public boolean updateLop(int id, Map<String, String> params);
        public boolean updateLop(Lop tc) ;
}
