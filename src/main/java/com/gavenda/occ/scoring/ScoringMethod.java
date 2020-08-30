package com.gavenda.occ.scoring;

import java.util.List;

import com.gavenda.occ.LetterHelper;

public interface ScoringMethod {
	
	public int score(List<String> names);
}
