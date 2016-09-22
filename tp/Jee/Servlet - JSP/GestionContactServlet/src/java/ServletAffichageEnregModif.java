// ==========================================================================
// Classe ServletAffichageEnregModif             Projet gestionContactServlet
// ==========================================================================

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import metierMapping.*;
import utilitairesMG.jee.*;

public class ServletAffichageEnregModif extends HttpServlet
{
   protected void executeRequete(HttpServletRequest requete,
                                 HttpServletResponse reponse)
                                 throws ServletException,
                                        IOException
   {
      String affiche;

      Contact contact;

      reponse.setContentType("text/html;charset=utf-8");
      PrintWriter sortie = reponse.getWriter();

      HttpSession session = requete.getSession();


      try
      {
         contact = (Contact)session.getAttribute("contact");

// --------------------------------------------------------------------------
// Doctype
// --------------------------------------------------------------------------
         affiche = Xhtml.docType();
         affiche +=
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\">";

// --------------------------------------------------------------------------
// Entete du fichier html
// --------------------------------------------------------------------------
         affiche += Xhtml.head("Enregistrement de la modification");
         
// --------------------------------------------------------------------------
// Corps du fichier html
// --------------------------------------------------------------------------
         affiche +=     "<body>";
         affiche +=        "<h2>";
         affiche +=           "Enregistrement du contact ";
         affiche +=           contact.getNumero();
         affiche +=           " effectué";
         affiche +=       "</h2>";
         affiche +=        "<p>";
         affiche +=          "<a href = \"index.jsp\">";
         affiche +=             "Retour au menu principal";
         affiche +=          "</a>";
         affiche +=       "</p>";
         affiche +=    "</body>";
         affiche += "</html>";

         sortie.println(affiche);
      }
      finally
      {
         sortie.close();
      }
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