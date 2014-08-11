package fr.eni_ecole.qcm.model;

import java.io.Serializable;
import java.sql.Date;

public class Test implements Serializable
{
	private int idTest;
	private Date duree;
	private String nom;
	private int seuilAcquis;
	private int seuilEnCours;
	private int nbSection;
	
	
	public int getIdTest() {
		return idTest;
	}
	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}
	public Date getDuree() {
		return duree;
	}
	public void setDuree(Date duree) {
		this.duree = duree;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getSeuilAcquis() {
		return seuilAcquis;
	}
	public void setSeuilAcquis(int seuilAcquis) {
		this.seuilAcquis = seuilAcquis;
	}
	public int getSeuilEnCours() {
		return seuilEnCours;
	}
	public void setSeuilEnCours(int seuilEnCours) {
		this.seuilEnCours = seuilEnCours;
	}
	public int getNbSection() {
		return nbSection;
	}
	public void setNbSection(int nbSection) {
		this.nbSection = nbSection;
	}
	
	
	public Test()
	{
		this(0,null,"",0,0,0);
	}
	
	
	public Test(int idTest, Date duree, String nom, int seuilAcquis, int seuilEnCours, int nbSection )
	{
		super();
		this.idTest=idTest;
		this.duree=duree;
		this.nom=nom;
		this.seuilAcquis=seuilAcquis;
		this.seuilEnCours=seuilEnCours;
		this.nbSection=nbSection;
	}	
}
