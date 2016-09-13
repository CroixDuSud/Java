// ==========================================================================
// Saisie2 : saisie au clavier
// --------------------------------------------------------------------------
// Ce programme montre l'utilisation des methodes read() heritees de la
// classe abstraite Reader. Un objet de type InputStreamReader (pont
// entre un flux d'octets et un flux de caracteres Unicode) va etre cree.
// Son constructeur a comme parametre System.in, flux d'entree d'octets
// correspondant au clavier. 
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class Saisie2
{
   public static void main(String args[]) throws IOException, InterruptedException
   {
      int codeRetour;
      int i;
      char[] tableauChar = new char[20];

// --------------------------------------------------------------------------
// Creation de l'objet InputStreamReader.      
// --------------------------------------------------------------------------
      InputStreamReader entree = new InputStreamReader(System.in);

// --------------------------------------------------------------------------
// La methode read() retourne le caractere lu, mais le stocke dans un 
// int. En l'occurence, la valeur du caractere lu est rangee dans 
// codeRetour.
// --------------------------------------------------------------------------
      System.out.print("Saisir une suite de caracteres : ");
      codeRetour = entree.read();    
      System.out.println("\nCaractere lu : " + codeRetour);

// --------------------------------------------------------------------------
// La methode read(char[] tableau, int offset, int longueur) utilisee 
// ci-dessous retourne le nombre de caracteres lus, et les stocke dans le
// tableau tableauChar. 7 indique la position de stockage dans le
// tableau, 2 le nombre de caracteres stockes. Tous les autres caracteres
// tapes seront lus par la troisieme fonction read.
// --------------------------------------------------------------------------
// Attention : le tableau tableauChar doit etre un tableau de char et non de
//             byte... Sinon, le compilateur ne reconnait pas la methode (de
//             InputStreamReader).
// --------------------------------------------------------------------------
      codeRetour = entree.read(tableauChar, 17, 2);          
      System.out.println("\nNombre de caracteres lus : " + codeRetour);

// --------------------------------------------------------------------------
// La methode read(char[] tableau) utilisee ci-dessous retourne le nombre
// de caracteres lus, et les stocke dans le tableau tableauChar, dans 
// l'ordre. 
// --------------------------------------------------------------------------
      codeRetour = entree.read(tableauChar);          
      System.out.println("\nNombre de caracteres lus : " + codeRetour);
      
      System.out.println("\n\n");
      
      for(i = 0; i < 20; i++)
      {
         Thread.sleep(100);
         System.out.print(tableauChar[i] + " ");
      }
      
      Clavier.readString();
   }
}