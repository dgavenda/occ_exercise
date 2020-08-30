package com.gavenda.occ.scoring;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gavenda.occ.LetterHelper;

public class ScoringMethodSimpleFirstNameOnly extends ScoringMethodSimple {
	private static final Logger logger = LoggerFactory.getLogger(ScoringMethodSimpleFirstNameOnly.class);
	
	public ScoringMethodSimpleFirstNameOnly(LetterHelper letterHelper) {
		super(letterHelper);
	}
	
	@Override
	public int score(List<String> names) {
		Collections.sort(names);
//		logger.debug("First name list: {}", names);
		
		return calculation(names);
	}

}
