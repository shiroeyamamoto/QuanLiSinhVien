/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.service.impl;

import com.fatscompany.pojo.BaiViet;
import com.fatscompany.pojo.Comment;

import com.fatscompany.repository.BaiVietRepository;
import com.fatscompany.service.BaiVietService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anhkh
 */
@Service
public class BaiVietServiceImpl implements BaiVietService {

    @Autowired
    BaiVietRepository bv;

    @Override
    public List<BaiViet> getListBaiViet() {
        return this.bv.getListBaiViet();
    }

    @Override
    public List<BaiViet> getListBaiVietByIDUser(int userId) {
        return this.bv.getListBaiVietByIDUser(userId);
    }

    @Override
    public List<Comment> getCommentByBaiVietID(int baiVietId) {
        return this.bv.getCommentByBaiVietID(baiVietId);
    }

    @Override
    public BaiViet getBaiVietByid(int id) {
        return this.bv.getBaiVietByid(id);
    }

}
