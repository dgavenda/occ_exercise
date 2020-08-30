package com.gavenda.occ.scoring;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.gavenda.occ.LetterHelper;


public class ScoringMethodSimpleFirstNameOnlyTest {

	@Test
	public void testSimpleFirstName() {
		ScoringMethod scoringMethod = new ScoringMethodSimpleFirstNameOnly(new LetterHelper());
		
		List<String> nameList = Arrays.asList("MARY");
		assertEquals(57, scoringMethod.score(nameList));
		
		List<String> nameList2 = Arrays.asList("BARB");
		assertEquals(23, scoringMethod.score(nameList2));
		
		List<String> nameList3 = Arrays.asList("MARY", "BARB");
		assertEquals(137, scoringMethod.score(nameList3));
	}
}
