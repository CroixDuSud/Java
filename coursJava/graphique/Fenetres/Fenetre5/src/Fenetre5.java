// ==========================================================================
// Classe Fenetre5                                       Application Fenetre5
// --------------------------------------------------------------------------
// Classe Fenetre heritee de JFrame.
// Classe EcouteFenetre qui herite de la classe WindowAdapter.
// --------------------------------------------------------------------------
// WindowAdapter est une classe qui implemente l'interface WindowListener.
// Il suffira ici de redefinir uniquement les methodes qui nous interessent.
// Les autres n'ont aucune action (elles sont definies vides dans
// WindowAdapter).
// ==========================================================================

public class Fenetre5
{

    public static void main(String args[])
    {
        Fenetre maFenetre;
        maFenetre = new Fenetre("Cinquième fenêtre");
    }
}
