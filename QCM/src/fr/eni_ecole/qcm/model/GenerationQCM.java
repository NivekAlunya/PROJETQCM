package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class GenerationQCM implements Serializable{
	
	private int idGenerationQCM;
	private String marque;
	private int idInscription;
	private int idTheme;
	private int idTest;
	private int idQuestion;
	
	
	
	
	
	public GenerationQCM(int idGenerationQCM, String marque, int idInscription,
			int idTheme, int idTest, int idQuestion) {
		super();
		this.idGenerationQCM = idGenerationQCM;
		this.marque = marque;
		this.idInscription = idInscription;
		this.idTheme = idTheme;
		this.idTest = idTest;
		this.idQuestion = idQuestion;
	}
	
	
	
	public int getIdGenerationQCM() {
		return idGenerationQCM;
	}
	public void setIdGenerationQCM(int idGenerationQCM) {
		this.idGenerationQCM = idGenerationQCM;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public int getIdInscription() {
		return idInscription;
	}
	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}
	public int getIdTheme() {
		return idTheme;
	}
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}
	public int getIdTest() {
		return idTest;
	}
	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	
	
	
	
	
	
	
	

}
