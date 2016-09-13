// ==========================================================================
// Classe JTable5                                         Application JTable5
// -------------------------------------------------------------------------- 
// La JTable est remplie avec un vecteur d'objets Contact. Elle utilise un
// modele de table ET un modele de colonne.
// ==========================================================================

import java.util.*;
import utilitairesMG.graphique.*;
import utilitairesMG.divers.*;

public class JTable5
{
   
// -------------------------------------------------------------------------- 
// Programme principal de l'application
// -------------------------------------------------------------------------- 
   public static void main(String args[])
   {
      Fenetre fenetre;
      
      Vector<Colonne> listeColonnes;
      Vector<Contact> listeContacts;
      
// -------------------------------------------------------------------------- 
// Creation des vecteurs des donnees a afficher.
// -------------------------------------------------------------------------- 
      listeContacts = getListeContacts();
      listeColonnes = getListeColonnes();

// -------------------------------------------------------------------------- 
// Affichage de la fenetre.
// -------------------------------------------------------------------------- 
      LF.setLF();
      fenetre = new Fenetre("JTable5", listeContacts, listeColonnes);
   }
  
// -------------------------------------------------------------------------- 
// Creation de la liste des Contacts a afficher dans la JTable
// -------------------------------------------------------------------------- 
// Remarque : listeContacts est un vecteur d'objets Contact...
// -------------------------------------------------------------------------- 
   public static Vector<Contact> getListeContacts()
   {
      Vector<Contact> listeContacts = new Vector<Contact>();
      Contact contact;
      
      contact = new Contact();
      contact.setNumero(100);
      contact.setNom("GINESTE");
      contact.setAdresse("Rue Barbe");
      contact.setCodePostal("94000");
      contact.setVille("CRETEIL");
      contact.setCodeSecteur(1);

      listeContacts.addElement(contact); 
      
      contact = new Contact();
      contact.setNumero(101);
      contact.setNom("GIROUD");
      contact.setAdresse("Avenue du Merdier");
      contact.setCodePostal("94100");
      contact.setVille("SAINT MAUR");
      contact.setCodeSecteur(3);

      listeContacts.addElement(contact); 

      contact = new Contact();
      contact.setNumero(112);
      contact.setNom("FIEVET");
      contact.setAdresse("Rue Aristide Dufumier");
      contact.setCodePostal("92120");
      contact.setVille("VANVES");
      contact.setCodeSecteur(3);

      listeContacts.addElement(contact); 

      return listeContacts;
   }

// -------------------------------------------------------------------------- 
// Creation de la liste des colonnes a afficher dans la JTable
// -------------------------------------------------------------------------- 
   public static Vector<Colonne> getListeColonnes()
   {
      Vector<Colonne> listeColonnes = new Vector<Colonne>();
      
// --------------------------------------------------------------------------
// Creation du vecteur des colonnes
// --------------------------------------------------------------------------
      
      listeColonnes.addElement(
         new Colonne("NUMERO", new Integer(5), "java.lang.Integer"));
         
      listeColonnes.addElement(
         new Colonne("NOM", new Integer(20), "java.lang.String"));
         
      listeColonnes.addElement(
         new Colonne("ADRESSE", new Integer(50), "java.lang.String"));
         
      listeColonnes.addElement(
         new Colonne("CODE_POSTAL", new Integer(12), "java.lang.String"));

      listeColonnes.addElement(
         new Colonne("VILLE", new Integer(20), "java.lang.String"));

      listeColonnes.addElement(
         new Colonne("CODE_SECTEUR", new Integer(1), "java.lang.Integer"));

      return listeColonnes;
   }
}