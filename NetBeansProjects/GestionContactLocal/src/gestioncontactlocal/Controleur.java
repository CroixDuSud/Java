// ==========================================================================
// Classe Controleur                                      Application JTable7
// -------------------------------------------------------------------------- 
// La JTable est modifiable.
// ==========================================================================
package gestioncontactlocal;
import java.util.*;
import utilitairesMG.graphique.*;
import utilitairesMG.divers.*;

public class Controleur
{
   private static Fenetre fenetre;
   private static ContactDAO contactDAO;
   
// -------------------------------------------------------------------------- 
// Programme principal de l'application.
// -------------------------------------------------------------------------- 
   public static void main(String args[])
   {
      Vector<Colonne> listeColonnes;
      Vector<Contact> listeContacts;
      
// -------------------------------------------------------------------------- 
// Creation des vecteurs des donnees a afficher.
// -------------------------------------------------------------------------- 
      contactDAO = new ContactDAO();
      listeContacts = contactDAO.getListe();
      listeColonnes = contactDAO.getListeColonnes();

// -------------------------------------------------------------------------- 
// Affichage de la fenetre.
// -------------------------------------------------------------------------- 
      LF.setLF();
      fenetre = new Fenetre("JTable7", listeContacts, listeColonnes);
   }
   
// -------------------------------------------------------------------------- 
// Arret de l'application.
// -------------------------------------------------------------------------- 
   public static void arreter(Vector<Contact> listeContacts,
                              Vector<Contact> listeContactsModifies,
                              Vector<Contact> listeContactsInseres)
   {
      System.out.println("Tous les contacts :\n" + listeContacts);
      System.out.println("\n\nContacts modifies :\n" + listeContactsModifies);
      System.out.println("\n\nContacts inseres :\n" + listeContactsInseres);
      System.exit(0);
   }
}