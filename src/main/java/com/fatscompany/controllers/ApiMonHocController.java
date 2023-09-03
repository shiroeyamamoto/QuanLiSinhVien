/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.service.MonHocService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anhkh
 */
@RestController
@RequestMapping("/api")
public class ApiMonHocController {

    private MonHocService mhSer;

    @DeleteMapping("/deletemonhoc/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMonHoc(@PathVariable(value = "id") int id) {
        this.mhSer.deleteMonHoc(id);
    }

}
