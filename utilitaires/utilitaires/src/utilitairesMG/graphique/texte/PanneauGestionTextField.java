// ==========================================================================
// package utilitairesMG.graphique.texte
// --------------------------------------------------------------------------
// Classe PanneauGestionTextField
// --------------------------------------------------------------------------
// Panneau qui ecoute le focus des composants, pour gerer les zones de saisie
// de texte (JTextField), sur lesquelles portent des controles (dates, zones
// numeriques).
// ==========================================================================

package utilitairesMG.graphique.texte;

import javax.swing.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.math.*;
import java.awt.event.*;


public class PanneauGestionTextField extends JPanel implements FocusListener,
                                                               ActionListener
{

// --------------------------------------------------------------------------
// PROPRIETE
// --------------------------------------------------------------------------
// Indique la reference de la zone de texte qui PREND le focus.
// Cette reference est initialisee quand la zone prend le focus, et est
// liberee (mise a null) quand la saisie est bonne.
// --------------------------------------------------------------------------
   private JTextField zoneTexteCourante = null;

// --------------------------------------------------------------------------
// METHODES
// --------------------------------------------------------------------------
// Gain du focus.
// --------------------------------------------------------------------------
// Si le composant qui prend le focus est un texte avec controle (classe
// heritee de JTextFieldMG), on note sa reference.
// --------------------------------------------------------------------------
   public void focusGained(FocusEvent e)
   {
      JComponent courant;

      courant = (JComponent)e.getSource();

      if (courant instanceof JTextFieldMG)
      {
         if (zoneTexteCourante == null) zoneTexteCourante = (JTextField)courant;
      }
   }

// --------------------------------------------------------------------------
// Perte du focus.
// --------------------------------------------------------------------------
// La zone de texte est verifiee, et le focus libere si c'est bon, et
// garde sinon.
// --------------------------------------------------------------------------
   public void focusLost(FocusEvent e)
   {
      JComponent courant;
      JComponent suivant;

      courant = (JComponent)e.getSource();
      suivant = (JComponent)e.getOppositeComponent();

// --------------------------------------------------------------------------
// La perte de focus ne se fait pas forcement au profit d'un autre composant
// (reduction de la fenetre en icone par exemple). Dans ce cas, la methode
// getOppositeComponent() retourne null...
// --------------------------------------------------------------------------
      if (suivant != null)
      {

// --------------------------------------------------------------------------
// Zone de texte 'Date'
// --------------------------------------------------------------------------
         if ((courant instanceof JTextFieldDate) && (courant == zoneTexteCourante))
         {
            JTextFieldDate champDate = (JTextFieldDate)courant;

            try
            {
               Date maDate = champDate.getDate();
               if (maDate != null)champDate.setDate(maDate);
               champDate.affichageNormal();
               zoneTexteCourante = null;
            }
            catch (ParseException ex)
            {
               champDate.affichageErreur();
               int position = ex.getErrorOffset();
               champDate.setCaretPosition(position);
               champDate.requestFocus();
            }
         }

// --------------------------------------------------------------------------
// Zone de texte 'Double'
// --------------------------------------------------------------------------
         if ((courant instanceof JTextFieldDouble) && (courant == zoneTexteCourante))
         {
            JTextFieldDouble champDouble= (JTextFieldDouble)courant;

            try
            {
               Double monDouble = champDouble.getDouble();
               if (monDouble != null)champDouble.setDouble(monDouble);
               champDouble.affichageNormal();
               zoneTexteCourante = null;
            }
            catch (NumberFormatException ex)
            {
               champDouble.affichageErreur();
               champDouble.requestFocus();
            }
         }

// --------------------------------------------------------------------------
// Zone de texte 'Long'
// --------------------------------------------------------------------------
         if ((courant instanceof JTextFieldLong) && (courant == zoneTexteCourante))
         {
            JTextFieldLong champLong = (JTextFieldLong)courant;

            try
            {
               Long monLong = champLong.getLong();
               if (monLong != null)champLong.setLong(monLong);
               champLong.affichageNormal();
               zoneTexteCourante = null;
            }
            catch (NumberFormatException ex)
            {
               champLong.affichageErreur();
               champLong.requestFocus();
            }
         }

// --------------------------------------------------------------------------
// Zone de texte 'BigDecimal'
// --------------------------------------------------------------------------
         if ((courant instanceof JTextFieldBigDecimal) && (courant == zoneTexteCourante))
         {
            JTextFieldBigDecimal champBigDecimal= (JTextFieldBigDecimal)courant;

            try
            {
               BigDecimal monBigDecimal = champBigDecimal.getBigDecimal();
               if (monBigDecimal != null)champBigDecimal.setBigDecimal(monBigDecimal);
               champBigDecimal.affichageNormal();
               zoneTexteCourante = null;
            }
            catch (NumberFormatException ex)
            {
               champBigDecimal.affichageErreur();
               champBigDecimal.requestFocus();
            }
         }
      }
   }

// --------------------------------------------------------------------------
// Validation de la zone.
// --------------------------------------------------------------------------
// Si c'est une zone de texte verifiee (JTextFieldMG), afficher la zone en
// erreur. La zone garde le focus.
// --------------------------------------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      JComponent courant;

      courant = (JComponent)e.getSource();

// --------------------------------------------------------------------------
// Zone de texte 'Date'
// --------------------------------------------------------------------------
      if (courant instanceof JTextFieldDate)
      {
         JTextFieldDate champDate = (JTextFieldDate)courant;

         try
         {
            Date maDate = champDate.getDate();
            if (maDate != null)champDate.setDate(maDate);
            champDate.affichageNormal();
         }
         catch (ParseException ex)
         {
            champDate.affichageErreur();
            int position = ex.getErrorOffset();
            champDate.setCaretPosition(position);
         }
      }

// --------------------------------------------------------------------------
// Zone de texte 'Double'
// --------------------------------------------------------------------------
      if (courant instanceof JTextFieldDouble)
      {
         JTextFieldDouble champDouble= (JTextFieldDouble)courant;

         try
         {
            Double monDouble = champDouble.getDouble();
            if (monDouble != null)champDouble.setDouble(monDouble);
            champDouble.affichageNormal();
         }
         catch (NumberFormatException ex)
         {
            champDouble.affichageErreur();
         }
      }

// --------------------------------------------------------------------------
// Zone de texte 'Long'
// --------------------------------------------------------------------------
      if (courant instanceof JTextFieldLong)
      {
         JTextFieldLong champLong = (JTextFieldLong)courant;

         try
         {
            Long monLong = champLong.getLong();
            if (monLong != null)champLong.setLong(monLong);
            champLong.affichageNormal();
         }
         catch (NumberFormatException ex)
         {
            champLong.affichageErreur();
         }
      }

// --------------------------------------------------------------------------
// Zone de texte 'BigDecimal'
// --------------------------------------------------------------------------
      if (courant instanceof JTextFieldBigDecimal)
      {
         JTextFieldBigDecimal champBigDecimal= (JTextFieldBigDecimal)courant;

         try
         {
            BigDecimal monBigDecimal = champBigDecimal.getBigDecimal();
            if (monBigDecimal != null)champBigDecimal.setBigDecimal(monBigDecimal);
            champBigDecimal.affichageNormal();
         }
         catch (NumberFormatException ex)
         {
            champBigDecimal.affichageErreur();
         }
      }
   }

// --------------------------------------------------------------------------
// Surcharge de la methode add() de Container.
// Cela permet d'ajouter l'ecouteur de focus lors du add.
// --------------------------------------------------------------------------
   public Component add(Component comp)
   {
      super.add(comp);
      comp.addFocusListener(this);
      if (comp instanceof JTextField)
      {
         ((JTextField)comp).addActionListener(this);
      }
      return comp;
   }
}
