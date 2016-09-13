// ==========================================================================
// package utilitairesMG.divers
// --------------------------------------------------------------------------
// Classe TriBulleList
// --------------------------------------------------------------------------
// Classe pour le tri de listes d'objets de type Comparable
// ==========================================================================

package utilitairesMG.divers;

import java.util.*;

public class TriBulleList
{

// --------------------------------------------------------------------------
// Methode de tri (a bulles)
// --------------------------------------------------------------------------
// vecteur : reference du vecteur a trier
// Les objets référencés dans le vecteur devront être des objets d'une classe
// qui implemente Comparable.
// --------------------------------------------------------------------------
   public static void trier(List<Comparable> liste)
   {
      boolean permut;
      int n;
      Comparable x;
      
      do
      {
         permut = false;
         for (n = 0; n < liste.size() - 1; n++)
         {
            if(liste.get(n).compareTo(liste.get(n + 1)) > 0)
            {
               x = liste.get(n);
               liste.set(n, liste.get(n + 1));
               liste.set( n + 1, x);
               permut= true;
            }
         }
      }
      while (permut == true);
   }


// --------------------------------------------------------------------------
// Affichage du vecteur
// --------------------------------------------------------------------------
   public static void afficher(List<Comparable> liste)
   {
      int n;
      
      for (n = 0; n < liste.size(); n++)
      {
         System.out.println(liste.get(n));
      }
   }
}