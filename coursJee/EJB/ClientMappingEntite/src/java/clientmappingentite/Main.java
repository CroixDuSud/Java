package clientmappingentite;


import java.util.Hashtable;
import java.util.Vector;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import objetDistant.MappingEntiteRemote;
import tables.*;

public class Main
{
    public static void main(String[] args) throws NamingException
    {
       Contact contact;

        Hashtable variablesEnv = new Hashtable();
        variablesEnv.put("org.omg.CORBA.ORBInitialHost", "localhost");
        variablesEnv.put("org.omg.CORBA.ORBInitialPort", "3700");

        Context ctx = new InitialContext(variablesEnv);
        MappingEntiteRemote baseMapping =
            (MappingEntiteRemote)ctx.lookup("jndiMappingEntite");

// ----------------------------------------------------------------------------
// Appel de quelques methodes de l'objet distant baseMapping...
// ----------------------------------------------------------------------------
// Lecture d'un contact, recherche de la liste de ses versements
// ----------------------------------------------------------------------------
        contact = baseMapping.lireContact(133);
        System.out.println(contact);

        if (contact != null)
        {
            Vector<Versement> listeVersements =
                    baseMapping.lireListeVersementsContact(contact);

            System.out.println("Liste des versements du contact " + contact.getNom()
                    + " :\n" + listeVersements + "\n\n");
        }
        else
        {
            System.out.println("Contact inconnu\n\n");
        }

// ----------------------------------------------------------------------------
// Creation d'un nouveau contact
// ----------------------------------------------------------------------------
/*
        contact = new Contact();
        contact.setNumero(333);

        contact.setNom("CRAPULE");
        contact.setVille("CRETEIL");
        contact.setAdresse("15, avenue du chat huant");
        contact.setCodePostal("75010");
        int retour = baseMapping.creerContact(contact);
        System.out.println("retour creer(1) = " + retour); 

// ----------------------------------------------------------------------------
// Le code retour == 2 indique que le contact existe en memoire et pas sur la
// base : le deuxieme appel de creeContact marchera car le refresh a vide le
// contact en memoire...
// ----------------------------------------------------------------------------
        if (retour == 2)
        {
            retour = baseMapping.creerContact(contact);
            System.out.println("retour creer(2) = " + retour);
        }
*/
// ----------------------------------------------------------------------------
// Destruction d'un contact
// ----------------------------------------------------------------------------
/*        
        contact = new Contact();
        contact.setNumero(666);

        int retour = baseMapping.detruireContact(contact);
        System.out.println("retour detruire(1) = " + retour);
*/  

// ----------------------------------------------------------------------------
// Quelques listes
// ----------------------------------------------------------------------------

        System.out.println("\n\nListe des colonnes de la table CONTACT : ");
        System.out.println(baseMapping.lireListeColonnes("tables.Contact"));
/*        
        System.out.println("\n\nListe des contacts : ");
        System.out.println(baseMapping.lireListeContacts());
        System.out.println("\nListe des contacts dont le nom contient la lettre U : ");
        System.out.println(baseMapping.lireListeContactsParNom("U"));

        System.out.println("\n\nListe des colonnes de la table VERSEMENT : ");
        System.out.println(baseMapping.lireListeColonnes(Versement.class));
*/ 
    }
}
