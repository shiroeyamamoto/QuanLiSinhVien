/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.formatters;

import com.fatscompany.pojo.Account;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author khang
 */
public class AccountFormatter implements Formatter<Account>{

    
    // đổ từ java ra template
    @Override
    public String print(Account acc, Locale locale) {
        return String.valueOf(acc.getId());
    }

    
    //Đổ tử template vào java
    @Override
    public Account parse(String accountId, Locale locale) throws ParseException {
        return new Account(Integer.parseInt(accountId));
    }
    
}
