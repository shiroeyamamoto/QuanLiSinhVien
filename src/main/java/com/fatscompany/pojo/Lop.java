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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author khang
 */
@Entity
@Table(name = "lop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lop.findAll", query = "SELECT l FROM Lop l"),
    @NamedQuery(name = "Lop.findById", query = "SELECT l FROM Lop l WHERE l.id = :id"),
    @NamedQuery(name = "Lop.findByName", query = "SELECT l FROM Lop l WHERE l.name = :name"),
    @NamedQuery(name = "Lop.findBySoLuongSinhVien", query = "SELECT l FROM Lop l WHERE l.soLuongSinhVien = :soLuongSinhVien")})
public class Lop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_luong_sinh_vien")
    private int soLuongSinhVien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lopId")
    private Set<SinhVien> sinhVienSet;

    public Lop() {
    }

    public Lop(Integer id) {
        this.id = id;
    }

    public Lop(Integer id, String name, int soLuongSinhVien) {
        this.id = id;
        this.name = name;
        this.soLuongSinhVien = soLuongSinhVien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoLuongSinhVien() {
        return soLuongSinhVien;
    }

    public void setSoLuongSinhVien(int soLuongSinhVien) {
        this.soLuongSinhVien = soLuongSinhVien;
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
        if (!(object instanceof Lop)) {
            return false;
        }
        Lop other = (Lop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fatscompany.pojo.Lop[ id=" + id + " ]";
    }
    
}
