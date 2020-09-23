package bll;

import bll.BillIncomeDetails;
import bll.Perdoruesi;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T18:56:08")
@StaticMetamodel(BillIncome.class)
public class BillIncome_ { 

    public static volatile SingularAttribute<BillIncome, BigDecimal> total;
    public static volatile CollectionAttribute<BillIncome, BillIncomeDetails> billIncomeDetailsCollection;
    public static volatile SingularAttribute<BillIncome, String> billNumber;
    public static volatile SingularAttribute<BillIncome, Date> billIncomeDate;
    public static volatile SingularAttribute<BillIncome, Integer> billIncomeID;
    public static volatile SingularAttribute<BillIncome, Perdoruesi> perdoruesiID;

}