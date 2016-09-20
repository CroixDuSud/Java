/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author afpa1800
 */
public class ServletAffichageModif extends HttpServlet
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
        
        String nom;
        String adresse;
        String codePostal;
        String ville;
        String codeSecteur;
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        
        nom = request.getParameter("nom");
        adresse = request.getParameter("adresse");
        codePostal = request.getParameter("codePostal");
        ville = request.getParameter("ville");
        codeSecteur = request.getParameter("secteur");
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAffichageModif</title>");
            out.println("");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAffichageModif at " + request.getContextPath() + "</h1>");
            out.println("<div>");
            out.println("<form action=\"#\" method=\"post\">");
            out.println("<fieldset id=\"field\">");
            out.println("<legend>Modification du  contact</legend>");
            out.println("<br>");
            out.println("<label for=\"nom\">Nom :</label>");
            out.println("<input type=\"text\" name=\"nom\" id=\"nom\">");
            out.println("<br>");
            out.println("<br>");
            out.println("<label for=\"adresse\">Adresse :</label>");
            out.println("<input type=\"text\" name=\"adresse\" id=\"adresse\">");
            out.println("<br><br>");
            out.println("<label for=\"codePostal\">Code postal :</label>");
            out.println("<input type=\"text\" name=\"codePostal\" id=\"codePostal\">");
            out.println("<br><br>");
            out.println("<label for=\"ville\">Ville :</label>");
            out.println("<input type=\"text\" name=\"ville\" id=\"ville\">");
            out.println("<br><br>");
            out.println("<label for=\"secteur\">Code secteur :</label>");
            out.println("<select name=\"secteur\" id=\"secteur\"></select>");
            out.println("<br><br>");
            out.println("</fieldset>");
            out.println("<br>");
            out.println("<div id=\"boutons\">");
            out.println("<input type=\"submit\" id=\"send\" value=\"Enregistrer\">");
            out.println("<input type=\"button\" id=\"annuler\" value=\"Annuler\">");
            out.println("</div>");
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
