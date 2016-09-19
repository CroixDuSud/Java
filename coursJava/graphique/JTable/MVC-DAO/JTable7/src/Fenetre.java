// ==========================================================================
// Classe Fenetre                                         Application JTable7
// ==========================================================================

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import utilitairesMG.divers.*;
import utilitairesMG.graphique.table.*;

public class Fenetre extends JFrame
{
   private JPanel panneauFond;

   private JTable table;
   private ModeleTableContact modeleTable;
   private ModeleColonneTable modeleColonne;

   private JScrollPane defileur;                               
   
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public Fenetre(String s, Vector<Contact> listeContacts, 
                            Vector<Colonne> listeColonnes)
   {
      super(s);
      addWindowListener(new EcouteWindowClosing());

// --------------------------------------------------------------------------
// Création de l'objet JPanel :
// --------------------------------------------------------------------------
      panneauFond = new JPanel();
      panneauFond.setLayout(new BorderLayout());
      panneauFond.setPreferredSize(new Dimension(650, 250));
      
// --------------------------------------------------------------------------
// Création de l'objet JTable :
// --------------------------------------------------------------------------
      table = new JTable();
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

// --------------------------------------------------------------------------
// Recherche de la largeur en nombre de points de la lettre M de la police
// par defaut de la JTable.
// --------------------------------------------------------------------------
      Font fontParDefaut = table.getFont();
      int tailleM = table.getFontMetrics(fontParDefaut).stringWidth("M");
      
// --------------------------------------------------------------------------
// Creation des modeles de table et de colonne. 
// --------------------------------------------------------------------------
      modeleTable = new ModeleTableContact(listeContacts, listeColonnes);
      modeleColonne = new ModeleColonneTable(listeColonnes, tailleM);

// --------------------------------------------------------------------------
// Changement de l'editeur de la colonne 5 (CodeSecteur)
// --------------------------------------------------------------------------
      JComboBox combo = new JComboBox();
      combo.addItem(null);
      for (int i = 1; i <= 4; i++)
      {
         combo.addItem(i);
      }
      
      DefaultCellEditor editeur = new DefaultCellEditor(combo);
      editeur.setClickCountToStart(2);
      
      modeleColonne.setEditeurColonne(5, editeur);

// --------------------------------------------------------------------------
// Ajout des modeles a la JTable. 
// --------------------------------------------------------------------------
      table.setModel(modeleTable);
      table.setColumnModel(modeleColonne);
      defileur = new JScrollPane(table);
      defileur.getViewport().setBackground(new Color(220, 170, 255));
      
      panneauFond.add(defileur);
      
      getContentPane().add(panneauFond);
      
      pack();
      setVisible(true);
   }
   
// --------------------------------------------------------------------------
// Ecouteur de l'evenement fermeture de la fenetre
// --------------------------------------------------------------------------
   private class EcouteWindowClosing extends WindowAdapter
   {
      public void windowClosing(WindowEvent e)
      {
         Controleur.arreter(modeleTable.getListeContacts(),
                            modeleTable.getListeContacts('M'),
                            modeleTable.getListeContacts('I'));
      }
   }
}