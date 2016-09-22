package sourcesJspUtilisateur;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletEnregistrement extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
    throws ServletException, IOException
    {
        ServletContext contexte;
        RequestDispatcher dispatcher;
        HttpSession session;

        contexte = getServletContext();
        session = request.getSession();
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Utilisateur util = new Utilisateur();
        util.setPrenom(request.getParameter("prenom"));
        util.setNom(request.getParameter("nom"));
        util.setLogin(request.getParameter("login"));
        try
        {
            Integer i = new Integer(request.getParameter("age"));
            util.setAge(i);
            session.setAttribute("util", util);
            dispatcher = contexte.getRequestDispatcher("/enregistrement.jsp");
        }
        catch(NumberFormatException e)
        {
            session.setAttribute("exception", e);
            dispatcher = contexte.getRequestDispatcher("/pageErreur.jsp");
        }
        dispatcher.forward(request, response);
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
}
