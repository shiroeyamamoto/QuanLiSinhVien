/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.pojo.Account;
import com.fatscompany.service.AccountService;
import com.fatscompany.service.StudentService;
import com.fatscompany.service.TeacherService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author khang
 */
@Controller
@PropertySource("classpath:configs.properties")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studenService;

    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("giangvien", this.teacherService.getGiangVien());
        model.addAttribute("sinhvien", this.studenService.getSinhVien());
    }

    @RequestMapping("/account")
    public String index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("acc", this.accountService.getAccount(params));
        int count = this.accountService.countAccount();
        int pageSize = Integer.parseInt(env.getProperty("PAGE_SIZE").toString());
        model.addAttribute("pages", Math.ceil(count * 1.0 / pageSize));
        return "account";
    }

    @GetMapping("/addAccount")
    public String list(Model model) {
        model.addAttribute("account", new Account());
        return "addAccount";
    }
    
    @PostMapping("/addAccount")
    public String add(@ModelAttribute(value = "account") @Valid Account acc,
            BindingResult rs){
        if (!rs.hasErrors())
            if(this.accountService.addOrUpdateAccount(acc)==true)
                return "redirect:/account";

        return "addAccount";
    }
}
