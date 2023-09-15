/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fatscompany.repository;

import com.fatscompany.pojo.BaiViet;
import com.fatscompany.pojo.Comment;
import com.fatscompany.pojo.Hoc;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author anhkh
 */
public interface BaiVietRepository {

    public List<BaiViet> getListBaiViet();

    public List<Comment> getCommentByBaiVietID(int baiVietId);
    public BaiViet getBaiVietByid(int id) ;
    public List<BaiViet> getListBaiVietByIDUser(int userId);
}
