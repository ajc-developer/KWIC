package com.se311.kwic;

import com.se311.kwic.interfaces.LineStorage;
import com.se311.kwic.interfaces.Output;

public class ConsoleOutput implements Output {
	private LineStorage abc;

	public ConsoleOutput(LineStorage abc) {
		this.abc = abc;
	}

	public void print() {
		String line;
		do {
			line = abc.getLine();
			if (line != null) System.out.println(line);
		} while (line != null);
	}

}
