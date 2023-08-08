/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.repository;

import java.util.List;

/**
 *
 * @author khang
 */
public interface StatsRepository {
    List<Object[]> infoGiangVien();
    List<Object[]> infoSinhVien();
    List<Object[]> traCuuDiem();
}
