// ==========================================================================
// Classe Fenetre                                         Application JTable1
// -------------------------------------------------------------------------- 
// On dispose de 3 composants : un JPanel, une JTable et un JScrollPane.
// -------------------------------------------------------------------------- 
// Premiere idee : 
// mettre la JTable dans le JPanel, puis le JPanel dans le JScrollPane. Dans 
// ce cas, on DOIT gerer le JPanel en BorderLayout, et mettre les entetes de 
// colonnes en NORTH et le reste de la table en CENTER. Le resultat n'est pas 
// encore fameux, car la table va occuper toute la largeur du panneau, et les
// colonnes vont changer de taille de facon intempestive...
// -------------------------------------------------------------------------- 
// DEUXIEME IDEE : (La BONNE !)
// mettre la JTable dans le JScrollPane, puis le JScrollPane dans le JPanel. 
// Il faut malgre tout veiller a mettre le JScrollPane dans une zone du 
// JPanel de taille variable (zone centre d'un BorderLayout par exemple, mais
// aussi une case de GridLayout...). Ainsi : le composant passe au 
// JScrollPane (ici la JTable) a une taille. Le JScrollPane aussi... Quand la 
// fenetre change de taille, le defileur aussi, mais pas la JTable ==>
// apparition du scrolling. De meme, si on redimensionne la JTable (augmenter
// la largeur des colonnes par exemple), on deborde du defileur ==> 
// apparition du scrolling.
// ==========================================================================

import javax.swing.*;
import java.util.*;
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame
{
   private JPanel panneauFond;
   private JTable table;
   private JScrollPane defileur;                               
      
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public Fenetre(String s)
   {
      super(s);
      addWindowListener(new EcouteFenetre());

// --------------------------------------------------------------------------
// Création de l'objet JPanel :
// --------------------------------------------------------------------------
      panneauFond = new JPanel();

// --------------------------------------------------------------------------
// Si on ne met pas cette instruction de changement de Layout, le Layout par
// defaut du JPanel est FlowLayout...
// --------------------------------------------------------------------------
// Quand on met un defileur (JScrollPane) sur un panneau en FlowLayout, quand
// la fenetre est redimensionnee, le defileur change de place, mais pas de
// taille... Le scrolling n'apparait jamais...
// --------------------------------------------------------------------------
      panneauFond.setLayout(new BorderLayout());
      panneauFond.setPreferredSize(new Dimension(650, 250));
      
// -------------------------------------------------------------------------- 
// Creation des vecteurs des donnees a afficher.
// -------------------------------------------------------------------------- 
      Vector<Vector<Object>> listeLignes = getListeLignes();
      Vector<String> listeColonnes = getListeColonnes();

// --------------------------------------------------------------------------
// Création de l'objet JTable :
// --------------------------------------------------------------------------
// L'appel de la methode setAutoResizeMode(JTable.AUTO_RESIZE_OFF) permet
// d'eviter le changement automatique de taille des colonnes quand le 
// defileur change de taille. Sans cette instruction, le scrolling horizontal
// n'apparait pas...
// --------------------------------------------------------------------------
      table = new JTable(listeLignes, listeColonnes);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      defileur = new JScrollPane(table);
      defileur.getViewport().setBackground(new Color(130, 0, 60));
      
      panneauFond.add(defileur);
      
      getContentPane().add(panneauFond);
      
      pack();
      setVisible(true);
   }
  
// -------------------------------------------------------------------------- 
// Creation de la liste des lignes a afficher dans la JTable
// -------------------------------------------------------------------------- 
// Remarque : listeLignes est un vecteur de vecteurs...
// -------------------------------------------------------------------------- 
   public static Vector<Vector<Object>> getListeLignes()
   {
      Vector<Vector<Object>> listeLignes = new Vector<Vector<Object>>();
      Vector<Object> donneesLigne;
      
      donneesLigne = new Vector<Object>();
      donneesLigne.addElement(new Integer(100));
      donneesLigne.addElement("GINESTE");
      donneesLigne.addElement("Rue Barbe");
      donneesLigne.addElement("94000");
      donneesLigne.addElement("CRETEIL");
      donneesLigne.addElement(new Integer(1));
      
      listeLignes.addElement(donneesLigne);

      donneesLigne = new Vector<Object>();
      donneesLigne.addElement(new Integer(101));
      donneesLigne.addElement("GIROUD");
      donneesLigne.addElement("Avenue du merdier");
      donneesLigne.addElement("94100");
      donneesLigne.addElement("SAINT MAUR");
      donneesLigne.addElement(new Integer(3));
      
      listeLignes.addElement(donneesLigne);

      donneesLigne = new Vector<Object>();
      donneesLigne.addElement(new Integer(103));
      donneesLigne.addElement("FIEVET");
      donneesLigne.addElement("Rue Aristide Dufumier");
      donneesLigne.addElement("92120");
      donneesLigne.addElement("VANVES");
      donneesLigne.addElement(new Integer(3));
      
      listeLignes.addElement(donneesLigne);
      
      return listeLignes;
   }

// -------------------------------------------------------------------------- 
// Creation de la liste des colonnes a afficher dans la JTable
// -------------------------------------------------------------------------- 
   public static Vector<String> getListeColonnes()
   {
      Vector<String> listeColonnes = new Vector<String>();
      
      listeColonnes.addElement("NUMERO");
      listeColonnes.addElement("NOM");
      listeColonnes.addElement("ADRESSE");
      listeColonnes.addElement("CODE_POSTAL");
      listeColonnes.addElement("VILLE");
      listeColonnes.addElement("CODE_SECTEUR");
      
      return listeColonnes;
   }
}