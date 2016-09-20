/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author afpa1800
 */
public class Fenetre extends JFrame implements ActionListener
{

    private Panneau panneau;

    public Fenetre(String s)
    {
        super(s);
        setAlwaysOnTop(true);
        addWindowListener(new EcouteWindowClosing());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class EcouteWindowClosing extends WindowAdapter
    {

        public void windowClosing(WindowEvent e)
        {
            //ParisSportif.deconnexion();
            System.exit(0);
        }
    }
}
