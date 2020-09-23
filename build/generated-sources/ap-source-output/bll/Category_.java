package bll;

import bll.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T18:56:08")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Integer> categoryID;
    public static volatile SingularAttribute<Category, String> categoryType;
    public static volatile CollectionAttribute<Category, Product> productCollection;

}