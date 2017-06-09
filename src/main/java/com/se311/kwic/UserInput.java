package com.se311.kwic;

import java.util.Scanner;

import com.se311.kwic.interfaces.Input;
import com.se311.kwic.interfaces.LineStorage;

public class UserInput implements Input {

	@SuppressWarnings("resource")
	public void parse(LineStorage ls) {
		System.out.println("Please enter the lines of text you wish to input.\nWhen you are finished, type '$$'");
		String line = null;
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			line = in.nextLine();
			System.out.println(line);
			if(line.equals("$$")) break;
			else ls.addLine(line);
		}
	}


}
