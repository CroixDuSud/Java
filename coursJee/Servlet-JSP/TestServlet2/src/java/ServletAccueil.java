// ==========================================================================
// ServletAccueil.java :
// Traitement de l'ecran index.jsp pour le projet testServlet2
// --------------------------------------------------------------------------
// Recuperation des parametres saisis sur l'ecran index.jsp
// Ecriture de ces parametres dans le ServletContext.
// Passage a l'ecran html de saisie des informations complementaires
// ==========================================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ServletAccueil extends HttpServlet
{

   protected void executeRequete(HttpServletRequest requete,
                                 HttpServletResponse reponse)
                                 throws ServletException,
                                        IOException
   {
      String nomUtil;
      String motPasseUtil;
      ServletContext contexte;


   // --------------------------------------------------------------------------
   // Lecture des parametres transmis par le formulaire d'index.jsp
   // --------------------------------------------------------------------------
      requete.setCharacterEncoding("utf-8");
      
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
   // Lancement de l'affichage du deuxieme ecran html : donnees.html
   // --------------------------------------------------------------------------
      reponse.sendRedirect("donnees.html");
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
