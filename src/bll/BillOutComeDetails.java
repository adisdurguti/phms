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
@Table(name = "BillOutComeDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillOutComeDetails.findAll", query = "SELECT b FROM BillOutComeDetails b"),
    @NamedQuery(name = "BillOutComeDetails.findByBillOutComeDetailsID", query = "SELECT b FROM BillOutComeDetails b WHERE b.billOutComeDetailsID = :billOutComeDetailsID"),
    @NamedQuery(name = "BillOutComeDetails.findByQuantity", query = "SELECT b FROM BillOutComeDetails b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "BillOutComeDetails.findBySubtotal", query = "SELECT b FROM BillOutComeDetails b WHERE b.subtotal = :subtotal"),
    @NamedQuery(name = "BillOutComeDetails.findByBillDate", query = "SELECT b FROM BillOutComeDetails b WHERE b.billDate = :billDate"),
    @NamedQuery(name = "BillOutComeDetails.findByBillTime", query = "SELECT b FROM BillOutComeDetails b WHERE b.billTime = :billTime")})
public class BillOutComeDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "billOutComeDetailsID")
    private Integer billOutComeDetailsID;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Basic(optional = false)
    @Column(name = "billDate")
    @Temporal(TemporalType.DATE)
    private Date billDate;
    @Basic(optional = false)
    @Column(name = "billTime")
    @Temporal(TemporalType.TIME)
    private Date billTime;
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    @ManyToOne
    private Product productID;
    @JoinColumn(name = "billOutComeID", referencedColumnName = "billOutComeID")
    @ManyToOne(optional = false)
    private BillOutCome billOutComeID;

    public BillOutComeDetails() {
    }

    public BillOutComeDetails(Integer billOutComeDetailsID) {
        this.billOutComeDetailsID = billOutComeDetailsID;
    }

    public BillOutComeDetails(Integer billOutComeDetailsID, int quantity, BigDecimal subtotal, Date billDate, Date billTime) {
        this.billOutComeDetailsID = billOutComeDetailsID;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.billDate = billDate;
        this.billTime = billTime;
    }

    public Integer getBillOutComeDetailsID() {
        return billOutComeDetailsID;
    }

    public void setBillOutComeDetailsID(Integer billOutComeDetailsID) {
        this.billOutComeDetailsID = billOutComeDetailsID;
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

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public BillOutCome getBillOutComeID() {
        return billOutComeID;
    }

    public void setBillOutComeID(BillOutCome billOutComeID) {
        this.billOutComeID = billOutComeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billOutComeDetailsID != null ? billOutComeDetailsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillOutComeDetails)) {
            return false;
        }
        BillOutComeDetails other = (BillOutComeDetails) object;
        if ((this.billOutComeDetailsID == null && other.billOutComeDetailsID != null) || (this.billOutComeDetailsID != null && !this.billOutComeDetailsID.equals(other.billOutComeDetailsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bll.BillOutComeDetails[ billOutComeDetailsID=" + billOutComeDetailsID + " ]";
    }
    
}
