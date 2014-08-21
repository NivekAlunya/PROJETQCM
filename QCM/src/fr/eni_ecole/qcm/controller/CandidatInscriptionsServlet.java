package fr.eni_ecole.qcm.controller;



import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.qcm.model.*;

import fr.eni_ecole.qcm.store.*;

/**
 * Servlet implementation class ListerTests
 */
public class CandidatInscriptionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ServletContext contexte = null ;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidatInscriptionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		contexte = config.getServletContext();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		System.out.println("processRequest " + response + " " + request);
		Candidat c = (Candidat)request.getSession().getAttribute("candidat");
		
		ArrayList<Inscription> listeInscription;
		// Construire la liste des tests et la placer en session
		try {
			listeInscription = InscriptionStore.rechercherInscription(c.getIdCandidat());
			System.out.println(listeInscription);
			request.setAttribute("inscriptions", listeInscription);			
			RequestDispatcher dispatcher= null;
			dispatcher = request.getRequestDispatcher("/CandidatInscriptions.jsp"); 
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
protected void redirectionErreur(Exception e, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Placer l'objet représentant l'exception dans le contexte de requete
	
		request.setAttribute("erreur", e);
		// Passer la main à la page de présentation des erreurs
		RequestDispatcher dispatcher = request.getRequestDispatcher("/static/Erreur.jsp"); 
		dispatcher.forward(request, response);

	}
}	



		