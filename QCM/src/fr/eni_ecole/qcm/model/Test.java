package fr.eni_ecole.qcm.model;

import java.sql.Date;

public class Test 
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
		super();
	}
	
	
	public Test(int _idTest, Date _duree, String _nom, int _seuilAcquis, int _seuilEnCours, int _nbSection )
	{
		this.idTest=_idTest;
		this.duree=_duree;
		this.nom=_nom;
		this.seuilAcquis=_seuilAcquis;
		this.seuilEnCours=_seuilEnCours;
		this.nbSection=_nbSection;
	}	
}
