// ==========================================================================
// APPLICATION Exception01 : Comprehension d'un message d'erreur
// ==========================================================================

public class Exception01
{
   public static void main(String argv[])
   {  
      A toto = new A(10, 0);
   }     
}

class A
{
   private int x, y, z;
   
   public A(int a, int b)
   {
      x = a;
      y = b;
      z = x / y;  // Lorsque y = 0, il y a creation d'une instance de la
                  // classe ArithmeticException (dérivee de Exception) avec
                  // passage d'un parametre "/ by zero" au constructeur
   }
}