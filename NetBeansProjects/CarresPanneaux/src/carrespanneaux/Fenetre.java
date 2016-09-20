// ==========================================================================
// Classe Fenetre                                         Application Dessin4
// ==========================================================================
package carrespanneaux;

import javax.swing.*;
import java.awt.*;
import utilitairesMG.graphique.*;

/**
 *
 * @author afpa1800
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilitairesMG.graphique.*;

/**
 *
 * @author afpa1800
 */
public class Fenetre extends JFrame implements ActionListener {

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu1 = new JMenu("Jeu");
    private JMenu menu2 = new JMenu("Couleur");
    public static JMenuItem item1 = new JMenuItem("Effacer");
    public static JMenuItem item2 = new JMenuItem("Aide");
    public JCheckBoxMenuItem cbItem1 = new JCheckBoxMenuItem("Rouge");
    public JCheckBoxMenuItem cbItem2 = new JCheckBoxMenuItem("Vert");
    public JCheckBoxMenuItem cbItem3 = new JCheckBoxMenuItem("Bleu");
    private Panneau mainPanel;

    public Fenetre(String s) {
        super(s);
        addWindowListener(new EcouteFenetre());

        //-------------------------------------
        //		Creation des panneaux
        //-------------------------------------
        mainPanel = new Panneau();
        mainPanel.setBackground(Color.orange);
        //mainPanel.setBackground(new Color(0, 0, 0, 0));
        mainPanel.setLayout(new FlowLayout());
        //mainPanel.setPreferredSize(380,380);

        //drawPanel = new Panneau();
        //drawPanel.setLayout(new FlowLayout());

        //-------------------------------------
        //		Creation des menus
        //-------------------------------------
        menu1.add(item1);
        //item1.addActionListener();
        menu1.addSeparator();
        menu1.add(item2);
        //item2.addActionListener();

        ButtonGroup bg = new ButtonGroup();
        bg.add(cbItem1);
        bg.add(cbItem2);
        bg.add(cbItem3);
        cbItem3.setSelected(true);

        menu2.add(cbItem1);
        menu2.add(cbItem2);
        menu2.add(cbItem3);

        menuBar.add(menu1);
        menuBar.add(menu2);

        //mainPanel.add(drawPanel);

        //---------------------------------
        // 	Ajout des panneaux à la fenetre
        //---------------------------------
        getContentPane().add(mainPanel);
        setPreferredSize(new Dimension(400, 400));
        setJMenuBar(menuBar);
        setVisible(true);
        //setDefaultLocationTo(null);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) e.getSource();

        if (source == item1) {
            // code effacer carré (clear du vector)
        }

        if (source == item2) {
            JOptionPane fenAide = new JOptionPane();
            fenAide.showMessageDialog(null, "Clic gauche : ajout et déplacement"
                    + "\nClic droit : suppression"
                    + "\nRoulette : dimension carré",
                    "Fonctionnement du jeu", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
