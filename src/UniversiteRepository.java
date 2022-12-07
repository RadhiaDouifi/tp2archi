import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversiteRepository implements IUniversiteRepository {
	private IDBConnection BD ;
	private static Statement stmt;
	private IJournal journal;


	
	public UniversiteRepository (IDBConnection BD,IJournal journal){
		this.BD = BD;
		this.journal=journal;
		}
	
	@Override	
	public Universite GetById(int universityId) {
		try {
		Connection connect=BD.getConn(); 
		stmt = connect.createStatement();
		journal.outPut_Msg("LogBD : début recherche de id université dans la base de donnée " +"\n"+"Générer par :" +getClass().getName());
		
		String sql = "select * from universite where id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite(rs.getInt(1),rs.getString(2),p);
			
		journal.outPut_Msg("LogBD : université récupérée" +"\n"+"Générer par :" +getClass().getName());

	
		connect.close();
		return u;	
		}catch(SQLException e){
			e.printStackTrace();
			}
		return null;
		
	
		
	}

	@Override
	public int NbrLivreAutorise(int id_univ) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
}
