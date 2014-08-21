<%@page import="fr.eni_ecole.qcm.model.Inscription"%>
<%@page import="fr.eni_ecole.qcm.model.Test"%>
<%@ page  import ="fr.eni_ecole.qcm.*, java.util.*, java.text.*" %>
<%@ page language="java"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import ="fr.eni_ecole.qcm.*, java.util.*"
%>
<% ArrayList<Inscription> inscriptions = (ArrayList<Inscription>)request.getAttribute("inscriptions");%>
<!DOCTYPE html>
<html>
<head>
  <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type"/>
  <title>Liste des tests</title>
  <link media="all" rel="stylesheet" href="<%=request.getContextPath()%>/theme/Theme1.css" type="text/css"/>
</head>
<body>
<div id="page">
    <div class="header" >
        <div class="cadre"><h1>Accueil passage d'un test</h1></div>
    </div>
    <div class="fond_selection">
            <div class="barre_session"> 
                <div class="Nom_utilisateur">
                    <%@ include file="/IdentiteCandidat.jspf" %>
                </div>
            </div>
            <h2>Sélectionnez le test que vous souhaitez passer :</h2>
            <ul>
            <% for (Inscription i : inscriptions) {%>

               <li><a onclick="valider('<%=request.getContextPath()%>/QuestionQCM?inscription=<%=i.getIdInscription()%>')" href ="#"><%=i.getTest().getNom()%></a></li>

               <li><a href="/QCM/QuestionQCM.jsp"><%=i.getTest().getNom()%></a></li>

            <%}%>   
            </ul>
    </div>
    <%@ include file="/piedDePage.jspf" %>
    
    <div id="confirmation" class="fond_confirmation overlay_hidden"> 
        <h3> Confirmation </h3>
        <div class="Barre_Confirmation"> 
            <img class="displayed" width=10%  alt="" src="image/attention.jpg" align="left" />
            <p>Vous êtes sur le point de commencer le test </p>
            <div><%@ include file="/IdentiteTest.jspf" %></div>                        
        </div>
        <div class="barre_boutons_OuiNon"> 
            <a id="confirmer" href="#" class="Bouton_Oui" >Oui</a>
            <a onclick="fermer()" href="#" class="Bouton_Non" >Non</a>
        </div> 
    </div>
    
    
</div>
</body>
<script type="text/javascript">
function valider(link) {
	document.getElementById("confirmer").setAttribute("href",link);
	document.getElementById("confirmation").setAttribute("class","fond_confirmation overlay_shown");
}

function fermer() {
    document.getElementById("confirmation").setAttribute("class","fond_confirmation overlay_hidden");
}
</script>
</html>
