package server.controllerServer;

import java.sql.*;
/**
 * Forms a databases in SQL for students
 * @author hamza
 *
 */
public class JDBCManager implements Credentials{
	
	// Attributes
		private Connection conn;
		private ResultSet rs;
		/**
		 * Initializes a connection to mySql 
		 */
		public void initializeConnection() {
			try {
				// Register JDBC driver
				Driver driver = new com.mysql.cj.jdbc.Driver();
				DriverManager.registerDriver(driver);
				// Open a connection
				conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				System.out.println("Problem");
				e.printStackTrace();
			}

		}
		/**
		 * Closes connection
		 */
		public void close() {
			try {
				// rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/**
		 * Inserts a student to database
		 * @param id Student id
		 * @param name Student name
		 */
		public void insertUser(int id, String name) {
			try {
				String query = "INSERT INTO STUDENT (ID,Name) values(?,?)";
				PreparedStatement pStat = conn.prepareStatement(query);
				pStat.setInt(1, id);
				pStat.setString(2, name);
				int rowCount = pStat.executeUpdate();
				System.out.println("row Count = " + rowCount);
				pStat.close();
			} catch (SQLException e) {
				System.out.println("problem inserting user");
				e.printStackTrace();
			}
		}
		/**
		 * Creates a table
		 */
		public void createTable() {
			String sql = "CREATE TABLE STUDENT " + "(ID INTEGER not NULL, " + " Name VARCHAR(255), " + " PRIMARY KEY ( ID ))";

			try {
				Statement stmt = conn.createStatement(); // construct a statement
				stmt.executeUpdate(sql); // execute my query (i.e. sql)
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Table can NOT be created!");
			}
			System.out.println("Created table in given database...");
		}

}
