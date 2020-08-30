package com.gavenda.occ.scoring;

import java.util.List;

import com.gavenda.occ.LetterHelper;

public abstract class ScoringMethodSimple implements ScoringMethod {
	
	private final LetterHelper letterHelper;
	
	public ScoringMethodSimple(LetterHelper letterHelper) {
		this.letterHelper = letterHelper;
	}	
	
	protected int calculation(List<String> names) {
		int total = 0;
		for (int i = 0; i < names.size(); i++) {
			total += count(names.get(i)) * (i + 1);
		}
		return total;		
	}
	
	protected int count(String string) {
		int counter = 0;
		//calculate first name 
		char[] fnArr = string.toCharArray();
		for (int i = 0; i < fnArr.length; i++) {
			counter += letterHelper.getValue(fnArr[i]);
		}
		return counter;
	}
	
	public abstract int score(List<String> names);
}
