// ==========================================================================
// AfficheParam.java : servlet du projet reEntrance
// --------------------------------------------------------------------------
// Affichage des parametres saisis sur l'ecran index.jsp
// --------------------------------------------------------------------------
// Cette servlet permet de verifier la re-entrance de la servlet utilisee par
// plusieurs threads (deux utilisateurs l'appelent en meme temps). A cause de
// la temporisation (Thread.sleep()), le deuxieme utilisateur voit les
// variables d'instance du precedent, s'il tape "enregistrer" assez vite...
// ==========================================================================


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AfficheParam extends HttpServlet
{
   private String nomUtil;
   private String motPasseUtil;
   private int tempsAttente;

   // --------------------------------------------------------------------------
   // Surcharge de la methode init heritee de GenericServlet.
   // Il s'agit d'initialiser une propriete qui sera fixe pour toute la vie de
   // la servlet.
   // --------------------------------------------------------------------------
   @Override
   public void init() throws ServletException
   {

   // --------------------------------------------------------------------------
   // getInitParameter() permet de lire un parametre initialise a
   // l'instanciation de la servlet. Ce parametre est stocke dans l'objet
   // ServletConfig (en fait, c'est la servlet qui est un ServletConfig).
   // Ici, le parametre "temporisation" va permettre de mettre le programme en
   // attente pendant 10000 milli-secondes (10 secondes), ce qui laissera le
   // temps a un autre utilisateur de saisir ses donnees avant la fin de ce
   // programme...
   // --------------------------------------------------------------------------
      tempsAttente = Integer.parseInt(getInitParameter("temporisation"));
   }

   // --------------------------------------------------------------------------
   // A l'interieur de la methode executeRequete, on definit des variables
   // locales nomUtilLocal et motPasseUtilLocal. Ces variables locales sont
   // dupliquees pour chaque utilisateur de la methode (dans chque Thread client
   // qui execute la servlet). Par contre, les proprietes de l'objet etant
   // uniques (une seule instanciation de la servlet est faite par le conteneur),
   // il y a melange des proprietes des clients... La temporisation permet de
   // saisir pour le deuxieme client avant la fin de la methode pour le premier.
   // --------------------------------------------------------------------------
   // Une possibilite pour eviter l'inconvenient lie au melange des valeurs des
   // proprietes consiste a "synchroniser" la methode. Ainsi, elle devra
   // se terminer avant qu'un autre thread y accede...
   //
   // protected synchronized void executeRequete(...
   // --------------------------------------------------------------------------
   protected void executeRequete(HttpServletRequest requete,
                                 HttpServletResponse reponse)
                                 throws ServletException,
                                        IOException
   {
      String nomUtilLocal;
      String motPasseUtilLocal;

      String affiche;

      requete.setCharacterEncoding("utf-8");
      reponse.setContentType("text/html;charset=utf-8");
      PrintWriter sortie = reponse.getWriter();

   // --------------------------------------------------------------------------
   // Lecture des parametres saisis dans le formulaire de accueil.html
   // --------------------------------------------------------------------------
      nomUtilLocal = requete.getParameter("nomUtil");
      motPasseUtilLocal = requete.getParameter("motPasseUtil");

   // --------------------------------------------------------------------------
   // Transfert dans les proprietes de la servlet
   // --------------------------------------------------------------------------
      this.nomUtil = nomUtilLocal;
      this.motPasseUtil = motPasseUtilLocal;

      try
      {
         Thread.sleep(tempsAttente);    // InterruptedException possible

         affiche =     "<body>";
         affiche +=       "<h2>Récapitulatif des paramètres</h2>";
         affiche +=       "<p>";
         affiche +=          "Le Thread courant est : " + Thread.currentThread();
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          "Temporisation : " + tempsAttente;
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          "<br />";
         affiche +=          "LES VARIABLES LOCALES SONT :";
         affiche +=          "<br />";
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          "nomUtil = " + nomUtilLocal;
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          "motPasseUtil = " + motPasseUtilLocal;
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          "<br />";
         affiche +=          "LES PROPRIETES DE LA SERVLET SONT :";
         affiche +=          "<br />";
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          "nomUtil = " + this.nomUtil;
         affiche +=       "</p>";
         affiche +=       "<p>";
         affiche +=          "motPasseUtil = " + this.motPasseUtil;
         affiche +=       "</p>";
         affiche +=     "</body>";
         affiche +=  "</html>";

         sortie.println(entete("Récapitulatif") + affiche);
      }
      catch (InterruptedException e)
      {
         affiche =     "<body>";
         affiche +=       "<h2>Erreur :  " + e.getMessage() + "</h2>";
         affiche +=     "</body>";

         sortie.println(entete("Erreur") + affiche);
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
