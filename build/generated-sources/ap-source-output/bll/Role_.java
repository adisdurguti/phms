package bll;

import bll.Perdoruesi;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T18:56:08")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, String> roleType;
    public static volatile CollectionAttribute<Role, Perdoruesi> perdoruesiCollection;
    public static volatile SingularAttribute<Role, Integer> roleID;

}