/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author afpa1800
 */
public class ServletAffichageAccueil extends HttpServlet
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\" lang=\"fr\">");
            out.println("<title>Gestion des Contacts</title>");
            out.println("<link href=\"style.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body id=\"home\">");
            out.println("<div>");
            out.println("<form action=\"ServletAccueil\" method=\"post\">");
            out.println("<fieldset id=\"field\">");
            out.println("<legend>Gestion des contacts</legend>");
            out.println("<div id=\"numC\">");
            out.println("<label for=\"numContact\">Numero de contact :</label>");
            out.println("<input type=\"text\" name=\"num\" id=\"numContact\">");
            out.println("</div>");
            out.println("<div id=\"radioG\">");
            out.println("<div id=\"radio\">");
            out.println("<input type=\"radio\" name=\"choix\" value=\"Modification\">Modification");
            out.println("<input type=\"radio\" name=\"choix\" value=\"Creation\">Creation");
            out.println("<input type=\"radio\" name=\"choix\" value=\"Suppression\">Suppression");
            out.println("</div>");
            out.println("<div>");
            out.println("<input type=\"radio\" name=\"choix\" value=\"ListeDesContacts\" id=\"liste\">Liste des contacts");
            out.println("</div>");
            out.println("</div>");
            out.println("</fieldset>");
            out.println("<br>");
            out.println("<input type=\"submit\" id=\"send\" value=\"Envoyer\">");
            out.println("</form>");
            out.println("</div>");
            out.println("<br><br><br><br>");
            out.println("<iframe src=\"boiteDialogue.html\">");
            out.println("</iframe>");
            out.println("</body>");
            out.println("</html>");
        }
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

