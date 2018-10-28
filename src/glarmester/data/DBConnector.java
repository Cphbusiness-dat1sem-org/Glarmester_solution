package glarmester.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private Connection connection = null;
	
	//Constants
	private static final String IP	     = "142.93.109.235";
	private static final String PORT     = "3306";
	public  static final String DATABASE = "Glarmester";
	private static final String USERNAME = "BigBoss"; 
	private static final String PASSWORD = "1234";	     	
	
	public DBConnector() throws SQLException {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
                this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
                throw new SQLException("Class not found! (com.mysql.jdbc.Driver)");
            }
	}
	
	public Connection getConnection() {
   		return this.connection;
	}
}