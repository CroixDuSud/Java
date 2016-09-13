// ==========================================================================
// Classe JTable2                                         Application JTable2
// -------------------------------------------------------------------------- 
// La difference avec JTable1 est dans la position des methodes 
// getListeLignes() et getListeColonnes()
// ==========================================================================

import java.util.*; 
import utilitairesMG.graphique.*;


public class JTable2
{
   
// -------------------------------------------------------------------------- 
// Programme principal de l'application
// -------------------------------------------------------------------------- 
   public static void main(String args[])
   {
      Fenetre fenetre;
      
      Vector<String> listeColonnes;
      Vector<Vector<Object>> listeLignes;
      
// -------------------------------------------------------------------------- 
// Creation des vecteurs des donnees a afficher.
// -------------------------------------------------------------------------- 
      listeLignes = getListeLignes();
      listeColonnes = getListeColonnes();

// -------------------------------------------------------------------------- 
// Affichage de la fenetre.
// -------------------------------------------------------------------------- 
      LF.setLF();
      fenetre = new Fenetre("JTable2", listeLignes, listeColonnes);
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
   public static Vector<String> getListeColonnes()
   {
      Vector<String> listeColonnes = new Vector<String>();
      
      listeColonnes.addElement("NUMERO");
      listeColonnes.addElement("NOM");
      listeColonnes.addElement("ADRESSE");
      listeColonnes.addElement("CODE_POSTAL");
      listeColonnes.addElement("VILLE");
      listeColonnes.addElement("CODE_SECTEUR");
      
      return listeColonnes;
   }
}