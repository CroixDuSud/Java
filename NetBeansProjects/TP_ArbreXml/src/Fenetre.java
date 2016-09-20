// ==========================================================================
// Classe Fenetre                                  Projet GestionContactLocal
// ==========================================================================

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

class Fenetre extends JFrame implements ActionListener
{

// --------------------------------------------------------------------------
// PROPRIETES
// --------------------------------------------------------------------------
// --------------------------------------------------------------------------
// Barre de menu
// --------------------------------------------------------------------------
    private JMenuBar barreMenu;
    private JMenu fichier;
    private JMenuItem ouvrir;
    private JMenuItem quitter;
    private JScrollPane defileur;

// --------------------------------------------------------------------------
// Zone de contenu de la fenetre
// --------------------------------------------------------------------------
    private JPanel panneauFond;
    private JTree arbre;

    private JLabel label;
    private JPanel panneauBas;

// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public Fenetre(String s)
    {
        super(s);
        addWindowListener(new EcouteWindowClosing());

// --------------------------------------------------------------------------
// Creation du menu de la fenetre
// --------------------------------------------------------------------------
        ouvrir = new JMenuItem("Ouvrir");
        ouvrir.setAccelerator(
                KeyStroke.getKeyStroke('O', InputEvent.ALT_MASK));
        quitter = new JMenuItem("Quitter");
        quitter.setAccelerator(
                KeyStroke.getKeyStroke('Q', InputEvent.ALT_MASK));

        ouvrir.addActionListener(this);
        quitter.addActionListener(this);

        fichier = new JMenu("Fichiers");
        fichier.add(ouvrir);
        fichier.add(quitter);

        barreMenu = new JMenuBar();
        barreMenu.add(fichier);

        setJMenuBar(barreMenu);

// --------------------------------------------------------------------------
// Zone de contenu de la fenetre
// --------------------------------------------------------------------------
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        panneauFond.setBackground(Color.GRAY);
        panneauFond.setPreferredSize(new Dimension(500, 300));
// --------------------------------------------------------------------------
// Cette option provoque l'affichage d'un rectangle et non de toute la
// fenetre lors du draggage de la fenetre. C'est moins beau mais ca va plus
// vite...
// --------------------------------------------------------------------------
        //panneauFenetres.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        
        panneauBas = new JPanel();
        panneauBas.setLayout(new BorderLayout());
        //defileur = new JScrollPane(panneauFond);
        
        label = new JLabel(" ");
        label.setForeground(Color.red);

        panneauBas.add(label);

        panneauFond.add(panneauBas, BorderLayout.SOUTH);
        //panneauFond.add(defileur);

        getContentPane().add(panneauFond);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

// --------------------------------------------------------------------------
// Traitement du menu
// --------------------------------------------------------------------------
    public void actionPerformed(ActionEvent e)
    {
        int confirmation;
        JFileChooser choixFichier;
        File fichierXml;

        if ((JMenuItem) e.getSource() == ouvrir)
        {
            choixFichier = new JFileChooser();
            choixFichier.setCurrentDirectory(new File("exemples"));
            choixFichier.setFileFilter(new FiltreFichiers());
            confirmation = choixFichier.showOpenDialog(this);

            if (confirmation == JFileChooser.APPROVE_OPTION)
            {
                fichierXml = choixFichier.getSelectedFile();
                TP_ArbreXml.litXml(fichierXml);
            }
        } else if ((JMenuItem) e.getSource() == quitter)
        {
            TP_ArbreXml.arreter();
        }
    }

// --------------------------------------------------------------------------
// Valider l'item Contact du menu (a la fermeture de la fenetre interne)
// --------------------------------------------------------------------------
    public void valideItemOuvrir()
    {
        ouvrir.setEnabled(true);
    }

    //-------------------------------------------------
    // Afficher l'arbre
    //-------------------------------------------------
    public void afficheArbre(Document documentDom)
    {
        if (defileur != null)
        {
            panneauFond.remove(arbre);
        }

        arbre = new JTree((new JTreeDom(documentDom)).getRacineJTreeDom());

        defileur = new JScrollPane(arbre);
        panneauFond.add(defileur);

        panneauFond.validate();
        panneauFond.repaint();

        //.setText(" ");
    }

// --------------------------------------------------------------------------
// Affichage d'un message 
// --------------------------------------------------------------------------
    public void afficheMessage(String message)
    {
        JOptionPane.showMessageDialog(this,
                message,
                "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

// --------------------------------------------------------------------------
// Ecouteur de l'evenement fermeture de la fenetre
// --------------------------------------------------------------------------
    private class EcouteWindowClosing extends WindowAdapter
    {

        public void windowClosing(WindowEvent e)
        {
            //setDefaultCloseOperation(Fenetre.EXIT_ON_CLOSE);
            TP_ArbreXml.arreter();
        }
    }
}
