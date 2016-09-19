// ==========================================================================
// APPLICATION Fenetre2 : utilisation de la classe JFrame
// --------------------------------------------------------------------------
// Identique à Fenetre1 mais avec modification de l'operation de fermeture
// par defaut de l'objet maFenetre de type JFrame.
// ==========================================================================

import javax.swing.*;

public class Fenetre2
{

    public static void main(String args[])
    {
        JFrame maFenetre;
        maFenetre = new JFrame("Deuxième fenêtre");

// --------------------------------------------------------------------------
// Cette instruction permet de positionner et dimensionner la fenêtre.
// Les 2 premiers chiffres : coin superieur gauche
// Les 2 derniers chiffres : largeur et hauteur
// --------------------------------------------------------------------------
        maFenetre.setBounds(100, 100, 300, 200);

// --------------------------------------------------------------------------
// Modification de l'option de fermeture :
// JFrame.EXIT_ON_CLOSE est une propriete (constante) de la classe JFrame.
// Cette fois-ci, la fermeture de la fenetre entraine l'arret du programme...
// --------------------------------------------------------------------------
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.setVisible(true);
    }
}
