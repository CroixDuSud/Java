// ==========================================================================
// package utilitairesMG.divers
// --------------------------------------------------------------------------
// Classe UtilEntiers
// --------------------------------------------------------------------------
// Utilitaires sur les entiers
// ==========================================================================

package utilitairesMG.divers;
 
public class UtilEntiers
{
   
// --------------------------------------------------------------------------
// Calcul du pgcd de deux entiers strictement positifs
// --------------------------------------------------------------------------
   public static int pgcd(int n1, int n2)
   {
      while (n1 != n2)
      {
         if (n1 > n2) n1 -= n2;
         else         n2 -= n1;
      }
      return n1;
   }
   
   public static int fact(int n)
   {
      if (n == 1) 
         return (1);
      else
         return (n * fact(n-1));
   }
}