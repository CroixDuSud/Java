// ==========================================================================
// Classe TestPoint8                                   Application TestPoint8
// --------------------------------------------------------------------------
// Initiation a l'heritage et au polymorphisme
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestPoint8
{
   public static void main(String argv[]) throws IOException
   {
      Point p;
      
// --------------------------------------------------------------------------
// Traitements d'un point
// --------------------------------------------------------------------------
      p = new Point(100, 100);
      
      System.out.print("Affichage du point : " + p);

      System.out.println("\n\nDeplacement :");
      p.deplace(-5, 120); 
          
      Clavier.readString();
   }
}