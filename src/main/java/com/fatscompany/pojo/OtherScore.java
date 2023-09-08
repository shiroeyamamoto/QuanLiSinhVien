/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author khang
 */
@Entity
@Table(name = "other_score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OtherScore.findAll", query = "SELECT o FROM OtherScore o"),
    @NamedQuery(name = "OtherScore.findById", query = "SELECT o FROM OtherScore o WHERE o.id = :id"),
    @NamedQuery(name = "OtherScore.findByDiem", query = "SELECT o FROM OtherScore o WHERE o.diem = :diem")})
public class OtherScore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "diem")
    private Float diem;
    @JoinColumn(name = "bangdiem_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BangDiem bangdiemId;

    public OtherScore() {
    }

    public OtherScore(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getDiem() {
        return diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }

    public BangDiem getBangdiemId() {
        return bangdiemId;
    }

    public void setBangdiemId(BangDiem bangdiemId) {
        this.bangdiemId = bangdiemId;
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
        if (!(object instanceof OtherScore)) {
            return false;
        }
        OtherScore other = (OtherScore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fatscompany.pojo.OtherScore[ id=" + id + " ]";
    }

}
