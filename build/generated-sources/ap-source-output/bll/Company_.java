package bll;

import bll.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T18:56:08")
@StaticMetamodel(Company.class)
public class Company_ { 

    public static volatile SingularAttribute<Company, String> companyAddress;
    public static volatile SingularAttribute<Company, String> companyEmail;
    public static volatile SingularAttribute<Company, String> companyCountry;
    public static volatile SingularAttribute<Company, String> companyBussinesNumber;
    public static volatile SingularAttribute<Company, Integer> companyID;
    public static volatile CollectionAttribute<Company, Product> productCollection;
    public static volatile SingularAttribute<Company, String> companyName;
    public static volatile SingularAttribute<Company, String> companyContactNumber;

}