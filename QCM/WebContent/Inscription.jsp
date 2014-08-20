<%@page import="fr.eni_ecole.qcm.model.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
ArrayList<Candidat> candidats = (ArrayList<Candidat>)request.getAttribute("candidats");
ArrayList<Test> tests = (ArrayList<Test>)request.getAttribute("tests");

%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<title>QCM ENI - Inscription</title>
<link rel="stylesheet" type="text/css" href="theme/Theme1.css" />
</head>

<body style="width:100%;">
    <div id="page" style="margin:0 100px">
        <div class="header" >
        <div class="cadre"><h1>Inscription</h1></div>
        </div>
        <div class="fond_selection">
            <div class="barre_session"> 
                <div class="Nom_utilisateur">
                <%@ include file="/IdentiteFormateur.jspf" %>
                </div>
            </div>
        <nav>
            <a href="default.jsp">Accueil</a> <b> | Inscrire à un test </b>
        </nav>
        <form action="" method="post" enctype="application/x-www-form-urlencoded">
            <fieldset>
               <label for="listeTest">Test :</label>
               <select id="listeTest" name="test">
                <option disabled="disabled">Choisir un test</option>
                <%for (Test test: tests ) { %>
                    <option value="<%=test.getIdTest()%>"><%=test.getNom()%></option>
               <% } %>
               </select>
            </fieldset>
            <fieldset>
                <label for="dateDebut">Activée le : </label>
                <input type="datetime" name="dateDebut" id="dateDebut"/> 
                <label for="dateFin">jusqu'au: </label>
               <input type="datetime" name="dateFin" id="dateFin" /> 
            </fieldset>
            <fieldset>
              <ul>
              <% for (Candidat candidat: candidats){ %>
                  <li><input name="candidats" type="checkbox" value="<%=candidat.getIdCandidat()%>" /><label><%=candidat.getNom().toUpperCase() + " " + candidat.getPrenom()%></label>
                  <% } %>
              </ul>
            </fieldset>
            <fieldset>
              <button type="submit" name="validerForm" value="valider">Envoyer</button>
              <button type="reset" name="annulerForm" value="annuler">Annuler</button>
              <a href="<%=request.getContextPath()%>/AccueilAdministration.jsp">Retour Acceuil</a>
            </fieldset>
        </form>
       
    </div>
        <%@ include file="/piedDePage.jspf" %>
    </div>
</body>
</html>
