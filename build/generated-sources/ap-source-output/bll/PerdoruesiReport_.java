package bll;

import bll.Perdoruesi;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-20T18:56:08")
@StaticMetamodel(PerdoruesiReport.class)
public class PerdoruesiReport_ { 

    public static volatile SingularAttribute<PerdoruesiReport, Date> time;
    public static volatile SingularAttribute<PerdoruesiReport, String> status;
    public static volatile SingularAttribute<PerdoruesiReport, Date> date;
    public static volatile SingularAttribute<PerdoruesiReport, Integer> reportID;
    public static volatile SingularAttribute<PerdoruesiReport, Perdoruesi> perdoruesiID;

}