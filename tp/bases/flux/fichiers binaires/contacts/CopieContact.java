// ==========================================================================
// CopieContact : Recopie d'un fichier "contacts" (contacts.dat) dans un 
//                autre (nouveauContacts.dat)
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class CopieContact
{
   public static void main(String args[]) throws IOException
   {
      FichierContact fc1, fc2;
      Contact contact = new Contact();
      
// --------------------------------------------------------------------------
// Ouverture des deux fichiers
// --------------------------------------------------------------------------
      try
      {
         fc1 = new FichierContact("contacts.dat", "r");
         fc2 = new FichierContact("nouveauContacts.dat", "rw");
         
// --------------------------------------------------------------------------
// Boucle de recopie. On s'amuse a modifier le nom...
// --------------------------------------------------------------------------
         try
         {
            fc1.lire(contact);
            
            while(true)
            {  
               contact.setNom(contact.getNom().replace('E', 'I'));
               fc2.ecrire(contact);
               fc1.lire(contact);
            }
         }
         catch(IOException e)
         {
            System.out.println("Recopie effectuee...");
         }
         finally
         {
            fc1.close();
            fc2.close();         
         }
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Le fichier contacts.dat est inconnu.");
      }
      
      Clavier.readString();
   }
}