

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector" %>
<%@page import="tables.*;" %>

<% Contact contact = (Contact)session.getAttribute("contact");
   Vector<Secteur> listeSecteurs =(Vector<Secteur>)session.getAttribute("listeSecteurs");%>
     
<!DOCTYPE html>
<html>
    <head>
        <title>Liste des contacts</title>
        <meta charset="UTF-8">
        <link rel='stylesheet' type='text/css' href='style.css'>
    </head>
    <body>
        <form action="ServletControleur" method="post">
            <input type="hidden" name="page" value="modif">
            <fieldset id="Modification">
                <legend>Modification du contact <%=contact.getNumero()%></legend>
                    <p><label>Nom : </label><input name="nom" id="nom" type="text" value="<%=((contact.getNom()!=null) ? contact.getNom() : "" )%>" ></p>
                    <p><label>Adresse : </label><input name="adresse" id="adresse" type="text" value="<%=((contact.getAdresse()!=null) ? contact.getAdresse() : "" )%>" ></p>
                    <p><label>Code Postal : </label><input name="codePostal" id="codePostal" type="text" value="<%=((contact.getCodePostal()!=null) ? contact.getCodePostal() : "" )%>" ></p>
                    <p><label>Ville : </label><input name="ville" id="ville" type="text" value="<%=((contact.getVille()!=null) ? contact.getVille() : "" )%>" ></p>
                    <p><label>Code Secteur : </label><select name="codeSecteur" id="codeSecteur">
                            <option></option>
                            <% for(Secteur secteur : listeSecteurs)
                            {%> <option <%=((secteur.getCode().equals(((contact.getCodeSecteur()!=null) ? contact.getCodeSecteur().getCode() : "" )))? "selected" : "")%>><%= secteur.getLibelle()%></option>
                            <% } %>
                        </select></p>
            </fieldset>
            <div id="submit">
                <input type="submit" name="enregistrer" value="enregistrer">
                <input type="submit" name="enregistrer" value="annuler">
            </div>
        </form>
        <footer><p><%=session.getAttribute("message")%></p></footer>
    </body>
</html>