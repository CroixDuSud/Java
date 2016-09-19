// ==========================================================================
// Classe Fenetre                                        Application Fenetre4
// --------------------------------------------------------------------------
// Toutes les operations autres que l'instanciation dont regroupees dans le
// constructeur de la classe Fenetre.
// ==========================================================================

import javax.swing.*;

public class Fenetre extends JFrame
{

    public Fenetre(String titre)
    {
        super(titre);

        setBounds(100, 100, 300, 200);

        addWindowListener(new EcouteFenetre());
        setVisible(true);
    }
}
