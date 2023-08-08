/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author khang
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findById", query = "SELECT c FROM Comment c WHERE c.id = :id")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "noi_dung")
    private String noiDung;
    @JoinColumn(name = "accountCM_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountCMid;
    @JoinColumn(name = "baivietCM_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BaiViet baivietCMid;

    public Comment() {
    }

    public Comment(Integer id) {
        this.id = id;
    }

    public Comment(Integer id, String noiDung) {
        this.id = id;
        this.noiDung = noiDung;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Account getAccountCMid() {
        return accountCMid;
    }

    public void setAccountCMid(Account accountCMid) {
        this.accountCMid = accountCMid;
    }

    public BaiViet getBaivietCMid() {
        return baivietCMid;
    }

    public void setBaivietCMid(BaiViet baivietCMid) {
        this.baivietCMid = baivietCMid;
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
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fatscompany.pojo.Comment[ id=" + id + " ]";
    }
    
}
