package fr.eni_ecole.qcm.store;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni_ecole.qcm.model.Candidat;
import fr.eni_ecole.qcm.model.Promotion;

public class CandidatStore {
	
	public static void ajouter(Candidat candidat){
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{

			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{CALL dbo.insertCandidat(?,?,?,?,?)}");
			cstmt.setString(1, candidat.getNom());
			cstmt.setString(2, candidat.getPrenom());
			cstmt.setString(3, candidat.getMotDePasse());
			cstmt.setString(4, candidat.getPromo().getCodePromotion());
			cstmt.registerOutParameter(5, java.sql.Types.INTEGER);
			cstmt.execute();
			candidat.setIdCandidat(cstmt.getInt(5));
			
			
			
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
	
	public static void modifier (Candidat candidat){
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{
			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{CALL dbo.UpdateCandidat(?,?,?,?,?)}");
			cstmt.setInt(1, candidat.getIdCandidat());
			cstmt.setString(2, candidat.getNom());
			cstmt.setString(3, candidat.getPrenom());
			cstmt.setString(4, candidat.getMotDePasse());
			cstmt.setString(5, candidat.getPromo().getCodePromotion());
			cstmt.execute();

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
	
	public static void supprimer (Candidat candidat){
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{
			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{CALL dbo.deleteCandidat(?)}");
			cstmt.setInt(1, candidat.getIdCandidat());
			cstmt.execute();
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
	
	public static ArrayList<Candidat> listerCandidat(){
		Connection cnx = null;
		Statement rqt = null;
		
		ResultSet rs = null;
		ArrayList<Candidat> listeCandidat = new ArrayList<Candidat>();
		
		try {
			cnx = PoolConnexion.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery("SELECT c.idCandidat, c.Nom, c.Prenom, c.MotDePasse as MDP, p.codePromotion,p.Libelle FROM Candidats c LEFT OUTER JOIN Promotions p ON p.codePromotion = c.codePromotion");
			Candidat candidat = null;
			Promotion promotion = null;
			while (rs.next()){
				promotion = new Promotion(rs.getString("codePromotion"),rs.getString("Libelle"));
				candidat = new Candidat(
						rs.getInt("idCandidat"),
						rs.getString("Nom"),
						rs.getString("Prenom"),
						rs.getString("MDP"),
						promotion);					
				listeCandidat.add(candidat);				
			}
		} catch (Exception e) {
		}
		finally{
			try {
				if (rqt!=null) rqt.close();
				if (cnx!=null) cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeCandidat;
	}
	
	public static Candidat rechercher(int idCandidat) throws Exception{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		Candidat candidat = null;
		try{
			cnx=PoolConnexion.getConnection();
			rqt=cnx.prepareStatement("select c.idCandidat, c.Nom, c.Prenom, c.MotDePasse, p.codePromotion, p.Libelle from Candidats c LEFT OUTER JOIN Promotions p ON p.codePromotion = c.codePromotion WHERE idCandidat = ?");
			rqt.setInt(1, idCandidat);
			rs=rqt.executeQuery();
			Promotion promotion = null;
			
			if (rs.next()){
				promotion = new Promotion(rs.getString("codePromotion"), rs.getString("Libelle"));
				candidat = new Candidat();
				candidat.setIdCandidat(idCandidat);
				candidat.setNom(rs.getString("Nom"));
				candidat.setPrenom(rs.getString("Prenom"));
				candidat.setMotDePasse(rs.getString("MotDePasse"));
				candidat.setPromo(promotion);
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return candidat;
	}	
	
}
