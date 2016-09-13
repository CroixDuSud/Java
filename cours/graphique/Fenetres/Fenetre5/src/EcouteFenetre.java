// ==========================================================================
// Classe EcouteFenetre                                  Application Fenetre5
// --------------------------------------------------------------------------
// Classe EcouteFenetre qui herite de la classe WindowAdapter.
// --------------------------------------------------------------------------
// WindowAdapter est une classe qui implemente l'interface WindowListener.
// Il suffira ici de redefinir uniquement les methodes qui nous interessent.
// Les autres n'ont aucune action (elles sont definies vides dans
// WindowAdapter).
// ==========================================================================

import java.awt.event.*;

public class EcouteFenetre extends WindowAdapter
{
// --------------------------------------------------------------------------
// Appelee quand l'utilisateur ferme la fenêtre
// --------------------------------------------------------------------------

    public void windowClosing(WindowEvent e)
    {
        System.out.println("windowClosing(event " + e.hashCode() + ")");
        System.exit(0);
    }
}
