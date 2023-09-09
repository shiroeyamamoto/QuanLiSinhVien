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
@Table(name = "giang_vien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiangVien.findAll", query = "SELECT g FROM GiangVien g"),
    @NamedQuery(name = "GiangVien.findById", query = "SELECT g FROM GiangVien g WHERE g.id = :id"),
    @NamedQuery(name = "GiangVien.findByFirstName", query = "SELECT g FROM GiangVien g WHERE g.firstName = :firstName"),
    @NamedQuery(name = "GiangVien.findByLastName", query = "SELECT g FROM GiangVien g WHERE g.lastName = :lastName"),
    @NamedQuery(name = "GiangVien.findByEmail", query = "SELECT g FROM GiangVien g WHERE g.email = :email")})
public class GiangVien implements Serializable {

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
    @JoinColumn(name = "accountGV_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Account accountGVid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giangvienId")
    @JsonIgnore
    private Set<Day> daySet;

    public GiangVien() {
    }

    public GiangVien(Integer id) {
        this.id = id;
    }

    public GiangVien(Integer id, String firstName, String lastName, String email) {
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

    public Account getAccountGVid() {
        return accountGVid;
    }

    public void setAccountGVid(Account accountGVid) {
        this.accountGVid = accountGVid;
    }

    @XmlTransient
    public Set<Day> getDaySet() {
        return daySet;
    }

    public void setDaySet(Set<Day> daySet) {
        this.daySet = daySet;
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
        if (!(object instanceof GiangVien)) {
            return false;
        }
        GiangVien other = (GiangVien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fatscompany.pojo.GiangVien[ id=" + id + " ]";
    }
    
}
