// ==========================================================================
// Classe FichierContact : gestion du fichier Contact
// --------------------------------------------------------------------------
// Description de ce fichier :
//
//    int  numero
//    char nom[21]
//    char adresse[51]
//    char codePostal[6]
//    char ville[21]
//    int  codeSecteur
// --------------------------------------------------------------------------
// Attention : entre ville et codeSecteur, il y a un octet de cadrage de
// l'entier codeSecteur sur un octet multiple de 4. 
// La taille de l'enregistrement est donc 108.  
// ==========================================================================

import java.io.*;
import java.util.*;
import utilitairesMG.divers.*;

class FichierContact extends Fichier
{
   
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public FichierContact(String nomFichier, String mode) throws IOException
   {
      super(nomFichier, mode, 108);
   }

// --------------------------------------------------------------------------
// Methodes d'ecriture (sequentielle et directe)
// --------------------------------------------------------------------------
   public void ecrire(Contact contact) throws IOException
   {
      writeInt(contact.getNumero());
      writeString(contact.getNom(), 21);
      writeString(contact.getAdresse(), 51);
      writeString(contact.getCodePostal(), 6);
      writeString(contact.getVille(), 21);
      writeByte(0);
      writeInt(contact.getCodeSecteur());
   }

   public void ecrire(Contact contact, int numEnreg) throws IOException
   {
      seekFichier(numEnreg);
      writeInt(contact.getNumero());
      writeString(contact.getNom(), 21);
      writeString(contact.getAdresse(), 51);
      writeString(contact.getCodePostal(), 6);
      writeString(contact.getVille(), 21);
      writeByte(0);
      writeInt(contact.getCodeSecteur());
   }
   
// --------------------------------------------------------------------------
// Methodes de lecture (sequentielle et directe)
// --------------------------------------------------------------------------
   public void lire(Contact contact) throws IOException
   {
      contact.setNumero(readInt());
      contact.setNom(readString(21));
      contact.setAdresse(readString(51));
      contact.setCodePostal(readString(6));
      contact.setVille(readString(21));
      readByte();
      contact.setCodeSecteur(readInt());
   }

   public void lire(Contact contact, int numEnreg) throws IOException
   {
      seekFichier(numEnreg);
      contact.setNumero(readInt());
      contact.setNom(readString(21));
      contact.setAdresse(readString(51));
      contact.setCodePostal(readString(6));
      contact.setVille(readString(21));
      readByte();
      contact.setCodeSecteur(readInt());
   }

// --------------------------------------------------------------------------
// Liste des contacts
// --------------------------------------------------------------------------
   public Vector<Contact> lireListe() throws IOException
   {
      Vector<Contact> listeContacts = new Vector<Contact>();
      Contact contact;
      
      try
      {
         seekFichier(0);

         while(true)
         {
            contact = new Contact();
            lire(contact);
            listeContacts.addElement(contact);
         }
      }
      catch(EOFException e)
      {
      }
/*      catch(IOException e)
      {
         System.out.println("Indice incorrect !");
      }*/
      
      return listeContacts;
   }
}