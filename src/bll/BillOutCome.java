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
@Table(name = "BillOutCome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillOutCome.findAll", query = "SELECT b FROM BillOutCome b"),
    @NamedQuery(name = "BillOutCome.findByBillOutComeID", query = "SELECT b FROM BillOutCome b WHERE b.billOutComeID = :billOutComeID"),
    @NamedQuery(name = "BillOutCome.findByTotal", query = "SELECT b FROM BillOutCome b WHERE b.total = :total"),
    @NamedQuery(name = "BillOutCome.findByBillDate", query = "SELECT b FROM BillOutCome b WHERE b.billDate = :billDate"),
    @NamedQuery(name = "BillOutCome.findByBillNumber", query = "SELECT b FROM BillOutCome b WHERE b.billNumber = :billNumber")})
public class BillOutCome implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "billOutComeID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer billOutComeID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @Column(name = "billDate")
    @Temporal(TemporalType.DATE)
    private Date billDate;
    @Basic(optional = false)
    @Column(name = "billNumber")
    private String billNumber;
    @JoinColumn(name = "perdoruesiID", referencedColumnName = "perdoruesiID")
    @ManyToOne(optional = false)
    private Perdoruesi perdoruesiID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billOutComeID")
    private Collection<BillOutComeDetails> billOutComeDetailsCollection;

    public BillOutCome() {
    }

    public BillOutCome(Integer billOutComeID) {
        this.billOutComeID = billOutComeID;
    }

    public BillOutCome(Integer billOutComeID, BigDecimal total, Date billDate, String billNumber) {
        this.billOutComeID = billOutComeID;
        this.total = total;
        this.billDate = billDate;
        this.billNumber = billNumber;
    }

    public Integer getBillOutComeID() {
        return billOutComeID;
    }

    public void setBillOutComeID(Integer billOutComeID) {
        this.billOutComeID = billOutComeID;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
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
    public Collection<BillOutComeDetails> getBillOutComeDetailsCollection() {
        return billOutComeDetailsCollection;
    }

    public void setBillOutComeDetailsCollection(Collection<BillOutComeDetails> billOutComeDetailsCollection) {
        this.billOutComeDetailsCollection = billOutComeDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billOutComeID != null ? billOutComeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillOutCome)) {
            return false;
        }
        BillOutCome other = (BillOutCome) object;
        if ((this.billOutComeID == null && other.billOutComeID != null) || (this.billOutComeID != null && !this.billOutComeID.equals(other.billOutComeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bll.BillOutCome[ billOutComeID=" + billOutComeID + " ]";
    }
    
}
