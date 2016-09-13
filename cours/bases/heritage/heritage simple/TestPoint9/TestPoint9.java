// ==========================================================================
// Classe TestPoint9                                   Application TestPoint9
// --------------------------------------------------------------------------
// Initiation a l'heritage et au polymorphisme
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestPoint9
{
   public static void main(String argv[]) throws IOException
   {
      Point p;
      Cercle c;

// --------------------------------------------------------------------------
// Traitements d'un point
// --------------------------------------------------------------------------
      p = new Point(100, 100);
      
      System.out.print("Affichage du point : " + p);

      System.out.println("\n\nDeplacement :");
      p.deplace(-5, 120);
      
// --------------------------------------------------------------------------
// Traitements d'un cercle
// --------------------------------------------------------------------------
      c = new Cercle(100, 100, 25);
      
      System.out.print("\n\n\n\nAffichage du cercle : " + c);

      System.out.println("\n\nDeplacement :");
      c.deplace(-5, 120);
      
      Clavier.readString();
   }
}