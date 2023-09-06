/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.pojo.Lop;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.service.LopService;
import com.fatscompany.service.MonHocService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author anhkh
 */
@Controller
public class LopController {

    @Autowired
    private LopService lSv;

    @RequestMapping("/lop")
    public String index(Model m, @RequestParam Map<String, String> params) {
        m.addAttribute("lop", this.lSv.getListLop(params));
        return "lop";
    }

    @GetMapping("/addorupdatelop")
    public String add(Model model) {
        model.addAttribute("lop", new Lop());
        return "addorupdatelop";
    }

    @GetMapping("/addorupdatelop/{id}")
    public String add(Model model, @PathVariable("id") int id) {
        model.addAttribute("lop", this.lSv.getLopById(id));
        return "addorupdatelop";
    }

    @PostMapping("/addorupdatelop")
    public String addOrUpdateLop(@ModelAttribute(value = "lop") @Valid Lop lop, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (lop.getId() != null) {
                if (this.lSv.updateLop(lop)) {
                    return "redirect:/lop";
                }
            }
            if (this.lSv.addLop(lop) == true) {
                return "redirect:/lop";
            }
        }

        return "addorupdatemonhoc";
    }

    @DeleteMapping("/deletelop/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLop(@PathVariable("id") int id) {
        this.lSv.deleteLop(id);
    }
}
