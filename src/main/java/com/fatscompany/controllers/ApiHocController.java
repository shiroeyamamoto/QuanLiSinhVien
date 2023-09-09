/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import DTO.StudentScoreDTO;
import com.fatscompany.pojo.Account;
import com.fatscompany.pojo.BangDiem;
import com.fatscompany.pojo.Hoc;
import com.fatscompany.pojo.MonHoc;
import com.fatscompany.pojo.OtherScore;
import com.fatscompany.pojo.SinhVien;
import com.fatscompany.service.AccountService;
import com.fatscompany.service.HocService;
import com.fatscompany.service.MonHocService;
import com.fatscompany.service.StudentService;
import com.sun.net.httpserver.HttpsConfigurator;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author anhkh
 */
@RestController
@RequestMapping("/api/studenScores")
@CrossOrigin(origins = "http://localhost:3000")
public class ApiHocController {

    @Autowired
    private HocService h;
    @Autowired
    StudentService stu;
    @Autowired
    AccountService asv;
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
    public ResponseEntity<List<StudentScoreDTO>> listDiemMonHoc(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            Principal user = request.getUserPrincipal();
            Account account = this.asv.getAccountByUserCurrent(user.getName());
            SinhVien sv = this.stu.getSinhVienByAccountId(account);

            List<MonHoc> lmh = this.h.getMonHocByStu(sv.getId());
            List<BangDiem> danhSachDiem = this.h.getDiemBySinhVien(sv.getId(), lmh);

            if (danhSachDiem != null && !danhSachDiem.isEmpty()) {
                List<StudentScoreDTO> danhSachDTO = new ArrayList<>();

                for (BangDiem diem : danhSachDiem) {
                    MonHoc mh = new MonHoc();
                    mh = this.mh.getMonHocById(diem.getMonhocScoreid().getId());
                    List<OtherScore> otherScores = this.h.getListOScroceByBangDiem(diem.getId());
                    List<Float> flList = new ArrayList<>();
                    StudentScoreDTO dto = new StudentScoreDTO();
                    dto.setBangDiemid(diem.getId());
                    dto.setStudentId(diem.getSinhvienScoreid().getId());
                    dto.setSubjectCode(diem.getMonhocScoreid().getId());
                    dto.setSubjectName(mh.getName());
                    for (OtherScore os : otherScores) {
                        flList.add(os.getDiem());
                    }
                    dto.setOtherScore(flList);
                    dto.setDiemGiuaki(diem.getDiemGiuaki());
                    dto.setDiemCuoiKi(diem.getDiemCuoiki());
                    danhSachDTO.add(dto);
                }

           
                return ResponseEntity.ok(danhSachDTO);
            } else {
                
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }

       
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

