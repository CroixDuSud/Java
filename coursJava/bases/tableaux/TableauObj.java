// ==========================================================================
// APPLICATION TableauObj : Tableau de references (Object)
// ==========================================================================

public class TableauObj
{
   public static void main(String argv[])
   {
      
// --------------------------------------------------------------------------
// Creation du tableau :      
// --------------------------------------------------------------------------
      int i;                         
      Object tableau[];
      
      tableau = new Object[6];
      
      tableau[0] = "FUMIER INFECT !";
      tableau[1] = new String();
      tableau[2] = new StringBuffer("ORDURE !");
      tableau[3] = new Integer(5);
      tableau[4] = new Point(7, 8);
      tableau[5] = new Entier("-2317");
                         
// --------------------------------------------------------------------------
// Affichage du tableau :
// --------------------------------------------------------------------------
      System.out.println("\nContenu du tableau : \n");

      for (i = 0; i < tableau.length; i++)
      {
         System.out.println("tableau[" + i + "] = " + tableau[i]);     
      }
      
// --------------------------------------------------------------------------
// Affichage du Point dont la reference est stockee dans tableau[4] :
// --------------------------------------------------------------------------
      System.out.print("\ntableau[4] (reference de Point) ==>     ");
      ((Point)tableau[4]).affiche();
   }	
}


// ==========================================================================
// Classe Entier
// ==========================================================================

class Entier
{
// --------------------------------------------------------------------------
// Propriete
// --------------------------------------------------------------------------
   private int valeur;

// --------------------------------------------------------------------------
// Constructeurs : 
// --------------------------------------------------------------------------
   public Entier(int valeur)
   {
      this.valeur = valeur;
   }

   public Entier(String s)
   {
      valeur = Integer.parseInt(s);
   }
   
   public Entier()
   {
   }

// --------------------------------------------------------------------------
// Methode toString : 
// --------------------------------------------------------------------------
   public String toString()
   {
      return ("Valeur : " + valeur);
   }
}


// ======================================================================
// Classe Point
// ======================================================================

class Point
{
// ----------------------------------------------------------------------
// Proprietes
// ----------------------------------------------------------------------
   private int x;
   private int y;

// ----------------------------------------------------------------------
// Constructeurs
// ----------------------------------------------------------------------
   public Point()
   {
   }
   
   public Point(int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   
// ----------------------------------------------------------------------
// Methodes
// ----------------------------------------------------------------------
   public void setX(int x)
   {
      this.x = x;
   }

   public void setY(int y)
   {
      this.y = y;
   }

   public void affiche()
   {
      System.out.println("x : " + x + "\ty : " + y);
   }

   public void affiche(String s)
   {
      System.out.println("\nCoordonnees de " + s + 
                         "\nx : " + x + "\ty : " + y);
   }
}
