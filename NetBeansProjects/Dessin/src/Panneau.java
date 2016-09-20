
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author afpa1800
 */
public class Panneau extends JPanel implements MouseListener {

    private int xr;
    private int xy;
    private boolean afficheRect = false;

    //----------------------------
    //	Constructeur
    //----------------------------
    public Panneau() {
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(Graphics g);
          	
            if (afficheRect) {
            g.fillRect(xr, xy, 10, 10);
            }
        //-------------------------------------
        // Methode de l'interface MouseListener
        //-------------------------------------

    public void mouseClicked(MouseEvent e) {
        //TODO 
    }

    public void mousePressed(MouseEvent e) {
        xr = e.getX();
        yr = e.getY();
        afficheRect = true;
        repaint();

            

    public void mouseReleased(MouseEvent) {

    }

    public void mouseEntered(MouseEvent) {

    }

    public void mouseExited(MouseEvent) {
        // TODO
    }
}
}
}
