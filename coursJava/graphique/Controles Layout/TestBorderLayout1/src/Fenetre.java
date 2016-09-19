// ==========================================================================
// Classe Fenetre                               Application TestBorderLayout1
// ==========================================================================

import javax.swing.*; 
import java.awt.*;
import utilitairesMG.graphique.*;

// ==========================================================================
// Classe Fenetre
// ==========================================================================

public class Fenetre extends JFrame
{
   private JPanel panneauFond;
   
   private JPanel panneauNord;
   private JPanel panneauSud;
   private JPanel panneauEst;
   private JPanel panneauOuest;
   private JPanel panneauCentre;


   public Fenetre(String s)
   {
      super(s);
      addWindowListener(new EcouteFenetre());        

// ---------------------------------------------------------------------
// Creation de l'objet panneauFond et changement de son gestionnaire de
// layout :
// ---------------------------------------------------------------------
      panneauFond = new JPanel();
      panneauFond.setLayout(new BorderLayout());

// ---------------------------------------------------------------------
// Creation des objets Jpanel :
// ---------------------------------------------------------------------
      panneauNord = new JPanel();
      panneauNord.setBackground(Color.white);
      
      panneauSud = new JPanel();
      panneauSud.setBackground(Color.white);
 
      panneauEst = new JPanel();
      panneauEst.setBackground(Color.black);
      
      panneauOuest = new JPanel();
      panneauOuest.setBackground(Color.black);
      
      panneauCentre = new JPanel();
      panneauCentre.setBackground(Color.pink);
      
// ---------------------------------------------------------------------
// Ajout de ces panneaux au panneauFond :
// ---------------------------------------------------------------------
      panneauFond.add(panneauNord, BorderLayout.NORTH);
      panneauFond.add(panneauSud, BorderLayout.SOUTH);
      panneauFond.add(panneauEst, BorderLayout.EAST);
      panneauFond.add(panneauOuest, BorderLayout.WEST);
      panneauFond.add(panneauCentre, BorderLayout.CENTER);
      
      getContentPane().add(panneauFond);
      pack();

      System.out.println("Fenetre : ");
      System.out.println("Taille : " + getSize());
      System.out.println("Taille preferee : " + getPreferredSize());

      setVisible(true);
   }
}