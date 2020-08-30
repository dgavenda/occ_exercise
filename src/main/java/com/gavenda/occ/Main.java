package com.gavenda.occ;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gavenda.occ.scoring.ScoringMethodSimpleFirstNameOnly;
import com.gavenda.occ.scoring.ScoringMethodSimpleFirstNameAndLastName;

public class Main {
	
	private static Logger logger = LoggerFactory.getLogger(Main.class);
	
	private static String filename;
	
	private final static LetterHelper letterHelper = new LetterHelper();
	private final static FirstLastNameParser firstLastNameHelper = new FirstLastNameParser();
	
	public static void main(String[] args) {
		//check for one arg which would be filename
		if (args.length != 1) {
			logger.info("Was looking for only one arg (filename) but had "+args.length +" args. Exiting.");
			System.exit(1);
		} else {
			filename = args[0];
		}

		logger.info("Using filename: :" + filename);
	
		//read the file and get the names 
		InputFileReader reader = new InputFileReader(filename);
		List<String> nameList = reader.read();

		//change implementation here, could be in a application config file or by an added param
//		int total = new ScoringMethodSimpleFirstNameAndLastName(letterHelper).score(nameList);
		int total = new ScoringMethodSimpleFirstNameOnly(letterHelper).score(nameList);
		logger.info("total:{}", total);
	}
}
