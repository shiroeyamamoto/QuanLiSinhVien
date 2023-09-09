/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.pojo.BangDiem;
import com.fatscompany.pojo.Hoc;
import com.fatscompany.pojo.SinhVien;
import com.fatscompany.service.BangDiemService;
import com.fatscompany.service.HocService;
import com.fatscompany.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author khang
 */
@RestController
@RequestMapping("/api")
public class ApiSinhVienController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private HocService hocService;
    @Autowired
    private BangDiemService bangDiemService;

    @RequestMapping("/sinhviens/")
    @CrossOrigin
    public ResponseEntity<List<SinhVien>> listSv() {
        return new ResponseEntity<>(this.studentService.getSinhVien(), HttpStatus.OK);
    }

    @RequestMapping(path = "/sinhviens/{sinhvienId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<SinhVien> detailsSinhVien(@PathVariable(value = "sinhvienId") int id) {
        return new ResponseEntity<>(this.studentService.getSinhVienById(id), HttpStatus.OK);
    }

    @RequestMapping("/sinhviens/list-sinhvien-hoc-monhoc/{idMonHoc}/")
    @CrossOrigin
    public ResponseEntity<List<SinhVien>> listSinhVienByMonHoc(@PathVariable(value = "idMonHoc") int id) {

        List<Hoc> hoc = this.hocService.getHocByMonHocId(id);

        List<SinhVien> listSinhVien = this.studentService.getListSinhVienByHocId(hoc);

        return new ResponseEntity<>(listSinhVien, HttpStatus.OK);
    }

    @RequestMapping(path = "/sinhviens/list-sinhvien-hoc-monhoc/{monhocId}/sinhvien/{sinhvienId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<BangDiem> SinhVienBangDiem(
            @PathVariable(value = "monhocId") int mhId,
            @PathVariable(value = "sinhvienId") int svId) {

        BangDiem bangDiem = this.bangDiemService.getBangDiemForSinhVien(mhId, svId);

        return new ResponseEntity<>(bangDiem, HttpStatus.OK);
    }
}
