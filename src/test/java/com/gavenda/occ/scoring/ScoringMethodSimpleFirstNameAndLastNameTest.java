package com.gavenda.occ.scoring;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.gavenda.occ.LetterHelper;

import junit.framework.Assert;


public class ScoringMethodSimpleFirstNameAndLastNameTest {

	@Test
	public void testFirstAndLastNames() {
		ScoringMethod scoringMethod = new ScoringMethodSimpleFirstNameAndLastName(new LetterHelper());
		
		List<String> nameList = Arrays.asList("A A", "B B");
		Assert.assertEquals(10, scoringMethod.score(nameList));

		List<String> nameList2 = Arrays.asList("B B", "A A");
		Assert.assertEquals(10, scoringMethod.score(nameList2));
	}
	
	@Test
	public void testFirstAndLastNameRealNames() {
		ScoringMethod scoringMethod = new ScoringMethodSimpleFirstNameAndLastName(new LetterHelper());
	
		List<String> nameList = Arrays.asList("BARB ALLEN");
		Assert.assertEquals(67, scoringMethod.score(nameList));
		
		List<String> nameList2 = Arrays.asList("MARY ALLEN");
		Assert.assertEquals(101, scoringMethod.score(nameList2));
		
		List<String> nameList3 = Arrays.asList("MARY ALLEN", "BARB ALLEN");
		Assert.assertEquals(269, scoringMethod.score(nameList3));
	}
	
	@Test
	public void testNamesInFile() {
		ScoringMethod scoringMethod = new ScoringMethodSimpleFirstNameAndLastName(new LetterHelper());
		
		List<String> nameList = Arrays.asList("MARY ZETA");
		Assert.assertEquals(109, scoringMethod.score(nameList));
		
		List<String> nameList2 = Arrays.asList("PATRICIA ASH");
		Assert.assertEquals(105, scoringMethod.score(nameList2));
		
		List<String> nameList3 = Arrays.asList("LINDA BALL");
		Assert.assertEquals(67, scoringMethod.score(nameList3));
		
		List<String> nameList4 = Arrays.asList("BARBARA SMITH");
		Assert.assertEquals(112, scoringMethod.score(nameList4));
		
		List<String> nameList5 = Arrays.asList("NANCY");
		Assert.assertEquals(0, scoringMethod.score(nameList5));
		
		List<String> nameList6 = Arrays.asList("MARY ZETA","PATRICIA ASH","LINDA BALL","BARBARA SMITH", "NANCY");
		Assert.assertEquals(1011, scoringMethod.score(nameList6));
	}
}
