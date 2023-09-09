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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author khang
 */
@Entity
@Table(name = "bang_diem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BangDiem.findAll", query = "SELECT b FROM BangDiem b"),
    @NamedQuery(name = "BangDiem.findById", query = "SELECT b FROM BangDiem b WHERE b.id = :id"),
    @NamedQuery(name = "BangDiem.findByDiemGiuaki", query = "SELECT b FROM BangDiem b WHERE b.diemGiuaki = :diemGiuaki"),
    @NamedQuery(name = "BangDiem.findByDiemCuoiki", query = "SELECT b FROM BangDiem b WHERE b.diemCuoiki = :diemCuoiki"),
    @NamedQuery(name = "BangDiem.findByStatus", query = "SELECT b FROM BangDiem b WHERE b.status = :status")})
public class BangDiem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diem_giuaki")
    private float diemGiuaki;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diem_cuoiki")
    private float diemCuoiki;
    @Column(name = "status")
    private Short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bangdiemId")
    @JsonIgnore
    private Set<OtherScore> otherScoreSet;
    @JoinColumn(name = "monhocScore_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private MonHoc monhocScoreid;
    @JoinColumn(name = "sinhvienScore_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private SinhVien sinhvienScoreid;

    public BangDiem() {
    }

    public BangDiem(Integer id) {
        this.id = id;
    }

    public BangDiem(Integer id, float diemGiuaki, float diemCuoiki) {
        this.id = id;
        this.diemGiuaki = diemGiuaki;
        this.diemCuoiki = diemCuoiki;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getDiemGiuaki() {
        return diemGiuaki;
    }

    public void setDiemGiuaki(float diemGiuaki) {
        this.diemGiuaki = diemGiuaki;
    }

    public float getDiemCuoiki() {
        return diemCuoiki;
    }

    public void setDiemCuoiki(float diemCuoiki) {
        this.diemCuoiki = diemCuoiki;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @XmlTransient
    public Set<OtherScore> getOtherScoreSet() {
        return otherScoreSet;
    }

    public void setOtherScoreSet(Set<OtherScore> otherScoreSet) {
        this.otherScoreSet = otherScoreSet;
    }

    public MonHoc getMonhocScoreid() {
        return monhocScoreid;
    }

    public void setMonhocScoreid(MonHoc monhocScoreid) {
        this.monhocScoreid = monhocScoreid;
    }

    public SinhVien getSinhvienScoreid() {
        return sinhvienScoreid;
    }

    public void setSinhvienScoreid(SinhVien sinhvienScoreid) {
        this.sinhvienScoreid = sinhvienScoreid;
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
        if (!(object instanceof BangDiem)) {
            return false;
        }
        BangDiem other = (BangDiem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fatscompany.pojo.BangDiem[ id=" + id + " ]";
    }
    
}
