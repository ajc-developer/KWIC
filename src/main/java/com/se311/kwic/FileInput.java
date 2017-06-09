package com.se311.kwic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.se311.kwic.interfaces.Input;
import com.se311.kwic.interfaces.LineStorage;

public class FileInput implements Input {
	
	public void parse(LineStorage ls) {
		System.out.println("Please enter the path of the file you wish to use.");
		Scanner in = new Scanner(System.in);
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(in.nextLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String line;

		System.out.println ("===================");
		try {
			while ((line = br.readLine()) != null)   {
			  System.out.println(line);
			  ls.addLine(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println ("===================");
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
