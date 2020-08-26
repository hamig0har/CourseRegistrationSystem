package server.moduleServer;

import java.util.ArrayList;

/**
 * Class that holds the information about the course
 * @author hamza
 *
 */

public class Course {
	
	private String courseName;
	private int courseNum;
	private ArrayList<Course> preReq;
	private ArrayList<CourseOffering> offeringList;
	
	public Course(String courseName, int courseNum) {
		this.setCourseName(courseName);
		this.setCourseNum(courseNum);
		preReq = new ArrayList<Course>();
		offeringList = new ArrayList<CourseOffering>();
	}
	/**
	 * Adds another Offering to the Course
	 * @param offering: The offering to be added
	 */
	public void addOffering(CourseOffering offering) {
		if (offering != null && offering.getTheCourse() == null) {
			offering.setTheCourse(this);
			if (!offering.getTheCourse().getCourseName().equals(courseName)
					|| offering.getTheCourse().getCourseNum() != courseNum) {
				System.err.println("Error! This section belongs to another course!");
				return;
			}
			
			offeringList.add(offering);
		}
	}
	/**
	 * Gets the name of the course
	 * @return Course Name
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * Sets the Name of the Course
	 * @param courseName: the name to be set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * Returns information about the course
	 */
	@Override
	public String toString () {
		String st = "\n";
		st += getCourseName() + " " + getCourseNum ();
		st += "\nAll course sections:\n";
		for (CourseOffering c : offeringList)
			st += c;
		st += "\n-------\n";
		return st;
	}

	/**
	 * Gets a particular Course Offering
	 * @param i: the index of the course offering
	 * @return the course offering at index i
	 */
	public CourseOffering getCourseOfferingAt(int i) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= offeringList.size() )
			return null;
		else
			return offeringList.get(i);
	}
	/**
	 * Finds an available Course Offering
	 * @return The available Course offering
	 */
	public CourseOffering availibleCourseOffering() {
		int i=0;
		
		while(i<offeringList.size()){
			if(offeringList.get(i).getRegList().size()<100) {
				break;
			}
			i++;
		}
		
		return offeringList.get(i);
			
		}
	/**
	 * Gets the pre Requisites for the particular course
	 * @return the pre requisites
	 */
	public ArrayList<Course> getPreReqs() {
		return preReq;
		
	}
	/**
	 * Checks whether the Course has more than 8 candidates to run
	 */
	public void courseRunCheck() {
		int stCounter=0;
		for(int i=0;i<offeringList.size();i++) {
			stCounter+=offeringList.get(i).getRegList().size();
		}
		if(stCounter<=8) {
			System.err.println("Course cannot run as their are less than 8 Students Registered");
		}
	}
	/**
	 * Gets the Course Number
	 * @return the Course number
	 */
	public int getCourseNum() {
		return courseNum;
	}
	
	/**
	 * Sets the Course number
	 * @param courseNum: the course number to be set 
	 */
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	 public ArrayList <CourseOffering> getOfferingList() {
		 return offeringList;
	 }
	 
	 public void addPreReq(Course p) {
		 preReq.add(p);
	 }
	
}

	

