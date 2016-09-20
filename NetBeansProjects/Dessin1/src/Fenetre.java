import javax.swing.*;
import java.awt.*;
import utilitairesMG.graphique.*;

/**
 *
 * @author afpa1800
 */
public class Fenetre extends JFrame{
    
    private Panneau panneauFond;

    public Fenetre(String s)
    {
    	super(s);
    	addWindowListener(new EcouteFenetre());

    	panneauFond = new Panneau();
    	panneauFond.setBackground(Color.YELLOW);
    	panneauFond.setPreferredSize(new Dimension(250,150));

    	getContentPane().add(panneauFond);
    	pack();
    	setVisible(true);
    }
}
