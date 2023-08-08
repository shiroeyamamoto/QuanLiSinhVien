/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.service.AccountService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author khang
 */
@Controller
public class IndexController {
     
    @Autowired
    private AccountService accountService;
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("acc", this.accountService.getAccount(params));
        
        return "index";
    }
}
