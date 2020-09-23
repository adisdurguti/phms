package bll;

import bll.BillIncome;
import bll.Product;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T18:56:08")
@StaticMetamodel(BillIncomeDetails.class)
public class BillIncomeDetails_ { 

    public static volatile SingularAttribute<BillIncomeDetails, Date> billIncomeDate;
    public static volatile SingularAttribute<BillIncomeDetails, Integer> quantity;
    public static volatile SingularAttribute<BillIncomeDetails, BillIncome> billIncomeID;
    public static volatile SingularAttribute<BillIncomeDetails, Integer> billIncomeDetailsID;
    public static volatile SingularAttribute<BillIncomeDetails, BigDecimal> subtotal;
    public static volatile SingularAttribute<BillIncomeDetails, Date> billIncomeTime;
    public static volatile SingularAttribute<BillIncomeDetails, Product> productID;

}