package bll;

import bll.BillIncome;
import bll.BillOutCome;
import bll.PerdoruesiReport;
import bll.Role;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T18:56:08")
@StaticMetamodel(Perdoruesi.class)
public class Perdoruesi_ { 

    public static volatile SingularAttribute<Perdoruesi, String> lastName;
    public static volatile SingularAttribute<Perdoruesi, String> email;
    public static volatile CollectionAttribute<Perdoruesi, BillIncome> billIncomeCollection;
    public static volatile SingularAttribute<Perdoruesi, String> name;
    public static volatile SingularAttribute<Perdoruesi, Character> gender;
    public static volatile SingularAttribute<Perdoruesi, String> userName;
    public static volatile CollectionAttribute<Perdoruesi, PerdoruesiReport> perdoruesiReportCollection;
    public static volatile SingularAttribute<Perdoruesi, Date> birthDate;
    public static volatile CollectionAttribute<Perdoruesi, BillOutCome> billOutComeCollection;
    public static volatile SingularAttribute<Perdoruesi, BigDecimal> salary;
    public static volatile SingularAttribute<Perdoruesi, Role> roleID;
    public static volatile SingularAttribute<Perdoruesi, String> password;
    public static volatile SingularAttribute<Perdoruesi, Integer> perdoruesiID;

}