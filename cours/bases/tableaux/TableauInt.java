// ==========================================================================
// APPLICATION TableauInt : Tableau d'entiers
// ==========================================================================

public class TableauInt
{
   public static void main(String argv[])
   {
      int i;
      int tableau[];
  
      tableau = new int[5];      
      System.out.println("tableau : " + tableau + 
                         " longueur : " + tableau.length);
      
      for(i = 0; i < tableau.length; i++)
      {
         tableau[i] = i + 1;
      }

      for(i = 0; i < tableau.length; i++)
      {
         System.out.println("tableau[" + i + "] = " + tableau[i]);
      }
      
// --------------------------------------------------------------------------
// Création d'un deuxieme tableau. modification de la reference du premier
// --------------------------------------------------------------------------
      int tableau2[] = {8, 9, 10};
      
      tableau = tableau2;
      System.out.println("tableau : " + tableau + 
                         " longueur : " + tableau.length);

      for(i = 0; i < tableau.length; i++)
      {
         System.out.println("tableau[" + i + "] = " + tableau[i]);
      }
   }	
}
