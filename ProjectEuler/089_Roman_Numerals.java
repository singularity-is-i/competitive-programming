/*
For a number written in Roman numerals to be considered valid there are basic rules which must be followed. Even though the rules allow some numbers to be expressed in more than one way there is always a "best" way of writing a particular number.

For example, it would appear that there are at least six ways of writing the number sixteen:

IIIIIIIIIIIIIIII
VIIIIIIIIIII
VVIIIIII
XIIIIII
VVVI
XVI

However, according to the rules only XIIIIII and XVI are valid, and the last example is considered to be the most efficient, as it uses the least number of numerals.

The 11K text file, roman.txt (right click and 'Save Link/Target As...'), contains one thousand numbers written in valid, but not necessarily minimal, Roman numerals; see About... Roman Numerals for the definitive rules for this problem.

Find the number of characters saved by writing each of these in their minimal form.

Note: You can assume that all the Roman numerals in the file contain no more than four consecutive identical units.
*/

import java.io.*;
import java.util.*;

class Roman_Numerals {
	public static int getValue(char letter) {
		// return values for each letter
		switch (letter) {
			case 'I':	return 1;
			case 'V':	return 5;
			case 'X':	return 10;					
			case 'L':	return 50;
			case 'C':	return 100;
			case 'D':	return 500;
			case 'M':	return 1000;
			default:	return 0;
		}
	}

	public static String simplify(String originalString) {
		int number = 0;	// holds the number from originalString
		int lastValue = 0;	// hold last value checked

		for(int i = 0; i < originalString.length(); i++) {	// iterate through each letter
			int value = getValue(originalString.charAt(i));	// get value of current char

			if(i != 0 && value > lastValue) {	// if we are not at the first character and lastValue is less than value
				number -= (2 * lastValue);	// subtract last value twice
			}

			number += value;	// add value to number
			lastValue = value;	// set lastValue as value
		}

		String stringNumber = Integer.toString(number);	// convert number to string
		int length = stringNumber.length();	// get value of length of string

		if(length <= 4) {	// if number is less than 4 characters long
			StringBuilder simplifyString = new StringBuilder();

			for(int currentChar = length - 1; currentChar >= 0; currentChar--) {	// iterate through all numbers
				int currentValue = Integer.parseInt(Character.toString(stringNumber.charAt(currentChar)));	// get current number

				switch (length - currentChar) {	// length - currentChar can only be... 1, 2, 3, 4
					// ones place
					case 1:		if(currentValue == 9) {	// IX
									simplifyString.insert(0,'X');
									simplifyString.insert(0,'I');
								} else if(currentValue >= 5) {	// VI...
									for(int i = 0; i < currentValue - 5; i++) {
										simplifyString.insert(0,'I');
									}

									simplifyString.insert(0,'V');
								} else if(currentValue == 4) {	// IV
									simplifyString.insert(0,'V');
									simplifyString.insert(0,'I');
								} else {	// I...
									for(int i = 0; i < currentValue; i++) {
										simplifyString.insert(0,'I');
									}
								}

								break;
					// tens place
					case 2:		if(currentValue == 9) {	// XC
									simplifyString.insert(0,'C');
									simplifyString.insert(0,'X');
								} else if(currentValue >= 5) {	// LX...
									for(int i = 0; i < currentValue - 5; i++) {
										simplifyString.insert(0,'X');
									}

									simplifyString.insert(0,'L');
								} else if(currentValue >= 4) {	// XL
									simplifyString.insert(0,'L');
									simplifyString.insert(0,'X');
								} else {	// X...
									for(int i = 0; i < currentValue; i++) {
										simplifyString.insert(0,'X');
									}
								}

								break;
					// hundreds place
					case 3:		if(currentValue == 9) {	// CM
									simplifyString.insert(0,'M');
									simplifyString.insert(0,'C');
								} else if(currentValue >= 5) {	// DC...
									for(int i = 0; i < currentValue - 5; i++) {
										simplifyString.insert(0,'C');
									}

									simplifyString.insert(0,'D');
								} else if(currentValue >= 4) {	// CD
									simplifyString.insert(0,'D');
									simplifyString.insert(0,'C');
								} else {	// C...
									for(int i = 0; i < currentValue; i++) {
										simplifyString.insert(0,'C');
									}
								}

								break;
					// thousands place
					case 4:		for(int i = 0; i < currentValue; i++) {	// M...
									simplifyString.insert(0,'M');
								}

								break;
					// error
					default:	System.out.println("Error.");	// this should never occur.
								break;
				}
			}

			return simplifyString.toString();
		} else {	// otherwise error
			System.out.println("ERROR: The value was greater than 9999");
			return "";	// error
		}
	}

	public static void main(String[] args) {
		try{	// Try
			Scanner scan = new Scanner(new FileReader("p089_roman.txt"));	// create scanner to read file "p089_roman.txt"

			int charsSaved = 0;	// value to hold number of characters saved

			while(scan.hasNext()) {	// iterate through each line in file
				String value = scan.nextLine();	// save line as string
				String newValue = simplify(value);	// simplifying the string

				charsSaved += value.length() - newValue.length();	// add the difference in length between the two to charsSaved
			}

			System.out.println("The total number of characters saved is: " + charsSaved);
		} catch (FileNotFoundException fe) {	// catch FileNotFoundException
			System.out.println("File p089_roman.txt was not found...");
		}
	}
}