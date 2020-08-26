package server.moduleServer;

import java.util.ArrayList;
/**
 * The Clients the Server is connected too (Will be replaced by a database)
 * @author hamza
 *
 */
public class Users {
	
	private ArrayList <Student> users;
	
	public Users() {
		users = new ArrayList<Student>();
	}

	public ArrayList <Student> getUsers() {
		return users;
	}

	public void setUsers(ArrayList <Student> users) {
		this.users = users;
	}
	
	public void insert(Student st) {
		users.add(st);
	}
	
	public Student searchStudent(String stName, int stId) {
		for (Student s : users) {
			if (stName.equals(s.getStudentName()) &&
					stId == s.getStudentId()) {
				return s;
			}	
		}
		return null;
	}

}
