package com.gavenda.occ.algo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.gavenda.occ.FirstAndLastName;
import com.gavenda.occ.FirstLastNameParser;
import com.gavenda.occ.LetterHelper;

import junit.framework.Assert;


public class ScoringAlgorithmFirstAndLastNameLocationMultiplyTest {
		
	@Test
	public void testFirstAndLastNameSimple() {
		ScoringAlgorithm scoringAlgo = new ScoringAlgorithmFirstAndLastNameLocationMultiply(new LetterHelper(), new FirstLastNameParser());
		
		List<FirstAndLastName> nameList = Arrays.asList(new FirstAndLastName("A", "A"), new FirstAndLastName("B", "B"));
		Assert.assertEquals(10, scoringAlgo.score(nameList));
		
		List<FirstAndLastName> nameList2 = Arrays.asList(new FirstAndLastName("B", "B"), new FirstAndLastName("A", "A"));
		Assert.assertEquals(10, scoringAlgo.score(nameList2));
	}
	
	@Test
	public void testFirstAndLastNameRealNames() {
		ScoringAlgorithm scoringAlgo = new ScoringAlgorithmFirstAndLastNameLocationMultiply(new LetterHelper(), new FirstLastNameParser());
	
		List<FirstAndLastName> nameList = Arrays.asList(new FirstAndLastName("BARB", "ALLEN"));
		Assert.assertEquals(67, scoringAlgo.score(nameList));
		
		List<FirstAndLastName> nameList2 = Arrays.asList(new FirstAndLastName("MARY", "ALLEN"));
		Assert.assertEquals(101, scoringAlgo.score(nameList2));
		
		List<FirstAndLastName> nameList3 = Arrays.asList(new FirstAndLastName("MARY", "ALLEN"), new FirstAndLastName("BARB",  "ALLEN"));
		Assert.assertEquals(269, scoringAlgo.score(nameList3));
	}
}
