// ==========================================================================
// Classe Fenetre                                  Projet GestionContactLocal
// ==========================================================================

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;


class FenetreClient extends JFrame implements ActionListener
{

// --------------------------------------------------------------------------
// PROPRIETES
// --------------------------------------------------------------------------
// --------------------------------------------------------------------------
// Zone de contenu de la fenetre
// --------------------------------------------------------------------------
    private JPanel panneauFond;
    private JPanel panneauCentre;
    private JPanel panneauNord;
    private JPanel panneauSud;
    private JButton bouton;
    private Icon vert = new ImageIcon("green-on.gif");
    private Icon rouge = new ImageIcon("green-off.gif");
    private JLabel titre;
    private JScrollPane defileur;
    private static JTextArea zoneDeTexte;

    static boolean display = false;

// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public FenetreClient(String s)
    {
        super(s);
        setAlwaysOnTop(true);
        addWindowListener(new EcouteWindowClosing());

// --------------------------------------------------------------------------
// Zone de contenu de la fenetre
// --------------------------------------------------------------------------
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        panneauFond.setBackground(new Color(0, 100, 150));
        //panneauFond.setPreferredSize(new Dimension(900, 600));

        //----------------------------------------------------------
        // Ajout de la barre de defilement au panneau central
        //----------------------------------------------------------
        //----------------------------------------------------------
        // Ajout des panneaux au panneau principal
        //----------------------------------------------------------
        panneauNord = new JPanel();
        panneauCentre = new JPanel();
        panneauSud = new JPanel();

        //panneauNord.setPreferredSize(new Dimension(900, 100));
        panneauCentre.setPreferredSize(new Dimension(880, 300));
        //panneauSud.setPreferredSize(new Dimension(900, 100));

        panneauNord.setBackground(new Color(0, 100, 150));
        panneauCentre.setBackground(Color.DARK_GRAY);
        panneauSud.setBackground(new Color(0, 100, 150));

        panneauFond.add(panneauNord, BorderLayout.NORTH);
        panneauFond.add(panneauCentre, BorderLayout.CENTER);
        panneauFond.add(panneauSud, BorderLayout.SOUTH);

        //-------------------------------------------
        // Gestion du panneau nord et de son label
        //-------------------------------------------
        titre = new JLabel("CLIENT JDBC");
        titre.setFont(new Font("Arial", Font.BOLD, 40));
        titre.setForeground(Color.WHITE);
        panneauNord.setLayout(new FlowLayout());
        panneauNord.add(titre);

        //-------------------------------------------
        // Gestion du panneau sud et de son bouton
        //-------------------------------------------
        bouton = new JButton("ON / OFF", rouge);
        bouton.addActionListener(this);
        bouton.setPreferredSize(new Dimension(115, 40));
        panneauSud.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panneauSud.add(bouton);

        //--------------------------------------------
        // Gestion du panneau central
        //--------------------------------------------
        panneauCentre.setLayout(new BorderLayout());

        //--------------------------------------------
        // Configuration de la zone de texte
        //--------------------------------------------
        zoneDeTexte = new JTextArea();
        zoneDeTexte.setEditable(false);
        zoneDeTexte.setForeground(Color.WHITE);
        zoneDeTexte.setBackground(Color.GRAY);
        //panneauCentre.add(zoneDeTexte);

        //----------------------------------------------------------
        // Ajout de la barre de defilement à la zone de texte
        //----------------------------------------------------------
        defileur = new JScrollPane(zoneDeTexte);
        panneauCentre.add(defileur);
        //defileur.setViewport(zoneDeTexte);

        // Sortie par défaut
        /*
        PrintStream printStream = new PrintStream(
                new CustomOutputStream(zoneDeTexte));
        System.setOut(printStream);
        System.setErr(printStream);
        PrintStream standardOut = System.out;
        PrintStream standardErr = System.err;
        */

        getContentPane().add(panneauFond);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

// --------------------------------------------------------------------------
// Traitement du menu
// --------------------------------------------------------------------------
    public void actionPerformed(ActionEvent e)
    {/*

        if ((JButton) e.getSource() == bouton && display == false)
        {
            try
            {
                ControleurServeur.connexion();
                display = true;
                bouton.setIcon(vert);
            } catch (IOException ex)
            {
                System.out.println("blablabla");
            }

        } else if ((JButton) e.getSource() == bouton && display == true)
        {
            try
            {
                ControleurServeur.deconnexion();
                display = false;
                bouton.setIcon(rouge);
            } catch (Exception ex)
            {
            }

        }*/
    }

// --------------------------------------------------------------------------
// Affichage d'un message 
// --------------------------------------------------------------------------
    public void afficheMessage(String message)
    {
        zoneDeTexte.append(message+"\n");
    }

// --------------------------------------------------------------------------
// Ecouteur de l'evenement fermeture de la fenetre
// --------------------------------------------------------------------------
    private class EcouteWindowClosing extends WindowAdapter
    {

        public void windowClosing(WindowEvent e)
        {
            //ControleurServeur.deconnexion();
            System.exit(0);
        }
    }
}
/*
class CustomOutputStream extends OutputStream
{

    private JTextArea textArea;

    public CustomOutputStream(JTextArea textArea)
    {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException
    {
        // redirects data to the text area
        textArea.append(String.valueOf((char) b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

}*/
