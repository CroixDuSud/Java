// ==========================================================================
// Classe Fenetre                                        Application Fenetre5
// --------------------------------------------------------------------------
// Classe identique a celle de l'application Fenetre6
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
