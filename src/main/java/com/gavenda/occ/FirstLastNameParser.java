package com.gavenda.occ;

import static com.gavenda.occ.Constants.EMPTY_SPACE;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FirstLastNameParser {
	private static final Logger logger = LoggerFactory.getLogger(FirstLastNameParser.class);
	
	public List<FirstAndLastName> convert(List<String> firstAndLastNames) {
		List<FirstAndLastName> firstAndLastNamesList = new ArrayList<FirstAndLastName>();
		for (String firstAndLastName : firstAndLastNames) {
			StringTokenizer tokenizer = new StringTokenizer(firstAndLastName.trim(), EMPTY_SPACE);
			if (tokenizer.countTokens() == 2) {
				firstAndLastNamesList.add(new FirstAndLastName(tokenizer.nextToken(), tokenizer.nextToken()));
			} else {
				logger.error("Only had 1 name.  Needed to have both first and last name.  name={}.  Will skip this one.", firstAndLastName);
			}
		}
		return firstAndLastNamesList;
	}

}
