/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.Day;
import com.fatscompany.pojo.GiangVien;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.service.AccountService;
import com.fatscompany.service.DayService;
import com.fatscompany.service.MonHocService;
import com.fatscompany.service.TeacherService;
import com.fatscompany.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anhkh
 */
@RestController
@RequestMapping("/api")
public class ApiMonHocController {

    @Autowired
    private MonHocService mhSer;
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private DayService dayService;

    @CrossOrigin
    @RequestMapping("/monhocs/")
    public ResponseEntity<List<MonHoc>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.mhSer.getListMonHoc(params), HttpStatus.OK);
    }

    @DeleteMapping("/monhoc/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMonHoc(@PathVariable(value = "id") int id) {
        this.mhSer.deleteMonHoc(id);
    }

    @CrossOrigin
    @RequestMapping(path = "/monhocs/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MonHoc> listDetails(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.mhSer.getMonHocById(id), HttpStatus.OK);
    }
    
    
    @GetMapping(path = "/monhoc-giangvien/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<List<MonHoc>> listMonhocTeacher(Principal user) {
        Account u = this.userService.getUserByUn(user.getName());
        
        GiangVien gv = this.teacherService.getTeacherByAcc(u);
        
        List<Day> listDay = this.dayService.getDayByTea(gv);
        
        List<MonHoc> listMonHoc = this.mhSer.getListMonHocByListDay(listDay);
        
        return new ResponseEntity<>(listMonHoc, HttpStatus.OK);
    }
}
