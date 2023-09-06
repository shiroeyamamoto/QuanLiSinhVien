/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.pojo.MonHoc;
import com.fatscompany.service.MonHocService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/monhocs")
    public ResponseEntity<List<MonHoc>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.mhSer.getListMonHoc(params), HttpStatus.OK);
    }

    @DeleteMapping("/monhoc/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMonHoc(@PathVariable(value = "id") int id) {
        this.mhSer.deleteMonHoc(id);
    }

}
