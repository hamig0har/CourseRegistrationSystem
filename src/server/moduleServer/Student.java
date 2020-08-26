package server.moduleServer;

import java.util.ArrayList;
/**
 * Class for student
 * @author hamza
 *
 */
public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList<Registration> studentRegList;
	
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
	}
	/**
	 * Gets student name
	 * @return student name
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * Sets student Name
	 * @param studentName student name
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * Gets student ID 
	 * @return the student Id
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * Sets the student id
	 * @param studentId the id to be set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString () {
		String st = "Student Name: " + getStudentName() + "\n" +
				"Student Id: " + getStudentId() + "\n\n";
		return st;
	}

	
	/**
	 * Adds a registration of a course to the student
	 * @param registration the registration to be added
	 */
	public void addRegistration(Registration registration) {
		studentRegList.add(registration);
	}
	/**
	 * Removes the registration for a course that the student registered for
	 * @param c The course to be dropped
	 */
	public void removeRegistration(Course c) {
		Course enDangerCourse;
		for(int i=0;i<studentRegList.size();i++) {
			enDangerCourse=studentRegList.get(i).getTheOffering().getTheCourse();
			if(enDangerCourse.getCourseName().equals(c.getCourseName()) && enDangerCourse.getCourseNum()==c.getCourseNum()) {
				studentRegList.remove(i);
			}
		}
	}
	/**
	 * Shows all courses the student signed up for on the console
	 */
	public void showAllCourse() {
		for(int i=0;i<studentRegList.size();i++) {
			System.out.println("Course: "+studentRegList.get(i).getOfferingCourseName() +" "+studentRegList.get(i).getOfferingCourseNumber());
		}
	}
	/**
	 * Returns information about all the courses the student registered for
	 * @return the information of the courses
	 */
	public String myCourses() {
		String st = "All your courses: \n";
		for(int i=0;i<studentRegList.size();i++)  {
			st += "Course: "+studentRegList.get(i).getOfferingCourseName() +" "+studentRegList.get(i).getOfferingCourseNumber();
			st += "\n";
		}
		return st;
	}
	
	/**
	 * Checks whether the student has registered for 6 courses
	 */
	public void checker() {
		if(studentRegList.size()>=6) {
			System.err.println("You have already registered for 6 courses");
		}
	}


}
