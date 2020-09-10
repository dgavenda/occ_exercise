package com.gavenda.occ;

public class FirstAndLastName implements Comparable<FirstAndLastName> {
	
	private final String firstName;
	private final String lastName;
	
	public FirstAndLastName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public int length() {
		return firstName.length() + lastName.length();
	}

	@Override
	public String toString() {
		return "FirstAndLastName [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FirstAndLastName other = (FirstAndLastName) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(FirstAndLastName firstLastName) {
		//look at last name first 
		int value = getLastName().compareTo(firstLastName.getLastName());
		
		if (value == 0) {
			//if same last name, look at first name 
			return getFirstName().compareTo(firstLastName.getFirstName());
		} else {
			return value;
		}	
	}	
}
