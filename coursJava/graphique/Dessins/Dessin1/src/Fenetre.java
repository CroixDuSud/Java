// ==========================================================================
// Classe Fenetre                                         Application Dessin1
// ==========================================================================

import javax.swing.*;
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame
{
    private Panneau panneauFond;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public Fenetre(String s)
    {
        super(s);
        addWindowListener(new EcouteFenetre());

// --------------------------------------------------------------------------
// Création de l'objet panneauFond, avec changement de la couleur de fond :
// --------------------------------------------------------------------------
        panneauFond = new Panneau();
        panneauFond.setBackground(Color.yellow);
        panneauFond.setPreferredSize(new Dimension(250, 150));

// --------------------------------------------------------------------------
// On l'ajoute au Container de la zone d'affichage de la fenetre :
// --------------------------------------------------------------------------
        getContentPane().add(panneauFond);

        pack();
        setVisible(true);
    }
}
