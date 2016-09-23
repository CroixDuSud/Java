<%-- 
    Document   : jspEnregModif
    Created on : 22 sept. 2016, 14:43:09
    Author     : afpa1800
--%>

<%@page import="java.util.Vector"%>
<%@page import="metierMapping.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% Contact contact;
Vector<Secteur> vSect;
Vector<Integer> vCodeSecteur;
String message;

try
{
    contact = (Contact) session.getAttribute("contact");
    vSect = (Vector<Secteur>) session.getAttribute("vSect");
    message = (String) session.getAttribute("message");
}

%>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" lang="fr">
<title>Gestion des Contacts</title>
<link href="style.css" type="text/css" rel="stylesheet"> 
</head>
    <body>
        <h2>"Enregistrement du contact effectué</h2>
        <p>
            <a href="index.jsp">Retour au menu principal</a>
        </p>
    </body>
</html>
