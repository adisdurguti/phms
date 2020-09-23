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
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductID", query = "SELECT p FROM Product p WHERE p.productID = :productID"),
    @NamedQuery(name = "Product.findByProductBarcode", query = "SELECT p FROM Product p WHERE p.productBarcode = :productBarcode"),
    @NamedQuery(name = "Product.findByProductSericNumber", query = "SELECT p FROM Product p WHERE p.productSericNumber = :productSericNumber"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByProductDosage", query = "SELECT p FROM Product p WHERE p.productDosage = :productDosage"),
    @NamedQuery(name = "Product.findByManufactoringDate", query = "SELECT p FROM Product p WHERE p.manufactoringDate = :manufactoringDate"),
    @NamedQuery(name = "Product.findByExpiringDate", query = "SELECT p FROM Product p WHERE p.expiringDate = :expiringDate"),
    @NamedQuery(name = "Product.findByProductSellPrice", query = "SELECT p FROM Product p WHERE p.productSellPrice = :productSellPrice"),
    @NamedQuery(name = "Product.findByProductBuyPrice", query = "SELECT p FROM Product p WHERE p.productBuyPrice = :productBuyPrice")})
public class Product implements Serializable {
    @Column(name = "isActive")
    private String isActive;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "productID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer productID;
    @Column(name = "productBarcode")
    private String productBarcode;
    @Column(name = "productSericNumber")
    private String productSericNumber;
    @Basic(optional = false)
    @Column(name = "productName")
    private String productName;
    @Column(name = "productDosage")
    private String productDosage;
    @Basic(optional = false)
    @Column(name = "manufactoringDate")
    @Temporal(TemporalType.DATE)
    private Date manufactoringDate;
    @Basic(optional = false)
    @Column(name = "expiringDate")
    @Temporal(TemporalType.DATE)
    private Date expiringDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "productSellPrice")
    private BigDecimal productSellPrice;
    @Basic(optional = false)
    @Column(name = "productBuyPrice")
    private BigDecimal productBuyPrice;
    @OneToMany(mappedBy = "productID")
    private Collection<BillOutComeDetails> billOutComeDetailsCollection;
    @OneToMany(mappedBy = "productID")
    private Collection<BillIncomeDetails> billIncomeDetailsCollection;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company companyID;
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
    @ManyToOne(optional = false)
    private Category categoryID;
    @OneToMany(mappedBy = "productID")
    private Collection<Stock> stockCollection;

    public Product() {
    }

    public Product(Integer productID) {
        this.productID = productID;
    }

    public Product(Integer productID, String productName, Date manufactoringDate, Date expiringDate, BigDecimal productSellPrice, BigDecimal productBuyPrice) {
        this.productID = productID;
        this.productName = productName;
        this.manufactoringDate = manufactoringDate;
        this.expiringDate = expiringDate;
        this.productSellPrice = productSellPrice;
        this.productBuyPrice = productBuyPrice;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public String getProductSericNumber() {
        return productSericNumber;
    }

    public void setProductSericNumber(String productSericNumber) {
        this.productSericNumber = productSericNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDosage() {
        return productDosage;
    }

    public void setProductDosage(String productDosage) {
        this.productDosage = productDosage;
    }

    public Date getManufactoringDate() {
        return manufactoringDate;
    }

    public void setManufactoringDate(Date manufactoringDate) {
        this.manufactoringDate = manufactoringDate;
    }

    public Date getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(Date expiringDate) {
        this.expiringDate = expiringDate;
    }

    public BigDecimal getProductSellPrice() {
        return productSellPrice;
    }

    public void setProductSellPrice(BigDecimal productSellPrice) {
        this.productSellPrice = productSellPrice;
    }

    public BigDecimal getProductBuyPrice() {
        return productBuyPrice;
    }

    public void setProductBuyPrice(BigDecimal productBuyPrice) {
        this.productBuyPrice = productBuyPrice;
    }

    @XmlTransient
    public Collection<BillOutComeDetails> getBillOutComeDetailsCollection() {
        return billOutComeDetailsCollection;
    }

    public void setBillOutComeDetailsCollection(Collection<BillOutComeDetails> billOutComeDetailsCollection) {
        this.billOutComeDetailsCollection = billOutComeDetailsCollection;
    }

    @XmlTransient
    public Collection<BillIncomeDetails> getBillIncomeDetailsCollection() {
        return billIncomeDetailsCollection;
    }

    public void setBillIncomeDetailsCollection(Collection<BillIncomeDetails> billIncomeDetailsCollection) {
        this.billIncomeDetailsCollection = billIncomeDetailsCollection;
    }

    public Company getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return productName+" "+categoryID.getCategoryType()+" "+productDosage;
    }
     public String toString1() {
        return productName+" "+categoryID.getCategoryType()+" "+productDosage;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
