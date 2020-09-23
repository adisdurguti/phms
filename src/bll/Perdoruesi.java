/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adis Durguti
 */
@Entity
@Table(name = "Perdoruesi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perdoruesi.findAll", query = "SELECT p FROM Perdoruesi p"),
    @NamedQuery(name = "Perdoruesi.findByPerdoruesiID", query = "SELECT p FROM Perdoruesi p WHERE p.perdoruesiID = :perdoruesiID"),
    @NamedQuery(name = "Perdoruesi.findByUserName", query = "SELECT p FROM Perdoruesi p WHERE p.userName = :userName"),
    @NamedQuery(name = "Perdoruesi.findByPassword", query = "SELECT p FROM Perdoruesi p WHERE p.password = :password"),
    @NamedQuery(name = "Perdoruesi.findByName", query = "SELECT p FROM Perdoruesi p WHERE p.name = :name"),
    @NamedQuery(name = "Perdoruesi.findByLastName", query = "SELECT p FROM Perdoruesi p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Perdoruesi.findByEmail", query = "SELECT p FROM Perdoruesi p WHERE p.email = :email"),
    @NamedQuery(name = "Perdoruesi.findByGender", query = "SELECT p FROM Perdoruesi p WHERE p.gender = :gender"),
    @NamedQuery(name = "Perdoruesi.findByBirthDate", query = "SELECT p FROM Perdoruesi p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "Perdoruesi.findBySalary", query = "SELECT p FROM Perdoruesi p WHERE p.salary = :salary")})
public class Perdoruesi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "perdoruesiID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer perdoruesiID;
    @Basic(optional = false)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Gender")
    private Character gender;
    @Basic(optional = false)
    @Column(name = "BirthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Salary")
    private BigDecimal salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perdoruesiID")
    private Collection<BillOutCome> billOutComeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perdoruesiID")
    private Collection<BillIncome> billIncomeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perdoruesiID")
    private Collection<PerdoruesiReport> perdoruesiReportCollection;
    @JoinColumn(name = "roleID", referencedColumnName = "roleID")
    @ManyToOne(optional = false)
    private Role roleID;

    public Perdoruesi() {
    }

    public Perdoruesi(Integer perdoruesiID) {
        this.perdoruesiID = perdoruesiID;
    }

    public Perdoruesi(Integer perdoruesiID, String userName, String password, String name, String lastName, String email, Character gender, Date birthDate, BigDecimal salary) {
        this.perdoruesiID = perdoruesiID;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public Integer getPerdoruesiID() {
        return perdoruesiID;
    }

    public void setPerdoruesiID(Integer perdoruesiID) {
        this.perdoruesiID = perdoruesiID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @XmlTransient
    public Collection<BillOutCome> getBillOutComeCollection() {
        return billOutComeCollection;
    }

    public void setBillOutComeCollection(Collection<BillOutCome> billOutComeCollection) {
        this.billOutComeCollection = billOutComeCollection;
    }

    @XmlTransient
    public Collection<BillIncome> getBillIncomeCollection() {
        return billIncomeCollection;
    }

    public void setBillIncomeCollection(Collection<BillIncome> billIncomeCollection) {
        this.billIncomeCollection = billIncomeCollection;
    }

    @XmlTransient
    public Collection<PerdoruesiReport> getPerdoruesiReportCollection() {
        return perdoruesiReportCollection;
    }

    public void setPerdoruesiReportCollection(Collection<PerdoruesiReport> perdoruesiReportCollection) {
        this.perdoruesiReportCollection = perdoruesiReportCollection;
    }

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perdoruesiID != null ? perdoruesiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perdoruesi)) {
            return false;
        }
        Perdoruesi other = (Perdoruesi) object;
        if ((this.perdoruesiID == null && other.perdoruesiID != null) || (this.perdoruesiID != null && !this.perdoruesiID.equals(other.perdoruesiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bll.Perdoruesi[ perdoruesiID=" + perdoruesiID + " ]";
    }
    public String toString1(){
        return name + " " +lastName;
    }
}
