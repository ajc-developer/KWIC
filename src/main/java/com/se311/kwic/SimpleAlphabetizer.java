package com.se311.kwic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.se311.kwic.interfaces.Alphabetizer;
import com.se311.kwic.interfaces.LineStorage;

public class SimpleAlphabetizer implements Alphabetizer {
	private LineStorage cs;
	private LineStorage alpha;
	
	public SimpleAlphabetizer(LineStorage cs) {
		this.cs = cs;
		alpha = new SimpleLineStorage();
		
	}

	public void alphabetize() {
		ArrayList<String> alphabetizedArrayList = new ArrayList<String>();
		String line;
		do {
			line = cs.getLine();
			if (line != null)
				alphabetizedArrayList.add(line);
		} while (line != null);

		Collections.sort(alphabetizedArrayList, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		});
		for(String s : alphabetizedArrayList){
			alpha.addLine(s);
		}
	}

	public String getLine() {
		return alpha.getLine();
	}
}
