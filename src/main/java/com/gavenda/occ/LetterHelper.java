package com.gavenda.occ;


import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LetterHelper {
	
	//could make this an unmodifiable map 
	private static final ConcurrentHashMap<Character, Integer> map = new ConcurrentHashMap<>();
	
	static {
		map.put('A', 1);
		map.put('B', 2);
		map.put('C', 3);
		map.put('D', 4);
		map.put('E', 5);
		map.put('F', 6);
		map.put('G', 7);
		map.put('H', 8);
		map.put('I', 9);
		map.put('J', 10);
		map.put('K', 11);
		map.put('L', 12);
		map.put('M', 13);
		map.put('N', 14);
		map.put('O', 15);
		map.put('P', 16);
		map.put('Q', 17);
		map.put('R', 18);
		map.put('S', 19);
		map.put('T', 20);
		map.put('U', 21);
		map.put('V', 22);
		map.put('W', 23);
		map.put('X', 24);
		map.put('Y', 25);
		map.put('Z', 26);			
	}
	
	public int getValue(char c) {
		Optional<Integer> optValue = Optional.ofNullable(map.get(c));

		if (optValue.isPresent()) {
			return optValue.get();
		} else {
			return 0;
		}
	}
}
