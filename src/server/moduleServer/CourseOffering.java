package server.moduleServer;

import java.util.ArrayList;

/**
 * The Class for a section of the course
 * @author hamza
 *
 */
public class CourseOffering {
	
	private int secNum;
	private int secCap;
	private Course theCourse;
	private ArrayList <Registration> offeringRegList;
	
	public CourseOffering (int secNum, int secCap) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		offeringRegList = new ArrayList <Registration>();
	}
	/**
	 * Fets section number
	 * @return section number
	 */
	public int getSecNum() {
		return secNum;
	}
	/**
	 * sets the section number
	 * @param secNum the section number to be set
	 */
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	/**
	 * Gets section capacity
	 * @return the section capacity
	 */
	public int getSecCap() {
		return secCap;
	}
	/**
	 * Sets section capacity
	 * @param secCap the capacity to be set
	 */
	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}
	/**
	 * Gets the course that the offering belings to
	 * @return the course
	 */
	public Course getTheCourse() {
		return theCourse;
	}
	/**
	 * Sets the course the offering belongs to
	 * @param theCourse the course
	 */
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	@Override
	public String toString () {
		String st = "\n";
		st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() +"\n";
		//We also want to print the names of all students in the section
		return st;
	}
	/**
	 * Adds a registration to the course offering
	 * @param registration the registration to be added
	 */
	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		offeringRegList.add(registration);
		
	}
	/**
	 * Returns the list of registrations
	 * @return the registration list
	 */
	public  ArrayList <Registration> getRegList(){
		return offeringRegList;
	}
	
	

}
