package com.gavenda.occ;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


public class FirstAndLastNameParserTest {
		
	private List<String> combinesFirstAndLastNames;
	
	
	@Before
	public void setup() {
		combinesFirstAndLastNames = Arrays.asList("First Last", "Michael Jordan", "Paul Konerko");
	}

	@Test
	public void testFirstAndLastNameParsing() {	
		List<FirstAndLastName> firstAndLastNameList = new FirstLastNameParser().convert(combinesFirstAndLastNames);
		
		Assert.assertEquals(new FirstAndLastName("First", "Last"), firstAndLastNameList.get(0));
		Assert.assertEquals(new FirstAndLastName("Michael", "Jordan"), firstAndLastNameList.get(1));
		Assert.assertEquals(new FirstAndLastName("Paul", "Konerko"), firstAndLastNameList.get(2));
	}
}