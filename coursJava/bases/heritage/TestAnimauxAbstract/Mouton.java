// ==========================================================================
// Classe Mouton :
// ==========================================================================

public class Mouton extends Animal
{
   private static int ageMaximumMouton = 3;

// --------------------------------------------------------------------------
// Constructeur de la classe Mouton :
// --------------------------------------------------------------------------
// Appel du constructeur de la classe Animal : super(int a)
// --------------------------------------------------------------------------
   public Mouton(int a)
   {
      super(a);
   }
  
// --------------------------------------------------------------------------
// Methodes :
// --------------------------------------------------------------------------
   public void afficheAge()
   {
      System.out.println("Ce mouton a maintenant  " + getAge() + " ans.");
   }
   
   public int getAgeMaximum()
   {
      return ageMaximumMouton;
   }
   
   public void afficheFairePart()
   {
      System.out.println("Un mouton vient de mourir !");
   }

   public void crier()
   {
      System.out.println("BEE !");
   }
}