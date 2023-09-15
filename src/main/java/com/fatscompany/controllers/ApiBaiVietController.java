/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.controllers;

import DTO.BaiVietSTUComent;
import com.fatscompany.pojo.BaiViet;
import com.fatscompany.pojo.Comment;
import com.fatscompany.service.AccountService;
import com.fatscompany.service.BaiVietService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anhkh
 */
@RestController
@RequestMapping("/api/baiviet")
@CrossOrigin
public class ApiBaiVietController {

    @Autowired
    BaiVietService bvs;

    @GetMapping("/lbaiviet")
    public ResponseEntity<List<BaiVietSTUComent>> list() {
        List<BaiVietSTUComent> baiVietSTUComents = new ArrayList<>();
        List<BaiViet> baiViets = this.bvs.getListBaiViet();
        for (BaiViet bv : baiViets) {
            BaiVietSTUComent baiVietSTUComent = new BaiVietSTUComent();
            baiVietSTUComent.setAccountAuthorName(bv.getAccountBVid().getUsername());
            baiVietSTUComent.setBaiVietID(bv.getId());
            baiVietSTUComent.setNoiDungBaiViet(bv.getNoiDung());
            baiVietSTUComent.setTitleBaiViet(bv.getTitle());
            List<Comment> comments = this.bvs.getCommentByBaiVietID(bv.getId());
            List<String> tempList = new ArrayList<>();
            for (Comment cm : comments) {

                tempList.add(cm.getNoiDung());
                baiVietSTUComent.setAccountCommentID(cm.getAccountCMid().getId());
                baiVietSTUComent.setAccountCommentName(cm.getAccountCMid().getAvatar());
                baiVietSTUComent.setImageAccountComment(cm.getAccountCMid().getAvatar());
            }
            baiVietSTUComent.setCommentBaiViet(tempList);
            baiVietSTUComents.add(baiVietSTUComent); // Thêm bài viết vào danh sách
        }
        return ResponseEntity.ok(baiVietSTUComents); // Trả về danh sách bài viết
    }

    @GetMapping("/lbaiviet/{id}")
    public ResponseEntity<BaiVietSTUComent> getBaiVietById(@PathVariable int id) {
        BaiViet bv = this.bvs.getBaiVietByid(id);

        if (bv == null) {
            // Trả về một ResponseEntity với HTTP status 404 Not Found nếu không tìm thấy bài viết
            return ResponseEntity.notFound().build();
        }

        BaiVietSTUComent baiVietSTUComent = new BaiVietSTUComent();
        baiVietSTUComent.setAccountBaiVietID(bv.getAccountBVid().getId());

        baiVietSTUComent.setAccountAuthorName(bv.getAccountBVid().getUsername());
        baiVietSTUComent.setBaiVietID(bv.getId());
        baiVietSTUComent.setNoiDungBaiViet(bv.getNoiDung());
        baiVietSTUComent.setTitleBaiViet(bv.getTitle());

        List<Comment> comments = this.bvs.getCommentByBaiVietID(bv.getId());
        List<String> tempList = new ArrayList<>();
        for (Comment cm : comments) {
            tempList.add(cm.getNoiDung());
            baiVietSTUComent.setAccountCommentID(cm.getAccountCMid().getId());
            baiVietSTUComent.setImageAccountComment(cm.getAccountCMid().getAvatar());
            baiVietSTUComent.setAccountCommentName(cm.getAccountCMid().getUsername());
        }
        baiVietSTUComent.setCommentBaiViet(tempList);

        // Trả về ResponseEntity với HTTP status 200 OK và thông tin bài viết cụ thể
        return ResponseEntity.ok(baiVietSTUComent);
    }

}
