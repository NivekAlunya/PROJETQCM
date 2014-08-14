package fr.eni_ecole.qcm.store;

import java.sql.CallableStatement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni_ecole.qcm.model.Question;
import fr.eni_ecole.qcm.model.Reponse;
import fr.eni_ecole.qcm.model.*;


public class ReponseStore 
{

	public static void ajouter(Reponse reponse) throws Exception{
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{

			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{call dbo.insertReponse(?,?,?,?)}");
			cstmt.setString(1,reponse.getProposition());
			cstmt.setString(2,String.valueOf(reponse.getCorrecte()));
			cstmt.setInt(3,reponse.getQuestion().getIdQuestion());
			cstmt.registerOutParameter(4, java.sql.Types.INTEGER);
			cstmt.execute();
			reponse.setIdReponse(cstmt.getInt(4));
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
			
	public static void modifier(Reponse reponse) throws Exception{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{call dbo.updateReponses(?,?,?,?)}");
			cstmt.setInt(1,reponse.getIdReponse());
			cstmt.setString(2, reponse.getProposition());
			cstmt.setString(3,reponse.getProposition());
			cstmt.setInt(4,reponse.getQuestion().getIdQuestion());
			cstmt.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	
	public static void supprimer(Reponse reponse) throws Exception{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
				
			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{call dbo.deleteReponses(?)}");
			cstmt.setInt(1,reponse.getIdReponse());		
			cstmt.execute();
			
		} 
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	public static Reponse rechercherReponse(int idReponse) {
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		try{
			cnx=PoolConnexion.getConnection();
			rqt=cnx.prepareStatement("select idReponse,Proposition,Correcte,idquestion " +
					" from Reponses " +
					" where idReponse = ?");
			rqt.setInt(1, idReponse);
			rs=rqt.executeQuery();
			if (rs.next()){
				  return  new Reponse(rs.getInt("idReponse"), 
						      rs.getString("Proposition"),
						      rs.getString("Correcte").charAt(0),
						      QuestionStore.rechercherQuestion(rs.getInt("idQuestion"))
				  );
			}
		}
		  catch (Exception e){
			  e.printStackTrace();
		  }
		finally{
			try {
				if (rs!=null) rs.close();
				if (rqt!=null) rqt.close();
				if (cnx!=null) cnx.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return null;
	}	
}
