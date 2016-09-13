// ==========================================================================
// APPLICATION VectorV4
// --------------------------------------------------------------------------
// Un Vector est un "tableau" extensible qui contient des references d'Object
// ==========================================================================

import java.util.*;  // Pour la classe Vector


public class VectorV4
{
   public static void main(String argv[])
   { 
      int i; 
      
// --------------------------------------------------------------------------
// Instanciation d'un Vector :
// --------------------------------------------------------------------------
// Quand on ne precise pas la capacite du Vector, il est de capacite 10.
// La capacite est le nombre d'elements que l'on peut ajouter dans le Vector 
// sans allouer plus de memoire.
// --------------------------------------------------------------------------
// La taille du Vector est le nombre d'elements qui ont ete ajoutes (le
// nombre d'elements contenus par le Vector, au debut 0).
// --------------------------------------------------------------------------
      Vector vecteur = new Vector();  
      
      System.out.println("Capacite Vector : " + vecteur.capacity());
      System.out.println("Taille Vector   : " + vecteur.size());
      
// --------------------------------------------------------------------------
// Création d'un poste dans le Vector :
// --------------------------------------------------------------------------
      vecteur.addElement("FUMIER INFECT !");   // On peut ajouter n'importe 
                                               // quel objet (Object)
      
      System.out.println("\nApres creation d'un nouvel element");
      System.out.println("Capacite Vector : " + vecteur.capacity());
      System.out.println("Taille Vector   : " + vecteur.size());

// --------------------------------------------------------------------------
// Affichage du poste :
// --------------------------------------------------------------------------
      System.out.println("vecteur.elementAt(0) : " + vecteur.elementAt(0));
      
// --------------------------------------------------------------------------
// Création d'autres postes :
// --------------------------------------------------------------------------
      vecteur.addElement(new String());
      vecteur.addElement(new StringBuffer("ORDURE !"));
      vecteur.addElement(new Integer(17));
      vecteur.addElement(new Point(13, 4));
      vecteur.addElement(new Entier(488));
      
      System.out.println("\nApres creation de cinq nouveaux postes");
      System.out.println("Capacite Vector : " + vecteur.capacity());
      System.out.println("Taille Vector   : " + vecteur.size());

      System.out.println("\nContenu du vecteur : \n");
      
      System.out.println("\nAffichage par defaut : \n");
      System.out.println(vecteur);

      System.out.println("\nAffichage par une boucle for sur tous les postes : \n");
      for(i = 0; i < vecteur.size(); i++)
      {
         System.out.println("vecteur.elementAt(" + i + ") : " + 
                            vecteur.elementAt(i));
      }
      
// --------------------------------------------------------------------------
// Modification du deuxieme element :
// --------------------------------------------------------------------------
      vecteur.setElementAt(new String("MORUE !"), 1);
      
      System.out.println("\nApres modification du deuxieme element");
      System.out.println(vecteur);
      
// --------------------------------------------------------------------------
// Creation d'une dizaine d'elements, nouvelle taille, nouvelle capacite
// --------------------------------------------------------------------------
      for (i = 0; i < 10; i++)
      {
         vecteur.addElement(new String());
      }
      
      System.out.println("\nApres ajout de 10 elements");
      System.out.println("Capacite Vector : " + vecteur.capacity());
      System.out.println("Taille Vector   : " + vecteur.size());
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
   public String toString()
   {
      return ("Valeur : " + valeur);
   }
}


// ======================================================================
// Classe Point
// ======================================================================

class Point
{
// ----------------------------------------------------------------------
// Proprietes
// ----------------------------------------------------------------------
   private int x;
   private int y;

// ----------------------------------------------------------------------
// Constructeurs
// ----------------------------------------------------------------------
   public Point()
   {
   }
   
   public Point(int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   
// ----------------------------------------------------------------------
// Methodes
// ----------------------------------------------------------------------
   public void setX(int x)
   {
      this.x = x;
   }

   public void setY(int y)
   {
      this.y = y;
   }

   public void affiche()
   {
      System.out.println("x : " + x + "\ty : " + y);
   }

   public void affiche(String s)
   {
      System.out.println("\nCoordonnees de " + s + 
                         "\nx : " + x + "\ty : " + y);
   }
}
