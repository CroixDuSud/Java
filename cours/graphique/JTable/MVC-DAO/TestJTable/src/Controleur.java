// ==========================================================================
// Classe Controleur                                               TestJTable
// --------------------------------------------------------------------------
// Pour passer du programme TestJTable à celui-ci, il suffit d'enlever la
// classe ModeleTableContact. C'est celui d'utilitairesMG qui sera utilise.
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