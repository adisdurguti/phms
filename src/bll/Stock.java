/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adis Durguti
 */
@Entity
@Table(name = "Stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByStockID", query = "SELECT s FROM Stock s WHERE s.stockID = :stockID"),
    @NamedQuery(name = "Stock.findByStockName", query = "SELECT s FROM Stock s WHERE s.stockName = :stockName"),
    @NamedQuery(name = "Stock.findByQuantity", query = "SELECT s FROM Stock s WHERE s.quantity = :quantity")})
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "stockID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer stockID;
    @Basic(optional = false)
    @Column(name = "stockName")
    private String stockName;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    @ManyToOne
    private Product productID;

    public Stock() {
    }

    public Stock(Integer stockID) {
        this.stockID = stockID;
    }

    public Stock(Integer stockID, String stockName, int quantity) {
        this.stockID = stockID;
        this.stockName = stockName;
        this.quantity = quantity;
    }

    public Integer getStockID() {
        return stockID;
    }

    public void setStockID(Integer stockID) {
        this.stockID = stockID;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockID != null ? stockID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.stockID == null && other.stockID != null) || (this.stockID != null && !this.stockID.equals(other.stockID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return stockName +" - "+ quantity;
    }
    
}
