package com.gavenda.occ.calculation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.gavenda.occ.LetterHelper;


public class CalculationImplSimpleFirstNameTest {

	@Test
	public void testSimpleFirstName() {
		CalculationImplSimpleFirstName c = new CalculationImplSimpleFirstName(new LetterHelper());
		
		List<String> nameList = Arrays.asList("MARY");
		assertEquals(57, c.calculate(nameList));
		
		List<String> nameList2 = Arrays.asList("BARB");
		assertEquals(23, c.calculate(nameList2));
		
		
		List<String> nameList3 = Arrays.asList("MARY", "BARB");
		assertEquals(137, c.calculate(nameList3));
	}
}
