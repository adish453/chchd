package edu.chc.helpdesk;

public class FrontPageBean {
	String FirstName, LastName, Email, location, PhoneNumber, problem, UrgentYes, UrgentNo;

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getUrgentYes() {
		return UrgentYes;
	}

	public void setUrgentYes(String urgentYes) {
		UrgentYes = urgentYes;
	}

	public String getUrgentNo() {
		return UrgentNo;
	}

	public void setUrgentNo(String urgentNo) {
		UrgentNo = urgentNo;
	}
}
