package server.moduleServer;
/**
 * The class that handles a particular registration
 * @author hamza
 *
 */
public class Registration {
	private Student theStudent;
	private CourseOffering theOffering;
	private char grade;
	/**
	 * Completes a registration 
	 * @param st the student part of the registration
	 * @param of the offering the registration is made to 
	 */
	public void completeRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		addRegistration ();
	}
	/**
	 * Adds registration to the student and offering
	 */
	private void addRegistration () {
		theStudent.addRegistration(this);
		theOffering.addRegistration(this);
	}
	
	/**
	 * gets the student part of the registration 
	 * @return the student
	 */
	public Student getTheStudent() {
		return theStudent;
	}
	/**
	 * gets the student part of the registration 
	 * @param theStudent the student
	 */
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	/**
	 * Gets the offering the registration is made to 
	 * @return the registration
	 */
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	/**
	 *  Gets the offering the registration is made to 
	 * @param theOffering the offering
	 */
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	/**
	 * Gets the grade of the student
	 * @return the grade
	 */
	public char getGrade() {
		return grade;
	}
	/**
	 * Sets the grade of the student
	 * @param grade the grade
	 */
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString () {
		String st = "\n";
		st += "Student Name: " + getTheStudent() + "\n";
		st += "The Offering: " + getTheOffering () + "\n";
		st += "Grade: " + getGrade();
		st += "\n-----------\n";
		return st;
		
	}
	/**
	 * Gets the name of the course the registration is made to
	 * @return the course name
	 */
	public String getOfferingCourseName() {
		return theOffering.getTheCourse().getCourseName();
	}
	/**
	 * Gets the number of the course the registration is made to
	 * @return the course number
	 */
	public int getOfferingCourseNumber() {
		return theOffering.getTheCourse().getCourseNum();
	}

}
