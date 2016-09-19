// ========================================================================
// Classe FractionEx07 : classe Fraction pour l'exercice Exception07
// ------------------------------------------------------------------------
// Creation d'un nouveau type d'exception pour empecher l'instanciation
// d'une fraction avec denominateur nul
// ========================================================================

public class FractionEx07
{
   private int numerateur;
   private int denominateur;

   public FractionEx07(int numerateur, int denominateur) throws DenominateurNulException 
   {
      if (denominateur == 0) throw new DenominateurNulException();
      
      this.numerateur = numerateur;
      this.denominateur = denominateur;
   }

   public int partieEntiere()
   {
      return numerateur / denominateur;
   }  
    
   public String toString()
   {
      if (denominateur != 1)
      {
         return numerateur + " / " + denominateur;
      }
      else
      {
         return "" + numerateur;
      }
   }
}

// ========================================================================
// Classe DenominateurNulException 
// ========================================================================

class DenominateurNulException extends Exception
{
   //private static final long serialVersionUID = 42L;
   
   public DenominateurNulException()
   {
      super("Le denominateur est nul !");
   }
}