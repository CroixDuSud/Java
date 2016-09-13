// ==========================================================================
// ModifVersement : Modification du nom d'un enregistrement de versements.dat
// ==========================================================================

import java.io.*;
import java.text.*;
import utilitairesMG.divers.*;

public class ModifVersement
{
   public static void main(String args[]) throws IOException
   {
      FichierVersement fv;
      int numEnreg;
      Versement versement = new Versement();
      String date;
            
// --------------------------------------------------------------------------
// Ouverture du fichier
// --------------------------------------------------------------------------
      try
      {
         fv = new FichierVersement("versements.dat", "rw");
         
// --------------------------------------------------------------------------
// Enregistrement a modifier :
// --------------------------------------------------------------------------
         try
         {
            System.out.print("Numero d'enregistrement a modifier : " );
            numEnreg = Clavier.readInt();

            fv.lire(versement, numEnreg);
            
            DateFr dateFr = new DateFr();
            dateFr.setTime(versement.getDate());
            
            System.out.println("Date actuelle du versement " + 
                               versement.getNumero() + " : " + dateFr);
            System.out.print("Nouvelle date : " );
            date = Clavier.readString();
            
            try
            {
               dateFr.set(date);
            }
            catch(ParseException e)
            {
               System.out.println("Date saisie incorrecte.");
            }
            versement.setDate(dateFr.getTime());
            
            fv.ecrire(versement, numEnreg);
         }
         catch(EOFException e)            // EOFException est une IOException
         {
            System.out.println("Enregistrement inconnu...");
         }

         catch(IOException e)   
         {
            System.out.println("Indice negatif...");
         }
         finally
         {
            System.out.println("Fermeture");
            fv.close();
         }
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Le fichier versements.dat est inconnu.");
      }
      Clavier.readString();
   }
}