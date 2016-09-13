// ==========================================================================
// package utilitairesMG.graphique.impression
// --------------------------------------------------------------------------
// Classe DialogueApercu
// --------------------------------------------------------------------------
// JDialog qui permet d'afficher un apercu d'un livre (Book) a imprimer.
// ==========================================================================

package utilitairesMG.graphique.impression;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.swing.*;


public class DialogueApercu extends JDialog implements ActionListener
{
   
   private JPanel panneauFond;
   
   private JPanel panneauHaut;
   private JPanel panneauGauche;
   private JPanel panneauDroit;
   
   private PanneauPageBook panneauApercu;
   
   private JPanel panneauBoutons;
   private JButton boutonSuivant;
   private JButton boutonPrecedent;
   
   private JFrame proprietaire;
   
  
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
// Le dialogue est appele a partir d'une fenetre (Frame ou JFrame)
// --------------------------------------------------------------------------
   public DialogueApercu(JFrame proprietaire, Book livre)
   {
      
// --------------------------------------------------------------------------
// Appel du constructeur de JDialog :
// --------------------------------------------------------------------------
// Premier parametre  : fenetre a partir de laquelle le dialogue est appelle
// Deuxieme parametre : titre de la fenetre-dialogue
// Toisieme parametre : si true, on ne peut plus interagir avec la fenetre
// --------------------------------------------------------------------------
// On pourrait aussi appeler :
//    super(proprietaire, "Aperçu", Dialog.ModalityType.APPLICATION_MODAL);
// --------------------------------------------------------------------------
      super(proprietaire, "Aperçu", true);

      setPreferredSize(proprietaire.getSize());
      
      panneauFond = new JPanel();
      panneauFond.setLayout(new BorderLayout());
      
      panneauHaut = new JPanel();
      panneauHaut.setBackground(Color.blue);
      
      panneauGauche = new JPanel();
      panneauGauche.setBackground(Color.blue);
      
      panneauDroit = new JPanel();
      panneauDroit.setBackground(Color.blue);
      
      panneauApercu = new PanneauPageBook(livre);
      panneauApercu.setBackground(Color.blue);
      
      panneauBoutons = new JPanel();
      panneauBoutons.setBackground(Color.blue);
      
      boutonSuivant = new JButton("Suivant");
      boutonSuivant.addActionListener(this);
      
      boutonPrecedent = new JButton("Précédent");
      boutonPrecedent.addActionListener(this);
      
      panneauBoutons.add(boutonPrecedent);
      panneauBoutons.add(boutonSuivant);
      
      panneauFond.add(panneauHaut, BorderLayout.NORTH);
      panneauFond.add(panneauGauche, BorderLayout.EAST);
      panneauFond.add(panneauDroit, BorderLayout.WEST);
      panneauFond.add(panneauApercu);
      panneauFond.add(panneauBoutons, BorderLayout.SOUTH);
      
      getContentPane().add(panneauFond);
      
      setLocation(proprietaire.getLocation());
      pack();
   }

// --------------------------------------------------------------------------
// Actions sur les boutons du panneau
// --------------------------------------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == boutonSuivant)
      {
         panneauApercu.pageSuivante();
      }
      else
      {
         panneauApercu.pagePrecedente();
      }
   }
}