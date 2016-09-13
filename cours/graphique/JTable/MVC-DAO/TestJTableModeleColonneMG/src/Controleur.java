// ==========================================================================
// Classe Controleur                                               TestJTable
// --------------------------------------------------------------------------
// Affichage d'une JTable editable avec les principaux types de colonnes.
// Le modele de table est herite de ModeleTable pour editer et inserer dans
// la table.
// Le modele de colonne est sans surcharge des editeurs et des rendus.
// ==========================================================================

import java.util.*;
import utilitairesMG.divers.*;
import utilitairesMG.graphique.*;


public class Controleur
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
      listeLignes   = EssaiDAO.getListeLignes();
      listeColonnes = EssaiDAO.getListeColonnes();

// --------------------------------------------------------------------------
// Affichage de la fenetre.
// --------------------------------------------------------------------------
      LF.setLF();
      fenetre = new Fenetre("TestJTable", listeLignes, listeColonnes);
   }

// --------------------------------------------------------------------------
// Arret de l'application
// --------------------------------------------------------------------------
   public static void arreter()
   {
      System.exit(0);
   }
}