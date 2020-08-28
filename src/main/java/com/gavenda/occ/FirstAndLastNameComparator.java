package com.gavenda.occ;

import java.util.Comparator;

public class FirstAndLastNameComparator implements Comparator<FirstAndLastName> {

	@Override
	public int compare(FirstAndLastName name1, FirstAndLastName name2) {
		//look at last name first 
		int value = name1.getLastName().compareTo(name2.getLastName());
		
		if (value == 0) {
			//if same last name, look at first name 
			return name1.getFirstName().compareTo(name2.getFirstName());
		} else {
			return value;
		}		
	}

}
