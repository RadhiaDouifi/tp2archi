import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EtudiantRepository implements IEtudiantRepository {
	private IDBConnection BD ;
	private static Statement stmt;
	private IJournal journal;

	public EtudiantRepository(IDBConnection BD,IJournal journal) {
		this.BD = BD;
		this.journal=journal;
		} 
	@Override
	public void add(Etudiant E)
	{ try {
		stmt = BD.getConn().createStatement();
		String sql = "INSERT into etudiant  values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "','"+ E.getPwd() +"'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		if (rs == 1){
			journal.outPut_Msg("log : ajout dans la BD réussi de l'étudiant  du Matricule" + E.getMatricule()+""
					+"\n"+"Générer par :" +getClass().getName());

			}else if (rs == 0){
				journal.outPut_Msg("log : Echec de l'ajout dans la BD de l'étudiant  du Matricule" + E.getMatricule()+""
						+"\n"+"Générer par :" +getClass().getName());

			}
		BD.getConn().close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	 }

	@Override
	public boolean Exists(String email) 
	{ try {
		
		stmt = BD.getConn().createStatement();
		String sql = "select * from etudiant where email = '" +email + "'";
		ResultSet rs = stmt.executeQuery(sql);
	      
	      // iterate through the java resultset
		if (rs.first()){
			journal.outPut_Msg("logBD--- :email existe deja dans la BD  " + email+""
					+"\n"+"Générer par :" +getClass().getName());

				//BD.getConn().close();
				return true;}
	     
		journal.outPut_Msg("logBD--- : email n'existe pas " + email+""
				+"\n"+"Générer par :" +getClass().getName());

				BD.getConn().close();
				return false;
	}catch(SQLException e){
		e.printStackTrace();
	}
	return false;}
	@Override
	public boolean Exists(int mat)	
	{ try {

		stmt = BD.getConn().createStatement();
		String sql = "select * from etudiant where matricule = " + mat;
		ResultSet rs = stmt.executeQuery(sql);
		
		if (rs.first()){
			journal.outPut_Msg("logBD--- :etudiant avec ce matricule existe déja dans la BD  " + mat+""
					+"\n"+"Générer par :" +getClass().getName());

			//BD.getConn().close();
			return true;
			}
		journal.outPut_Msg("logBD----: etudiant avec ce matricule n'existe pas " + mat+""
				+ "\n"+"Générer par :" +getClass().getName());

		BD.getConn().close();
		return false;
	}catch(SQLException e){
		e.printStackTrace();
	}
	return false;
	}	
	
	@Override
	public boolean vérifier(int Matricule, String Email) {

		return this.Exists(Matricule) || this.Exists(Email) || Email.length() == 0 || Email == null; 

	}
}