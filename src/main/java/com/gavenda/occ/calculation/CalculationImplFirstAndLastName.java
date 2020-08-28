package com.gavenda.occ.calculation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gavenda.occ.FirstAndLastName;
import com.gavenda.occ.FirstLastNameParser;
import com.gavenda.occ.algo.ScoringAlgorithm;

public class CalculationImplFirstAndLastName implements Calculation {
	private static final Logger logger = LoggerFactory.getLogger(CalculationImplFirstAndLastName.class);
	
	private final ScoringAlgorithm scoringAlgo;
	
	public CalculationImplFirstAndLastName(ScoringAlgorithm scoringAlgo) {
		this.scoringAlgo = scoringAlgo;
	}
	
	@Override
	public int calculate(List<String> firstAndLastNames) {
		//put names into a list using FirstAndLastName object
		List<FirstAndLastName> firstAndLastNamesList = new FirstLastNameParser().convert(firstAndLastNames);
		return scoringAlgo.score(firstAndLastNamesList);
	}
}
