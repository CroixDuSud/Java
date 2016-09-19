// ==========================================================================
// Classe Fenetre                                         Application JTable2
// -------------------------------------------------------------------------- 
// Affichage d'une JTable dans la fenêtre, avec scrolling. La JTable est 
// construite a partir de 2 vecteurs.
// ==========================================================================

import javax.swing.*; 
import java.util.*; 
import java.awt.*;
import utilitairesMG.graphique.*;


// ==========================================================================
// Classe Fenetre
// ==========================================================================

public class Fenetre extends JFrame
{
   private JPanel panneauFond;
   private JTable table;
   private JScrollPane defileur;                               

   
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public Fenetre(String s, Vector<Vector<Object>> listeLignes, 
                            Vector<String> listeColonnes)
   {
      super(s);
      addWindowListener(new EcouteFenetre());

// --------------------------------------------------------------------------
// Création de l'objet JPanel :
// --------------------------------------------------------------------------
      panneauFond = new JPanel();
      panneauFond.setLayout(new BorderLayout());
      panneauFond.setPreferredSize(new Dimension(650, 250));
      
// --------------------------------------------------------------------------
// Création de l'objet JTable :
// --------------------------------------------------------------------------
      table = new JTable(listeLignes, listeColonnes);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      defileur = new JScrollPane(table);
      defileur.getViewport().setBackground(Color.pink);
      
      panneauFond.add(defileur);
      
      getContentPane().add(panneauFond);
      
      pack();
      setVisible(true);
   }
}