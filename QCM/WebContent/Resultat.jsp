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
<body>
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
            
            
            <div class="Barre_Affichage_Resultat">
            <table>
            <tr> 
                <td></td><td><div align="right"  class="Barre_titre"><h5>Résultats: </h5></div></td>
            </tr>
            <% for (int i =1 ; i<count ; ++i) { %>
            <tr>
                <td class="Cellule_Section"><%=sections.get(i) %></td><td align="center" class="Cellule_Resultat"><%=resultat.get(i)%>/<%=nombreQuestion.get(i)%></td>
            </tr>
            <% } %>
            <tr>
                <td class="Cellule_Section"><%=sections.get(0) %></td><td align="center" class="Cellule_Resultat"><%=resultat.get(0)%>/<%=nombreQuestion.get(0)%></td>
            </tr>
            </table>           
            </div>
            
           <div class="Barre_Mail"> <p>Un mail a été envoyé au responsable de formation avec ce résultat</p></div>
           <div align="center"><a href="<%=request.getContextPath()%>/CandidatInscriptions" class="text_souligne">Fin du test</a></div>
        </div>
        
        <%@ include file="/piedDePage.jspf" %>
    </div>   
</body>
</html>