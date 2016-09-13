// ==========================================================================
// Saisie3 : essai de saisie au clavier (bufferisee)
// ==========================================================================

import java.io.*;

public class Saisie3
{
   public static void main(String args[]) throws IOException
   {
      String chaineLue;
      
// ==========================================================================
// Pour ouvrir un flux il faut creer un objet correspondant au besoin
// --------------------------------------------------------------------------
// System.in est une propri�t� (static) de la classe System. 
// Elle est de type InputStream (classe m�re des flux d'entree d'octets).
// Ce flux est d�j� ouvert et pret pour lire des octets.
// --------------------------------------------------------------------------
// InputStreamReader est une classe d�riv�e de Reader, qui d�finit
// des flux d'entree de caracteres. Elle permet la saisie de caract�res
// cod�s en ASCII, sur un octet, et leur transformation en "Unicode sur
// 16 bits", c'est � dire sur deux octets. 
// --------------------------------------------------------------------------
// Le constructeur de InputStreamReader demande un objet de type InputStream
// qui lui indique l'emplacement du flux d'octets � utiliser.
// --------------------------------------------------------------------------
// BufferedReader est une classe d�riv�e de Reader.
// Elle va permettre de lire plus de caract�res qu'il n'en est n�cessaire
// pour un simple read(). Les autres caract�res seront stock�s dans un buffer
// et lus au fur et � mesure des besoins. La taille du buffer est d�finie par
// d�faut, mais peut etre modifi�e (option du constructeur).
// Le constructeur de BufferedReader a comme parametre un objet de type
// Reader (ou d'une classe d�riv�e : ici InputStreamReader). Cela lui permet
// de bufferiser les caracteres lus par les methodes de l'objet 
// InputStreamReader...
// --------------------------------------------------------------------------
// Une autre (grande) utilit� de la classe BufferedReader est de poss�der la
// m�thode ReadLine(), qui permet de lire une suite de caract�res, jusqu'� 
// la rencontre d'un indicateur de "fin de ligne" (\n, \r, ou les 2).
// Le r�sultat de ReadLine est affect� � une variable de type String.
// ==========================================================================
      BufferedReader entree = 
         new BufferedReader(new InputStreamReader(System.in));
      
      chaineLue = entree.readLine();
      System.out.println("Vous venez de taper : " + chaineLue);
   }
}