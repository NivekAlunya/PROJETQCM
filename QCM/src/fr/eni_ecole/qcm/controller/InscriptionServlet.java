package fr.eni_ecole.qcm.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import microsoft.sql.DateTimeOffset;

import fr.eni_ecole.qcm.model.Administrateur;
import fr.eni_ecole.qcm.model.Candidat;
import fr.eni_ecole.qcm.model.Inscription;
import fr.eni_ecole.qcm.model.Test;
import fr.eni_ecole.qcm.store.CandidatStore;
import fr.eni_ecole.qcm.store.InscriptionStore;
import fr.eni_ecole.qcm.store.TestStore;

/**
 * Servlet implementation class InscriptionServlet
 */
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext contexte = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	contexte = config.getServletContext();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		gotoFormulaire(request,response);
	}

	private void gotoFormulaire(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("tests", TestStore.listeTest());
		request.setAttribute("candidats", CandidatStore.listerCandidat());
		java.util.Date today = new java.util.Date();
		request.setAttribute("dateDebut",new java.sql.Timestamp(today.getTime()));
		RequestDispatcher dispatcher = contexte.getRequestDispatcher("/Inscription.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		//Récupération de la liste des idcandidats
		String[] idcandidats = request.getParameterValues("candidats");
		if (idcandidats == null) {
			gotoFormulaire(request, response);
			return;
		}
		//Récupération du test sélectioné
		String test = request.getParameter("test");
		//Récupération des dates de Début/Fin
		String dateDebut = request.getParameter("dateDebut");
		String dateFin = request.getParameter("dateFin");
		Administrateur administrateur = (Administrateur)request.getSession().getAttribute("administrateur");
		//Création des inscriptions (1 inscription par candidat) + ajout de l'inscription à la BD
		for (String idcandidat : idcandidats) {
			Candidat candidat=CandidatStore.rechercher(Integer.parseInt(idcandidat));
			if(candidat == null) continue;
			
			Inscription inscription = new Inscription();
			inscription.setCandidat(candidat);
			try {
				inscription.setDateDebut(Date.valueOf(dateDebut));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				inscription.setDateFin(Date.valueOf(dateFin));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (administrateur.getEmail() != null) {
				inscription.setEmail(administrateur.getEmail());
			}

			inscription.setTest(TestStore.rechercherTest(Integer.parseInt(test)));

			InscriptionStore.ajouter(inscription); //Insertion de l'inscription dans la BD
			System.out.println("Inscription ajoutée");
		
		}
		gotoFormulaire(request, response);
		return;
	}

}
