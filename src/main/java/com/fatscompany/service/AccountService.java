/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.service;

import com.fatscompany.pojo.Account;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khang
 */
public interface AccountService {

    List<Account> getAccount(Map<String, String> params);

    List<Map<String, Object>> getAccountDetails(String keyword);

    boolean addOrUpdateAccount(Account acc);

    int countAccount();
}
