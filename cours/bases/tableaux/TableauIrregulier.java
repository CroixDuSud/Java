// ==========================================================================
// APPLICATION TableauIrregulier
// ==========================================================================

public class TableauIrregulier
{
   public static void main(String args[])   
   {
      int tableau[][];
      int lig, col;
      
      tableau = new int[3][];
      
      System.out.println("Longueur du tableau (nombre de lignes) : " + tableau.length);

      for (lig = 0; lig < 3; lig++)
      {
         tableau[lig] = new int[lig + 1];
      }
      
      for (lig = 0; lig < 3; lig++)
      {
         System.out.println(tableau[lig].length);
      }
   }
}