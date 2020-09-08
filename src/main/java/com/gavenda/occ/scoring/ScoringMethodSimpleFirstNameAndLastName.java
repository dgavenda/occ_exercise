package com.gavenda.occ.scoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gavenda.occ.FirstAndLastName;
import com.gavenda.occ.FirstAndLastNameComparator;
import com.gavenda.occ.FirstLastNameParser;
import com.gavenda.occ.LetterHelper;

public class ScoringMethodSimpleFirstNameAndLastName extends ScoringMethodSimple {

	private static final Logger logger = LoggerFactory.getLogger(ScoringMethodSimpleFirstNameAndLastName.class);
	
	public ScoringMethodSimpleFirstNameAndLastName(LetterHelper letterHelper) {
		super(letterHelper);
	}
	
	
	@Override
	public List<String> sort(List<String> names) {
		//converting to FirstLastName object to sort
		List<FirstAndLastName> firstAndLastNamesList = new FirstLastNameParser().convert(names);
		
		//sort the first/last names 
		Collections.sort(firstAndLastNamesList, new FirstAndLastNameComparator());
		logger.debug("First and last name list: {}", firstAndLastNamesList);
		
		//converting back to string.  
		List<String> firstLastNameListAsString = new ArrayList<String>();
		
		for (FirstAndLastName firstAndLastName : firstAndLastNamesList) {
			firstLastNameListAsString.add(firstAndLastName.getFirstName() + " " + firstAndLastName.getLastName());
		}
		return firstLastNameListAsString;
	}

}
