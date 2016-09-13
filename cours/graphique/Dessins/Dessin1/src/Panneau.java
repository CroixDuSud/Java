// ==========================================================================
// Classe Panneau                                         Application Dessin1
// --------------------------------------------------------------------------
// On doit creer cette classe car le dessin va etre fait dans la methode
// paintComponent qui redefinit la methode paintComponent de la classe
// JPanel. Cette methode est appelee a chaque fois que le panneau doit etre
// redessine (changement de taille de la fenetre...).
// Si on ne met pas super.paintComponent(g), le panneau ne se dessine pas 
// (ici, la couleur de fond n'est pas modifiee, le panneau s'affiche gris au
// lieu de jaune).
// --------------------------------------------------------------------------
// La reference g est un contexte graphique. C'est un objet de la classe
// Graphics qui sert d'intermediaire entre nos dessins et leur realisation 
// effective (depend du systeme...).
// Un panneau possede un lien avec un contexte graphique. paintComponent sait
// le repérer et l'utiliser...
// ==========================================================================

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawLine(15, 10, 100, 50);
    }
}
