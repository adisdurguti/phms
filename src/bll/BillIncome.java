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
@Table(name = "BillIncome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillIncome.findAll", query = "SELECT b FROM BillIncome b"),
    @NamedQuery(name = "BillIncome.findByBillIncomeID", query = "SELECT b FROM BillIncome b WHERE b.billIncomeID = :billIncomeID"),
    @NamedQuery(name = "BillIncome.findByTotal", query = "SELECT b FROM BillIncome b WHERE b.total = :total"),
    @NamedQuery(name = "BillIncome.findByBillIncomeDate", query = "SELECT b FROM BillIncome b WHERE b.billIncomeDate = :billIncomeDate"),
    @NamedQuery(name = "BillIncome.findByBillNumber", query = "SELECT b FROM BillIncome b WHERE b.billNumber = :billNumber")})
public class BillIncome implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "billIncomeID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer billIncomeID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @Column(name = "billIncomeDate")
    @Temporal(TemporalType.DATE)
    private Date billIncomeDate;
    @Basic(optional = false)
    @Column(name = "billNumber")
    private String billNumber;
    @JoinColumn(name = "perdoruesiID", referencedColumnName = "perdoruesiID")
    @ManyToOne(optional = false)
    private Perdoruesi perdoruesiID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billIncomeID")
    private Collection<BillIncomeDetails> billIncomeDetailsCollection;

    public BillIncome() {
    }

    public BillIncome(Integer billIncomeID) {
        this.billIncomeID = billIncomeID;
    }

    public BillIncome(Integer billIncomeID, BigDecimal total, Date billIncomeDate, String billNumber) {
        this.billIncomeID = billIncomeID;
        this.total = total;
        this.billIncomeDate = billIncomeDate;
        this.billNumber = billNumber;
    }

    public Integer getBillIncomeID() {
        return billIncomeID;
    }

    public void setBillIncomeID(Integer billIncomeID) {
        this.billIncomeID = billIncomeID;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getBillIncomeDate() {
        return billIncomeDate;
    }

    public void setBillIncomeDate(Date billIncomeDate) {
        this.billIncomeDate = billIncomeDate;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public Perdoruesi getPerdoruesiID() {
        return perdoruesiID;
    }

    public void setPerdoruesiID(Perdoruesi perdoruesiID) {
        this.perdoruesiID = perdoruesiID;
    }

    @XmlTransient
    public Collection<BillIncomeDetails> getBillIncomeDetailsCollection() {
        return billIncomeDetailsCollection;
    }

    public void setBillIncomeDetailsCollection(Collection<BillIncomeDetails> billIncomeDetailsCollection) {
        this.billIncomeDetailsCollection = billIncomeDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billIncomeID != null ? billIncomeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillIncome)) {
            return false;
        }
        BillIncome other = (BillIncome) object;
        if ((this.billIncomeID == null && other.billIncomeID != null) || (this.billIncomeID != null && !this.billIncomeID.equals(other.billIncomeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bll.BillIncome[ billIncomeID=" + billIncomeID + " ]";
    }
    
}
