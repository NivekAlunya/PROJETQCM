/**
 * 
 */
package fr.eni_ecole.qcm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author d144sellierb
 *
 */
public class Inscription implements Serializable{
	private Integer idInscription;
	private Candidat candidat;
	private Test test;
	private String typeInscription;
	private String rapport;
	private Date dateDebut;
	private Date dateFin;
	private String eMail;
	private Integer tempsEcoule;
	
	
	

	@Override
	public String toString() {
		return "Inscription [idInscription=" + idInscription + ", candidat="
				+ candidat.toString() + ", test=" + test.toString() + ", typeInscription="
				+ typeInscription + ", rapport=" + rapport + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", eMail=" + eMail
				+ ", tempsEcoule=" + tempsEcoule + "]";
	}

	public Inscription(Integer idInscription, Candidat candidat,
			Test test, String typeInscription, String rapport,
			Date dateDebut, Date dateFin, String eMail, Integer tempsEcoule) {
		super();
		this.idInscription = idInscription;
		this.candidat = candidat;
		this.test = test;
		this.typeInscription = typeInscription;
		this.rapport = rapport;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.eMail = eMail;
		this.tempsEcoule = tempsEcoule;
	}
	
	public Inscription (){
		this(0,null,null,"","",null, null, "",0);
	}


	public Integer getIdInscription() {
		return idInscription;
	}




	public void setIdInscription(Integer idInscription) {
		this.idInscription = idInscription;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String getTypeInscription() {
		return typeInscription;
	}

	public void setTypeInscription(String typeInscription) {
		this.typeInscription = typeInscription;
	}

	public String getRapport() {
		return rapport;
	}


	public void setRapport(String rapport) {
		this.rapport = rapport;
	}

	public Date getDateDebut() {
		return dateDebut;
	}




	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}




	public Date getDateFin() {
		return dateFin;
	}




	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}




	public String geteMail() {
		return eMail;
	}




	public void seteMail(String eMail) {
		if (typeInscription == "ECF")
		{
			this.eMail = eMail;
			}
		else {
			this.eMail = null;
		}
		
	}




	public Integer getTempsEcoule() {
		return tempsEcoule;
	}




	public void setTempsEcoule(Integer tempsEcoule) {
		this.tempsEcoule = tempsEcoule;
	}



}
