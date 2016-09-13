// ==========================================================================
// Classe Figure : figures geometriques
// --------------------------------------------------------------------------
// Figure implemente l'interface Comparable typee : Comparable<Figure>
// La methode compareTo prend alors un parametre de type Figure. 
// Il n'est plus necessaire de "caster" le resultat de f.surface()...
// --------------------------------------------------------------------------
// Cette version utilise l'amélioration  proposée par Salah LAMIR en 
// janvier 2010 (utilisation de la methode compareTo de la classe Float).
// ==========================================================================


public abstract class Figure implements Comparable<Figure>
{
   public int compareTo(Figure f)
   {
      return surface().compareTo(f.surface());
   }
// --------------------------------------------------------------------------
// Methode abstraite surface (permet de compiler Figure). Elle sera 
// surchargee dans les classes derivees
// --------------------------------------------------------------------------
   public abstract Float surface();
}