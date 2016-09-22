// ==========================================================================
// Classe ServletEnregModif                      Projet gestionContactServlet
// --------------------------------------------------------------------------
// Servlet d'enregistrement d'un contact modifie
// ==========================================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import utilitairesMG.jdbc.BaseDeDonnees;

public class ServletEnregModif extends HttpServlet
{
   private TraitementEnregModif traitementEnregModif;

   @Override
   public void init()
   {
      ServletContext contexte = getServletContext();
      BaseDeDonnees base = (BaseDeDonnees)contexte.getAttribute("base");

      traitementEnregModif = new TraitementEnregModif(base);
   }

   protected void executeRequete(HttpServletRequest requete,
                                 HttpServletResponse reponse)
   throws ServletException, IOException
   {

// --------------------------------------------------------------------------
// contexte   : ServletContext pour utiliser le dispatcher.
// dispatcher : pour acceder aux jsp d'affichage.
// --------------------------------------------------------------------------
      ServletContext contexte;
      RequestDispatcher dispatcher;

// --------------------------------------------------------------------------
// servlet : servlet d'affichage (retournee par les methodes de Traitement).
// --------------------------------------------------------------------------
      String servlet;
      String choixAction;

// --------------------------------------------------------------------------
// Indication du codage pour l'interpretation des caracteres recus par la
// requete. Type et codage du texte envoye par la reponse.
// --------------------------------------------------------------------------
      requete.setCharacterEncoding("UTF-8");
      reponse.setContentType("text/html;charset=UTF-8");

      contexte = getServletContext();

      choixAction = requete.getParameter("choixAction");

      if(choixAction.compareTo("Annuler") == 0)
      {
         servlet = traitementEnregModif.annulationModif(requete);
      }
      else
      {
         servlet = traitementEnregModif.enregModif(requete);
      }

      dispatcher = contexte.getRequestDispatcher(servlet);
      dispatcher.forward(requete, reponse);
}

   @Override
   protected void doGet(HttpServletRequest requete,
                      HttpServletResponse reponse)
   throws ServletException, IOException {
     executeRequete(requete, reponse);
   }

   @Override
   protected void doPost(HttpServletRequest requete,
                       HttpServletResponse reponse)
   throws ServletException, IOException {
     executeRequete(requete, reponse);
   }
}
