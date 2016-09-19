// ==========================================================================
// Classe Fenetre6                                       Application Fenetre6
// --------------------------------------------------------------------------
// Classe Fenetre heritee de JFrame  ET  qui implemente l'interface
// WindowListener.
// --------------------------------------------------------------------------
// La classe Fenetre est son propre ecouteur (ce qu'on demande a la classe
// ecouteur, c'est de definir toutes les methodes de WindowListener...)
//
// La classe Fenetre doit implementer Windowlistener. Une classe ne pouvant
// deriver de deux classes, on ne peut faire de la classe fenetre un ecouteur
// avec WindowAdapter...
// ==========================================================================

public class Fenetre6
{

    public static void main(String args[])
    {
        Fenetre maFenetre;
        maFenetre = new Fenetre("Sixième fenêtre");
    }
}
