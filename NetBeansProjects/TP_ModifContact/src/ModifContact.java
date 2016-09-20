// ==========================================================================
// ModifContact : Modification du nom d'un enregistrement de contacts.dat
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class ModifContact
{
   public static void main(String args[]) throws IOException
   {
      FichierContact fc;
      int numEnreg;
      Contact contact = new Contact();
      String nom;
            
// --------------------------------------------------------------------------
// Ouverture du fichier
// --------------------------------------------------------------------------
      try
      {
         fc = new FichierContact("contacts.dat", "rw");
         
// --------------------------------------------------------------------------
// Enregistrement a modifier :
// --------------------------------------------------------------------------
         try
         {
            System.out.print("Numero d'enregistrement a modifier : " );
            numEnreg = Clavier.readInt();

            fc.lire(contact, numEnreg);
            
            System.out.print("Nouveau nom de " + contact.getNom() + " : " );
            nom = Clavier.readString();
            
            contact.setNom(nom);
            fc.ecrire(contact, numEnreg);
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
            fc.close();
         }
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Le fichier contacts.dat est inconnu.");
      }
      Clavier.readString();
   }
}