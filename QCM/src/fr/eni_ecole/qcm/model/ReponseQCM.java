package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class ReponseQCM implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private char cochee ;
	private int idReponse;
	private int idGenerationQCM;
	
	
	public ReponseQCM(char cochee, int idReponse, int idGenerationQCM) {
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


	public int getIdReponse() {
		return idReponse;
	}


	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}


	public int getIdGenerationQCM() {
		return idGenerationQCM;
	}


	public void setIdGenerationQCM(int idGenerationQCM) {
		this.idGenerationQCM = idGenerationQCM;
	}
	
	
	
	
	
	
	
	

}
