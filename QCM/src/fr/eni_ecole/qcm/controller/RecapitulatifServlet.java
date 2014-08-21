package fr.eni_ecole.qcm.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.qcm.model.Candidat;
import fr.eni_ecole.qcm.model.Inscription;
import fr.eni_ecole.qcm.model.Question;
import fr.eni_ecole.qcm.model.QuestionQCM;
import fr.eni_ecole.qcm.model.ReponseQCM;
import fr.eni_ecole.qcm.store.InscriptionStore;
import fr.eni_ecole.qcm.store.QuestionQCMStore;
import fr.eni_ecole.qcm.store.QuestionStore;

/**
 * Servlet implementation class RecapitulatifServlet
 */
public class RecapitulatifServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ServletContext contexte = null ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecapitulatifServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		contexte = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			processRequest(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			System.out.println("processRequest " + response + " " + request);
			 int cptrMarquee = 0, cptrNonRepondu = 0 , cptrMarqueeNonRepondu = 0;
			 boolean marquee, repondu;
			
			ArrayList<QuestionQCM> questions;
			// Construire la liste des questions et la placer en session
			try {
				questions=(ArrayList<QuestionQCM>)request.getSession().getAttribute("questions");
				System.out.println(questions);
				
				for (QuestionQCM questionQCM : questions) {
					repondu = marquee = false;

					if ( questionQCM.getMarque().equals("O")) { 
						cptrMarquee++;
						marquee=true;
					}
					
					for (ReponseQCM reponseQCM : questionQCM.getReponsesQCM()) {
						if ( reponseQCM.getCochee()=='O'){
							repondu=true;
						}
					}
					
					if (!repondu) {
						cptrNonRepondu++;
					}
					
					if (!repondu || marquee){
						cptrMarqueeNonRepondu++;
					}	
				}
				request.setAttribute("nombre",questions.size());
				request.setAttribute("marquee",cptrMarquee);
				request.setAttribute("nonrepondu", cptrNonRepondu);
				request.setAttribute("marqueeNonRepondu", cptrMarqueeNonRepondu);
				RequestDispatcher dispatcher= null;
				dispatcher = request.getRequestDispatcher("/Recapitulatif.jsp"); 
				dispatcher.forward(request, response);
				return;
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
}
