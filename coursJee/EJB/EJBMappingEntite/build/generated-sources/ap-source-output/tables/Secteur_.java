package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Contact;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-23T16:14:40")
@StaticMetamodel(Secteur.class)
public class Secteur_ { 

    public static volatile SingularAttribute<Secteur, Integer> code;
    public static volatile CollectionAttribute<Secteur, Contact> contactCollection;
    public static volatile SingularAttribute<Secteur, String> libelle;

}