
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection  implements IDBConnection {
	   
		String BDD = "tparchit";
		String url = "jdbc:mysql://localhost:3306/tparchit?characterEncoding=latin1" + BDD;
		String user = "root";
		String passwd = "";
	    private Connection conn;

	    
	    private static IDBConnection instance;
	   
	    private DBConnection() {
			
		}

	    public static synchronized  IDBConnection getinstance(){
	    	if (instance == null) {
	    		instance= new DBConnection();
	    	}
	    	
			return instance;
	    }
	    @Override
		public Connection getConn() {
	    	
	    	try {
				conn=DriverManager.getConnection(url, user,passwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			return conn;
	    }
			
}
	    
