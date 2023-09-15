/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.BangDiem;
import com.fatscompany.pojo.Hoc;
import com.fatscompany.pojo.OtherScore;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/bangdiem/{bangdiemId}/otherscore/")
    @CrossOrigin
    public ResponseEntity<List<OtherScore>> SinhVienBangDiemOther(
            @PathVariable(value = "bangdiemId") int bdId) {

        List<OtherScore> list = this.bangDiemService.getOrtherScoreByBangDiemId(bdId);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSinhVien(@RequestBody SinhVien sinhVienRequest) {
        try {
            // Gọi hàm tạo SinhVien từ SinhVienService
            SinhVien sinhVien = studentService.createSinhVien(
                    sinhVienRequest.getFirstName(),
                    sinhVienRequest.getLastName(),
                    sinhVienRequest.getEmail(),
                    sinhVienRequest.getUserNameAccount()
            );

            // Trả về SinhVien đã tạo thành công
            return new ResponseEntity<>(sinhVien, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Xử lý lỗi nếu email không hợp lệ hoặc trùng
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Xử lý lỗi khác (ví dụ: lỗi Hibernate)
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
