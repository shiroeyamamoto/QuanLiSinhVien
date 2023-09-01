/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.service.MonHocService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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

public class MonHocController {

    @Autowired
    private MonHocService monHocService;

    @RequestMapping("/monhoc")
    public String index(Model m, @RequestParam Map<String, String> params) {
        m.addAttribute("monhoc", this.monHocService.getListMonHoc(params));

        return "monhoc";
    }

    @GetMapping("/addorupdatemonhoc")
    public String addOrUpdateMonHoc(Model model) {
        MonHoc monHoc = new MonHoc();
        model.addAttribute("monhoc", monHoc);
        return "addorupdatemonhoc";
    }
       @GetMapping("/addorupdatemonhoc/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("monhoc", this.monHocService.getMonHocById(id));
        return "addorupdatemonhoc";
    }
    
    @PostMapping("/addorupdatemonhoc")
    public String add(@ModelAttribute(value = "monhoc") @Valid MonHoc mh,
            BindingResult rs) {
        
        if (!rs.hasErrors())
            if (this.monHocService.addOrUpdateMonHoc(mh) == true)
                return "redirect:/";

        return "monhoc";
    }

}
