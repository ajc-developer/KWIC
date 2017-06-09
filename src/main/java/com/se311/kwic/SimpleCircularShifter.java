package com.se311.kwic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.se311.kwic.interfaces.CircularShifter;
import com.se311.kwic.interfaces.LineStorage;

public class SimpleCircularShifter implements CircularShifter {
	private LineStorage ls;
	private LineStorage shiftedLines;

	public SimpleCircularShifter(LineStorage ls) {
		this.ls = ls;
		shiftedLines = new SimpleLineStorage();
	}

	public void setup() {
		String currentLine = ls.getLine();
		while (currentLine != null) {
			int numWords = currentLine.split(" ").length;
			ArrayList<String> lineAsList = new ArrayList<String>(Arrays.asList(currentLine.split(" ")));
			for (int i = 0; i < numWords; i++) {
				Collections.rotate(lineAsList, -1);
				shiftedLines.addLine(stringArrayListToString(lineAsList));
			}
			currentLine = ls.getLine();
		}
	}
	
	private String stringArrayListToString(ArrayList<String> al){
		String ret = "";
		for(String s : al){
			ret+=s+ " ";
		}
		ret.trim();
		return ret;
	}

	public String getLine() {
		return shiftedLines.getLine();
	}

}
