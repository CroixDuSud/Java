// ==========================================================================
// Saisie1 : saisie au clavier
// --------------------------------------------------------------------------
// Ce programme montre l'utilisation directe des methodes read() de
// l'objet System.in. Ces methodes sont definies dans la classe abstraite
// InputStream. 
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class Saisie1
{
   public static void main(String args[]) throws IOException
   {
      int codeRetour;
      int i;
      byte[] tableauOctets = new byte[20];
      
// --------------------------------------------------------------------------
// La methode read() retourne l'octet lu, mais le stocke dans un int.
// En l'occurence, la valeur de l'octet lu est rangee dans codeRetour.
// --------------------------------------------------------------------------
      System.out.print("Saisir une suite de caracteres : ");
      codeRetour = System.in.read();    
      System.out.println("\nOctet lu : " + codeRetour);

// --------------------------------------------------------------------------
// La methode read(byte[] tableau, int offset, int longueur) utilisee 
// ci-dessous retourne le nombre d'octets lus, et les stocke dans le
// tableau tableauOctets. 17 indique la position de stockage dans le
// tableau, 2 le nombre d'octets stockes. Tous les autres octets tapes
// seront lus par la troisieme fonction read.
// --------------------------------------------------------------------------
      codeRetour = System.in.read(tableauOctets, 17, 2);          
      System.out.println("\nNombre d'octets lus : " + codeRetour);

// --------------------------------------------------------------------------
// La methode read(byte[] tableau) utilisee ci-dessous retourne le nombre
// d'octets lus, et les stocke dans le tableau tableauOctets, dans 
// l'ordre. 
// --------------------------------------------------------------------------
      codeRetour = System.in.read(tableauOctets);          
      System.out.println("\nNombre d'octets lus : " + codeRetour + "\n\n");
      
      for(i = 0; i < 20; i++)
      {
         System.out.print(tableauOctets[i] + " ");
      }
      
      Clavier.readString();
   }
}