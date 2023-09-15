/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.List;

/**
 *
 * @author anhkh
 */
public class BaiVietSTUComent {
    private int baiVietID;
    private String titleBaiViet;
    private String noiDungBaiViet;
    private int accountBaiVietID;
    private int accountCommentID;
    private List<String> CommentBaiViet;
    private String imageAccountComment;
    private String accountCommentName;
    private String accountAuthorName;
    public String getImageAccountComment() {
        return imageAccountComment;
    }

    public void setImageAccountComment(String imageAccountComment) {
        this.imageAccountComment = imageAccountComment;
    }

    public String getAccountCommentName() {
        return accountCommentName;
    }

    public void setAccountCommentName(String accountCommentName) {
        this.accountCommentName = accountCommentName;
    }

    public String getAccountAuthorName() {
        return accountAuthorName;
    }

    public void setAccountAuthorName(String accountAuthorName) {
        this.accountAuthorName = accountAuthorName;
    }

    public BaiVietSTUComent() {
    }

    public int getAccountCommentID() {
        return accountCommentID;
    }

    public void setAccountCommentID(int accountCommentID) {
        this.accountCommentID = accountCommentID;
    }

    
    public int getBaiVietID() {
        return baiVietID;
    }

    public void setBaiVietID(int baiVietID) {
        this.baiVietID = baiVietID;
    }

    public String getTitleBaiViet() {
        return titleBaiViet;
    }

    public void setTitleBaiViet(String titleBaiViet) {
        this.titleBaiViet = titleBaiViet;
    }

    public String getNoiDungBaiViet() {
        return noiDungBaiViet;
    }

    public void setNoiDungBaiViet(String noiDungBaiViet) {
        this.noiDungBaiViet = noiDungBaiViet;
    }

    public int getAccountBaiVietID() {
        return accountBaiVietID;
    }

    public void setAccountBaiVietID(int accountBaiVietID) {
        this.accountBaiVietID = accountBaiVietID;
    }

    public List<String> getCommentBaiViet() {
        return CommentBaiViet;
    }

    public void setCommentBaiViet(List<String> CommentBaiViet) {
        this.CommentBaiViet = CommentBaiViet;
    }
    
}
