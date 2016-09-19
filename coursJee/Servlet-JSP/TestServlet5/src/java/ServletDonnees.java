// ==========================================================================
// ServletDonnees.java : servlet du projet testServlet5
// --------------------------------------------------------------------------
// Recuperation des parametres saisis sur l'ecran affiche par Donnees.java
// Affichage de ces donnees et de celles de index.jsp recuperees dans des
// cookies
// ==========================================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletDonnees extends HttpServlet
{

   protected void executeRequete(HttpServletRequest requete,
                                 HttpServletResponse reponse)
                                 throws ServletException,
                                        IOException
   {
      String texte1;
      String texte2;
      String texte3;

      String nomUtil = null;
      String motPasseUtil = null;

      Cookie tableCookies[];
      int iCook;

      String affiche;

      requete.setCharacterEncoding("utf-8");
      reponse.setContentType("text/html;charset=utf-8");
      PrintWriter sortie = reponse.getWriter();

      try
      {

// --------------------------------------------------------------------------
// Lecture des parametres transmis par le formulaire de donnees.html
// --------------------------------------------------------------------------
         texte1 = requete.getParameter("texte1");
         texte2 = requete.getParameter("texte2");
         texte3 = requete.getParameter("texte3");

// --------------------------------------------------------------------------
// Lecture des cookies
// --------------------------------------------------------------------------
         tableCookies = requete.getCookies();

         for (iCook = 0; iCook < tableCookies.length; iCook++)
         {
            if ((tableCookies[iCook].getName()).compareTo("nomUtil") == 0)
            {
               nomUtil = tableCookies[iCook].getValue();
            }
            if ((tableCookies[iCook].getName()).compareTo("motPasseUtil") == 0)
            {
               motPasseUtil = tableCookies[iCook].getValue();
            }
         }
      
// --------------------------------------------------------------------------
// Affichage de tout cela...
// --------------------------------------------------------------------------
         affiche =     "<body>";
         affiche +=       "<h2>Récapitulatif des données entrées</h2>";
         affiche +=       "<p>";
         affiche +=          "Nom utilisateur : " + nomUtil;
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          "Mot de passe utilisateur : " + motPasseUtil;
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          "<br />";
         affiche +=          "Textes complémentaires saisis :";
         affiche +=          "<br />";
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          texte1;
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          texte2;
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          texte3;
         affiche +=       "</p>";

         affiche +=       "<p>";
         affiche +=          "<br />";
         affiche +=          "Cookies :";
         affiche +=          "<br />";
         affiche +=       "</p>";
         
         for(iCook = 0; iCook < tableCookies.length; iCook++)
         {
            affiche += "<p>";
            affiche += tableCookies[iCook].getName() + " : " +
                       tableCookies[iCook].getValue();
            affiche += "</p>";
         }
         
         affiche +=     "</body>";
         affiche +=  "</html>";

         sortie.println(entete("Récapitulatif") + affiche);
      }
      finally
      {
         sortie.close();
      }
   }

// --------------------------------------------------------------------------
// Constitution de l'entete du programme html
// --------------------------------------------------------------------------
   public static String entete(String titre)
   {
      String entete ="";
      entete = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" ";
      entete += "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">";

      entete += "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\">";
      entete +=    "<head>";
      entete +=       "<title>" + titre + "</title>";
      entete +=       "<meta http-equiv=\"Content-Type\" ";
      entete +=             "content=\"text/html; charset=utf-8\" />";
      entete +=       "<link rel=\"stylesheet\" ";
      entete +=             "type=\"text/css\" ";
      entete +=             "href=\"miseEnPage.css\" />";
      entete +=    "</head>";

      return entete;
   }

   @Override
   protected void doGet(HttpServletRequest requete,
                        HttpServletResponse reponse)
                        throws ServletException,
                        IOException
   {
      executeRequete(requete, reponse);
   }

   @Override
   protected void doPost(HttpServletRequest requete,
                         HttpServletResponse reponse)
                         throws ServletException,
                         IOException
   {
      executeRequete(requete, reponse);
   }
}