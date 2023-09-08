/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "day")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Day.findAll", query = "SELECT d FROM Day d"),
    @NamedQuery(name = "Day.findById", query = "SELECT d FROM Day d WHERE d.id = :id")})
public class Day implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "giangvien_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private GiangVien giangvienId;
    @JoinColumn(name = "monhoc_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private MonHoc monhocId;

    public Day() {
    }

    public Day(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GiangVien getGiangvienId() {
        return giangvienId;
    }

    public void setGiangvienId(GiangVien giangvienId) {
        this.giangvienId = giangvienId;
    }

    public MonHoc getMonhocId() {
        return monhocId;
    }

    public void setMonhocId(MonHoc monhocId) {
        this.monhocId = monhocId;
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
        if (!(object instanceof Day)) {
            return false;
        }
        Day other = (Day) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fatscompany.pojo.Day[ id=" + id + " ]";
    }
    
}
