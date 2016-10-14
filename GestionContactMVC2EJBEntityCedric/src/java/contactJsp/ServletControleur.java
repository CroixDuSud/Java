package contactJsp;

import java.io.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import objetDistant.MappingEntityRemote;


public class ServletControleur extends HttpServlet {

    private TraitementAccueil traitement;
    private TraitementModif traitementModif;
    private TraitementCreation traitementCreat;
    private Context ctxt;
    
    @Override
    public void init() throws ServletException
    {
        Hashtable varsEnv = new Hashtable();
        varsEnv.put("org.omg.CORBA.ORBInitialHost", "localhost");
        varsEnv.put("org.omg.CORBA.ORBInitialPort", "3700"); 
        
        Context ctxt;
        try 
        {
            ctxt = new InitialContext(varsEnv);
            MappingEntityRemote mapping = (MappingEntityRemote)ctxt.lookup("jndiMappingEntity");
            
            traitement = new TraitementAccueil(mapping);
            traitementModif = new TraitementModif(mapping);
            traitementCreat = new TraitementCreation(mapping);
        } 
        catch (NamingException ex) 
        {
            System.out.println("le nom jndi n'a pas été trouvé" + ex.getMessage());
        }
    }
    
    protected void executeRequete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        ServletContext contexte;
        RequestDispatcher dispatcher;
        
        String page;
        String choix;
        String retour;
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        
        contexte = getServletContext();
        
        page = request.getParameter("page");
        
        if(page.equals("accueil"))
        {
            choix = request.getParameter("action");

            if(choix.compareTo("list")==0)
            {
                retour = traitement.traitementListe(request);
            }
            else
            {
                if(choix.compareTo("modif")==0)
                {
                    retour = traitement.traitementModif(request);
                }
                else
                {
                    if(choix.compareTo("creat")==0)
                    {
                        retour = traitement.traitementCreat(request);
                    }
                    else
                    {
                        retour = traitement.traitementSuppr(request);
                    }
                }
            }
        }
        else
        {
            if(page.equals("modif"))
            {
                choix = request.getParameter("enregistrer");
            
                if(choix.equals("annuler"))
                {
                    retour = traitementModif.annulerModif(request);
                }
                else
                {
                    retour = traitementModif.modifierContact(request);
                }
            }
            else
            {
                if(page.equals("creat"))
                {
                    choix = request.getParameter("creer");
                    if(choix.equals("ANNULER"))
                    {
                        retour = traitementCreat.annulerCreat(request);
                    }
                    else
                    {
                        retour = traitementCreat.traitementCreer(request);
                    }
                }
                else
                {
                    retour = "/accueil.jsp";
                }
            }
        }
        dispatcher = contexte.getRequestDispatcher(retour);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executeRequete(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        executeRequete(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}