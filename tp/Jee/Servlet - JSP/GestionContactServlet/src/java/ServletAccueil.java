// ==========================================================================
// Classe ServletAccueil                         Projet gestionContactServlet
// ==========================================================================

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import utilitairesMG.jdbc.*;


public class ServletAccueil extends HttpServlet
{
   private TraitementAccueil traitementAccueil;

// --------------------------------------------------------------------------
// Cette methode pourrait etre implementee dans ServletAffichageAccueil, qui
// est la premiere servlet appelee dans l'application. Il faudrait alors
// recuperer ici la base de donnees stockee dans le ServletContext. Voir
// ce qui est fait dans ServletEnregModif...
// --------------------------------------------------------------------------
// Il est plus coherent de recupere la base de donnees dans une Servlet qui
// l'utilise, dautant que les servlets d'affichage vont etre remplacees par
// des jsp...
// --------------------------------------------------------------------------
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

      if (choixAction.compareTo("liste")==0)
      {
         servlet = traitementAccueil.traitementListe(requete);
      }
      else
      {
         if(choixAction.compareTo("modification")==0)
         {
            servlet = traitementAccueil.traitementModif(requete);
         }
         else
         {
            servlet = traitementAccueil.traitementNonRealise(requete);
         }
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
