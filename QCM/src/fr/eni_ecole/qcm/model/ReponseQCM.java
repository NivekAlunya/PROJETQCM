package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class ReponseQCM implements Serializable{
	
	/**
	 * 
	 */
	private char cochee ;
	private Reponse reponse;
	private GenerationQCM generationQCM;

	public ReponseQCM (){
		this('-',null,null);
	}

	public ReponseQCM(char cochee, Reponse reponse, GenerationQCM generationQCM) {
		super();
		this.cochee = cochee;
		this.reponse = reponse;
		this.generationQCM = generationQCM;
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


	public GenerationQCM getGenerationQCM() {
		return generationQCM;
	}

	public void setGenerationQCM(GenerationQCM generationQCM) {
		this.generationQCM = generationQCM;
	}

	public char getCochee() {
		return cochee;
	}
}
