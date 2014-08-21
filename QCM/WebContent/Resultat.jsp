<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni_ecole.qcm.model.*,java.util.*" %>
<%
ArrayList<Integer> resultat = (ArrayList<Integer>)request.getAttribute("resultat");
ArrayList<Integer> nombreQuestion = (ArrayList<Integer>)request.getAttribute("nombreQuestion");
ArrayList<String> sections = (ArrayList<String>)request.getAttribute("sections");
Integer count = sections.size();
Inscription insc = (Inscription)request.getSession().getAttribute("inscription");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="http://localhost:8080/QCM/"/>
<title>QCM ENI - Résultat</title>
<link rel="stylesheet" type="text/css" href="theme/Theme1.css" />
</head>
<body style="width:100%;">
    <div id="page">
        <div class="header" >
            <div class="cadre"><h1>Résultats</h1></div>
        </div>
        <div class="fond_selection">
            <div class="barre_session" align="center"> 
                <div class="Barre_utilisateur">
	               <%@ include file="/IdentiteCandidat.jspf" %>
                </div>
	            <div class="Test_Selectionner">
	                <%=insc.getTest().getNom()%>
	            </div>
            </div>
            <a>Résultats: </a> </br>
            <ul> 
            <% for (int i =1 ; i<count ; ++i) { %>
                <li><p><%=sections.get(i) %> : <%=resultat.get(i)%>/<%=nombreQuestion.get(i)%></p></li>
            <% } %>
                <li><p><%=sections.get(0) %> : <%=resultat.get(0)%>/<%=nombreQuestion.get(0)%></p></li>
            </ul>
            <!--p>Un mail a été envoyé au responsable de formation avec ce résultat</p-->
        </div>
        <div class="Pied_Page">
            <div class="cadre"><img  width=100%  src="image/pieddepageENI.png" ></div>
        </div>
    </div>
</body>
</html>