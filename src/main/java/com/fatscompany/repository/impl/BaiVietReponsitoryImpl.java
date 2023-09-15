/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.repository.impl;

import com.fatscompany.pojo.BaiViet;
import com.fatscompany.pojo.Comment;
import com.fatscompany.pojo.Hoc;
import com.fatscompany.repository.BaiVietRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anhkh
 */
@Repository
@Transactional
public class BaiVietReponsitoryImpl implements BaiVietRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<BaiViet> getListBaiViet() {
        Session s = this.factory.getObject().getCurrentSession();
        org.hibernate.query.Query q = s.createQuery("FROM BaiViet");

        return q.getResultList();
    }
    public BaiViet getBaiVietByid(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(BaiViet.class, id);
    }
    @Override
    public List<BaiViet> getListBaiVietByIDUser(int userId) {
        Session s = this.factory.getObject().getCurrentSession();
        String hql = "FROM BaiViet bv WHERE bv.accountBVid.id = :userId";
        Query<BaiViet> query = s.createQuery(hql, BaiViet.class);
        query.setParameter("userId", userId);

        List<BaiViet> danhSachBaiViet = query.getResultList();
        return danhSachBaiViet;
    }

@Override
public List<Comment> getCommentByBaiVietID(int baiVietId) {
    Session s = this.factory.getObject().getCurrentSession();
    String hql = "FROM Comment cm WHERE cm.baivietCMid.id = :baiVietId";
    Query<Comment> query = s.createQuery(hql, Comment.class);
    query.setParameter("baiVietId", baiVietId);

    List<Comment> danhSachComment = query.getResultList();
    return danhSachComment;
}


}
