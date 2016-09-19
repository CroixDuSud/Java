// ==========================================================================
// Classe ModeleTableContact                              Application JTable4
// -------------------------------------------------------------------------- 
// Modele de table constitue a partir d'un vecteur de contacts.
// ==========================================================================

import java.util.*;
import utilitairesMG.divers.*;

public class ModeleTableContact extends ModeleTable
{

// -------------------------------------------------------------------------- 
// CONSTRUCTEUR
// -------------------------------------------------------------------------- 
// On transforme la liste d'objets 'Contact' en  lignes (Vector<Object>) pour
// alimenter le ModeleTable
// -------------------------------------------------------------------------- 
   public ModeleTableContact(Vector<Contact> listeContacts, 
                             Vector<Colonne> listeColonnes)
   {
      Vector<Vector<Object>>listeLignes = new Vector<Vector<Object>>();
      
      for (int i = 0; i < listeContacts.size(); i++)
      {
         Vector<Object> ligne = new Vector<Object>();
         Contact c = listeContacts.elementAt(i);
         
         ligne.addElement(c.getNumero());
         ligne.addElement(c.getNom());
         ligne.addElement(c.getAdresse());
         ligne.addElement(c.getCodePostal());
         ligne.addElement(c.getVille());
         ligne.addElement(c.getCodeSecteur());
         
         listeLignes.addElement(ligne);
      }
      
      setListeLignes(listeLignes);
      setListeColonnes(listeColonnes);
   }
   
// -------------------------------------------------------------------------- 
// Recuperation de la liste des 'Contact' a partir de la liste des lignes du
// ModeleTable
// -------------------------------------------------------------------------- 
   public Vector<Contact> getListeContacts()
   {
      Vector<Contact> listeContacts = new Vector<Contact>();
      Vector<Vector<Object>>listeLignes = getListeLignes();
      
      for (int i = 0; i < listeLignes.size(); i++)
      {
         Vector<Object> ligne = listeLignes.elementAt(i);
         Contact c = new Contact();
         
         c.setNumero((Integer)ligne.elementAt(0));
         c.setNom((String)ligne.elementAt(1));
         c.setAdresse((String)ligne.elementAt(2));
         c.setCodePostal((String)ligne.elementAt(3));
         c.setVille((String)ligne.elementAt(4));
         c.setCodeSecteur((Integer)ligne.elementAt(5));
         
         listeContacts.addElement(c);
      }
       
      return listeContacts;
   }
}

 