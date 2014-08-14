package fr.eni_ecole.qcm.store;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.servicetag.SystemEnvironment;

import fr.eni_ecole.qcm.model.Question;
import fr.eni_ecole.qcm.model.Theme;


public class QuestionStore {
	
	
	public static void ajouter(Question question) throws Exception{
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{

			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{call dbo.insertQuestion(?,?,?,?)}");
			cstmt.setString(1,question.getEnonce());
			cstmt.setString(2,question.getUrlimage());
			cstmt.setInt(3, question.getTheme().getIdTheme());
			cstmt.registerOutParameter(4,java.sql.Types.INTEGER);
			cstmt.execute();
			question.setIdQuestion(cstmt.getInt(4));
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
			
	public static void modifier(Question question) throws Exception{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{call dbo.UpdateQuestion(?,?,?,?)}");
			cstmt.setInt(1, question.getIdQuestion());
			cstmt.setString(2,question.getEnonce());
			cstmt.setString(3, question.getUrlimage());
			cstmt.setInt(4, question.getTheme().getIdTheme());
			cstmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	
	public static void supprimer(Question question) throws Exception{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
				
			cnx=PoolConnexion.getConnection();
			CallableStatement cstmt = cnx.prepareCall("{call dbo.deleteQuestions(?)}");
			cstmt.setInt(1,question.getIdQuestion());	
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
	
	public static ArrayList<Question> listerQuestion() throws Exception{
		
		Connection cnx=null;
		Statement rqt=null;
		ResultSet rs=null;
		
		ArrayList<Question> listeQuestion = new ArrayList<Question>();
		
		try{
			cnx = PoolConnexion.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery("select idQuestion,Enonce,Urlimage,themes.idtheme,nom from Questions inner join themes on  themes.idtheme = questions.idtheme");
			Question question = null;
			while (rs.next()){
				question = new Question(
					rs.getInt("idQuestion"),
					rs.getString("Enonce"),
					rs.getString("URLimage"),
					new Theme(rs.getInt("idtheme"), rs.getString("nom"))
				);
				
				listeQuestion.add(question);				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    }
		finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
		}
		
		return listeQuestion;
	}
	
	
	public static Question rechercherQuestion(int idQuestion){
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		try{
			cnx=PoolConnexion.getConnection();
			rqt=cnx.prepareStatement("select idQuestion,Enonce,URLimage,themes.idtheme,nom from Questions inner join Themes on themes.idtheme = Questions.idtheme where idQuestion = ?");
			rqt.setInt(1, idQuestion);
			rs=rqt.executeQuery();
			if (rs.next()){
				return  new Question(rs.getInt("idQuestion"), 
						rs.getString("Enonce"),
						rs.getString("urlimage"),
						new Theme(rs.getInt("idTheme"),rs.getString("nom")));
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
