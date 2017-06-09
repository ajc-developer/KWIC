package com.se311.kwic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import com.se311.kwic.interfaces.LineStorage;
import com.se311.kwic.interfaces.Output;

public class FileOutput implements Output {

	private LineStorage abc;

	public FileOutput(LineStorage abc) {
		this.abc = abc;
	}

	public void print() {
		try{
	        Writer output = null;
	        File file = new File("results.txt");
	        output = new BufferedWriter(new FileWriter(file));

	        String line;
			do {
				line = abc.getLine();
				if (line != null) output.write(line+"\n");
			} while (line != null);

	        output.close();
	        System.out.println("File created.");

	    }catch(Exception e){
	        System.out.println("Could not create file");
	    }
	}
}
