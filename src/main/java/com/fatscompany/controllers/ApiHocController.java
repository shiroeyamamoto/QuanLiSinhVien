/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import DTO.StudentScoreDTO;
import com.fatscompany.pojo.BangDiem;
import com.fatscompany.pojo.Hoc;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.pojo.SinhVien;
import com.fatscompany.service.HocService;
import com.fatscompany.service.MonHocService;
import com.fatscompany.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anhkh
 */
@RestController
@RequestMapping("/api/studenScores")
@CrossOrigin
public class ApiHocController {
    
    @Autowired
    private HocService h;
    @Autowired
    StudentService stu;
    @Autowired
    MonHocService mh;
    
    @GetMapping("/hocs")
    
    public ResponseEntity<List<Hoc>> list() {
        return new ResponseEntity<>(this.h.getListHoc(), HttpStatus.OK);
    }
    
    @GetMapping("/StuHoc")
    
    public ResponseEntity<List<MonHoc>> listStuMonHoc() {
        return new ResponseEntity<>(this.h.getMonHocByStu(5), HttpStatus.OK);
    }
    
    @GetMapping("/listscore")
    
    public ResponseEntity<List<StudentScoreDTO>> listDiemMonHoc() {
        List<MonHoc> lmh = this.h.getMonHocByStu(5);
        List<BangDiem> danhSachDiem = this.h.getDiemBySinhVien(5, lmh);
        
        List<StudentScoreDTO> danhSachDTO = new ArrayList<>();
        
        for (BangDiem diem : danhSachDiem) {
            MonHoc mh = new MonHoc();
            mh = this.mh.getMonHocById(diem.getMonhocScoreid().getId());
            StudentScoreDTO dto = new StudentScoreDTO();
            dto.setStudentId(diem.getSinhvienScoreid().getId());
            dto.setSubjectCode(diem.getMonhocScoreid().getId());
            dto.setSubjectName(mh.getName());
            dto.setDiemGiuaki(diem.getDiemGiuaki());
            dto.setDiemCuoiKi(diem.getDiemCuoiki());
            danhSachDTO.add(dto);
        }

        // Trả về danh sách DTO dưới dạng JSON
        return ResponseEntity.ok(danhSachDTO);
    }
    
}
