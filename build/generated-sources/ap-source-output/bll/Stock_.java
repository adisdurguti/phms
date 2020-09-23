package bll;

import bll.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T18:56:08")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, String> stockName;
    public static volatile SingularAttribute<Stock, Integer> quantity;
    public static volatile SingularAttribute<Stock, Product> productID;
    public static volatile SingularAttribute<Stock, Integer> stockID;

}