// ==========================================================================
// package utilitairesMG.graphique.impression
// --------------------------------------------------------------------------
// Classe PanneauPageBook
// --------------------------------------------------------------------------
// Panneau qui permet de presenter une page d'un livre (Book). 
// ==========================================================================

package utilitairesMG.graphique.impression;

import java.awt.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.swing.*;


public class PanneauPageBook extends JPanel
{
   private Book livre;
   private int page;
   
// --------------------------------------------------------------------------
// CONSTRUCTEURS
// --------------------------------------------------------------------------
// La creation du livre (Book) se fait au moment de la demande d'impression
// ou de la demande d'apercu. Cette creation necessite en effet de connaitre
// le format d'affichage (PageFormat). Ce format peut etre modifie avant
// ces affichages...  
// --------------------------------------------------------------------------
// Le constructeur vide se justifie si le panneau doit etre cree avant la
// creation du livre. C'est au moment de l'affichage du livre qu'on lui
// passera le livre par la methode setLivre(Book livre).
// --------------------------------------------------------------------------
// Le deuxieme constructeur utilise un livre deja cree. C'est par exemple le 
// cas quand on cree un composant graphique de type JDialog pour afficher un 
// apercu. Dans le constructeur de ce JDialog, il y a une instanciation d'un 
// nouveau panneau, qui peut alors recevoir le livre en parametre.
// --------------------------------------------------------------------------
   public PanneauPageBook()
   {
   }
   
   public PanneauPageBook(Book livre)
   {
      this.livre = livre;
      page = 0;
   }
   
// --------------------------------------------------------------------------
// METHODES
// --------------------------------------------------------------------------
   public void setLivre(Book livre)
   {
      this.livre = livre;
      page = 0;
   }
   
// --------------------------------------------------------------------------
// Affichage du panneau
// --------------------------------------------------------------------------
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      if (livre != null)
      {

// --------------------------------------------------------------------------
// On va utiliser des methodes de Graphics2D : scale, fill...
// --------------------------------------------------------------------------
         Graphics2D g2 = (Graphics2D) g;

// --------------------------------------------------------------------------
// Taille reelle du panneau au moment du paintComponent
// --------------------------------------------------------------------------
         Dimension taillePanneau = getSize();
         int wPanneau = taillePanneau.width;
         int hPanneau = taillePanneau.height;
         
// --------------------------------------------------------------------------
// Calcul du ratio hauteur largeur de l'image (page a imprimer)
// --------------------------------------------------------------------------
         PageFormat formatPage = livre.getPageFormat(page);
         float ratioHauteurLargeurImg = (float)formatPage.getHeight() / 
                                        (float)formatPage.getWidth();
         
         int wImage, hImage;

         wImage = wPanneau;
         hImage = (int)(wImage * ratioHauteurLargeurImg);
      
         if (hImage > hPanneau)
         {
            hImage = hPanneau;
            wImage = (int)(hImage / ratioHauteurLargeurImg);
         }

// --------------------------------------------------------------------------
// On positionne l'image au centre du panneau
// --------------------------------------------------------------------------
         int posX = (wPanneau - wImage) / 2;
         int posY = (hPanneau - hImage) / 2;
         
         double echelle = (double)wImage / (double)formatPage.getWidth();
         
// --------------------------------------------------------------------------
// Translation des coordonnees d'origine pour les dessins (ex : g2.fill())
// --------------------------------------------------------------------------
         g2.translate(posX, posY);

// --------------------------------------------------------------------------
// Modification des dimensions des dessins en fonction de l'echelle
// --------------------------------------------------------------------------
         g2.scale(echelle, echelle);
         
         Rectangle2D feuille = new Rectangle2D.Double(0, 0, 
                                                      formatPage.getWidth(), 
                                                      formatPage.getHeight());

// --------------------------------------------------------------------------
// Affichage de la feuille blanche
// --------------------------------------------------------------------------
         g2.setColor(Color.white);
         g2.fill(feuille);
         
// --------------------------------------------------------------------------
// Recuperation de la page a imprimer, qui est objet de type Printable. Cet 
// objet, specifique a chaque impression, est de type ComposantGraphique.
// --------------------------------------------------------------------------
         Printable printable = livre.getPrintable(page);
         try
         {
            printable.print(g2, formatPage, page);
         }
         catch(PrinterException e)
         {
         }
      }
   }
   
// --------------------------------------------------------------------------
// Affichage de la page suivante du livre
// --------------------------------------------------------------------------
   public void pageSuivante()
   {
      if (page < livre.getNumberOfPages() - 1) page++;
      repaint();
   }
   
// --------------------------------------------------------------------------
// Affichage de la page precedente du livre
// --------------------------------------------------------------------------
   public void pagePrecedente()
   {
      if (page > 0) page--;
      repaint();
   }
}