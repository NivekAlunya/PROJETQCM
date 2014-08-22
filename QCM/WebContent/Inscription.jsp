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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/theme/Theme1.css" />
</head>

<body>
    <div id="page">
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
            <a class="text_souligne" href="default.jsp">Accueil</a> <b> | Inscrire à un test </b>
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
                  <div class="Barre_Date_Debut">
                       <label for="dateDebut">Activée le : </label>
                       <input type="datetime" name="dateDebut" id="ChampDateDebut" /> 
                   </div>
                   <div class="Barre_Date_Fin">
                        <label for="dateFin">jusqu'au: </label>
                        <input  type="datetime" name="dateFin" id="ChampDateFin" /> 
                    </div>         
            </fieldset>
            <fieldset>
              <ul>
              <% for (Candidat candidat: candidats){ %>
                  <li><input class="text_souligne" name="candidats" type="checkbox" value="<%=candidat.getIdCandidat()%>" /><label><%=candidat.getNom().toUpperCase() + " " + candidat.getPrenom()%></label>
                  <% } %>
              </ul>
            </fieldset>
            <fieldset>
              <button class="Bouton_Envoyer" type="submit" name="validerForm" value="valider" >Envoyer</button>
              <button class="Bouton_Annuler" type="reset" name="annulerForm" value="annuler" >Annuler</button>
              <div class="Barre_Retour_Accueil"> <a class="text_souligne" href="<%=request.getContextPath()%>/AccueilAdministration.jsp">Retour Accueil</a></div>
            </fieldset>
        </form>
       
    </div>
        <%@ include file="/piedDePage.jspf" %>
    </div>
</body>
</html>
