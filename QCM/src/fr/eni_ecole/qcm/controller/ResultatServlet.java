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

import fr.eni_ecole.qcm.model.Inscription;
import fr.eni_ecole.qcm.model.QuestionQCM;
import fr.eni_ecole.qcm.model.ReponseQCM;
import fr.eni_ecole.qcm.store.InscriptionStore;
import fr.eni_ecole.qcm.store.QuestionQCMStore;
import fr.eni_ecole.qcm.store.TestStore;

/**
 * Servlet implementation class ResultatServlet
 */
public class ResultatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ServletContext contexte = null ;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultatServlet() {
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
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doRequest(request,response);
	}

	private void doRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// récuperer l'inscription dans la session
		Inscription insc = null;
		ArrayList<QuestionQCM> questions = null;
		ArrayList<Integer> resultat = new ArrayList<Integer>();
		ArrayList<Integer> nombreQuestion = new ArrayList<Integer>();
		ArrayList<String> sections = new ArrayList<String>();
		Integer cptrSection=0; 
		Integer lastIdTheme = 0;
		
		if(request.getSession().getAttribute("inscription") != null ) {
			insc = (Inscription)request.getSession().getAttribute("inscription");
			insc.getTest();
			questions = (ArrayList<QuestionQCM>)request.getSession().getAttribute("questions");
			System.out.println(questions);
			resultat.add(0);
			nombreQuestion.add(0);
			sections.add("Résultat global");
			for (QuestionQCM question : questions) {
				if (lastIdTheme != question.getQuestion().getTheme().getIdTheme()) {
					cptrSection++;
					lastIdTheme = question.getQuestion().getTheme().getIdTheme();
					sections.add(question.getQuestion().getTheme().getNom());
					resultat.add(0);
					nombreQuestion.add(0);
				}
				Integer count = nombreQuestion.get(cptrSection) +1 ;  
				nombreQuestion.set(cptrSection, count);
				//nmbre de reponse global
				count = nombreQuestion.get(0) +1 ;
				nombreQuestion.set(0, count);
				
				
				boolean cor = true;
				for(ReponseQCM rq : question.getReponsesQCM()) {
					if ((rq.getCochee() == 'O' && 'O' != rq.getReponse().getCorrecte()) 
							|| rq.getCochee() != 'O' && 'O' == rq.getReponse().getCorrecte()) {
						cor = false;
					}
				}
				
				if (cor) {
					count = resultat.get(cptrSection) +1 ;  
					resultat.set(cptrSection, count);
					//indice 0 = resultat global
					count = resultat.get(0) +1 ;  
					resultat.set(0, count);
				}
			}
		}
		
		
		
		request.setAttribute("resultat", resultat);
		request.setAttribute("sections", sections);
		request.setAttribute("nombreQuestion", nombreQuestion);
		contexte.getRequestDispatcher("/Resultat.jsp").forward(request, response);
		
		
	}
}
