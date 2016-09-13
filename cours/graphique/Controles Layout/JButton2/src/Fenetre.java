// ==========================================================================
// Classe Fenetre                                        Application JButton2
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame implements ActionListener
{
   private JPanel panneauFond;
   private JButton monBouton1;
   private JButton monBouton2;

   public Fenetre(String s)
   {
      super(s);
      addWindowListener(new EcouteFenetre());

// ---------------------------------------------------------------------
// Creation de l'objet panneauFond :
// ---------------------------------------------------------------------
      panneauFond = new JPanel();
      panneauFond.setBackground(Color.green);

      monBouton1 = new JButton("FUMIER");
      monBouton1.setFont(new Font("TimesRoman", Font.BOLD + Font.ITALIC, 16));

      monBouton2 = new JButton("CREVURE PUANTE");

      int maxWidth;
      int maxHeight;

      if ((monBouton1.getPreferredSize().width) >
          (monBouton2.getPreferredSize().width))
      {
         maxWidth = (monBouton1.getPreferredSize().width);
      }
      else
      {
         maxWidth = (monBouton2.getPreferredSize().width);
      }

      if ((monBouton1.getPreferredSize().height) >
          (monBouton2.getPreferredSize().height))
      {
         maxHeight = (monBouton1.getPreferredSize().height);
      }
      else
      {
         maxHeight= (monBouton2.getPreferredSize().height);
      }

      monBouton1.setPreferredSize(new Dimension(maxWidth, maxHeight));
      monBouton2.setPreferredSize(new Dimension(maxWidth, maxHeight));

      monBouton1.addActionListener(this);
      monBouton2.addActionListener(this);

      panneauFond.add(monBouton1);
      panneauFond.add(monBouton2);

      getContentPane().add(panneauFond);

      pack();
      setVisible(true);
   }


   public void actionPerformed(ActionEvent e)
   {
      System.out.println(e.getActionCommand());
   }
}