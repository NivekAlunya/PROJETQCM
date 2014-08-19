package fr.eni_ecole.qcm.model;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionQCM implements Serializable{
	
	private int idQuestionQCM;
	private String marque;
	private Inscription inscription;
	private Question question;
	private ArrayList<ReponseQCM> reponsesQCM;
	
	public QuestionQCM(int idQuestionQCM, String marque,
			Inscription inscription, Question question,
			ArrayList<ReponseQCM> reponsesQCM) {
		super();
		this.idQuestionQCM = idQuestionQCM;
		this.marque = marque;
		this.inscription = inscription;
		this.question = question;
		this.reponsesQCM = reponsesQCM == null ? new ArrayList<ReponseQCM>() : reponsesQCM;
	}
	
	public QuestionQCM() {
		this(0,"",null,null,null);
	}
	
	public ArrayList<ReponseQCM> getReponsesQCM() {
		return reponsesQCM;
	}

	public void setReponsesQCM(ArrayList<ReponseQCM> reponsesQCM) {
		this.reponsesQCM = reponsesQCM;
	}

	public int getIdQuestionQCM() {
		return idQuestionQCM;
	}
	
	public void setIdQuestionQCM(int idQuestionQCM) {
		this.idQuestionQCM = idQuestionQCM;
	}
	
	public String getMarque() {
		return marque;
	}
	
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	public Inscription getInscription() {
		return inscription;
	}
	
	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public void setQuestion(Question question) {
		this.question = question;
	}

}
