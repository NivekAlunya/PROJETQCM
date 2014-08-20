package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class ReponseQCM implements Serializable{
	
	/**
	 * 
	 */
	private char cochee ;
	private Reponse reponse;
	private QuestionQCM questionQCM;

	public ReponseQCM (){
		this('-',null,null);
	}

	public ReponseQCM(char cochee, Reponse reponse, QuestionQCM questionQCM) {
		super();
		this.cochee = cochee;
		this.reponse = reponse;
		this.questionQCM = questionQCM;
	}

	public void setCochee(char cochee) {
		this.cochee = cochee;
	}

	public Reponse getReponse() {
		return reponse;
	}

	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}


	public QuestionQCM getQuestionQCM() {
		return questionQCM;
	}

	public void setGenerationQCM(QuestionQCM questionQCM) {
		this.questionQCM = questionQCM;
	}

	public char getCochee() {
		return cochee;
	}
}
