package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class ReponseQCM implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private char cochee ;
	private Reponse idReponse;
	private GenerationQCM idGenerationQCM;
	
	
	public ReponseQCM(char cochee, Reponse idReponse, GenerationQCM idGenerationQCM) {
		super();
		this.cochee = cochee;
		this.idReponse = idReponse;
		this.idGenerationQCM = idGenerationQCM;
	}


	public char getCochee() {
		return cochee;
	}


	public void setCochee(char cochee) {
		this.cochee = cochee;
	}


	public Reponse getIdReponse() {
		return idReponse;
	}


	public void setIdReponse(Reponse idReponse) {
		this.idReponse = idReponse;
	}


	public GenerationQCM getIdGenerationQCM() {
		return idGenerationQCM;
	}


	public void setIdGenerationQCM(GenerationQCM idGenerationQCM) {
		this.idGenerationQCM = idGenerationQCM;
	}
	
	
	
	
	
	
	
	

}
