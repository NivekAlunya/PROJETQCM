package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class Promotion implements Serializable{
	private String codepromotion;
	private String libelle;
	
	
	@Override
	public String toString() {
		return "Promotion [codepromotion=" + codepromotion + ", libelle="
				+ libelle + "]";
	}

	public Promotion(String codepromotion, String libelle) {
		super();
		this.codepromotion = codepromotion;
		this.libelle = libelle;
	}
	
	public Promotion () {
		this(null, null);
	}
	
	public String getCodepromotion() {
		return codepromotion;
	}
	public void setCodepromotion(String codepromotion) {
		this.codepromotion = codepromotion;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
