// ==========================================================================
// Classe JButton4                                       Application JButton4
// -------------------------------------------------------------------------- 
// Ajout d'un defileur (JScrollPane) au panneau contenant les deux boutons.
// Les boutons sont places dans le panneau gere par un FlowLayout. 
// On observe leur mise en page et le comportement du defileur (JScrollPane).
// ==========================================================================

// -------------------------------------------------------------------------- 
// La taille preferee du panneau est calculee au moment du pack().
// A partir de ce moment la, on peut modifier la taille du panneau, mais on
// ne peut pas diminuer sa largeur en dessous de sa largeur preferee, ni sa
// hauteur en dessous de sa hauteur preferee. Quand la fenetre et le defileur
// deviennent plus petits que le panneau, les barres de scrolling 
// apparaissent...
// -------------------------------------------------------------------------- 
// Un defaut : le panneau ne pouvant diminuer de largeur, meme si on augmente
// sa hauteur, la place disponible n'est pas utilisee pour reorganiser les 
// boutons...
// -------------------------------------------------------------------------- 

public class JButton4
{
   public static void main(String argv[])
   {
      Fenetre fenetre = new Fenetre("JButton4 : Scrolling");
   }
}