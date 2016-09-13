// ==========================================================================
// APPLICATION TestControleInt :
// --------------------------------------------------------------------------
// Création d'une classe d'Exception personnelle
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestControleInt
{
   public static void main(String argv[]) throws IOException
   {  
      int i;
      i = ControleInt.saisieInt(150, 200);      
      System.out.println("Valeur saisie : " + i);
      Clavier.readString();
   }     
}