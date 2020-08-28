package com.gavenda.occ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputFileReader {
	
	private static Logger logger = LoggerFactory.getLogger(InputFileReader.class);
	
	private final String filename;
	
	public InputFileReader(String filename) {
		this.filename = filename;
	}
	
	protected List<String> read() {
		List<String> nameList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))) {
			String line;
			while ((line = reader.readLine()) != null) {
//				logger.info("Read line:{}",line);
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				while (tokenizer.hasMoreElements()) {
					nameList.add(tokenizer.nextToken().toUpperCase().replaceAll("\"", ""));
				}
			}
		} catch (IOException e) {
			logger.error("There was an error reading the names file.  filename:" + filename + ".\n" + e);
		}
		return nameList;
	}
}
