/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.service.AccountService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author khang
 */
@Controller
@PropertySource("classpath:configs.properties")
public class IndexController {
     
    @Autowired
    private AccountService accountService;
     @Autowired
    private Environment evr;
     @ModelAttribute
     void commonAtr(Model model) {
//         trong đây sẽ gắn nhắn thằng chung chẳng hạn danh mục
     }
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params){
        
        model.addAttribute("acc", this.accountService.getAccount(params));
        
        int count = this.accountService.countAccount();
        int pageSize = Integer.parseInt(evr.getProperty("PAGE_SIZE").toString());
        model.addAttribute("pages", Math.ceil(count*1.0/pageSize));
        return "index";
    }
    @GetMapping("/monhoc") 
    public String listMonHoc() {
        return "monhoc";
    }       
}
