// ==========================================================================
// AfficheParamAttrib.java : servlet qui permet de visualiser les attributs
// et les parametres de ServletConfig et ServletContext.
// ==========================================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class AfficheParamAttrib extends HttpServlet
{
   protected void executeRequete(HttpServletRequest requete,
                                 HttpServletResponse reponse)
                                 throws ServletException,
                                        IOException
   {
      Enumeration liste;
      String nomParametre;
      String parametre;
      ServletContext contexte;
      String affiche;

   // --------------------------------------------------------------------------
   // Flux de sortie de la reponse
   // --------------------------------------------------------------------------
      requete.setCharacterEncoding("utf-8");
      reponse.setContentType("text/html;charset=utf-8");
      PrintWriter sortie = reponse.getWriter();

      try
      {
         affiche =     "<body>";

   // --------------------------------------------------------------------------
   // getInitParameterNames() permet d'obtenir la liste des parametres de
   // configuration de la servlet. Pour chacun d'entre eux, la methode
   // getInitParameter() permet d'en obtenir la valeur... Les methodes
   // getInitParameterNames() et getInitParameter() sont ici appliquees a la
   // servlet. On recupere les parametres d'initialisation de la servlet.
   // --------------------------------------------------------------------------
         liste = getInitParameterNames();

         affiche +=       "<p>";

         if (!liste.hasMoreElements())
         {
            affiche += "Aucun paramètre d'initialisation de la Servlet";
            affiche +=          "<br />";
            affiche +=       "</p>";
         }
         else
         {
            affiche += "Paramètres d'initialisation de la Servlet : ";
            affiche +=          "<br />";
            affiche +=       "</p>";

            do
            {
               nomParametre = (String)liste.nextElement();
               parametre = getInitParameter(nomParametre);
               affiche +=       "<p>";
               affiche +=          nomParametre + " : " + parametre;
               affiche +=       "</p>";
            }
            while(liste.hasMoreElements());
         }

   // --------------------------------------------------------------------------
   // Les methodes getInitParameterNames() et getInitParameter() vont etre ici
   // appliquees a l'objet ServletContext de la servlet. On recupere les
   // parametres d'initialisation du contexte de la servlet.
   // --------------------------------------------------------------------------
         contexte = getServletContext();

         liste = contexte.getInitParameterNames();

         affiche +=       "<p>";
         affiche +=          "<br />";

         if (!liste.hasMoreElements())
         {
            affiche += "Aucun paramètre d'initialisation du ServletContext";
            affiche +=          "<br />";
            affiche +=       "</p>";
         }
         else
         {
            affiche += "Paramètres d'initialisation du ServletContext : ";
            affiche +=          "<br />";
            affiche +=       "</p>";

            do
            {
               nomParametre = (String)liste.nextElement();
               parametre = (String)contexte.getInitParameter(nomParametre);
               affiche +=       "<p>";
               affiche +=          nomParametre + " : " + parametre;
               affiche +=       "</p>";
            }
            while(liste.hasMoreElements());
         }

   // --------------------------------------------------------------------------
   // Ajout d'un attribut au contexte (les attributs sont des parametres mais on
   // les distingue ainsi des parametres d'initialisation du ServletContext).
   // --------------------------------------------------------------------------
         contexte.setAttribute("VERRAT", "LUBRIQUE");
         String test = (String)contexte.getAttribute("VERRAT");

         affiche +=       "<p>";
         affiche +=          "<br />";
         affiche +=          "L'attribut VERRAT contient : " + test ;
         affiche +=          "<br />";
         affiche +=       "</p>";

   // --------------------------------------------------------------------------
   // On peut effectuer une boucle de lecture de tous les attributs de
   // ServletContext. Attention cependant ! En plus des attributs positionnes
   // par setAttribute (comme VERRAT ci-dessus), on obtient une liste
   // d'attributs qui ont ete positionnes a l'instanciation du ServletContext.
   // --------------------------------------------------------------------------
         liste = contexte.getAttributeNames();

         affiche +=       "<p>";
         affiche +=          "<br />";

         if (!liste.hasMoreElements())
         {
            affiche += "Aucun attribut de contexte...";
            affiche +=          "<br />";
            affiche +=       "</p>";
         }
         else
         {
            affiche += "Attributs (type d'objets) du ServletContext : ";
            affiche +=          "<br />";
            affiche +=       "</p>";

            do
            {
               nomParametre = (String)liste.nextElement();
               parametre = contexte.getAttribute(nomParametre).getClass().getName();
               affiche +=       "<p>";
               affiche +=          nomParametre + " : " + parametre;
               affiche +=       "</p>";
            }
            while(liste.hasMoreElements());
         }

         affiche += "</body>";
         affiche += "</html>";

         sortie.println(entete("Paramètres et attributs") + affiche);
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
