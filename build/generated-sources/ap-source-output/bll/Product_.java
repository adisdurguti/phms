package bll;

import bll.BillIncomeDetails;
import bll.BillOutComeDetails;
import bll.Category;
import bll.Company;
import bll.Stock;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T18:56:08")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile CollectionAttribute<Product, BillOutComeDetails> billOutComeDetailsCollection;
    public static volatile SingularAttribute<Product, String> productSericNumber;
    public static volatile SingularAttribute<Product, Category> categoryID;
    public static volatile CollectionAttribute<Product, BillIncomeDetails> billIncomeDetailsCollection;
    public static volatile SingularAttribute<Product, Date> expiringDate;
    public static volatile SingularAttribute<Product, Integer> productID;
    public static volatile SingularAttribute<Product, String> isActive;
    public static volatile CollectionAttribute<Product, Stock> stockCollection;
    public static volatile SingularAttribute<Product, Date> manufactoringDate;
    public static volatile SingularAttribute<Product, String> productBarcode;
    public static volatile SingularAttribute<Product, BigDecimal> productSellPrice;
    public static volatile SingularAttribute<Product, String> productDosage;
    public static volatile SingularAttribute<Product, Company> companyID;
    public static volatile SingularAttribute<Product, BigDecimal> productBuyPrice;
    public static volatile SingularAttribute<Product, String> productName;

}