package tables;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tables.Secteur;
import tables.Versement;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-23T16:14:40")
@StaticMetamodel(Contact.class)
public class Contact_ { 

    public static volatile CollectionAttribute<Contact, Versement> versementCollection;
    public static volatile SingularAttribute<Contact, Secteur> codeSecteur;
    public static volatile SingularAttribute<Contact, String> ville;
    public static volatile SingularAttribute<Contact, Integer> numero;
    public static volatile SingularAttribute<Contact, String> adresse;
    public static volatile SingularAttribute<Contact, String> codePostal;
    public static volatile SingularAttribute<Contact, String> nom;

}