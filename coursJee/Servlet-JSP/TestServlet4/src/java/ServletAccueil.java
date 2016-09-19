// ==========================================================================
// ServletAccueil.java :
// Traitement de l'ecran index.jsp pour le projet testServlet3
// --------------------------------------------------------------------------
// Passage a la servlet de saisie des informations complementaires.
// Cette servlet sert uniquement de servlet d'accueil. Elle ne sert ici a
// rien d'autre que tester le RequestDispacher. Mais elle pourra plus tard
// servir pour "dispatcher" le traitement selon le type d'utilisateur, par
// exemple...
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
      ServletContext contexte;
      RequestDispatcher dispatcher;

   // --------------------------------------------------------------------------
   // Un objet de type RequestDispatcher recoit les requetes du client et les
   // envoie a une autre ressource du serveur (servlet, JSP...). La reference de
   // cet objet s'obtient a partir de l'objet ServletContext (qui a une "vue"
   // sur l'ensemble des ressources de l'application.
   // --------------------------------------------------------------------------
      contexte = getServletContext();
      dispatcher = contexte.getRequestDispatcher("/Donnees");

   // --------------------------------------------------------------------------
   // Lancement de l'affichage du deuxieme ecran html : donnees.html
   // --------------------------------------------------------------------------
      dispatcher.forward(requete, reponse);
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
