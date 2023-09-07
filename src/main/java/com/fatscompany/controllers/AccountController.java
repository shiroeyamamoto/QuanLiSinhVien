/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.GiangVien;
import com.fatscompany.pojo.SinhVien;
import com.fatscompany.service.AccountService;
import com.fatscompany.service.StudentService;
import com.fatscompany.service.TeacherService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author khang
 */
@Controller
@PropertySource("classpath:configs.properties")
//@RequestMapping("/admin")
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
        model.addAttribute("selectAccount", this.accountService.selectAllAccount());
    }

    @RequestMapping("/account")
    //@PreAuthorize("hasRole('ADMIN')")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("acc", this.accountService.getAccount(params));
        int count = this.accountService.countAccount();
        int pageSize = Integer.parseInt(env.getProperty("PAGE_SIZE").toString());
        model.addAttribute("pages", Math.ceil(count * 1.0 / pageSize));
        return "account";
    }

    @GetMapping("/addAccount")
    public String accountAddMode(Model model) {
        model.addAttribute("account", new Account());
        return "addAccount";
    }
    
    @GetMapping("/addAccount/{id}")
    public String Update(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("account", this.accountService.getAccountById(id));
        return "addAccount";
    }
    
        //GiangVien gv = this.teacherService.getTeacherById(id);
        //gv.set
    @PostMapping("/addAccount")
    public String addAccount(@ModelAttribute(value = "account") @Valid Account acc,
            BindingResult rs){
        if (!rs.hasErrors())
            if(this.accountService.addOrUpdateAccount(acc)==true)
                return "redirect:/account";

        return "addAccount";
    }
    
    @GetMapping("/addTeacher")
    public String teacherAddMode(Model model) {
        model.addAttribute("addTea", new GiangVien());
        return "addTeacher";
    }
    
    @PostMapping("/addTeacher")
    public String addGiangVien(@ModelAttribute(value = "addTea") @Valid GiangVien gv,
            BindingResult rs){
        if (!rs.hasErrors())
            if(this.teacherService.addOrUpdateTeacher(gv)==true)
                return "redirect:/account";

        return "addTeacher";
    }
    
    @GetMapping("/addStudent")
    public String studentAddMode(Model model) {
        model.addAttribute("addStu", new SinhVien());
        return "addStudent";
    }
    
    @PostMapping("/addStudent")
    public String addSinhVien(@ModelAttribute(value = "addStu") @Valid SinhVien sv,
            BindingResult rs){
        if (!rs.hasErrors())
            if(this.studenService.addOrUpdateStudent(sv)==true)
                return "redirect:/account";

        return "addStudent";
    }
}
