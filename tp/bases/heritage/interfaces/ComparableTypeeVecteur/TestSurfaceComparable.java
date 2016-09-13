// ==========================================================================
// APPLICATION TestSurfaceComparable
// --------------------------------------------------------------------------
// Meme programme que TestSurfaceComparable mais utilisation de l'interface
// typee Comparable<T> (ici Comparable<Figure>).
// ==========================================================================

import java.io.*;
import java.util.*;
import utilitairesMG.divers.*;

public class TestSurfaceComparable
{
   public static void main(String argv[]) throws IOException
   {
      Vector<Comparable> vectFigures = new Vector<Comparable>();
      
      vectFigures.addElement(new Triangle(6, 2));
      vectFigures.addElement(new Cercle(4));
      vectFigures.addElement(new Rectangle(7, 9));
      vectFigures.addElement(new Triangle(6, 17));
      vectFigures.addElement(new Cercle(3));
      vectFigures.addElement(new Triangle(6, 7));
      vectFigures.addElement(new Rectangle(3, 14));
                             
      System.out.println("Figures a trier :\n");
      TriBulleList.afficher(vectFigures);
      TriBulleList.trier(vectFigures);
      System.out.println("\n\nFigures triees :\n");
      TriBulleList.afficher(vectFigures);
      
      Clavier.readString();
   }
}