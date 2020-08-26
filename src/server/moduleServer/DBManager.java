package server.moduleServer;
import java.util.ArrayList;

import server.controllerServer.DBCourseManager;

/**
 * This class is making courses 
 * @author hamza
 *
 */

public class DBManager {
	
	ArrayList <Course> courseList;
	//private DBCourseManager coursedb;

	public DBManager () {
		courseList = new ArrayList<Course>();
		//coursedb = new DBCourseManager();
		//coursedb.initializeConnection();
		//coursedb.createTable();
	}

	public ArrayList readFromDataBase() {
		
		Course c = new Course ("ENGG", 233);
		courseList.add(c);
		//coursedb.insertUser(10, c.getCourseName(), c.getCourseNum());
		
		Course c1 = new Course ("ENSF", 409);
		createPreReqs(c1,c);
		courseList.add(c1);
		//coursedb.insertUser(1, c1.getCourseName(), c1.getCourseNum());
		
		Course c2 = new Course ("PHYS", 259);
		courseList.add(c2);
		//coursedb.insertUser(2, c2.getCourseName(), c2.getCourseNum());
		
		Course c3 = new Course ("PHYS", 269);
		createPreReqs(c3,c2);
		courseList.add(c3);
		//coursedb.insertUser(3, c3.getCourseName(), c3.getCourseNum());
		
		Course c4 = new Course ("ENEL", 353);
		createPreReqs(c4,c2);
		courseList.add(c4);
		//coursedb.insertUser(4, c4.getCourseName(), c4.getCourseNum());
		
		Course c5 = new Course ("ENCM", 369);
		createPreReqs(c5,c4);
		courseList.add(c5);
		//coursedb.insertUser(5, c5.getCourseName(), c5.getCourseNum());
		
		Course c6 = new Course ("ENEL", 327);
		createPreReqs(c6,c4);
		courseList.add(c6);
		//coursedb.insertUser(6, c6.getCourseName(), c6.getCourseNum());
		
		Course c7 = new Course ("ENSF", 480);
		createPreReqs(c7,c1);
		courseList.add(c7);
		//coursedb.insertUser(7, c7.getCourseName(), c7.getCourseNum());
		
		Course c8 = new Course ("MATH", 211);
		courseList.add(c8);
		//coursedb.insertUser(8, c8.getCourseName(), c8.getCourseNum());
		
		Course c9 = new Course ("MATH", 271);
		createPreReqs(c9,c8);
		courseList.add(c9);
		//coursedb.insertUser(9, c9.getCourseName(), c9.getCourseNum());
		
		return courseList;
	}
	public void createPreReqs(Course c,Course p) {
		
		c.addPreReq(p);
		
	}

}