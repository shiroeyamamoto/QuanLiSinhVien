/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.repository;

import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.SinhVien;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khang
 */
public interface AccountRepository {
    List<Account> getAccount(Map<String, String> params);
}
