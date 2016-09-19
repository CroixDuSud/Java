// ==========================================================================
// Classe TestPoint2                                   Application TestPoint2
// --------------------------------------------------------------------------
// Ramasse-miettes
// ==========================================================================

public class TestPoint2
{
   public static void main(String argv[])
   {
      Point p1, p2;
      
// --------------------------------------------------------------------------
// Initialisation de la reference p1 a null (non renseignee). 
// --------------------------------------------------------------------------
// Si cette initialisation n'est pas faite, le compilateur refuse le println
// qui suit avec le message d'erreur suivant :
//
// TestPoint2.java:19: variable p1 might not have been initialized
//      System.out.println("p1 : " + p1);
//                                   ^
// --------------------------------------------------------------------------
      p1 = null;
      System.out.println("p1 : " + p1);
      
// --------------------------------------------------------------------------
// Instanciation de l'objet p1 et affichage de la reference. 
// --------------------------------------------------------------------------
      p1 = new Point();
      System.out.println("p1 : " + p1);
      
// --------------------------------------------------------------------------
// Instanciation de l'objet p2 et affichage de la reference. 
// --------------------------------------------------------------------------
      p2 = new Point();
      System.out.println("p2 : " + p2);
      
// --------------------------------------------------------------------------
// Nouvelle instanciation de l'objet p2 et affichage de la reference.
// --------------------------------------------------------------------------
// L'objet precedemment reference par p2 n'est plus accessible, car son 
// adresse a ete ecrasee. L'espace perdu est recupere automatiquement par
// le "garbage collector" (ramasse-miettes).
// --------------------------------------------------------------------------
      p2 = new Point();
      System.out.println("p2 : " + p2);
   }
}