/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import utilitairesMG.divers.*;
import utilitairesMG.graphique.fenetreinterne.JDesktopPaneMG;
import utilitairesMG.graphique.table.*;

/**
 *
 * @author afpa1800
 */
public class Ifenetre extends JInternalFrame implements ActionListener, InternalFrameListener {

    //private JPanel panneauFond;

    private JTable table;
    private ModeleTableContact modeleTable;
    private ModeleColonneTable modeleColonne;
    
    private JMenuBar barreMenuContacts;
    private JMenu menuEdition;
    private JMenuItem supprimerItem;
    private JMenuItem restaurerItem;

    private JScrollPane defileur;
    

    public Ifenetre(String s, Vector<Contact> listeContacts,
            Vector<Colonne> listeColonnes) {
        super(s, true, true, true, true);
        addInternalFrameListener(this);
        
        
// --------------------------------------------------------------------------
// Création de l'objet JPanel
// --------------------------------------------------------------------------
/*
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        
        panneauFond.setPreferredSize(new Dimension(600, 250));
        
        panneauFond.setBackground(Color.GREEN);
        setVisible(true);
        //setSize(600,250);
        //setLocation(0, 0);
*/
// --------------------------------------------------------------------------
// Création du menu Edition de la fenêtre interne
// --------------------------------------------------------------------------
        // Initialisation du menu
        barreMenuContacts = new JMenuBar();
        menuEdition = new JMenu("Edition");
        menuEdition.setMnemonic('E');
        supprimerItem = new JMenuItem("Supprimer des lignes");
        restaurerItem = new JMenuItem("Restaurer les lignes supprimées");
        // Ecouteurs sur menuItem
        supprimerItem.addActionListener(this);
        restaurerItem.addActionListener(this);
        // Construction du menu
        menuEdition.add(supprimerItem);
        menuEdition.add(restaurerItem);
        barreMenuContacts.add(menuEdition);
        
        setJMenuBar(barreMenuContacts);
        
        
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

        defileur.getViewport().setBackground(Color.ORANGE);//new Color(220, 170, 255));
        
 // -------------------------------------------------------------------------
 //
 // -------------------------------------------------------------------------
 
        add(defileur);
        getContentPane().add(defileur);
        setPreferredSize(new Dimension(800, 180));
        setVisible(true);
        pack();
    }
    
    public void FermeContacts()
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        
        if(source == supprimerItem)
        {
            modeleTable.supprimer(table.getSelectedRows());
            repaint();
        }
        else
        {
            modeleTable.restaurer();
            repaint();
        }

    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        Controleur.appelFermetureFenetreInterne();
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        Controleur.decrireContacts(modeleTable.getListeContacts(),
                modeleTable.getListeContacts('M'),
                modeleTable.getListeContacts('I'),
                modeleTable.getListeContactsSupprimes());
        
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        
    }
    
    // --------------------------------------------------------------------------
    // Ecouteur de l'evenement fermeture de la fenetre
    // --------------------------------------------------------------------------
    
    private class EcouteWindowClosing extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
           Controleur.appelFermetureFenetreInterne();
        }
    }

}

