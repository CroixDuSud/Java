// ==========================================================================
// Classe Controleur                                   Application JTable5DAO
// -------------------------------------------------------------------------- 
// La JTable est remplie avec un vecteur d'objets Contact. Elle utilise un
// modele de table ET un modele de colonne.
// ==========================================================================

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
      LF.setLF(LF.WindowsLF);
      fenetre = new Fenetre("JTable5DAO", listeContacts, listeColonnes);
   }
   
// -------------------------------------------------------------------------- 
// Arret de l'application.
// -------------------------------------------------------------------------- 
   public static void arreter()
   {
      System.exit(0);
   }
}