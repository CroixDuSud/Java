// ==========================================================================
// ClavierInt : saisie clavier et test des bornes
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class ClavierInt
{
// --------------------------------------------------------------------------
// Lecture d'un entier :
// --------------------------------------------------------------------------
   public static int readInt(int min, int max) throws IOException,
                                                    BorneException
   {
      int retour;
      
      retour = Clavier.readInt();
      if ((retour < min) || (retour > max))
      {
         throw new BorneException(retour, min, max);
      }
      return retour;
   }
}

class BorneException extends Exception
{
   //private static final long serialVersionUID = 17L;   // Pour le warning de Java 6
   
   public BorneException(int valeur, int min, int max)
   {
      super("Valeur " + valeur + " hors de [" + min + ", " + max + "]");
   }
}