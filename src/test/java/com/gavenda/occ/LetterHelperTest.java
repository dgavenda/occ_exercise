package com.gavenda.occ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


public class LetterHelperTest {
	
	@Test
	public void testProperLetters() {		
		LetterHelper letterHelper = new LetterHelper();
		
		Assert.assertEquals(4, letterHelper.getValue('D'));
		Assert.assertEquals(1, letterHelper.getValue('A'));
		Assert.assertEquals(26, letterHelper.getValue('Z'));
	}
	
	@Test
	public void testInvalidLetterAndSymbols() {		
		LetterHelper letterHelper = new LetterHelper();
		
		Assert.assertEquals(0, letterHelper.getValue('d'));
		Assert.assertEquals(0, letterHelper.getValue('-'));
		Assert.assertEquals(0, letterHelper.getValue('_'));
	}
}