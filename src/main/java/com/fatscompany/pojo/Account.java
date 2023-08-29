/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author khang
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
    @NamedQuery(name = "Account.findByRole", query = "SELECT a FROM Account a WHERE a.role = :role"),
    @NamedQuery(name = "Account.findByAvatar", query = "SELECT a FROM Account a WHERE a.avatar = :avatar")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "avatar")
    private String avatar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountGVid")
    private Set<GiangVien> giangVienSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountBVid")
    private Set<BaiViet> baiVietSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountCMid")
    private Set<Comment> commentSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountSVid")
    private Set<SinhVien> sinhVienSet;
    // Đánh dấu đây là 1 trường bình thường, phải chi tôi biết em nó sớm hơn, thì tôi không khổ như thế này
    @Transient
    private MultipartFile file;

    // join table column 
//    private String giangVienFirstName;
//    private String giangVienLastName;
//    private String sinhVienFirstName;
//    private String sinhVienLastName;
//    private String giangVienEmail;
//    private String sinhVienEmail;

    public Account() {
    }

    public Account(Integer id) {
        this.id = id;
    }

    public Account(Integer id, String username, String password, String role, String avatar) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
    }

//    public Account(Integer id, String username, String password, String role, String avatar,
//            String giangVienFirstName, String giangVienLastName,
//            String sinhVienFirstName, String sinhVienLastName,
//            String giangVienEmail, String sinhVienEmail
//    ) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.role = role;
//        this.avatar = avatar;
//        this.giangVienFirstName = giangVienFirstName;
//        this.giangVienLastName = giangVienLastName;
//        this.sinhVienFirstName = sinhVienFirstName;
//        this.sinhVienLastName = sinhVienLastName;
//        this.giangVienEmail = giangVienEmail;
//        this.sinhVienEmail = sinhVienEmail;
//    }
//
//    public String getSinhVienEmail() {
//        return sinhVienEmail;
//    }
//
//    public void setSinhVienEmail(String sinhVienEmail) {
//        this.sinhVienEmail = sinhVienEmail;
//    }
//
//    public String getGiangVienEmail() {
//        return giangVienEmail;
//    }
//
//    public void setGiangVienEmail(String giangVienEmail) {
//        this.giangVienEmail = giangVienEmail;
//    }
//
//    public String getSinhVienLastName() {
//        return sinhVienLastName;
//    }
//
//    public void setSinhVienLastName(String sinhVienLastName) {
//        this.sinhVienLastName = sinhVienLastName;
//    }
//
//    public String getSinhVienFirstName() {
//        return sinhVienFirstName;
//    }
//
//    public void setSinhVienFirstName(String sinhVienFirstName) {
//        this.sinhVienFirstName = sinhVienFirstName;
//    }
//
//    public String getGiangVienLastName() {
//        return giangVienLastName;
//    }
//
//    public void setGiangVienLastName(String giangVienLastName) {
//        this.giangVienLastName = giangVienLastName;
//    }
//
//    public String getGiangVienFirstName() {
//        return giangVienFirstName;
//    }
//
//    public void setGiangVienFirstName(String giangVienFirstName) {
//        this.giangVienFirstName = giangVienFirstName;
//    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Set<GiangVien> getGiangVienSet() {
        return giangVienSet;
    }

    public void setGiangVienSet(Set<GiangVien> giangVienSet) {
        this.giangVienSet = giangVienSet;
    }

    @XmlTransient
    public Set<BaiViet> getBaiVietSet() {
        return baiVietSet;
    }

    public void setBaiVietSet(Set<BaiViet> baiVietSet) {
        this.baiVietSet = baiVietSet;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    @XmlTransient
    public Set<SinhVien> getSinhVienSet() {
        return sinhVienSet;
    }

    public void setSinhVienSet(Set<SinhVien> sinhVienSet) {
        this.sinhVienSet = sinhVienSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fatscompany.pojo.Account[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
