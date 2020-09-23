/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adis Durguti
 */
@Entity
@Table(name = "Company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByCompanyID", query = "SELECT c FROM Company c WHERE c.companyID = :companyID"),
    @NamedQuery(name = "Company.findByCompanyName", query = "SELECT c FROM Company c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "Company.findByCompanyBussinesNumber", query = "SELECT c FROM Company c WHERE c.companyBussinesNumber = :companyBussinesNumber"),
    @NamedQuery(name = "Company.findByCompanyEmail", query = "SELECT c FROM Company c WHERE c.companyEmail = :companyEmail"),
    @NamedQuery(name = "Company.findByCompanyContactNumber", query = "SELECT c FROM Company c WHERE c.companyContactNumber = :companyContactNumber"),
    @NamedQuery(name = "Company.findByCompanyCountry", query = "SELECT c FROM Company c WHERE c.companyCountry = :companyCountry"),
    @NamedQuery(name = "Company.findByCompanyAddress", query = "SELECT c FROM Company c WHERE c.companyAddress = :companyAddress")})
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "companyID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer companyID;
    @Basic(optional = false)
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "companyBussinesNumber")
    private String companyBussinesNumber;
    @Basic(optional = false)
    @Column(name = "companyEmail")
    private String companyEmail;
    @Basic(optional = false)
    @Column(name = "companyContactNumber")
    private String companyContactNumber;
    @Basic(optional = false)
    @Column(name = "companyCountry")
    private String companyCountry;
    @Basic(optional = false)
    @Column(name = "companyAddress")
    private String companyAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyID")
    private Collection<Product> productCollection;

    public Company() {
    }

    public Company(Integer companyID) {
        this.companyID = companyID;
    }

    public Company(Integer companyID, String companyName, String companyEmail, String companyContactNumber, String companyCountry, String companyAddress) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyContactNumber = companyContactNumber;
        this.companyCountry = companyCountry;
        this.companyAddress = companyAddress;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyBussinesNumber() {
        return companyBussinesNumber;
    }

    public void setCompanyBussinesNumber(String companyBussinesNumber) {
        this.companyBussinesNumber = companyBussinesNumber;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyContactNumber() {
        return companyContactNumber;
    }

    public void setCompanyContactNumber(String companyContactNumber) {
        this.companyContactNumber = companyContactNumber;
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    public void setCompanyCountry(String companyCountry) {
        this.companyCountry = companyCountry;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyID != null ? companyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyID == null && other.companyID != null) || (this.companyID != null && !this.companyID.equals(other.companyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return companyName;
    }
    
}
