// ==========================================================================
// Classe Fenetre                                         Application JTable7
// ==========================================================================
package gestioncontactlocal;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import utilitairesMG.divers.*;
import utilitairesMG.graphique.table.*;

public class Fenetre extends JFrame implements ActionListener{

    private JPanel panneauFond;

    private JTable table;
    private ModeleTableContact modeleTable;
    private ModeleColonneTable modeleColonne;

    private JScrollPane defileur;

    private JMenuBar barreMenu;
    private JMenu menuPrincipal;
    private JMenuItem contactItem;
    private JMenuItem versementItem;
    private JMenuItem secteurItem;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public Fenetre(String s, Vector<Contact> listeContacts,
            Vector<Colonne> listeColonnes) {
        super(s);
        addWindowListener(new EcouteWindowClosing());

// --------------------------------------------------------------------------
// Création de l'objet JPanel :
// --------------------------------------------------------------------------
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        panneauFond.setPreferredSize(new Dimension(650, 250));

// --------------------------------------------------------------------------
// Création du menu "menuPrincipal
// --------------------------------------------------------------------------
        barreMenu = new JMenuBar();
        menuPrincipal = new JMenu("Tables");
        menuPrincipal.setMnemonic('T');
        contactItem = new JMenuItem("Contact");
        contactItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_C, ActionEvent.ALT_MASK));
        versementItem = new JMenuItem("Versement");
        versementItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_V, ActionEvent.ALT_MASK));
        secteurItem = new JMenuItem("Secteur");
        secteurItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_S, ActionEvent.ALT_MASK));
        
        contactItem.addActionListener(this);
        versementItem.addActionListener(this);
        secteurItem.addActionListener(this);
        
        menuPrincipal.add(contactItem);
        menuPrincipal.add(versementItem);
        menuPrincipal.add(secteurItem);
        
        setJMenuBar(barreMenu);
        
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
        for (int i = 1; i <= 4; i++) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        
        if(source == versementItem)
        {
            JOptionPane.showMessageDialog(null,
                    "Gestion des versements non réalisée",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else if(source == contactItem)
        {
            JDesktopPane conteneur = new JDesktopPane();
            JInternalFrame iFenetre = new JInternalFrame("CONTACTS");
            JPanel iPanneauFond = new JPanel();
            JScrollPane iDefileur = new JScrollPane(iPanneauFond);
            iFenetre.setVisible(true);
            iFenetre.setSize(500,100);
            
        }
    }

// --------------------------------------------------------------------------
// Ecouteur de l'evenement fermeture de la fenetre
// --------------------------------------------------------------------------
    private class EcouteWindowClosing extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            Controleur.arreter(modeleTable.getListeContacts(),
                    modeleTable.getListeContacts('M'),
                    modeleTable.getListeContacts('I'));
        }
    }
}
