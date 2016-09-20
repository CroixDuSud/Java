/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author afpa1800
 */
public class ServletAccueil extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        String numContact;
        String choixGestion;
        String erreur;
        
        /*
        Cookie numContactCookie;
        Cookie choixGestionCookie;
        Cookie erreurCookie;
        */
        
        ServletContext contexte;
        RequestDispatcher dispatcher;
        
        //contexte = getServletContext();
        //dispatcher = contexte.getRequestDispatcher("/Donnees");
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        
        /*---------------------------------------------------------------------
        Lecture des paramètre transmis par le formulaire de gestionContact via
        la servletAcceuil :
        ---------------------------------------------------------------------*/
        numContact = request.getParameter("numContact");
        choixGestion = request.getParameter("choix");
        erreur = request.getParameter("erreur");
        
        HttpSession session = request.getSession();
        session.setAttribute("numContact", numContact);
        session.setAttribute("choix", choixGestion);
        session.setAttribute("erreur", erreur);
        
        //if(choixGestion )
        
        
        
        /*
        // Copie des attributs dans les cookies
        
        numContactCookie = new Cookie("numContact", numContact);
        choixGestionCookie = new Cookie("choixGestion", choixGestion);
        erreurCookie = new Cookie("erreur", erreur);
        
        
        
        try (PrintWriter out = response.getWriter())
        {
            
        }
        
        finally
        {
            out.close();
        }
        */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
