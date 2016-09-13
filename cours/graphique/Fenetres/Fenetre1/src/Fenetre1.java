// ==========================================================================
// APPLICATION Fenetre1 : utilisation de la classe JFrame
// --------------------------------------------------------------------------
// Creation et affichage d'une fenetre.
// ==========================================================================

import javax.swing.*;

public class Fenetre1
{

    public static void main(String args[])
    {
        JFrame maFenetre;

// --------------------------------------------------------------------------
// Instanciation d'un objet JFrame. C'est juste une reservation d'espace
// memoire. Rien ne s'affiche a l'ecran.
// --------------------------------------------------------------------------
        maFenetre = new JFrame("Première fenêtre");

// --------------------------------------------------------------------------
// La methode setVisible est une methode de la classe Component. L'appel de
// setVisible(true) permet de visualiser le composant, ici la fenetre.
// --------------------------------------------------------------------------
// Apres l'execution de cette methode, les evenements reçus par la fenetre
// sont traites automatiquement. On peut l'agrandir, la deplacer, la reduire
// en icone... Cela signifie qu'il y a un programme qui ecoute les evenements
// et des methodes toutes faites qui agissent en fonction de l'evenement.
// --------------------------------------------------------------------------
        maFenetre.setVisible(true);

// --------------------------------------------------------------------------
// Pendant que le thread d'ecoute des evenements travaille, le thread
// principal (main) continue son execution, mais attend un signe pour se
// terminer. Quand on ferme la fenetre (en cliquant sur l'icone de
// fermeture), le thread d'ecoute masque la fenetre (il execute
// setVisible(false)), mais ne dit rien au programme  principal, qui du coup
// ne s'arrête pas...  Il faut l'interrompre manuellement.
// --------------------------------------------------------------------------
    }
}
