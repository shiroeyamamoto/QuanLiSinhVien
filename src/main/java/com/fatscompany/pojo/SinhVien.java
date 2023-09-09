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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author khang
 */
@Entity
@Table(name = "sinh_vien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SinhVien.findAll", query = "SELECT s FROM SinhVien s"),
    @NamedQuery(name = "SinhVien.findById", query = "SELECT s FROM SinhVien s WHERE s.id = :id"),
    @NamedQuery(name = "SinhVien.findByFirstName", query = "SELECT s FROM SinhVien s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "SinhVien.findByLastName", query = "SELECT s FROM SinhVien s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "SinhVien.findByEmail", query = "SELECT s FROM SinhVien s WHERE s.email = :email")})
public class SinhVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhvienScoreid")
    @JsonIgnore
    private Set<BangDiem> bangDiemSet;
    @JoinColumn(name = "accountSV_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Account accountSVid;
    @JoinColumn(name = "lop_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Lop lopId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhvienHOCid")
    @JsonIgnore
    private Set<Hoc> hocSet;

    public SinhVien() {
    }

    public SinhVien(Integer id) {
        this.id = id;
    }

    public SinhVien(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Set<BangDiem> getBangDiemSet() {
        return bangDiemSet;
    }

    public void setBangDiemSet(Set<BangDiem> bangDiemSet) {
        this.bangDiemSet = bangDiemSet;
    }

    public Account getAccountSVid() {
        return accountSVid;
    }

    public void setAccountSVid(Account accountSVid) {
        this.accountSVid = accountSVid;
    }

    public Lop getLopId() {
        return lopId;
    }

    public void setLopId(Lop lopId) {
        this.lopId = lopId;
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
        if (!(object instanceof SinhVien)) {
            return false;
        }
        SinhVien other = (SinhVien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fatscompany.pojo.SinhVien[ id=" + id + " ]";
    }
    
}
