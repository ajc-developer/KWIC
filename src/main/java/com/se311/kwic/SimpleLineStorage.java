package com.se311.kwic;

import java.util.ArrayList;

import com.se311.kwic.interfaces.LineStorage;

public class SimpleLineStorage implements LineStorage {
	private ArrayList<String> lines;

	public SimpleLineStorage() {
		this.lines = new ArrayList<String>();
	}

	public void addLine(String line) {
		lines.add(line);
	}

	public String getLine() {
		if(lines.size() == 0){
			return null;
		}
		String l = lines.remove(lines.size()-1);
		return l;
	}

	public void nullify() {
		this.lines = new ArrayList<String>();
	}

}
