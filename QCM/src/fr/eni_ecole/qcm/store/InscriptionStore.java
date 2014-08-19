package fr.eni_ecole.qcm.store;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni_ecole.qcm.model.Candidat;
import fr.eni_ecole.qcm.model.Inscription;
import fr.eni_ecole.qcm.model.Promotion;
import fr.eni_ecole.qcm.model.Test;

public class InscriptionStore {
	
	public static void ajouter(Inscription inscription){
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{CALL dbo.insertInscription(?,?,?,?,?,?,?,?,?)}");
			cstmt.setInt(1, inscription.getCandidat().getIdCandidat());
			cstmt.setInt(2, inscription.getTest().getIdTest());
			cstmt.setString(3, inscription.getRapport());
			if (null != inscription.getDateDebut()) {
				cstmt.setDate(4, new java.sql.Date(inscription.getDateDebut().getTime())); //TODO
			} else {
				cstmt.setNull(4, java.sql.Types.DATE);
			}
			if (null != inscription.getDateFin()) {
				cstmt.setDate(5, new java.sql.Date(inscription.getDateFin().getTime())); //TODO
			} else {
				cstmt.setNull(5, java.sql.Types.DATE);
			}
			cstmt.setString(6, inscription.getEmail());
			cstmt.setString(7,inscription.getTypeInscription());
			cstmt.setInt(8,inscription.getTempsEcoule());
			cstmt.registerOutParameter(9, java.sql.Types.INTEGER);
			cstmt.execute();
			inscription.setIdInscription(cstmt.getInt(9));
			
		} catch (Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				if (rqt!=null) rqt.close();
				if (cnx!=null) cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void modifier (Inscription inscription){
		CallableStatement cstmt = null;
		Connection cnx=null;
		try{
			cnx=PoolConnexion.getConnection();
			cstmt = cnx.prepareCall("{CALL dbo.UpdateInscription(?,?,?,?,?,?,?,?,?)}");
			cstmt.setInt(1, inscription.getIdInscription());
			cstmt.setInt(2, inscription.getCandidat().getIdCandidat());
			cstmt.setInt(3, inscription.getTest().getIdTest());
			cstmt.setString(4, inscription.getRapport());
			cstmt.setDate(5, new java.sql.Date(inscription.getDateDebut().getTime())); //TODO
			cstmt.setDate(6, new java.sql.Date(inscription.getDateFin().getTime()));
			cstmt.setString(7, inscription.getEmail());
			cstmt.setString(8,inscription.getTypeInscription());
			cstmt.setInt(9,inscription.getTempsEcoule());
			cstmt.execute();

		} catch (Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				if (cstmt!=null) cstmt.close();
				if (cnx!=null) cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void supprimer (Inscription inscription){
		CallableStatement cstmt = null;
		Connection cnx=null;
		try{
			cnx=PoolConnexion.getConnection();
			cstmt = cnx.prepareCall("{CALL dbo.deleteInscription(?)}");
			cstmt.setInt(1, inscription.getIdInscription());
			cstmt.execute();
		} catch (Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				if (cstmt!=null) cstmt.close();
				if (cnx!=null) cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Inscription rechercher(int idInscription) {
		String query = "select i.idInscription, c.idCandidat, c.Nom, c.Prenom, c.login, " +
				" c.MotDePasse, c.codePromotion, t.idTest, t.duree, t.Nom as NomTest, t.SeuilAcquis, t.SeuilEnCours, " +
				" t.NbSection, i.typeInscription, i.Rapport, i.dateDebut, i.dateFin, i.eMail, i.tempsEcoule, " +
				" p.codePromotion, p.Libelle " +
				" FROM Inscriptions i " +
				" INNER JOIN Candidats c ON c.idCandidat = i.idCandidat " +
				" INNER JOIN Tests t ON t.idTest=i.idtest " +
				" LEFT OUTER JOIN Promotions p ON p.codePromotion = c.codePromotion " +
				" WHERE i.idInscription = ?";
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;

		try {
			cnx=PoolConnexion.getConnection();
			rqt=cnx.prepareStatement(query);
			rqt.setInt(1, idInscription);
			rs=rqt.executeQuery();
			Promotion promotion = null;
			Candidat candidat = null;
			Test test = null;
			if (rs.next()){
				rs.getString("codePromotion");
				if (!rs.wasNull() && !rs.getString("codePromotion").isEmpty()) {
					promotion = new Promotion(rs.getString("codePromotion"), rs.getString("Libelle"));
				} else {
					promotion = null;
				}
				candidat = new Candidat(rs.getInt("idCandidat"), rs.getString("Nom"), rs.getString("Prenom"), rs.getString("login"), rs.getString("MotDePasse"), promotion);
				test = new Test(rs.getInt("idTest"), rs.getInt("duree"), rs.getString("NomTest"), 
						rs.getInt("seuilAcquis"), rs.getInt("seuilEnCours"), rs.getInt("nbSection"));
				
				return new Inscription(
						rs.getInt("idInscription"),
						candidat,
						test,
						rs.getString("typeInscription"),
						rs.getString("rapport"),
						rs.getDate("dateDebut"),
						rs.getDate("dateFin"),
						rs.getString("eMail"),
						rs.getInt("tempsEcoule"));
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (rs!=null) rs.close();
				if (rqt!=null) rqt.close();
				if (cnx!=null) cnx.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}	
}
