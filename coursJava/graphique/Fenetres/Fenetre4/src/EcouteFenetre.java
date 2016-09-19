// ==========================================================================
// Classe EcouteFenetre                                  Application Fenetre4
// --------------------------------------------------------------------------
// Meme classe que pour Fenetre3.
// Suppression de tous les System.out.println()
// ==========================================================================

import java.awt.event.*;

public class EcouteFenetre implements WindowListener
{

// --------------------------------------------------------------------------
// Appelee quand l'utilisateur ferme la fenetre.
// --------------------------------------------------------------------------
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

// --------------------------------------------------------------------------
// La fenetre est rendue active : cette methode s'execute.
// --------------------------------------------------------------------------
    public void windowActivated(WindowEvent e)
    {
    }

// --------------------------------------------------------------------------
// La fenetre est fermee par programme.
// Par exemple : appel de la methode dispose() de la classe Window
// --------------------------------------------------------------------------
    public void windowClosed(WindowEvent e)
    {
    }

// --------------------------------------------------------------------------
// La fenetre est rendue inactive : cette methode s'execute.
// --------------------------------------------------------------------------
    public void windowDeactivated(WindowEvent e)
    {
    }

// --------------------------------------------------------------------------
// Appelee quand l'utilisateur clique sur l'icone.
// --------------------------------------------------------------------------
    public void windowDeiconified(WindowEvent e)
    {
    }

// --------------------------------------------------------------------------
// Appelee quand l'utilisateur reduit la fenetre en icone.
// --------------------------------------------------------------------------
    public void windowIconified(WindowEvent e)
    {
    }

// --------------------------------------------------------------------------
// Appelee quand la fenetre devient pour la premiere fois visible.
// setVisible() provoque l'execution de cette methode, precedee de
// l'execution de windowActivated().
// --------------------------------------------------------------------------
    public void windowOpened(WindowEvent e)
    {
    }
}
