// ==========================================================================
// package utilitairesMG.divers
// --------------------------------------------------------------------------
// Classe Clavier
// ==========================================================================

package utilitairesMG.divers;

import java.io.*;

public class Clavier
{
// --------------------------------------------------------------------------
// On utilisera les trois methodes statiques readString, readInt, readDouble.
// Il n'y aura donc pas besoin de creer des instances de Console. 
// Pour utiliser readLine() de la classe BufferedReader, il est necessaire de
// declarer une propriete de type BufferReader qui reference une instance de 
// BufferedReader. Cette propriete, utilisee dans les methodes statiques, 
// doit etre statique.
// --------------------------------------------------------------------------
   private static BufferedReader clavier =
      new BufferedReader(new InputStreamReader(System.in)) ;

// --------------------------------------------------------------------------
// Methodes de saisie
// --------------------------------------------------------------------------
   public static String readString() throws IOException
   {
      String ligne;
      
      ligne = clavier.readLine();
      return ligne;
   }

   public static int readInt() throws IOException
   {
      int retour;
      String ligne;
      
      ligne = clavier.readLine();
      retour = Integer.parseInt(ligne);
      return retour;
   }
   
   public static double readDouble() throws IOException
   {
      double retour;
      String ligne;
      
      ligne = clavier.readLine();
      retour = Double.parseDouble(ligne);
      return retour;
   }
}