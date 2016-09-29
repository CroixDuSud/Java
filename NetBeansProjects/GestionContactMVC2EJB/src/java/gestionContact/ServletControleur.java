package gestionContact;

// ==========================================================================
// ServletControleur.java : servlet d'accueil du projet gestionContactMVC2
// ==========================================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import utilitairesMG.jdbc.*;

public class ServletControleur extends HttpServlet
{
   private TraitementAccueil traitementAccueil;
   private TraitementEnregModif traitementEnregModif;
   private BaseDeDonnees base;

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

      base = new BaseDeDonnees(getInitParameter("BDD"));

      traitementAccueil = new TraitementAccueil(base);
      traitementEnregModif = new TraitementEnregModif(base);
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
// idEcran    : identifiant de l'ecran reçu.
// jsp        : jsp a afficher (retournee par les methodes de Traitement.
// choixAction : action choisie sur l'ecran d'accueil.
// --------------------------------------------------------------------------
      Integer idEcran;
      String jsp;
      String choixAction;

// --------------------------------------------------------------------------
// Indication du codage pour l'interpretation des caracteres recus par la
// requete.
// --------------------------------------------------------------------------
      requete.setCharacterEncoding("UTF-8");

// --------------------------------------------------------------------------
// Recuperation du SerletContext pour dispatcher...
// --------------------------------------------------------------------------
      contexte = getServletContext();

// --------------------------------------------------------------------------
// Lecture de l'identifiant de l'ecran (champ cache ou parametre d'index.jsp)
// --------------------------------------------------------------------------
      String numeroEcran = requete.getParameter("idEcran");
      idEcran = new Integer(numeroEcran);

// --------------------------------------------------------------------------
// Divers branchements suivant l'ecran qui vient d'appeler ServletControleur
// --------------------------------------------------------------------------
      switch(idEcran)
      {

// --------------------------------------------------------------------------
// On vient de l'ecran jspAccueil
// --------------------------------------------------------------------------
      case 1 :
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
         break;

// --------------------------------------------------------------------------
// On vient de l'ecran jspModif
// --------------------------------------------------------------------------
         case 2 :
            choixAction = requete.getParameter("choixAction");

            if (choixAction.compareTo("Annuler")==0)
            {
               jsp = traitementEnregModif.annulationModif(requete);
            }
            else
            {
               jsp = traitementEnregModif.enregModif(requete);
            }
            break;

         default :
            jsp = null;
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
