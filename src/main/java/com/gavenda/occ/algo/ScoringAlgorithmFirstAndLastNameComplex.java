package com.gavenda.occ.algo;

import java.util.List;

import com.gavenda.occ.FirstAndLastName;
import com.gavenda.occ.FirstLastNameParser;
import com.gavenda.occ.LetterHelper;

public class ScoringAlgorithmFirstAndLastNameComplex implements ScoringAlgorithm {

	private final LetterHelper letterHelper;
	private final FirstLastNameParser firstLastNameHelper;

	public ScoringAlgorithmFirstAndLastNameComplex (LetterHelper letterHelper, FirstLastNameParser firstLastNameHelper) {
		this.letterHelper = letterHelper;
		this.firstLastNameHelper = firstLastNameHelper;
	}
	
	@Override
	public int score(List<FirstAndLastName> firstAndLastNamesList) {		
		//TODO: impl complex scoring algo
		
		return 0;
	}
	
	@Override
	public int scoreFromExternal(List<String> firstAndLastName) {
		List<FirstAndLastName> firstAndLastNameList =  firstLastNameHelper.convert(firstAndLastName);
		return score(firstAndLastNameList);
	}

}
