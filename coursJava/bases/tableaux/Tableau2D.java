// ==========================================================================
// APPLICATION Tableau2D
// ==========================================================================

public class Tableau2D
{
   public static void main(String args[])   
   {
      int tableau[][];
      int lig, col;
      
      tableau = new int[3][4];
      
      System.out.println("Longueur du tableau (nombre de lignes) : " + tableau.length);
      System.out.println("Longueur de la ligne (0) : " + tableau[0].length);

      for (lig = 0; lig < 3; lig++)
      {
         for (col = 0; col < 4; col++)
         {
            tableau[lig][col] = lig + col;
         }
      }
      
      System.out.println("\nTableau :\n");
      
      for (lig = 0; lig < 3; lig++)
      {
         for (col = 0; col < 4; col++)
         {
            System.out.print(tableau[lig][col] + " ");
         }
         System.out.print("\n");
      }
   }
}