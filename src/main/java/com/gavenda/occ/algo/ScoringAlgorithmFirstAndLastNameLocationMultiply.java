package com.gavenda.occ.algo;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gavenda.occ.FirstAndLastName;
import com.gavenda.occ.FirstAndLastNameComparator;
import com.gavenda.occ.FirstLastNameParser;
import com.gavenda.occ.LetterHelper;

public class ScoringAlgorithmFirstAndLastNameLocationMultiply implements ScoringAlgorithm {
	private static final Logger logger = LoggerFactory.getLogger(ScoringAlgorithmFirstAndLastNameLocationMultiply.class);
	
	private final LetterHelper letterHelper;
	private final FirstLastNameParser firstLastNameHelper;
	
	public ScoringAlgorithmFirstAndLastNameLocationMultiply (LetterHelper letterHelper, FirstLastNameParser firstLastNameHelper) {
		this.letterHelper = letterHelper;
		this.firstLastNameHelper = firstLastNameHelper;
	}

	@Override
	public int score(List<FirstAndLastName> firstAndLastNamesList) {
		//sort the first/last names 
		Collections.sort(firstAndLastNamesList, new FirstAndLastNameComparator());
		
		logger.debug("Sorted list: {}", firstAndLastNamesList);
		
		int total = 0;
		for (int i = 0; i < firstAndLastNamesList.size(); i++) {
			total += count(firstAndLastNamesList.get(i)) * (i + 1);
		}

		return total;
	}
	
	private int count(FirstAndLastName firstAndLastName) {
		int counter = 0;				
		
		//calculate first name 
		char[] fnArr = firstAndLastName.getFirstName().toCharArray();
		for (int i = 0; i < fnArr.length; i++) {
			counter += letterHelper.getValue(fnArr[i]);
		}
		
		//calculate second name 
		char[] lnArr = firstAndLastName.getLastName().toCharArray();
		for (int i = 0; i < lnArr.length; i++) {
			counter += letterHelper.getValue(lnArr[i]);
		}

		return counter;
	}

	@Override
	public int scoreFromExternal(List<String> firstAndLastName) {
		List<FirstAndLastName> firstAndLastNameList =  firstLastNameHelper.convert(firstAndLastName);
		return score(firstAndLastNameList);
	}
}
