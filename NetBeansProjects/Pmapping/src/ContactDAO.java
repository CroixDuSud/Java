
import java.sql.SQLException;
import java.util.Vector;
import utilitairesMG.divers.Colonne;
import utilitairesMG.jdbc.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afpa1800
 */
public class ContactDAO {
    
    //-------------------------------
    // Déclaration des variables
    //-------------------------------
    
    private JeuResultat resultats;
    private BaseDeDonnees base;
  
    
    //-------------------------------
    // Constructeur
    //-------------------------------
    
    public ContactDAO(BaseDeDonnees base)
    {
        this.base = base;
    }
    
    
    public void lire(Contact contact) throws SQLException
    {
        Vector ligneContact;
        String requete;
        
        requete = "SELECT * FROM CONTACT WHERE NUMERO = " + contact.getNumero();
        
        resultats = base.executeQuery(requete);
        

      
        ligneContact = (Vector) ((resultats.getLignes()).elementAt(0));
      
        contact.setNom((String) ligneContact.elementAt(1));
        contact.setAdresse((String) ligneContact.elementAt(2));
        contact.setCodePostal((String) ligneContact.elementAt(3));
        contact.setVille((String) ligneContact.elementAt(4));
        contact.setCodeSecteur((Integer) ligneContact.elementAt(5));
    }
    
    public void insererContact(Contact contact)
    {
        Vector ligneContact;
        String requete;
        
        requete = "INSERT INTO CONTACT"
                + "VALUES (contact.getNumero(), contact.getNom(),"
                + "contact.getAdresse(), contact.getCodePostal(),"
                + "contact.getVille(), contact.getCodeSecteur()";
        
        //ligneContact = (Vector)
    }
    
// --------------------------------------------------------------------------
// Liste des contacts
// --------------------------------------------------------------------------
    public Vector<Contact> lireListe() throws SQLException
    {
        Vector<Contact> listeContacts;
        Contact contact;

// --------------------------------------------------------------------------
// SELECT a executer
// --------------------------------------------------------------------------
        String select = "SELECT * FROM CONTACT";

        int nombreDeContacts;
        Vector ligneContact;
        int i;

        resultats = base.executeQuery(select);

        listeContacts = new Vector<Contact>();
        nombreDeContacts = (resultats.getLignes()).size();

        for (i = 0; i < nombreDeContacts; i++)
        {
            ligneContact = (Vector) ((resultats.getLignes()).elementAt(i));

            contact = new Contact();
            contact.setNumero((Integer) ligneContact.elementAt(0));
            contact.setNom((String) ligneContact.elementAt(1));
            contact.setAdresse((String) ligneContact.elementAt(2));
            contact.setCodePostal((String) ligneContact.elementAt(3));
            contact.setVille((String) ligneContact.elementAt(4));
            contact.setCodeSecteur((Integer) ligneContact.elementAt(5));
            listeContacts.addElement(contact);
        }

        return listeContacts;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table Contact
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return resultats.getColonnes();
    }
}
