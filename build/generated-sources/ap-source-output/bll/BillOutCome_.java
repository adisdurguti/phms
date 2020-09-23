package bll;

import bll.BillOutComeDetails;
import bll.Perdoruesi;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T18:56:08")
@StaticMetamodel(BillOutCome.class)
public class BillOutCome_ { 

    public static volatile SingularAttribute<BillOutCome, BigDecimal> total;
    public static volatile CollectionAttribute<BillOutCome, BillOutComeDetails> billOutComeDetailsCollection;
    public static volatile SingularAttribute<BillOutCome, String> billNumber;
    public static volatile SingularAttribute<BillOutCome, Date> billDate;
    public static volatile SingularAttribute<BillOutCome, Integer> billOutComeID;
    public static volatile SingularAttribute<BillOutCome, Perdoruesi> perdoruesiID;

}