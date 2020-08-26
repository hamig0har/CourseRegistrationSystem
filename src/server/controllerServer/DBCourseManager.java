package server.controllerServer;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * This class adds Courses created to a database
 * @author hamza
 *
 */
public class DBCourseManager implements Credentials {
	
	// Attributes
			private Connection conn;
			private ResultSet rs;
/**
 * Initializes connection to a database
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
			 * closes connection
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
			 * Inserts the course into a table in SQL
			 * @param id the id of the course
			 * @param name Name of the course
			 * @param number Number of the course
			 */
			public void insertUser(int id, String name,int number) {
				try {
					String query = "INSERT INTO COURSES (id,Name,Number) values(?,?,?)";
					PreparedStatement pStat = conn.prepareStatement(query);
					pStat.setInt(1, id);
					pStat.setString(2, name);
					pStat.setInt(3, number);
					int rowCount = pStat.executeUpdate();
					System.out.println("row Count = " + rowCount);
					pStat.close();
				} catch (SQLException e) {
					System.out.println("problem inserting user");
					e.printStackTrace();
				}
			}
			/**
			 * Creates a table in SQL
			 */
			public void createTable() {
				String sql = "CREATE TABLE COURSES " + "(id INTEGER not NULL, " + " Name VARCHAR(255), " + " Number INTEGER not NULL, " + " PRIMARY KEY ( id ))";

				
				try {
					Statement stmt = conn.createStatement(); // construct a statement
					stmt.executeUpdate(sql); // execute my query (i.e. sql)
					stmt.close();
				} catch (SQLException e) {
					System.out.println("Table can NOT be created!");
				}
				System.out.println("Created table in given database...");
			}

	}



