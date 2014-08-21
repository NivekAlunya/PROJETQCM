<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni_ecole.qcm.model.*,java.util.*" %>
<%
QuestionQCM questionqcm = (QuestionQCM)request.getAttribute("questionqcm");
ArrayList<QuestionQCM> questionsqcm  = (ArrayList<QuestionQCM>)request.getSession().getAttribute("questions");
Integer numero = (Integer)request.getAttribute("numero");
Integer count = questionsqcm.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Passage d'un Test</title>
    <base href="http://localhost:8080/QCM/"/>
    <link rel="stylesheet" type="text/css" href="theme/Theme1.css" />
</head>
<body>
  <div id="page">
    <div class="header" >
        <div class="cadre"><h1>Passage d'un test</h1></div>
    </div>
    <div class="fond_selection">
        <div class="barre_session" align="center">
            <div class="Barre_utilisateur">
                <%@ include file="/IdentiteCandidat.jspf" %>
            </div>
            <div align="center" class="Test_Selectionner">
                <%=questionqcm.getInscription().getTest().getNom()%>
            </div>
            <div class="Chronometre">
                <!-- include chronometre -->
            </div>
        </div>
        <div class="barre_Recap_Question">
            <div class="Numero_question">
                <%=numero%> / <%=count %> - <%=questionqcm.getQuestion().getTheme().getNom()%>
            </div>
        </div>      
        <h5><%=questionqcm.getQuestion().getEnonce()%></h5><br />
        <section>
            <form action="<%=request.getContextPath()%>/QuestionQCM" method="post" enctype="application/x-www-form-urlencoded">
            <% for (ReponseQCM r : questionqcm.getReponsesQCM()) { %>
            <fieldset>
                <div class="Radio_Bouton">
                    <div class="round">
                    <%String checked =  r.getCochee() == 'O' ? " checked=\"checked\"" : ""; %>
                        <input type="radio" class="radio" id="reponse:<%=r.getReponse().getIdReponse()%>" name="reponse" value="<%=r.getReponse().getIdReponse()%>"<%=checked %>>
                    </div>               
                </div>
                <label for="reponse:<%=r.getReponse().getIdReponse()%>"><%=r.getReponse().getProposition()%></label>
             </fieldset>
            <% } %>
            <fieldset> 
                <div class="barre_marquage_Question">       
                <div class="Checkbox">
                    <%String marquee = questionqcm.getMarque().equals("O") ? " checked=\"checked\"" : ""; %>                
                    <input type="checkbox" value="O" name="marquee"<%=marquee%> />
                    <label for="Checkbox">marquer cette question</label>          
                </div>
                </div> 
                <div class="barre_Bouton_Test">
                <input class="Bouton_Valider" type="submit" value="Valider" />
                <a href="/Recapitulatif" class="text_souligne">Avancement</a>
                <!--input class="Bouton_Avancement" type="submit" value="Avancement" /-->
                <input type="hidden" value="<%=numero%>" name="numero" />
                </div>            
            </fieldset>
            </form>
        </section>
        <div class="barre_Navigation" align="center">
            <div align="center"  class="Barre_Fleche">
                <div class="text_souligne"><a href="<%=request.getContextPath()%>/QuestionQCM?pnumero=<%=(numero-1 < 1 ? count : numero -1 )%>"> Précédent </a> - <a href="<%=request.getContextPath()%>/QuestionQCM?pnumero=<%=(numero + 1 > count ? 1 : numero + 1 )%>"> Suivant </a></div>
                <!--a href="static/ConfirmationRecapitulatif.html" id="Barre_Recapitulatif" class="Bouton_Recapitulatif" >Récapitulatif</a-->                                       
            </div>              
        </div> 
   </div>
   <div class="Pied_Page">
        <div class="cadre"><img  width=100%  src="<%=request.getContextPath()%>/image/pieddepageENI.png" ></div>
   </div>  
</div>
</body>
</html>