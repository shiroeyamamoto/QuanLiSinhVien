/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.repository;

import com.fatscompany.pojo.Account;

/**
 *
 * @author khang
 */
public interface UserRepository {
    Account getAccountByUsername(String username);
    
    boolean authUser(String username, String password);
}
