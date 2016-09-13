// ==========================================================================
// Classe Fenetre                                         Application JTable5
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
}