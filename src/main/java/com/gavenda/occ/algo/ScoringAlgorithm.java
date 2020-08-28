package com.gavenda.occ.algo;

import java.util.List;

import com.gavenda.occ.FirstAndLastName;

public interface ScoringAlgorithm {

	public int score(List<FirstAndLastName> firstAndLastNamesList);
	
	public int scoreFromExternal(List<String> firstAndLastName);
}
