package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class Promotion implements Serializable{
	private String codePromotion;
	private String libelle;
	
	
	@Override
	public String toString() {
		return "Promotion [codepromotion=" + codePromotion + ", libelle="
				+ libelle + "]";
	}

	public Promotion(String codepromotion, String libelle) {
		super();
		this.codePromotion = codepromotion;
		this.libelle = libelle;
	}
	
	public Promotion () {
		this("----------", "");
	}
	
	public String getCodePromotion() {
		return codePromotion;
	}
	public void setCodePromotion(String codepromotion) {
		this.codePromotion = codepromotion;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
