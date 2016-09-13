// ==========================================================================
// Classe Fenetre3                                       Application Fenetre3
// --------------------------------------------------------------------------
// Ecouteur d'evenement de type WindowEvent
// --------------------------------------------------------------------------
// Classe Fenetre heritee de JFrame
// Classe EcouteFenetre qui implemente l'interface WindowListener.
// ==========================================================================

public class Fenetre3
{

    public static void main(String args[])
    {
        Fenetre maFenetre;
        EcouteFenetre ecouteur;

// --------------------------------------------------------------------------
// Creation de la fenetre et de l'ecouteur
// --------------------------------------------------------------------------
        maFenetre = new Fenetre("Troisième fenêtre");
        ecouteur = new EcouteFenetre();

// --------------------------------------------------------------------------
// L'ecouteur est associe a la fenetre.
// --------------------------------------------------------------------------
// Il est a l'ecoute des evenements suivants : ouverture, fermeture,
// activation, desactivation, iconification, desiconification de la fenetre.
// --------------------------------------------------------------------------
        maFenetre.addWindowListener(ecouteur);

// --------------------------------------------------------------------------
// setVisible(true) rend la fenetre visible. L'ecoute des evenements commence.
// --------------------------------------------------------------------------
// Remarque : il vaut mieux preparer completement la fenetre avant de faire
// le setVisible(true). A defaut, on risque de rater quelques evenements...
// --------------------------------------------------------------------------
        maFenetre.setVisible(true);
    }
}
