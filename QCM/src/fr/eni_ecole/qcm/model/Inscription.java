/**
 * 
 */
package fr.eni_ecole.qcm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.*;

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
	private String email;
	private Integer tempsEcoule;
	private ArrayList<QuestionQCM> questions;
	
	@Override
	public String toString() {
		return "Inscription [idInscription=" + idInscription + ", candidat="
				+ candidat.toString() + ", test=" + test.toString() + ", typeInscription="
				+ typeInscription + ", rapport=" + rapport + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", eMail=" + email
				+ ", tempsEcoule=" + tempsEcoule + "]";
	}

	public Inscription(Integer idInscription, Candidat candidat,
			Test test, String typeInscription, String rapport,
			Date dateDebut, Date dateFin, String email, Integer tempsEcoule) {
		super();
		this.idInscription = idInscription;
		this.candidat = candidat;
		this.test = test;
		this.typeInscription = typeInscription;
		this.rapport = rapport;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.email = email;
		this.tempsEcoule = tempsEcoule;
		this.questions = null;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (typeInscription == "ECF")
		{
			this.email = email;
			}
		else {
			this.email = null;
		}
	}

	public Integer getTempsEcoule() {
		return tempsEcoule;
	}

	public void setTempsEcoule(Integer tempsEcoule) {
		this.tempsEcoule = tempsEcoule;
	}

}
