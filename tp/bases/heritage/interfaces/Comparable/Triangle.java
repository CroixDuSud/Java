// ==========================================================================
// Classe Triangle
// ==========================================================================

public class Triangle extends Figure
{
   private int base;           // Largeur de la base du triangle
   private int hauteur;        // Hauteur du triangle
   
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public Triangle(int base, int hauteur)
   {
      this.base = base;
      this.hauteur = hauteur;
   }   

// --------------------------------------------------------------------------
// Methodes redéfinies
// --------------------------------------------------------------------------
   public float surface()
   {
      return ((float)base * (float)hauteur)/2;
   }
   
   public String toString()
   {
      return ("Triangle de base " + base + 
              ", de hauteur " + hauteur + 
              ", Surface : " + surface());
   }
}