// ==========================================================================
// APPLICATION TestSurfaceComparableList
// --------------------------------------------------------------------------
// Meme programme que TestSurfaceComparable mais utilisation de l'interface
// typee Comparable<T> (ici Comparable<Figure>).
// ==========================================================================

import java.io.*;
import java.util.*;
import utilitairesMG.divers.*;

public class TestSurfaceComparableList
{
   public static void main(String argv[]) throws IOException
   {
      ArrayList<Comparable> vectFigures = new ArrayList<Comparable>();
      
      vectFigures.add(new Triangle(6, 2));
      vectFigures.add(new Cercle(4));
      vectFigures.add(new Rectangle(7, 9));
      vectFigures.add(new Triangle(6, 17));
      vectFigures.add(new Cercle(3));
      vectFigures.add(new Triangle(6, 7));
      vectFigures.add(new Rectangle(3, 14));
                             
      System.out.println("Figures a trier :\n");
      TriBulleList.afficher(vectFigures);
      TriBulleList.trier(vectFigures);
      System.out.println("\n\nFigures triees :\n");
      TriBulleList.afficher(vectFigures);
      
      Clavier.readString();
   }
}