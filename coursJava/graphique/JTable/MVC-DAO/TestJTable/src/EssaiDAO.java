// ==========================================================================
// Classe EssaiDAO                                                 TestJTable
// --------------------------------------------------------------------------
// Remplissage des objets listeLignes et listeColonnes
// ==========================================================================

import java.util.*;
import java.text.*;
import java.math.*;
import utilitairesMG.divers.*;


public class EssaiDAO
{

// --------------------------------------------------------------------------
// Creation de la liste des objets "Essai" a afficher dans la JTable
// --------------------------------------------------------------------------
   public static Vector<Vector<Object>> getListeLignes()
   {
      Vector<Vector<Object>> listeLignes = new Vector<Vector<Object>>();
      Vector<Object> ligne;

// --------------------------------------------------------------------------
// Ligne 0
// --------------------------------------------------------------------------
      ligne = new Vector<Object>();

      ligne.addElement(100L);
      ligne.addElement("GINESTE");
      ligne.addElement(3.14);
      try
      {
         ligne.addElement((new DateFr("08/11/2012")).getTime());
      }
      catch (ParseException e)
      {
         ligne.addElement(null);
      }
      ligne.addElement(true);
      ligne.addElement(new BigDecimal(3.01));

      listeLignes.addElement(ligne);

// --------------------------------------------------------------------------
// Ligne 1
// --------------------------------------------------------------------------
      ligne = new Vector<Object>();

      ligne.addElement(200L);
      ligne.addElement(null);
      ligne.addElement(2.71828);
      try
      {
         ligne.addElement((new DateFr("18/10/2012")).getTime());
      }
      catch (ParseException e)
      {
         ligne.addElement(null);
      }
      ligne.addElement(false);
      ligne.addElement(new BigDecimal(-173.175));

      listeLignes.addElement(ligne);

// --------------------------------------------------------------------------
// Ligne 2
// --------------------------------------------------------------------------
      ligne = new Vector<Object>();

      ligne.addElement(null);
      ligne.addElement("CREVURE PUANTE");
      ligne.addElement(17.1717);
      ligne.addElement(null);
      ligne.addElement(true);
      ligne.addElement(new BigDecimal(8888.888));

      listeLignes.addElement(ligne);

// --------------------------------------------------------------------------
// Ligne 3
// --------------------------------------------------------------------------
      ligne = new Vector<Object>();

      ligne.addElement(300L);
      ligne.addElement("FUMIER INFECT");
      ligne.addElement(null);
      try
      {
         ligne.addElement((new DateFr("31/03/2012")).getTime());
      }
      catch (ParseException e)
      {
         ligne.addElement(null);
      }
      ligne.addElement(false);
      ligne.addElement(new BigDecimal(7575.7578));

      listeLignes.addElement(ligne);


      return listeLignes;
   }

// --------------------------------------------------------------------------
// Creation de la liste des colonnes a afficher dans la JTable
// --------------------------------------------------------------------------
   public static Vector<Colonne> getListeColonnes()
   {
      Vector<Colonne> listeColonnes = new Vector<Colonne>();

// --------------------------------------------------------------------------
// Creation du vecteur des colonnes
// --------------------------------------------------------------------------

      listeColonnes.addElement(
         new Colonne("LONG", new Integer(10), "java.lang.Long"));

      listeColonnes.addElement(
         new Colonne("STRING", new Integer(50), "java.lang.String"));

      listeColonnes.addElement(
         new Colonne("DOUBLE", new Integer(15), "java.lang.Double"));

      listeColonnes.addElement(
         new Colonne("DATE", new Integer(30), "java.util.Date"));

      listeColonnes.addElement(
         new Colonne("BOOLEAN", new Integer(5), "java.lang.Boolean"));

      listeColonnes.addElement(
         new Colonne("BIGDECIMAL", new Integer(15), "java.math.BigDecimal"));

      return listeColonnes;
   }
}