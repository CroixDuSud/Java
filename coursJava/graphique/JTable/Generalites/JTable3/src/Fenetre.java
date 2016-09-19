// ==========================================================================
// Classe Fenetre                                         Application JTable3
// ==========================================================================

import javax.swing.*;
import java.util.*;
import java.awt.*;
import utilitairesMG.graphique.*;
import utilitairesMG.divers.*;

public class Fenetre extends JFrame
{
   private JPanel panneauFond;
   
   private JTable table;
   private ModeleTable modeleTable;
   
   private JScrollPane defileur;                               

   
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public Fenetre(String s, Vector<Vector<Object>> listeLignes, 
                            Vector<Colonne> listeColonnes)
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
      modeleTable = new ModeleTable(listeLignes, listeColonnes);
      table = new JTable(modeleTable);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      defileur = new JScrollPane(table);
      defileur.getViewport().setBackground(new Color(190, 250, 130));
      
      panneauFond.add(defileur);
      
      getContentPane().add(panneauFond);
      
      pack();
      setVisible(true);
   }
}