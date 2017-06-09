package com.se311.kwic;

import java.util.Scanner;

import com.se311.kwic.interfaces.Alphabetizer;
import com.se311.kwic.interfaces.CircularShifter;
import com.se311.kwic.interfaces.Input;
import com.se311.kwic.interfaces.LineStorage;
import com.se311.kwic.interfaces.Output;

/**
 * See lecture 1/12/2017, 47:30
 *
 */
public class Driver {	
	public static void main(String[] args) {
		printLogo();
		String line = null;
		LineStorage ls = new SimpleLineStorage();

		Input input = null;
		System.out.println("Press '1' for user input.\nPress '2' for file input.");
		int choice = 0;
		Scanner in = new Scanner(System.in);
		do {
			choice = in.nextInt();
			if (choice < 1 || choice > 2) {
				System.out.println("Choice must be 1 or 2.\nPress '1' for user input.\nPress '2' for file input.");
			} else {
				if (choice == 1) {
					input = new UserInput();
				} else if (choice == 2) {
					input = new FileInput();
				}
			}
		} while (choice < 1 || choice > 2);
		input.parse(ls);
		CircularShifter cs = new SimpleCircularShifter(ls);
		cs.setup();

		ls.nullify();
		do {
			line = cs.getLine();
			if (line != null)
				ls.addLine(line);
		} while (line != null);

		Alphabetizer alpha = new SimpleAlphabetizer(ls);
		alpha.alphabetize();

		ls.nullify();
		do {
			line = alpha.getLine();
			if (line != null)
				ls.addLine(line);
		} while (line != null);

		Output co = null;

		System.out.println("Press '1' for console output.\nPress '2' for file output.");
		choice = 0;
		do {
			choice = in.nextInt();
			if (choice < 1 || choice > 2) {
				System.out.println("Choice must be 1 or 2.\nPress '1' for console output.\nPress '2' for file output.");
			} else {
				if (choice == 1) {
					co = new ConsoleOutput(ls);
				} else if (choice == 2) {
					co = new FileOutput(ls);
				}
			}
		} while (choice < 1 || choice > 2);

		in.close();
		co.print();
	}
	
	public static void printLogo(){
		String logo = "    __ __ _       __    ____   ______\r\n   / //_/| |     / /   /  _/  / ____/\r\n  / ,<   | | /| / /    / /   / /     \r\n / /| |  | |/ |/ /   _/ /   / /___   \r\n/_/ |_|  |__/|__/   /___/   \\____/   \r\n                                     \r\n";
		System.out.println(logo);
	}
}
