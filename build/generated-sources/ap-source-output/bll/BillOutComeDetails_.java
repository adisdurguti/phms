package bll;

import bll.BillOutCome;
import bll.Product;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T18:56:08")
@StaticMetamodel(BillOutComeDetails.class)
public class BillOutComeDetails_ { 

    public static volatile SingularAttribute<BillOutComeDetails, Date> billTime;
    public static volatile SingularAttribute<BillOutComeDetails, Integer> billOutComeDetailsID;
    public static volatile SingularAttribute<BillOutComeDetails, Date> billDate;
    public static volatile SingularAttribute<BillOutComeDetails, Integer> quantity;
    public static volatile SingularAttribute<BillOutComeDetails, BigDecimal> subtotal;
    public static volatile SingularAttribute<BillOutComeDetails, Product> productID;
    public static volatile SingularAttribute<BillOutComeDetails, BillOutCome> billOutComeID;

}