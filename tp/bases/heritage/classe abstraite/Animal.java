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
// ageMaximum           : age maximum d'un animal de la la classe Animal.
// --------------------------------------------------------------------------
   private boolean vivant;
   private int age;
   private static int nombreAnimauxVivants = 0;
   //private static int ageMaximum = 3;   // Cette propriete est un peu
                                        // artificielle. Il s'agit de faire
                                        // mourir un animal qui a ete cree
                                        // comme une instance de Animal et
                                        // non d'une classe derivee (Vache)
   
// --------------------------------------------------------------------------
// Constructeur avec param�tre : la cr�ation d'un objet animal s'accompagne
// de l'initialisation de son age. L'animal est vivant par d�faut.
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
/*   {
      System.out.println("Cet animal a maintenant " + age + " ans.");
   }*/
   
   public abstract int getAgeMaximum();
/*   {
      return ageMaximum;
   }*/
   
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
/*   {
      System.out.println("Un animal vient de mourir !");
   }*/
   
   public abstract void crier();
/*   {
      System.out.println("Je suis muet !");
   }*/
   
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