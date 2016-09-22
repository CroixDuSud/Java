<%-- ------------------------------------------------------------------- --%>
<%-- pageErreur.jsp : page d'erreur du projet jspServlet                 --%>
<%-- ------------------------------------------------------------------- --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>

<!DOCTYPE html>

<html>
   <head>
      <title>Erreur de saisie</title>
      <meta http-equiv="Content-Type"
            content="text/html; charset=utf-8" />
      <link rel="stylesheet"
            type="text/css"
            href="miseEnPage.css" />
   </head>

   <body>
      <h1>Non mais, ça va pas ?</h1>
      <p>Voici le message d'erreur : <%= exception.getMessage() %></p>

      <%@ include file="piedPage.jspf" %>
   </body>
</html>