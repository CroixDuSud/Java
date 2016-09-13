// ==========================================================================
// APPLICATION TestEntier
// --------------------------------------------------------------------------
// Primitives (types de donnees) et objets 
// Méthode toString
// Surcharge (de contructeurs)
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestEntier
{
   public static void main(String argv[]) throws IOException
   {
      float x;            // Primitive de type virgule flottante (32 bits)
      char c;             // Primitive de type entier non signé  (16 bits)
      Entier e1, e2, e3;  // Handles sur des objets de la classe Entier
      
      x = 5.5f;           // Si on ne met pas le 'f', JAVA considere que 5.5
                          // est une constante en double precision. 
                          // Cela provoque une erreur (pas un warning)...
                          // On peut aussi utiliser un operateur de "cast" :
                          // x = (float)5.5;
                        
      System.out.println("Valeur de x : " + x);
      
      c = 65;             // On peut aussi ecrire : c = 'A';
      
      System.out.println(c++ + "bruti");
      System.out.println(c + "aderne");
      
// --------------------------------------------------------------------------
// Creation (instanciation) des objets et affectation des handles
// --------------------------------------------------------------------------
      e1 = new Entier("-2317");   // new cree l'objet 
      e2 = new Entier(1);         // = affecte son adresse au handle
      e3 = new Entier();
      
      System.out.println(e1); 
      System.out.println(e2);
      System.out.println(e3);
      
      e2 = e1;
      System.out.println(e2);
      
      Clavier.readString();
   }
}

// ==========================================================================
// Classe Entier
// ==========================================================================

class Entier
{
// --------------------------------------------------------------------------
// Propriete
// --------------------------------------------------------------------------
   private int valeur;

// --------------------------------------------------------------------------
// Constructeurs : 
// --------------------------------------------------------------------------
// On pourrait ne pas declarer de constructeur. Un constructeur par defaut,
// initialisant valeur a 0, serait appele lors du "new Entier()".
// 
// Par contre, a partir du moment ou un constructeur est declare, l'appel du
// constructeur par defaut ne marche plus. Pour pouvoir utiliser le 
// constructeur par defaut, il est obligatoire de le declarer (voir ci 
// dessous la declaration de : Entier()
// --------------------------------------------------------------------------
   public Entier(int valeur)
   {
      this.valeur = valeur;
   }

   public Entier(String s)
   {
      valeur = Integer.parseInt(s);
   }
   
   public Entier()
   {
   }

// --------------------------------------------------------------------------
// Methode toString : 
// --------------------------------------------------------------------------
// Il s'agit ici de la redefinition d'une methode de la classe Object.
// Cette methode est appelee par System.out.println(a). 
// Faute de cette redefinition, c'est la methode de la classe Objet qui
// serait appelee. Le resultat de l'impression serait :
/*
   Valeur de x : 5.5
   Abruti
   Baderne
   Entier@1ac04e8
   Entier@765291
   Entier@26e431
   Entier@1ac04e8
*/
// Ce qui est affiche est :   le nom de la classe 
//                          + "@" 
//                          + une valeur hexa (hashcode) identifiant l'objet
// --------------------------------------------------------------------------

   public String toString()
   {
      return ("Valeur : " + valeur);
   }
}