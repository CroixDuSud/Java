// ==========================================================================
// Classe Animal :
// ==========================================================================

public abstract class Animal
{
// --------------------------------------------------------------------------
// Proprietes :
// --------------------------------------------------------------------------
// vivant               : logique indiquant si l'animal est vivant.
// age                  : age de l'animal.
// nombreAnimauxVivants : variable statique indiquant le nb d'animaux vivants
// --------------------------------------------------------------------------
   private boolean vivant;
   private int age;
   private static int nombreAnimauxVivants = 0;
   
// --------------------------------------------------------------------------
// Constructeur avec paramètre : la création d'un objet animal s'accompagne
// de l'initialisation de son age. L'animal est vivant par défaut.
// --------------------------------------------------------------------------
   public Animal(int age)
   {
      this.age = age;
      vivant = true;
      nombreAnimauxVivants++;
   }
  
// --------------------------------------------------------------------------
// Methodes :
// --------------------------------------------------------------------------
   public void vieillir()
   {
      if(vivant)
      {
         age++;
         
         if(age > getAgeMaximum())
         {
            mourir();
         }
         else
         {
            afficheAge();   
         }
      }
   }
   
   public abstract void afficheAge();
   public abstract int getAgeMaximum();
   
   public void mourir()
   {
      if (vivant)
      {
         vivant = false;
         nombreAnimauxVivants--;
         afficheFairePart();
      }
   } 
   
   public abstract void afficheFairePart();
   public abstract void crier();
   
   public static int getNombreAnimauxVivants()
   {
      return nombreAnimauxVivants;
   }

   public int getAge()
   {
      return age;
   }

   public boolean getVivant()
   {
      return vivant;
   }
}