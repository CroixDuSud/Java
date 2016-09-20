
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import utilitairesMG.graphique.table.ModeleColonneTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author afpa1800
 */
public class FenetreInterneSecteur extends JInternalFrame
        implements ActionListener {
    
// --------------------------------------------------------------------------
// Barre de menu de la fenetre interne
// --------------------------------------------------------------------------

    private JMenuBar barreMenu;
    private JMenu menuEdition;
    private JMenuItem supprimerLignesItem;
    private JMenuItem restaurerLignesItem;

// --------------------------------------------------------------------------
// Zone de contenu de la fenetre
// --------------------------------------------------------------------------
    private JPanel panneauFond;

    private JTable table;
    private ModeleTableContact modeleTable;
    private ModeleColonneTable modeleColonne;

    private JScrollPane defileur;

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
