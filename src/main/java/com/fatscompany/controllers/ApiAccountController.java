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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author khang
 */
@RestController
@RequestMapping("/api")
public class ApiAccountController {
    
    @Autowired
    private AccountService accService;
    
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studenService;
    
    @GetMapping("/accounts")
    @CrossOrigin
    public ResponseEntity<List<Account>> list(){
        return new ResponseEntity<>(this.accService.selectAllAccount(),HttpStatus.OK);
    }
    
    @DeleteMapping("/addAccount/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id){
        List<GiangVien> gv = this.teacherService.getGiangVien();
        List<SinhVien> sv = this.studenService.getSinhVien();
        this.accService.deleteAccount(id, gv,sv);
    }
}
