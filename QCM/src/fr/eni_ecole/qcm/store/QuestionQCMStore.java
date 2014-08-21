package fr.eni_ecole.qcm.store;
import fr.eni_ecole.qcm.model.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class QuestionQCMStore {
	
	public static ArrayList<QuestionQCM> getQCMForInscription(Inscription insc) {
		String query = "select q.idQuestion,q.Enonce,q.URLimage " +
			" ,t.IdTheme,t.Nom " +
			" ,r.idReponse,r.Correcte,r.Proposition " +
			" ,rq.Cochee " +
			" ,g.idQuestionQCM,g.marquee " +
			" from QuestionQCMs g " + 
			" inner join questions q on q.idquestion = g.idquestion " +  
			" inner join themes t on t.IdTheme = q.idTheme " +
			" inner join reponses r on q.idquestion = r.idquestion " +  
			" inner join reponseQCMs rq on r.idreponse = rq.idreponse and g.idQuestionQCM = rq.idQuestionQCM " +  
 			" where g.idinscription = ? ";
		//@totdo mettre une clause order 
		boolean loop = true;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int lastIdquestion = 0;
		ArrayList<QuestionQCM> list = new ArrayList<QuestionQCM>();
		QuestionQCM questionqcm = null;
		try {
			cn = PoolConnexion.getConnection();
			ps = cn.prepareStatement(query);
			ps.setInt(1, insc.getIdInscription());
			
			do
			{
				rs = ps.executeQuery();
				if (rs.next()) {
					loop = false;
					do {
						if(lastIdquestion != rs.getInt("idQuestion")) {
							lastIdquestion = rs.getInt("idQuestion");
							questionqcm = new QuestionQCM(rs.getInt("idQuestionQCM"),
									rs.getString("marquee"),insc,
									new Question(rs.getInt("idquestion"),rs.getString("enonce"),
										rs.getString("urlimage"),new Theme(rs.getInt("idTheme"), rs.getString("nom")),
										null),
										null
								);
							list.add(questionqcm);
						}
						questionqcm.getReponsesQCM().add(
							new ReponseQCM(
								rs.getString("Cochee").charAt(0), 
								new Reponse(
									rs.getInt("idreponse"),
									rs.getString("proposition"),
									rs.getString("Correcte").charAt(0),
									questionqcm.getQuestion()), 
								questionqcm)
							);
					} while(rs.next());
				} else {
					genererQCM(insc);					
				}
			} while(loop);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (cn != null && cn.isClosed()) cn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return list;
	}

	private static void genererQCM(Inscription insc) {
		String query  = "select q.idquestion,q.enonce,urlimage,t.idtheme,t.nom,s.nombrequestion " +
				" from questions q " +
				" inner join themes t on t.idtheme  = q.idtheme " +
				" inner join sections s on t.idtheme = s.idtheme and s.idtest = ? " +
				" order by s.idtheme,q.idquestion"; 
		
		Connection cn = null;
		PreparedStatement ps =  null;
		CallableStatement cs = null;
		ResultSet rs = null;
		int lastTheme = 0;
		int cptr = 0;
		try {
			cn = PoolConnexion.getConnection();
			ps = cn.prepareStatement(query);
			System.out.println(query);
			ps.setInt(1, insc.getTest().getIdTest());
			rs = ps.executeQuery();
			while(rs.next()) {
				if(lastTheme != rs.getInt("idtheme")) {
					cptr = 0;
					lastTheme = rs.getInt("idtheme");
				}
				if(cptr < rs.getInt("nombrequestion")) {
					
					QuestionQCM qcm = new QuestionQCM(0,"N",insc,new Question(
							rs.getInt("idquestion"),
							rs.getString("enonce"),
							rs.getString("urlimage"),
							new Theme(rs.getInt("idTheme"), rs.getString("nom")),
							null),
						null);
					ajouter(qcm);
					cptr++;
				}
			}
			cs = cn.prepareCall("{CALL dbo.insertReponseQCM(?,?)}");
			cs.setInt(1, insc.getIdInscription());
			cs.setString(2, "N");
			cs.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (cs != null) cs.close();
				if (cn != null && cn.isClosed()) cn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	private static void ajouter(QuestionQCM qcm){
		CallableStatement cs = null;
		Connection cn = null;
		try {
			cn = PoolConnexion.getConnection();
			cs = cn.prepareCall("{CALL dbo.insertQuestionQCMs(?,?,?,?)}");
			cs.setString(1, qcm.getMarque());
			cs.setInt(2, qcm.getInscription().getIdInscription());
			cs.setInt(3, qcm.getQuestion().getIdQuestion());
			cs.registerOutParameter(4, java.sql.Types.INTEGER);
			cs.execute();
			qcm.setIdQuestionQCM(cs.getInt(4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (cs != null) cs.close();
				if (cn != null && cn.isClosed()) cn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public static void modifier(QuestionQCM qcm){
		CallableStatement cs = null;
		Connection cn = null;
		try {
			cn = PoolConnexion.getConnection();
			cs = cn.prepareCall("{CALL dbo.updateQuestionQCMs(?,?,?,?)}");
			cs.setInt(1, qcm.getIdQuestionQCM());
			cs.setString(2, qcm.getMarque());
			cs.setInt(3, qcm.getInscription().getIdInscription());
			cs.setInt(4, qcm.getQuestion().getIdQuestion());
			System.out.println(qcm.getIdQuestionQCM() + ":" + qcm.getMarque());
			cs.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (cs != null) cs.close();
				if (cn != null && cn.isClosed()) cn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static void supprimer(Inscription inscription){
		Connection cn=null;
		CallableStatement cs = null; 
		try{
			cn = PoolConnexion.getConnection();
			cs = cn.prepareCall("{CALL dbo.deleteQuestionQCMs(?)}");
			cs.setInt(1, inscription.getIdInscription());
			cs.execute();
		} catch (Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				if (cs!=null) cs.close();
				if (cn!=null) cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
