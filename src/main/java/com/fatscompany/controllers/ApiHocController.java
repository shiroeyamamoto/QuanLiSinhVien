/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.pojo.Hoc;
import com.fatscompany.service.HocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anhkh
 */
@RestController
@RequestMapping("/api")
public class ApiHocController {
    @Autowired
    private HocService h;

    @GetMapping("/hocs")
    public ResponseEntity<List<Hoc>> list() {
        return new ResponseEntity<>(this.h.getListHoc(), HttpStatus.OK);
    }
}
    