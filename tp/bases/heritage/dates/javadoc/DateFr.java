// ==========================================================================
// DateFr : classe de dates en notation francaise
// ==========================================================================

import java.util.*;
import java.text.*;

/**Cette classe permet d'ajouter des méthodes  à la classe GregorianCalendar. 
  *<br>Il sera possible d'initialiser (constructeur) ou de mettre à jour (set) 
  *la date de l'objet à l'aide d'une variable de type String contenant une 
  *date. <br>Il sera possible de visualiser (toString) la date de l'objet en 
  *utilisant un format. Ce format est initialisé par défaut à dd/MM/yyyy.
  *<br>Il sera possible de modifier ce format (setFormat) et de le visualiser
  *(toFormat).<br>Une méthode permet de calculer le nombre de JOURS écoulés 
  *entre deux dates (difDates).
  *<br>Les formats utilisés sont décrits dans la classe Calendar.
  * @author Michel GINESTE
  * @version 2012.11
*/  

public class DateFr extends GregorianCalendar
{
   private SimpleDateFormat formatDateFr;
   
// --------------------------------------------------------------------------
// Constructeurs :
// --------------------------------------------------------------------------
// Ces constructeurs initialisent le format de dates par defaut a dd/MM/yyyy
// La date initiale transmise au second devra donc respecter ce format. A 
// defaut, il y aura une exception ParseException.
// --------------------------------------------------------------------------

/**Construit un objet DateFr, initialisé avec la date et l'heure système. 
*/
   public DateFr()
   {
      formatDateFr = new SimpleDateFormat("dd/MM/yyyy");  
   }

/**
  *Construit un objet DateFr, initialisé avec la date indiquée dans le 
  *paramètre dateInitiale.<br>Le format de la chaîne doit être dd/MM/yyyy 
  *(exemple : 01/03/2012). 
*/
   public DateFr(String dateInitiale) throws ParseException
   {
      formatDateFr = new SimpleDateFormat("dd/MM/yyyy");  
      setTime(formatDateFr.parse(dateInitiale));
   }

// --------------------------------------------------------------------------
// Modification de la date contenue dans l'objet courant.
// --------------------------------------------------------------------------
// Cette methode s'ajoute a toutes les methodes set() contenues dans la 
// classe Calendar.
// --------------------------------------------------------------------------

/**
  *Modifie la date de l'objet courant.
*/  
   public void set(String nouvelleDate) throws ParseException
   {
      setTime(formatDateFr.parse(nouvelleDate));
   }
   
// --------------------------------------------------------------------------
// Methodes liees au format :
// --------------------------------------------------------------------------
// setFormat : changement de format
// toFormat  : recuperation du format courant (pour affichage par exemple)
// --------------------------------------------------------------------------

/**
  *Modifie le format d'affichage et de saisie de l'objet courant.
*/ 
   public void setFormat(String nouveauFormat)
   {
      formatDateFr.applyPattern(nouveauFormat);
   }
   
/**
  *Retourne le format d'affichage de l'objet courant.
  *@return Chaîne de format de l'affichage courant.
*/ 
   public String toFormat()
   {
      return formatDateFr.toPattern();
   }
   
// --------------------------------------------------------------------------
// Methode de calcul.
// --------------------------------------------------------------------------
// Cette methode permet de calculer le nombre de jours entre deux dates.
// Elle s'ajoute aux methodes de GregorianCalendar (Par exemple : add())
// --------------------------------------------------------------------------

/**
  *Retourne le nombre de jours entre les deux dates.
  *@return Nombre de jours entre date1 et date2.
  *@param date1 date de debut de la periode.
  *@param date2 date de fin de la periode.
*/ 
   public static long difDates(DateFr date1, DateFr date2)
   {
      long difference;
      
      difference = date2.getTimeInMillis() - date1.getTimeInMillis();
      difference = difference / (1000 * 3600 * 24);
      
      return difference;
   }
   
// --------------------------------------------------------------------------
// Methode toString().
// --------------------------------------------------------------------------
// Cette methode permet d'afficher la date avec le format courant.
// --------------------------------------------------------------------------
   
/**
  *Retourne une représentation de la date sous forme de chaine.
  *@return Date au format courant.
*/ 
   public String toString()
   {
      return formatDateFr.format(getTime());
   }
}