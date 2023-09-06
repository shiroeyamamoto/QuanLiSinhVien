/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author khang
 */
@Entity
@Table(name = "mon_hoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonHoc.findAll", query = "SELECT m FROM MonHoc m"),
    @NamedQuery(name = "MonHoc.findById", query = "SELECT m FROM MonHoc m WHERE m.id = :id"),
    @NamedQuery(name = "MonHoc.findByName", query = "SELECT m FROM MonHoc m WHERE m.name = :name"),
    @NamedQuery(name = "MonHoc.findByTinChi", query = "SELECT m FROM MonHoc m WHERE m.tinChi = :tinChi")})
public class MonHoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)

    @Column(name = "name")

    @NotNull
    private String name;
    @Basic(optional = false)

    @Column(name = "tin_chi")

    @NotNull
    private int tinChi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monhocScoreid")
    @JsonIgnore
    private Set<BangDiem> bangDiemSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monhocId")
    @JsonIgnore
    private Set<Day> daySet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monhocHOCid")
    @JsonIgnore
    private Set<Hoc> hocSet;

    public MonHoc() {
    }

    public MonHoc(Integer id) {
        this.id = id;
    }

    public MonHoc(Integer id, String name, int tinChi) {
        this.id = id;
        this.name = name;
        this.tinChi = tinChi;
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

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }

    @XmlTransient
    public Set<BangDiem> getBangDiemSet() {
        return bangDiemSet;
    }

    public void setBangDiemSet(Set<BangDiem> bangDiemSet) {
        this.bangDiemSet = bangDiemSet;
    }

    @XmlTransient
    public Set<Day> getDaySet() {
        return daySet;
    }

    public void setDaySet(Set<Day> daySet) {
        this.daySet = daySet;
    }

    @XmlTransient
    public Set<Hoc> getHocSet() {
        return hocSet;
    }

    public void setHocSet(Set<Hoc> hocSet) {
        this.hocSet = hocSet;
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
        if (!(object instanceof MonHoc)) {
            return false;
        }
        MonHoc other = (MonHoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fatscompany.pojo.MonHoc[ id=" + id + " ]";
    }

}
