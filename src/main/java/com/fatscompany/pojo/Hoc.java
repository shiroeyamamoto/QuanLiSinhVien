/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fatscompany.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author khang
 */
@Entity
@Table(name = "hoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoc.findAll", query = "SELECT h FROM Hoc h"),
    @NamedQuery(name = "Hoc.findById", query = "SELECT h FROM Hoc h WHERE h.id = :id"),
    @NamedQuery(name = "Hoc.findByRegisterDate", query = "SELECT h FROM Hoc h WHERE h.registerDate = :registerDate")})
public class Hoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "register_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    @JoinColumn(name = "monhocHOC_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
 
    private MonHoc monhocHOCid;
    
    @JoinColumn(name = "sinhvienHOC_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private SinhVien sinhvienHOCid;

    public Hoc() {
    }

    public Hoc(Integer id) {
        this.id = id;
    }

    public Hoc(Integer id, Date registerDate) {
        this.id = id;
        this.registerDate = registerDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public MonHoc getMonhocHOCid() {
        return monhocHOCid;
    }

    public void setMonhocHOCid(MonHoc monhocHOCid) {
        this.monhocHOCid = monhocHOCid;
    }

    public SinhVien getSinhvienHOCid() {
        return sinhvienHOCid;
    }

    public void setSinhvienHOCid(SinhVien sinhvienHOCid) {
        this.sinhvienHOCid = sinhvienHOCid;
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
        if (!(object instanceof Hoc)) {
            return false;
        }
        Hoc other = (Hoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fatscompany.pojo.Hoc[ id=" + id + " ]";
    }
    
}
