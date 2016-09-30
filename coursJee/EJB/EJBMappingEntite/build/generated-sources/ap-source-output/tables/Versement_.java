package tables;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Contact;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-23T16:14:40")
@StaticMetamodel(Versement.class)
public class Versement_ { 

    public static volatile SingularAttribute<Versement, Date> date;
    public static volatile SingularAttribute<Versement, Integer> numero;
    public static volatile SingularAttribute<Versement, Contact> numeroContact;
    public static volatile SingularAttribute<Versement, BigDecimal> montant;

}