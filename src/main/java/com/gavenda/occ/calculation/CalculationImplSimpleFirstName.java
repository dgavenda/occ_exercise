package com.gavenda.occ.calculation;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gavenda.occ.LetterHelper;

public class CalculationImplSimpleFirstName implements Calculation {	
	private static final Logger logger = LoggerFactory.getLogger(CalculationImplSimpleFirstName.class);
	private final LetterHelper letterHelper;
	
	
	public CalculationImplSimpleFirstName(LetterHelper letterHelper) {
		this.letterHelper = letterHelper;
	}

	@Override
	public int calculate(List<String> names) {
		Collections.sort(names);
		
		logger.debug("Sorted list: {}", names);

		int total = 0;
		//iterate and count the values
		for (int i = 0; i < names.size(); i++) {
			total += count(names.get(i)) * (i + 1);
		}
		return total;
	}
	
	
	private int count(String name) {
		int counter = 0;				

		for (int i = 0; i < name.length(); i++) {
			counter += letterHelper.getValue(name.charAt(i));
		}
		return counter;
	}
}
