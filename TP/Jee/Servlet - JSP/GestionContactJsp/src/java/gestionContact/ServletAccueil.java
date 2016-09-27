package gestionContact;

// ==========================================================================
// ServletAccueil.java : servlet d'accueil du projet gestionContact
// --------------------------------------------------------------------------
// Recuperation des parametres saisis sur l'ecran d'accueil
// ==========================================================================

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import utilitairesMG.jdbc.*;


public class ServletAccueil extends HttpServlet
{
   private TraitementAccueil traitementAccueil;

   @Override
   public void init()
   {
      try
      {
         Class.forName(getInitParameter("driverJDBC"));
      }
      catch(ClassNotFoundException e)
      {
      }

      BaseDeDonnees base = new BaseDeDonnees(getInitParameter("BDD"));

      ServletContext contexte = getServletContext();
      contexte.setAttribute("base", base);

      traitementAccueil = new TraitementAccueil(base);
   }

// --------------------------------------------------------------------------
// Traitement du formulaire d'accueil (index.jsp)
// --------------------------------------------------------------------------
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
// choixAction : action choisie sur l'ecran d'accueil.
// --------------------------------------------------------------------------
      String jsp;
      String choixAction;

// --------------------------------------------------------------------------
// Indication du codage pour l'interpretation des caracteres recus par la
// requete. Type et codage du texte envoye par la reponse.
// --------------------------------------------------------------------------
      requete.setCharacterEncoding("UTF-8");
      reponse.setContentType("text/html;charset=UTF-8");

      contexte = getServletContext();

      choixAction = requete.getParameter("choixAction");

      if (choixAction.compareTo("liste")==0)
      {
         jsp = traitementAccueil.traitementListe(requete);
      }
      else
      {
         if(choixAction.compareTo("modification")==0)
         {
            jsp = traitementAccueil.traitementModif(requete);
         }
         else
         {
            jsp = traitementAccueil.traitementNonRealise(requete);
         }
      }

      dispatcher = contexte.getRequestDispatcher(jsp);
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
