// ==========================================================================
// Classe Cercle                                       Application TestPoint9
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class Cercle extends Point
{
// --------------------------------------------------------------------------
// Propriete
// --------------------------------------------------------------------------
   private int rayon;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public Cercle(int xCentre, int yCentre, int rayon)
   {
      super(xCentre, yCentre);
      this.rayon = rayon;
   }

// ----------------------------------------------------------------------
// Methodes
// ----------------------------------------------------------------------
   public void affiche()
   {
      System.out.println("Affichage du cercle  : " + this);
   }

   public void efface()
   {
      System.out.println("Effacement du cercle : " + this);
   }
   
   public String toString()
   {
      return super.toString() + ", rayon " + rayon ;
   }
}