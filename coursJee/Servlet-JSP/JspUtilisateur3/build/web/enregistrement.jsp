<%-- ------------------------------------------------------------------- --%>
<%-- enregistrement.jsp :                                                --%>
<%-- ------------------------------------------------------------------- --%>
<%-- Affichage des donnes saisies sur formEnregistrement.html            --%>
<%-- Utilisation du JavaBean Utilisateur                                 --%>
<%-- ------------------------------------------------------------------- --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="pageErreur.jsp"%>
<%@page import="sourcesJspUtilisateur.Utilisateur" %>

<%
    request.setCharacterEncoding("utf-8");
//    response.setContentType("text/html;charset=utf-8");
%>

<!DOCTYPE html>

<%-- ------------------------------------------------------------------- --%>
<%-- Creation d'un objet Utilisateur et ajout dans une session           --%>
<%-- ------------------------------------------------------------------- --%>
    <%! Utilisateur util = new Utilisateur(); %>

    <% util.setPrenom(request.getParameter("prenom")); %>
    <% util.setNom(request.getParameter("nom")); %>
    <% util.setLogin(request.getParameter("login")); %>
    <% util.setAge(new Integer(request.getParameter("age"))); %>

    <% session.setAttribute("util", util); %>

<html>
   <head>
      <title>Données enregistrées</title>
      <meta http-equiv="Content-Type"
            content="text/html; charset=utf-8" />
      <link rel="stylesheet"
            type="text/css"
            href="miseEnPage.css" />
   </head>

    <body>
      <div id="texteCentre">
         <h1 class="titre">Données enregistrées pour l'utilisateur</h1>


         <p>Voici les données que vous avez fournies :</p>

         <p>Votre prénom est <%= request.getParameter("prenom") %>.</p>
         <p>Votre nom est <%= passeEnMajuscules(request.getParameter("nom")) %>.</p>
         <p>Votre login est <%= request.getParameter("login") %>.</p>
         <p>Votre age est <%= request.getParameter("age") %>.</p>

         <br />
         <br />
         <p>Aller à la <a href="index.jsp">page d'accueil</a></p>
      </div>

      <%@ include file="piedPage.jspf" %>
   </body>
</html>

<%-- ------------------------------------------------------------------- --%>
<%-- Tag de declaration de la methode passeEnMajuscules                  --%>
<%-- ------------------------------------------------------------------- --%>

<%!
    public String passeEnMajuscules(String s)
    {
        return s.toUpperCase();
    }
%>


