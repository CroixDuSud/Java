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
// System.in est une propriété (static) de la classe System. 
// Elle est de type InputStream (classe mère des flux d'entree d'octets).
// Ce flux est déjà ouvert et pret pour lire des octets.
// --------------------------------------------------------------------------
// InputStreamReader est une classe dérivée de Reader, qui définit
// des flux d'entree de caracteres. Elle permet la saisie de caractères
// codés en ASCII, sur un octet, et leur transformation en "Unicode sur
// 16 bits", c'est à dire sur deux octets. 
// --------------------------------------------------------------------------
// Le constructeur de InputStreamReader demande un objet de type InputStream
// qui lui indique l'emplacement du flux d'octets à utiliser.
// --------------------------------------------------------------------------
// BufferedReader est une classe dérivée de Reader.
// Elle va permettre de lire plus de caractères qu'il n'en est nécessaire
// pour un simple read(). Les autres caractères seront stockés dans un buffer
// et lus au fur et à mesure des besoins. La taille du buffer est définie par
// défaut, mais peut etre modifiée (option du constructeur).
// Le constructeur de BufferedReader a comme parametre un objet de type
// Reader (ou d'une classe dérivée : ici InputStreamReader). Cela lui permet
// de bufferiser les caracteres lus par les methodes de l'objet 
// InputStreamReader...
// --------------------------------------------------------------------------
// Une autre (grande) utilité de la classe BufferedReader est de posséder la
// méthode ReadLine(), qui permet de lire une suite de caractères, jusqu'à 
// la rencontre d'un indicateur de "fin de ligne" (\n, \r, ou les 2).
// Le résultat de ReadLine est affecté à une variable de type String.
// ==========================================================================
      BufferedReader entree = 
         new BufferedReader(new InputStreamReader(System.in));
      
      chaineLue = entree.readLine();
      System.out.println("Vous venez de taper : " + chaineLue);
   }
}