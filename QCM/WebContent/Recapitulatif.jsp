<%@page import="fr.eni_ecole.qcm.controller.RecapitulatifServlet"%>
<%@page import="fr.eni_ecole.qcm.store.QuestionStore"%>
<%@page import="fr.eni_ecole.qcm.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import ="fr.eni_ecole.qcm.*, java.util.*, java.text.*" %>    
<%
Inscription insc = (Inscription)request.getSession().getAttribute("inscriptions");
ArrayList<QuestionQCM> questions= (ArrayList<QuestionQCM>)request.getSession().getAttribute("questions");
Integer cptrMarquee = (Integer)request.getAttribute("marquee");
Integer cptrNonRepondu = (Integer)request.getAttribute("nonrepondu");
Integer cptrMarqueeNonRepondu = (Integer)request.getAttribute("marqueeNonRepondu");
Integer nombre = (Integer)request.getAttribute("nombre");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QCM ENI Récapitulatif</title>
     <base href="http://localhost:8080/QCM/"/>
     <link rel="stylesheet" type="text/css" href="theme/Theme1.css" />
</head>
<body>
<body>
    <div id="page">
        <div class="header" >
            <div class="cadre"><h1>QCM ENI Récapitulatif</h1></div>
        </div>
        <div class="fond_selection">  
       
        <h5>Retournez voir les questions :</h5>
            <ul>     
                <li><a href ="#">Toutes les questions(<%=questions.size()%>/<%=nombre%>)</a></li>        
                <li><a href ="#">Les questions non repondues(<%=cptrNonRepondu%>/<%=nombre%>)</a></li>
                <li><a href ="#">Les questions marquées(<%=cptrMarquee%>/<%=nombre%>)</a></li>
                <li><a href ="#">Les questions marquées ou non répondues(<%=cptrMarqueeNonRepondu%>/<%=nombre%>)</a></li>
            </ul>
            <div align="right" class="Barre_Cloturer">
                <a href="<%=request.getContextPath()%>/QuestionQCM?pnumero=1" class="Bouton_Cloturer">Retour au test</a> 
                <a href="<%=request.getContextPath()%>/Resultat" class="Bouton_Cloturer">Clôturer</a> 
            </div>          
        </div>
        <div class="Pied_Page">
                <div class="cadre"><img  width=100%  src="image/pieddepageENI.png" ></div>
        </div>
     </div>
</body>
</html>