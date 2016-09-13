// ==========================================================================
// Classe Fenetre                                        Application Fenetre6
// --------------------------------------------------------------------------
// Classe Fenetre heritee de JFrame  ET  qui implemente l'interface
// WindowListener.
// --------------------------------------------------------------------------
// La classe Fenetre est son propre ecouteur (ce qu'on demande a la classe
// ecouteur, c'est de definir toutes les methodes de WindowListener...)
//
// La classe Fenetre doit implementer Windowlistener. Une classe ne pouvant
// deriver de deux classes, on ne peut faire de la classe fenetre un ecouteur
// avec WindowAdapter...
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements WindowListener
{

    public Fenetre(String titre)
    {
        super(titre);

        setBounds(100, 100, 300, 300);

        addWindowListener(this);
        setVisible(true);
    }

// --------------------------------------------------------------------------
// Methodes de Windowlistener
// --------------------------------------------------------------------------
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

    public void windowActivated(WindowEvent e)
    {
    }

    public void windowClosed(WindowEvent e)
    {
    }

    public void windowDeactivated(WindowEvent e)
    {
    }

    public void windowDeiconified(WindowEvent e)
    {
    }

    public void windowIconified(WindowEvent e)
    {
    }

    public void windowOpened(WindowEvent e)
    {
    }
}
