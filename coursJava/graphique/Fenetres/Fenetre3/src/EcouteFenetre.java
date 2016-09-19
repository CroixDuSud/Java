// ==========================================================================
// Classe EcouteFenetre                                  Application Fenetre3
// --------------------------------------------------------------------------
// Implementation de l'interface WindowListener. Toutes les methodes de
// l'interface doivent donc être redefinies (meme vides).
// ==========================================================================

import java.awt.event.*;

public class EcouteFenetre implements WindowListener
{

// --------------------------------------------------------------------------
// Appelee quand l'utilisateur ferme la fenetre.
// --------------------------------------------------------------------------
    public void windowClosing(WindowEvent e)
    {
        System.out.println("windowClosing(event " + e.hashCode() + ")");
        System.exit(0);
    }

// --------------------------------------------------------------------------
// La fenetre est rendue active : cette methode s'execute.
// --------------------------------------------------------------------------
    public void windowActivated(WindowEvent e)
    {
        System.out.println("windowActivated(Event " + e.hashCode() + ")");
    }

// --------------------------------------------------------------------------
// La fenetre est fermee par programme.
// Par exemple : appel de la methode dispose() de la classe Window
// --------------------------------------------------------------------------
    public void windowClosed(WindowEvent e)
    {
        System.out.println("windowClosed(Event " + e.hashCode() + ")");
    }

// --------------------------------------------------------------------------
// La fenetre est rendue inactive : cette methode s'execute.
// --------------------------------------------------------------------------
    public void windowDeactivated(WindowEvent e)
    {
        System.out.println("windowDeactivated(Event " + e.hashCode() + ")");
    }

// --------------------------------------------------------------------------
// Appelee quand l'utilisateur clique sur l'icone.
// --------------------------------------------------------------------------
    public void windowDeiconified(WindowEvent e)
    {
        System.out.println("windowDeiconified(Event " + e.hashCode() + ")");
    }

// --------------------------------------------------------------------------
// Appelee quand l'utilisateur reduit la fenetre en icone.
// --------------------------------------------------------------------------
    public void windowIconified(WindowEvent e)
    {
        System.out.println("windowIconified(Event " + e.hashCode() + ")");
    }

// --------------------------------------------------------------------------
// Appelee quand la fenetre devient pour la premiere fois visible.
// setVisible() provoque l'execution de cette methode, precedee de
// l'execution de windowActivated().
// --------------------------------------------------------------------------
    public void windowOpened(WindowEvent e)
    {
        System.out.println("windowOpened(Event " + e.hashCode() + ")");
    }
}
