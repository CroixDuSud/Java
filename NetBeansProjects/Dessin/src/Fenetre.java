import javax.swing.*;
import java.awt.*;
import utilitairesMG.graphique.*;

/**
 *
 * @author afpa1800
 */
public class Fenetre extends JFrame{
    
    private Panneau panneauOuest;
    private Panneau panneauEst;

    public Fenetre(String s)
    {
    	super(s);
    	addWindowListener(new EcouteFenetre());

    	//-------------------------------------
        //		Creation des panneaux
  	//-------------------------------------
  	panneauOuest = new Panneau();
  	panneauOuest.setBackground(Color.white);
  	panneauOuest.setForeground(Color.blue);
  	panneauOuest.setPreferredSize(new Dimension(200,200));

  	panneauEst = new Panneau();
  	panneauEst.setBackground(Color.white);
  	panneauEst.setForeground(Color.red);
  	panneauEst.setPreferredSize(new Dimension(200,200));
        
  	//---------------------------------
  	// 	Ajout des panneaux à la fenetre
  	//---------------------------------

  	getContentPane().add(panneauOuest);
  	getContentPane().add(panneauEst);

  	pack();
  	setVisible(true);
    }
}
