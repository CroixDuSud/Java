// ========================================================================
// APPLICATION TabString2 : deuxieme etape
// ------------------------------------------------------------------------
// Gestion de l'erreur ArrayIndexOutOfBoundsException
// ========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TabString2
{
   public static void main(String argv[]) throws IOException
   {
      int i;
      String tab[] = new String[3];
      
      tab[0] = "Abruti";
      tab[1] = "Bandit";
      tab[2] = "Cretin";
      
      for (i = 0; i <= 4; i++)
      {
         try
         {
            if (i == 4) throw new IOException();
            System.out.println(tab[i]);
         }

// ------------------------------------------------------------------------
// Debordement du tableau (i > 2)
// ------------------------------------------------------------------------
         catch (ArrayIndexOutOfBoundsException e)
         {
            System.out.print("L'indice i = " + i + " deborde du tableau.\n");
         } 
			
// ------------------------------------------------------------------------
// Le catch suivant traite une Exception. 
// IOException �tant une classe d�riv�e de Exception, c'est ce bloc qui 
// sera ex�cut� en cas de IOException (cree artificiellement dans la 
// boucle for ci-dessus...
// ------------------------------------------------------------------------
         catch (Exception e)
         {
            System.out.println("Traitement d'une exception " + 
                               e.getClass().getName() + "\n");
         }
      }
      
      Clavier.readString();
   }
}