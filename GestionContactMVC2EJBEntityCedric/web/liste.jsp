
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tables.*" %>
<%@page import="utilitairesMG.divers.Colonne" %>
<%@page import="java.util.Vector" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Liste des contacts</title>
        <meta charset="UTF-8">
        <link rel='stylesheet' type='text/css' href='style.css'>
    </head>
    <body>
        <table><caption>LISTE DES CONTACTS</caption>
            <thead>
                <tr>
    <% Vector<Colonne> listeColonnes;
    listeColonnes = (Vector<Colonne>)session.getAttribute("listeColonnes");
    for (Colonne colonne : listeColonnes) 
    {%>             <th><%=colonne.getNom()%></th>
    <% }%>      
                </tr>
            </thead>
            <tbody>
    <% Vector<Contact> listeContacts;
    listeContacts = (Vector<Contact>)session.getAttribute("listeContacts");
    for(Contact contact : listeContacts){%> 
                <tr>
                    <td><%=((contact.getNumero()!=null) ? contact.getNumero() : "" )%></td>
                    <td><%=((contact.getNom()!=null) ? contact.getNom() : "" )%></td>
                    <td><%=((contact.getAdresse()!=null) ? contact.getAdresse() : "" )%></td>
                    <td><%=((contact.getCodePostal()!=null) ? contact.getCodePostal() : "" )%></td>
                    <td><%=((contact.getVille()!=null) ? contact.getVille() : "" )%></td>
                    <td><%=((contact.getCodeSecteur()!=null) ? contact.getCodeSecteur().getLibelle() : "" )%></td>
                </tr>
    <% }%>
            </tbody>
        </table>
        <p><a href='accueil.jsp'>Retour au menu principal</a></p>
    </body>
</html>
