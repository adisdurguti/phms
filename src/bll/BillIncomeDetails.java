/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adis Durguti
 */
@Entity
@Table(name = "BillIncomeDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillIncomeDetails.findAll", query = "SELECT b FROM BillIncomeDetails b"),
    @NamedQuery(name = "BillIncomeDetails.findByBillIncomeDetailsID", query = "SELECT b FROM BillIncomeDetails b WHERE b.billIncomeDetailsID = :billIncomeDetailsID"),
    @NamedQuery(name = "BillIncomeDetails.findByQuantity", query = "SELECT b FROM BillIncomeDetails b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "BillIncomeDetails.findBySubtotal", query = "SELECT b FROM BillIncomeDetails b WHERE b.subtotal = :subtotal"),
    @NamedQuery(name = "BillIncomeDetails.findByBillIncomeDate", query = "SELECT b FROM BillIncomeDetails b WHERE b.billIncomeDate = :billIncomeDate"),
    @NamedQuery(name = "BillIncomeDetails.findByBillIncomeTime", query = "SELECT b FROM BillIncomeDetails b WHERE b.billIncomeTime = :billIncomeTime")})
public class BillIncomeDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "billIncomeDetailsID")
    private Integer billIncomeDetailsID;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Basic(optional = false)
    @Column(name = "billIncomeDate")
    @Temporal(TemporalType.DATE)
    private Date billIncomeDate;
    @Basic(optional = false)
    @Column(name = "billIncomeTime")
    @Temporal(TemporalType.TIME)
    private Date billIncomeTime;
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    @ManyToOne
    private Product productID;
    @JoinColumn(name = "billIncomeID", referencedColumnName = "billIncomeID")
    @ManyToOne(optional = false)
    private BillIncome billIncomeID;

    public BillIncomeDetails() {
    }

    public BillIncomeDetails(Integer billIncomeDetailsID) {
        this.billIncomeDetailsID = billIncomeDetailsID;
    }

    public BillIncomeDetails(Integer billIncomeDetailsID, int quantity, BigDecimal subtotal, Date billIncomeDate, Date billIncomeTime) {
        this.billIncomeDetailsID = billIncomeDetailsID;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.billIncomeDate = billIncomeDate;
        this.billIncomeTime = billIncomeTime;
    }

    public Integer getBillIncomeDetailsID() {
        return billIncomeDetailsID;
    }

    public void setBillIncomeDetailsID(Integer billIncomeDetailsID) {
        this.billIncomeDetailsID = billIncomeDetailsID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Date getBillIncomeDate() {
        return billIncomeDate;
    }

    public void setBillIncomeDate(Date billIncomeDate) {
        this.billIncomeDate = billIncomeDate;
    }

    public Date getBillIncomeTime() {
        return billIncomeTime;
    }

    public void setBillIncomeTime(Date billIncomeTime) {
        this.billIncomeTime = billIncomeTime;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public BillIncome getBillIncomeID() {
        return billIncomeID;
    }

    public void setBillIncomeID(BillIncome billIncomeID) {
        this.billIncomeID = billIncomeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billIncomeDetailsID != null ? billIncomeDetailsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillIncomeDetails)) {
            return false;
        }
        BillIncomeDetails other = (BillIncomeDetails) object;
        if ((this.billIncomeDetailsID == null && other.billIncomeDetailsID != null) || (this.billIncomeDetailsID != null && !this.billIncomeDetailsID.equals(other.billIncomeDetailsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bll.BillIncomeDetails[ billIncomeDetailsID=" + billIncomeDetailsID + " ]";
    }
    
}
