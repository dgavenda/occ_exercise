package com.gavenda.occ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


public class FirstAndLastNameComparatorTest {
	
	private final List<FirstAndLastName> list = new ArrayList<>();
	
	
	@Before
	public void setup() {
		FirstAndLastName name1 = new FirstAndLastName("Frank", "Thomas");
		FirstAndLastName name2 = new FirstAndLastName("Babe", "Thomas");
		FirstAndLastName name3 = new FirstAndLastName("Robin", "Ventura");
		FirstAndLastName name4 = new FirstAndLastName("Robi", "Ventura");
		FirstAndLastName name5 = new FirstAndLastName("AA", "BB");
		FirstAndLastName name6 = new FirstAndLastName("A", "BB");
		FirstAndLastName name7 = new FirstAndLastName("AA", "B");
				
		list.clear();
		list.add(name1);
		list.add(name2);
		list.add(name3);
		list.add(name4);
		list.add(name5);
		list.add(name6);
		list.add(name7);
	}

	@Test
	public void testFirstAndLastName() {		
		FirstAndLastNameComparator comparator = new FirstAndLastNameComparator();
		Collections.sort(list, comparator);
		
		Assert.assertEquals(new FirstAndLastName("AA", "B"), list.get(0));
		Assert.assertEquals(new FirstAndLastName("A", "BB"), list.get(1));
		Assert.assertEquals(new FirstAndLastName("AA", "BB"), list.get(2));
		Assert.assertEquals(new FirstAndLastName("Babe", "Thomas"), list.get(3));
		Assert.assertEquals(new FirstAndLastName("Frank", "Thomas"), list.get(4));
		Assert.assertEquals(new FirstAndLastName("Robi", "Ventura"), list.get(5));
		Assert.assertEquals(new FirstAndLastName("Robin", "Ventura"), list.get(6));
	}
}