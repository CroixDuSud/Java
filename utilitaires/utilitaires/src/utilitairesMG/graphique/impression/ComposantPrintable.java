// ==========================================================================
// package utilitairesMG.graphique.impression
// --------------------------------------------------------------------------
// Classe ComposantPrintable
// --------------------------------------------------------------------------
// Classe abstraite qui definit la methode print() d'un composant Printable.
// Pour creer un composant a imprimer  il suffira de redefinir les methodes
// specifiques au calcul du nombre de pages et au dessin graphique de chaque
// page.
// ==========================================================================

package utilitairesMG.graphique.impression;

import java.awt.*;
import java.awt.print.*;

public abstract class ComposantPrintable implements Printable
{

// --------------------------------------------------------------------------
// Methode d'impression appelee automatiquement par la methode print() de
// l'objet PrinterJob, pour chaque page a imprimer.
// --------------------------------------------------------------------------
   public int print(Graphics g, PageFormat pf, int page)
              throws PrinterException
   {
      if(page >= calculeNombrePages(g, pf))
      {
         return Printable.NO_SUCH_PAGE;
      }
      else
      {
         dessinePage(g, pf, page);
         return Printable.PAGE_EXISTS;
      }
   }

// --------------------------------------------------------------------------
// Calcul du nombre de pages du document a imprimer.
// --------------------------------------------------------------------------
// Depend du format choisi (taille et orientation de la page a imprimer) et
// des choix de presentation des elements graphiques (ici textes). La mise
// en page graphique se fait dans un contexte graphique.
// --------------------------------------------------------------------------
   public abstract int calculeNombrePages(Graphics g, PageFormat pf);

// --------------------------------------------------------------------------
// Methode de dessin
// --------------------------------------------------------------------------
   public abstract void dessinePage(Graphics g, PageFormat pf, int page);
}