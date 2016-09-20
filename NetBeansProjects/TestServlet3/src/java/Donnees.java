// ==========================================================================
// Donnees.java :
// Traitement de l'ecran index.jsp pour le projet testServlet3
// --------------------------------------------------------------------------
// Cette servlet est appelee par la servlet ServletAccueil, qui lui a
// transmis la requete du client (et l'objet reponse).
// Elle ecrit ces parametres dans le ServletContext.
// Elle affiche l'ecran de saisie des donnees complementaires.
// ==========================================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Donnees extends HttpServlet
{

   protected void executeRequete(HttpServletRequest requete,
               HttpServletResponse reponse)
               throws ServletException,
                      IOException
   {
      String nomUtil;
      String motPasseUtil;

      ServletContext contexte;

      String affiche;

      requete.setCharacterEncoding("utf-8");
      reponse.setContentType("text/html;charset=utf-8");
      PrintWriter sortie = reponse.getWriter();

   // --------------------------------------------------------------------------
   // Lecture des parametres transmis par le formulaire d'index.jsp via la
   // servlet ServletAccueil :
   // --------------------------------------------------------------------------
      nomUtil = requete.getParameter("nomUtil");
      motPasseUtil = requete.getParameter("motPasseUtil");

   // --------------------------------------------------------------------------
   // Ecriture des parametres dans deux nouveaux attributs de ServletContext
   // Les noms des attributs crees (nomUtil, motPasseUtil) sont identiques a
   // ceux des parametres recus... Mais ce sont deux nouvelles informations !
   // --------------------------------------------------------------------------
      contexte = getServletContext();
      contexte.setAttribute("nomUtil", nomUtil);
      contexte.setAttribute("motPasseUtil", motPasseUtil);

   // --------------------------------------------------------------------------
   // Affichage de l'ecran de saisie des donnees complementaires
   // --------------------------------------------------------------------------
      try
      {
         affiche =      "<body>";
         affiche +=        "<form action=\"ServletDonnees\" method=\"post\">";
         affiche +=           "<fieldset>";
         affiche +=              "<legend>Informations complémentaires de ";
         affiche +=                       nomUtil + "(" + motPasseUtil + ")";
         affiche +=              "</legend>";
         affiche +=              "<div class=\"divTexteCompl\">";
         affiche +=                 "<label for=\"t1\">Texte 1 : </label>";
         affiche +=                 "<input type=\"text\" ";
         affiche +=                        "name=\"texte1\" ";
         affiche +=                        "size=\"60\" ";
         affiche +=                        "id=\"t1\" />";
         affiche +=              "</div>";
         affiche +=              "<div class=\"divTexteCompl\">";
         affiche +=                 "<label for=\"t2\">Texte 2 : </label>";
         affiche +=                 "<input type=\"text\" ";
         affiche +=                        "name=\"texte2\" ";
         affiche +=                        "size=\"60\" ";
         affiche +=                        "id=\"t2\" />";
         affiche +=              "</div>";
         affiche +=              "<div class=\"divTexteCompl\">";
         affiche +=                 "<label for=\"t3\">Texte 3 : </label>";
         affiche +=                 "<input type=\"text\" ";
         affiche +=                        "name=\"texte3\" ";
         affiche +=                        "size=\"60\" ";
         affiche +=                        "id=\"t3\" />";
         affiche +=              "</div>";
         affiche +=           "</fieldset>";
         affiche +=           "<div id=\"envoyer\">";
         affiche +=              "<input type=\"submit\" ";
         affiche +=                     "value=\"Envoyer\" />";
         affiche +=           "</div>";
         affiche +=        "</form>";
         affiche +=     "</body>";
         affiche +=  "</html>";

         sortie.println(entete("Autres informations") + affiche);
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
