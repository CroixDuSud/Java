// ==========================================================================
// APPLICATION Souris : 
// --------------------------------------------------------------------------
// La classe Fenetre est son propre ecouteur d'evenements MouseEvent.
// L'ecouteur d'evenements WindowEvent est declare dans une classe a part.
// --------------------------------------------------------------------------
// Recuperation des evenements de type MouseEvent (Mouse, Mouse Motion) et
// MouseWheelEvent qui se produisent sur la fenetre.
// ==========================================================================

public class Souris
{
   public static void main(String args[])
   {
      Fenetre maFenetre = new Fenetre("Deplacement vertical");
   }
}
