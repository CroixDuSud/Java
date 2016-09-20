package carrespanneaux;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import utilitairesMG.graphique.*;

/**
 *
 * @author afpa1800
 */
public class Panneau extends JPanel implements MouseListener {

    ArrayList<Carre> listeCarre = new ArrayList<>();

    Color couleur;
    Point location;

    public Panneau() {
        addMouseListener(this);
    }
    
    public void paintComponent(Graphics g)
    {
        int i;
           
        super.paintComponent(g);
        
        for(i = 0; i < listeCarre.size(); i++)
        {
            add(listeCarre.get(i));
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            int x = e.getX();
            int y = e.getY();
        
            Carre c = new Carre();
            c.setLocation(x, y);
            c.setBackground(Color.RED);
            c.setForeground(Color.BLUE);
            listeCarre.add(c);
            //repaint();
        }
        if(e.getButton() == MouseEvent.BUTTON3)
        {
            Carre c = (Carre)e.getComponent();
            location = c.getLocation(location);
            
            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();

        if (source == Fenetre.item1) {
            // code effacer carré (clear du vector)
        }

        if (source == Fenetre.item2) {
            JOptionPane fenAide = new JOptionPane();
            fenAide.showMessageDialog(null, "Clic gauche : ajout et déplacement"
                    + "\nClic droit : suppression"
                    + "\nRoulette : dimension carré",
                    "Fonctionnement du jeu", JOptionPane.INFORMATION_MESSAGE);

        }
    }
/*
    public Color getCouleurCarre() {
        return couleurCarre;
    }

    public int getTailleCarre() {
        return tailleCarre;
    }

    public void setCouleurCarre(Color couleurCarre) {
        this.couleurCarre = couleurCarre;
    }

    public void setTailleCarre(int tailleCarre) {
        this.tailleCarre = tailleCarre;
    }
*/
    //-------------------------------
    //      Méthodes de classe
    //-------------------------------
    public void dessineCarre(MouseEvent e) {
        Carre c = new Carre();
        c.setBounds(e.getX(), e.getY(), 30, 30);
        c.setForeground(Color.red);
    }

    public void effacerCarre() {

    }

    public void effacerPanneau() {

    }
}
