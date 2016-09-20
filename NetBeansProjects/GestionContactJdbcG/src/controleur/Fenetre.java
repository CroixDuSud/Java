// ==========================================================================
// Classe Fenetre                                         Application JTable7
// ==========================================================================
package controleur;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import utilitairesMG.divers.*;
import utilitairesMG.graphique.EcouteFenetre;
import utilitairesMG.graphique.LF;
import utilitairesMG.graphique.fenetreinterne.JDesktopPaneMG;
import utilitairesMG.graphique.fenetreinterne.JScrollPaneMG;
import utilitairesMG.graphique.table.*;

public class Fenetre extends JFrame implements ActionListener{

    private JDesktopPaneMG panneauFond;

    private JScrollPaneMG defileur;

    private JMenuBar barreMenu;
    private JMenu menuTables;
    private JMenuItem contactItem;
    private JMenuItem versementItem;
    private JMenuItem secteurItem;
    
    private static Ifenetre fenetreContacts;
    
    private static int nbreFenetreInterne = 0;

    
    

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public Fenetre(String s) {
        super(s);
        addWindowListener(new CloseMainWindow());

// --------------------------------------------------------------------------
// Création de l'objet JPanel :
// --------------------------------------------------------------------------
        panneauFond = new JDesktopPaneMG();
        //panneauFond.setLayout(new BorderLayout());
        
        panneauFond.setBackground(new Color(0,100,150));

// --------------------------------------------------------------------------
// Création du menu "menuPrincipal
// --------------------------------------------------------------------------
        barreMenu = new JMenuBar();
        menuTables = new JMenu("Tables");
        menuTables.setMnemonic('T');
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
        
        menuTables.add(contactItem);
        menuTables.add(versementItem);
        menuTables.add(secteurItem);
        barreMenu.add(menuTables);
        
        setJMenuBar(barreMenu);
        


        defileur = new JScrollPaneMG(panneauFond);
        defileur.setPreferredSize(new Dimension(1024, 700));
        getContentPane().add(defileur);
           
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        
        if(source == versementItem)
        {
            Controleur.afficherMessageVersements();
        }
        else if(source == secteurItem)
        {
            Controleur.afficherMessageSecteur();
        }
        
        else
        {
            Controleur.recupContacts();
            
        }
    }
    
    
    public void afficheContacts(Vector<Contact> listeContacts,
            Vector<Colonne> listeColonne)
    {
       
        
        Ifenetre fenetreContacts = new Ifenetre("CONTACTS",
                listeContacts,
                listeColonne);
        
        panneauFond.add(fenetreContacts);
        contactItem.setEnabled(false);
        nbreFenetreInterne++;
    }
    public void reactiveContacts()
    {
        contactItem.setEnabled(true);
    }
    
    
    public void messageVersements()
    {
        JOptionPane.showMessageDialog(this,
                    "Gestion des versements non réalisée",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void messageSecteur()
    {
        JOptionPane.showMessageDialog(this,
                    "Gestion des secteurs non réalisée",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void fenetreInterneFermee()
    {
        nbreFenetreInterne--;
    }

// --------------------------------------------------------------------------
// Ecouteur de l'evenement fermeture de la fenetre
// --------------------------------------------------------------------------
    
    private class CloseMainWindow extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            if(nbreFenetreInterne > 0)
            {
                JOptionPane confirmQuitter = new JOptionPane();
                int option = confirmQuitter.showConfirmDialog(null,
                        "Voulez-vous vraiment quitter ?",
                        "Des fenetres sont encore actives !",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if(option == JOptionPane.OK_OPTION)
                {
                    Controleur.quitterProgramme();
                }
                else
                {
                    Controleur.annulerQuitter();
                }
            }
            else
            {
                Controleur.quitterProgramme();
            }
        }
    }
}
// fermeture classique
//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   