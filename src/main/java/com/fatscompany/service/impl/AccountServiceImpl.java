/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.SinhVien;
import com.fatscompany.repository.AccountRepository;
import com.fatscompany.service.AccountService;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khang
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Account> getAccount(Map<String, String> params) {
        return this.accountRepository.getAccount(params);
    }

    @Override
    public boolean addOrUpdateAccount(Account acc) {
        try {
            Map res = this.cloudinary.uploader().upload(acc.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            acc.setAvatar(res.get("secure_url").toString());

            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hashBytes = md.digest(acc.getPassword().getBytes());

                StringBuilder hashBuilder = new StringBuilder();
                for (byte b : hashBytes) {
                    hashBuilder.append(String.format("%02x", b));
                }

                acc.setPassword(hashBuilder.toString());
            } catch (NoSuchAlgorithmException e) {
                // Xử lý ngoại lệ nếu thuật toán không hỗ trợ
                e.printStackTrace();
                return false; 
            }
        } catch (IOException ex) {
            Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.accountRepository.addOrUpdateAccount(acc);
    }

    @Override
    public int countAccount() {
        return this.accountRepository.countAccount();
    }

    @Override
    public List<Map<String, Object>> getAccountDetails(String keyword) {
        return this.accountRepository.getAccountDetails(keyword);
    }

}
