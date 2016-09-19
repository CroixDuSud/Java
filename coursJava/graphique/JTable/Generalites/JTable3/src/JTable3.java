// ==========================================================================
// Classe JTable3                                         Application JTable3
// -------------------------------------------------------------------------- 
// Affichage d'une JTable dans la fenêtre, avec scrolling. La JTable est 
// construite a partir d'un modele de table.
// ==========================================================================

import java.util.*;
import utilitairesMG.graphique.*;
import utilitairesMG.divers.*;

public class JTable3
{
   
// -------------------------------------------------------------------------- 
// Programme principal de l'application
// -------------------------------------------------------------------------- 
   public static void main(String args[])
   {
      Fenetre fenetre;
      
      Vector<Colonne> listeColonnes;
      Vector<Vector<Object>> listeLignes;
      
// -------------------------------------------------------------------------- 
// Creation des vecteurs des donnees a afficher.
// -------------------------------------------------------------------------- 
      listeLignes   = getListeLignes();
      listeColonnes = getListeColonnes();

// -------------------------------------------------------------------------- 
// Affichage de la fenetre.
// -------------------------------------------------------------------------- 
      LF.setLF();
      fenetre = new Fenetre("JTable3", listeLignes, listeColonnes);
   }
  
// -------------------------------------------------------------------------- 
// Creation de la liste des lignes a afficher dans la JTable
// -------------------------------------------------------------------------- 
// Remarque : listeLignes est un vecteur de vecteurs...
// -------------------------------------------------------------------------- 
   public static Vector<Vector<Object>> getListeLignes()
   {
      Vector<Vector<Object>> listeLignes = new Vector<Vector<Object>>();
      Vector<Object> donneesLigne;
      
      donneesLigne = new Vector<Object>();
      donneesLigne.addElement(new Integer(100));
      donneesLigne.addElement("GINESTE");
      donneesLigne.addElement("Rue Barbe");
      donneesLigne.addElement("94000");
      donneesLigne.addElement("CRETEIL");
      donneesLigne.addElement(new Integer(1));
      
      listeLignes.addElement(donneesLigne);

      donneesLigne = new Vector<Object>();
      donneesLigne.addElement(new Integer(101));
      donneesLigne.addElement("GIROUD");
      donneesLigne.addElement("Avenue du merdier");
      donneesLigne.addElement("94100");
      donneesLigne.addElement("SAINT MAUR");
      donneesLigne.addElement(new Integer(3));
      
      listeLignes.addElement(donneesLigne);

      donneesLigne = new Vector<Object>();
      donneesLigne.addElement(new Integer(103));
      donneesLigne.addElement("FIEVET");
      donneesLigne.addElement("Rue Aristide Dufumier");
      donneesLigne.addElement("92120");
      donneesLigne.addElement("VANVES");
      donneesLigne.addElement(new Integer(3));
      
      listeLignes.addElement(donneesLigne);
      
      return listeLignes;
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