package server.moduleServer;
import java.util.ArrayList;

/**
 * Holds all the Courses available
 * @author hamza
 *
 */
public class CourseCatalogue {
	
	private ArrayList <Course> courseList;
	
	public CourseCatalogue () {
		loadFromDataBase ();
	}
	
	private void loadFromDataBase() {
		// TODO Auto-generated method stub
		DBManager db = new DBManager();
		setCourseList(db.readFromDataBase());
		
	}
	/**
	 * Creates a new Course Offering
	 * @param c: the course that the offering is for
	 * @param secNum the number of the Course offering for that course
	 * @param secCap the capacity of the offering
	 */
	public void createCourseOffering (Course c, int secNum, int secCap) {
		if (c!= null) {
			CourseOffering theOffering = new CourseOffering (secNum, secCap);
			c.addOffering(theOffering);
		}
	}
	/**
	 * Searches the catalog for a particular course
	 * @param courseName: the Name of the course
	 * @param courseNum: the number of the course
	 * @return: the particular course that is searched for
	 */
	public Course searchCat (String courseName, int courseNum) {
		for (Course c : courseList) {
			if (courseName.equals(c.getCourseName()) &&
					courseNum == c.getCourseNum()) {
				return c;
			}	
		}
		displayCourseNotFoundError();
		return null;
	}
	/**
	 * Generates an error message
	 */
	private void displayCourseNotFoundError() {
		// TODO Auto-generated method stub
		System.err.println("Course was not found!");
		
	}
	/**
	 * Returns the whole list of courses
	 * @return the list of all courses
	 */
	public ArrayList <Course> getCourseList() {
		return courseList;
	}
	/**
	 * Sets the course list
	 * @param courseList the list that needs to be set
	 */
	public void setCourseList(ArrayList <Course> courseList) {
		this.courseList = courseList;
	}
	/**
	 * Returns all information about all courses
	 */
	@Override
	public String toString () {
		String st = "All courses in the catalogue: \n";
		for (Course c : courseList) {
			st += c;  //This line invokes the toString() method of Course
			st += "\n";
		}
		return st;
	}
	/**
	 * Searches for a course by name to return its info
	 * @param name the course name
	 * @param x the course number
	 * @return the information about the particular course
	 */
	public String searchCourseByName(String name, int x) {
		String str = "";
		for (int i=0; i<courseList.size();i++) {
			if(courseList.get(i).getCourseName().equalsIgnoreCase(name)&& courseList.get(i).getCourseNum()==x) {
				str = "Course: "+courseList.get(i).getCourseName()+" "+x;
			}
		}
		return str;
	}
	/**
	 * Gets information about the pre requisites about a particular course
	 * @param name the name of the course
	 * @param x the number of the course
	 * @return the information about pre reqs
	 */
	public String coursePreReqs(String name, int x) {
		String str = "Course PreRequistes \n";
		for (int i=0; i<courseList.size();i++) {
			if(courseList.get(i).getCourseName().equalsIgnoreCase(name) && courseList.get(i).getCourseNum()==x) {
				for(int j=0;j<courseList.get(i).getPreReqs().size();j++) {
					str += "Course: "+ courseList.get(i).getPreReqs().get(j).getCourseName()+" "+courseList.get(i).getPreReqs().get(j).getCourseNum()+"\n";
				}
				
			}
		}
		return str;
	}
	/**
	 * lists all courses on the console
	 */
	public void listAllCourses() {
		for (int i=0;i<courseList.size();i++) {
			System.out.println("Course: "+courseList.get(i).getCourseName()+" "+courseList.get(i).getCourseNum());
		}
	}
}
