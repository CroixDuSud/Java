<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="utilitairesMG.jee.*, metierMapping.*"%>

<%= Xhtml.docType()%>

<% Contact contact = (Contact)session.getAttribute("contact");
%>

<html>
   <%= Xhtml.head("Enregistrement de la modification") %>
   
   <body>
      <h2>
         Enregistrement du contact <%= contact.getNumero() %> effectué
      </h2>

      <p>
         <a href = "index.jsp">Retour au menu principal</a>
      </p>
   </body>
</html>
