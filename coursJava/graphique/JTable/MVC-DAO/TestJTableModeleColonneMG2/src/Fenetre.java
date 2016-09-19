// ==========================================================================
// Classe Fenetre                                                  TestJTable
// ==========================================================================

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import utilitairesMG.divers.*;
import utilitairesMG.graphique.table.*;

// ==========================================================================
// Classe Fenetre
// ==========================================================================
public class Fenetre extends JFrame
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
    private JPanel panneauFond;

    private JTable table;
    private ModeleTable modeleTable;
    private ModeleColonneTable modeleColonne;

    private JScrollPane defileur;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public Fenetre(String s, Vector<Vector<Object>> listeLignes,
        Vector<Colonne> listeColonnes)
    {
        super(s);
        addWindowListener(new EcouteWindowClosing());

// --------------------------------------------------------------------------
// Création de l'objet JPanel :
// --------------------------------------------------------------------------
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        panneauFond.setPreferredSize(new Dimension(800, 200));

// --------------------------------------------------------------------------
// Création du panneau contenant la JTable
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
// Creation du modele de table :
// --------------------------------------------------------------------------
// La classe ModeleTable offre un modele par defaut non editable.
// On peut utiliser une classe heritee de ModeleTable et surcharger les
// methodes qu'on veut pour modifier le comportement...
// --------------------------------------------------------------------------
// Exemple ici : ModeleTableEditable
// --------------------------------------------------------------------------
        modeleTable = new ModeleTableEditable();

        modeleTable.setListeLignes(listeLignes);
        modeleTable.setListeColonnes(listeColonnes);

// --------------------------------------------------------------------------
// Ajout du modele de table a la JTable
// --------------------------------------------------------------------------
        table.setModel(modeleTable);

// --------------------------------------------------------------------------
// Creation du modele de colonne.
// --------------------------------------------------------------------------
        modeleColonne = new ModeleColonneTable(listeColonnes, tailleM);

// --------------------------------------------------------------------------
// On souhaite changer l'editeur de cellules de la colonne 0
// --------------------------------------------------------------------------
        JComboBox combo = new JComboBox();

        combo.addItem(null);
        combo.addItem(new Long(100));
        combo.addItem(new Long(200));
        combo.addItem(new Long(300));
        combo.addItem(new Long(400));
        combo.addItem(new Long(500));
        combo.addItem(new Long(600));
        combo.addItem(new Long(700));
        combo.addItem(new Long(800));

        DefaultCellEditor editeur = new DefaultCellEditor(combo);
        editeur.setClickCountToStart(2);

        modeleColonne.setEditeurColonne(0, editeur);

// --------------------------------------------------------------------------
// On souhaite changer le rendu et l'edition de la colonne numero 3 (Date)
// --------------------------------------------------------------------------
        modeleColonne.setRenduColonne(3, new RenduDate("d MMMM yyyy"));
        modeleColonne.setEditeurColonne(3, new EditeurDate("d MMMM yyyy"));

// --------------------------------------------------------------------------
// On souhaite changer le rendu et l'edition de la colonne numero 5 (BigDecimal)
// --------------------------------------------------------------------------
      modeleColonne.setRenduColonne(5, new RenduBigDecimal(3, 1));
      modeleColonne.setEditeurColonne(5, new EditeurBigDecimal(3, 1));

// --------------------------------------------------------------------------
// Ajout du modele de colonne a la JTable
// --------------------------------------------------------------------------
        table.setColumnModel(modeleColonne);

        defileur = new JScrollPane(table);
        defileur.getViewport().setBackground(new Color(0, 100, 0));

        panneauFond.add(defileur);

        getContentPane().add(panneauFond);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

// --------------------------------------------------------------------------
// Ecouteur de l'evenement fermeture de la fenetre
// --------------------------------------------------------------------------
    private class EcouteWindowClosing extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            Controleur.arreter();
        }
    }
}
