// ==========================================================================
// Classe Figure : figures geometriques
// --------------------------------------------------------------------------
// L'objectif de la creation de cette classe est de pouvoir trier des 
// figures geometriques (cercles, rectangles, triangles...) par surface
// croissante, en utilisant la classe TriBulle. 
//
// Cette classe possede une methode trier() capable de trier les elements
// references dans un tableau, sous reserve qu'ils soient de type Comparable, 
// c'est-a-dire qu'ils implementent l'interface Comparable. La classe Figure
// doit donc implementer Comparable.
// 
// L'implementation de Comparable oblige la classe Figure a redefinir la 
// methode : public int compareTo(Object f)
//
// La methode compareTo de figure compare la surface de deux objets de type
// Figure. Elle appelle donc la methode surface() de l'objet courant et 
// compare le resultat avec celui de la methode surface() appliquee a l'objet
// f passe en parametre. Mais la declaration du parametre precise que f est
// de type Object. Pour pouvoir utiliser la methode surface(), il faut 
// preciser que cet Object est de type Figure. Cela se fait par l'utilisation
// de l'operateur de cast (Figure) applique a f : ((Figure)f).surface()
// (Attention au parenthesage !)
//
// La methode surface() utilisee dans Figure est forcement abstraite car
// son contenu depend du type de Figure (le calcul n'est pas le meme suivant
// qu'il s'agit d'un cercle, d'un triangle...).
// On pourrait ecrire une methode "bidon" qui ne soit pas abstraite, mais la
// declaration en abstract force la redefinition de surface() dans les 
// classes derivees.
// ==========================================================================

public abstract class Figure implements Comparable
{
   public int compareTo(Object f)
   {
      int resultat;
      
      if (surface() == ((Figure)f).surface())
      {
         resultat = 0;
      }
      else
      {
         if (surface() > ((Figure)f).surface())
         {
            resultat = 1;
         }
         else
         {
            resultat = -1;
         }
      }
      
      return resultat;
   }
// --------------------------------------------------------------------------
// Methode abstraite surface (permet de compiler Figure). Elle sera 
// surchargee dans les classes derivees
// --------------------------------------------------------------------------
   public abstract float surface();
}