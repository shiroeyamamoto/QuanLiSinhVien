/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.service;

import com.fatscompany.pojo.BaiViet;
import com.fatscompany.pojo.Comment;
import com.fatscompany.pojo.Hoc;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author anhkh
 */
public interface BaiVietService {
        public List<BaiViet> getListBaiViet();
    public BaiViet getBaiVietByid(int id) ;
       public List<Comment> getCommentByBaiVietID(int baiVietId);

    public List<BaiViet> getListBaiVietByIDUser(int userId);
}
