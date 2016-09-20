// ==========================================================================
// Classe ContactDAO                                   Application JTable5DAO
// ==========================================================================
package controleur;
import java.sql.SQLException;
import java.util.*;
import utilitairesMG.divers.*;
import utilitairesMG.jdbc.*;

public class ContactDAO
{
    
    private JeuResultat resultats;
    private BaseDeDonnees base;
    
    public ContactDAO(BaseDeDonnees base)
    {
        this.base = base;
    }
  
// -------------------------------------------------------------------------- 
// Creation de la liste des Contacts a afficher dans la JTable
// -------------------------------------------------------------------------- 
// Remarque : listeContacts est un vecteur d'objets Contact...
// -------------------------------------------------------------------------- 
   public Vector<Contact> getListe() throws SQLException
   {
      Vector<Contact> listeContacts = new Vector<Contact>();
      Contact contact;
      
      String requete = "SELECT * FROM CONTACT";
      
      int nbreContacts = (resultats.getLignes()).size();
      Vector ligneContact = null;
      
      resultats = base.executeQuery(requete);
      
      for(int i = 0; i < nbreContacts; i++)
      {
          ligneContact = (Vector) ((resultats.getLignes()).elementAt(i));
      }
      
      contact = new Contact();
      contact.setNumero((Integer) ligneContact.elementAt(0));
      contact.setNom((String) ligneContact.elementAt(1));
      contact.setAdresse((String) ligneContact.elementAt(2));
      contact.setCodePostal((String) ligneContact.elementAt(3));
      contact.setVille((String) ligneContact.elementAt(4));
      contact.setCodeSecteur((Integer) ligneContact.elementAt(5));
      listeContacts.addElement(contact);

      return listeContacts;
   }

// -------------------------------------------------------------------------- 
// Creation de la liste des colonnes a afficher dans la JTable
// -------------------------------------------------------------------------- 
   public Vector<Colonne> getListeColonnes()
   {
      return resultats.getColonnes();
   }
   

}
