// ==========================================================================
// DateFr : classe de dates en notation francaise
// ==========================================================================

import java.util.*;
import java.text.*;


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
   public DateFr()
   {
      formatDateFr = new SimpleDateFormat("dd/MM/yyyy");  
   }

   public DateFr(String dateInitiale) throws ParseException
   {
      //formatDateFr = new SimpleDateFormat("dd/MM/yyyy");
      this();  
      //setTime(formatDateFr.parse(dateInitiale));
      set(dateInitiale);
   }

// --------------------------------------------------------------------------
// Modification de la date contenue dans l'objet courant.
// --------------------------------------------------------------------------
// Cette methode s'ajoute a toutes les methodes set() contenues dans la 
// classe Calendar.
// --------------------------------------------------------------------------
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
   public void setFormat(String nouveauFormat)
   {
      formatDateFr.applyPattern(nouveauFormat);
   }
   
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
   public String toString()
   {
      return formatDateFr.format(getTime());
   }
}
