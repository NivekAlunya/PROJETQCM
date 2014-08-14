package fr.eni_ecole.qcm.store;

import fr.eni_ecole.qcm.model.Promotion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PromotionStore {

	public static void ajouter(Promotion promotion)
	{
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{

			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{CALL dbo.insertPromotion(?, ?)}");
			cstmt.setString(1, promotion.getCodePromotion());
			cstmt.setString(2, promotion.getLibelle());
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
	
	public static void modifier(Promotion promotion)
	{
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{
			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{CALL dbo.UpdatePromotion(?, ?)}");
			cstmt.setString(1, promotion.getCodePromotion());
			cstmt.setString(2, promotion.getLibelle());
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
	
	public static void supprimer(Promotion promotion)
	{
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{
			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{CALL dbo.deletePromotion(?)}");
			cstmt.setString(1, promotion.getCodePromotion());
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
	
	public static ArrayList<Promotion> listerPromotion(){
		Connection cnx = null;
		Statement rqt = null;
		
		ResultSet rs = null;
		ArrayList<Promotion> listePromotion = new ArrayList<Promotion>();
		
		try {
			cnx = PoolConnexion.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery("SELECT * FROM Promotions");
			Promotion promotion = null;
			while (rs.next()){
				promotion = new Promotion(
									rs.getString("codePromotion"),
									rs.getString("Libelle")									
						);
				listePromotion.add(promotion);				
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
		
		return listePromotion;
	}
	
//	public static Promotion rechercherPromotion(){
//		Connection cnx=null;
//		PreparedStatement rqt=null;
//		ResultSet rs=null;
//		
//		try {
//			cnx=PoolConnexion.getConnection();
//			rqt = cnx.prepareStatement("SELECT * FROM Promotions WHERE codePromotion = ?");
//			rqt.set
//
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return null;
//	}
	
}
