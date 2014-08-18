/**
 * 
 */
package fr.eni_ecole.qcm.model;

import java.io.Serializable;

/**
 * @author d144sellierb
 *
 */
public class Candidat implements Serializable{
	private Integer idCandidat;
	private String nom;
	private String prenom;
	private String motDePasse;
	private String login;
	private Promotion promo;
	
	public Candidat(Integer idCandidat, String nom, String prenom,
			String motDePasse, String login, Promotion promo) {
		super();
		this.idCandidat = idCandidat;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
		this.login = login;
		this.promo = promo;
	}

	public Candidat() {
		this(0, "","","","",null);
		
	}

	@Override
	public String toString() {
		return "Candidat [idCandidat=" + idCandidat + ", nom=" + nom
				+ ", prenom=" + prenom + ", login=" + login + ", Promo=" + (promo != null ? promo.getLibelle() : "NULL") + "]";
	}

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getIdCandidat() {
		return idCandidat;
	}

	public void setIdCandidat(Integer idCandidat) {
		this.idCandidat = idCandidat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Promotion getPromo() {
		return promo;
	}

	public void setPromo(Promotion promo) {
		this.promo = promo;
	}

}
