/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.GiangVien;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean addOrUpdateAccount(Account acc) {
        try {
            if (acc.getAvatar() == "") {
                if (acc.getFile() != null) {
                    Map res = this.cloudinary.uploader().upload(acc.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                    acc.setAvatar(res.get("secure_url").toString());
                }
                if (acc.getAvatar() == null || acc.getAvatar() == "") {
                    acc.setAvatar("https://res.cloudinary.com/dfv13jmbq/image/upload/v1694010996/qyebfascjyrybwbq7a8i.png");
                }
            }

            String hashedPassword = passwordEncoder.encode(acc.getPassword());
            acc.setPassword(hashedPassword);
            acc.setRole("ROLE_" + acc.getRole());
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

    @Override
    public List<Account> selectAllAccount() {
        return this.accountRepository.selectAllAccount();
    }

    @Override
    public Account getAccountById(int id) {
        return this.accountRepository.getAccountById(id);
    }

    @Override
    public boolean deleteAccount(int id, List<GiangVien> gv, List<SinhVien> sv) {
        Account acc = this.accountRepository.getAccountById(id);

        for (int i = 0; i < gv.size(); i++) {
            if (gv.get(i).getAccountGVid().getId() == id) {
                gv.get(i).setAccountGVid(null);
            }
        }

        for (int i = 0; i < gv.size(); i++) {
            if (sv.get(i).getAccountSVid().getId() == id) {
                sv.get(i).setAccountSVid(null);
            }
        }

        return this.accountRepository.deleteAccount(id);
    }

    @Override
    public Account getAccountByUserCurrent(String userName) {
        return this.accountRepository.getAccountByUserCurrent(userName);

    }
}
