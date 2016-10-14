<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% session.setAttribute("message", ""); %>
<% session.setAttribute("action", "list"); %>
<% session.setAttribute("numContact", ""); %>

<jsp:forward page="/accueil.jsp" />