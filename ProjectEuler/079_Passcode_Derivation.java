/*
A common security method used for online banking is to ask the user for three random characters from a passcode. For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected reply would be: 317.

The text file, keylog.txt, contains fifty successful login attempts.

Given that the three characters are always asked for in order, analyse the file so as to determine the shortest possible secret passcode of unknown length.
*/

import java.io.*;
import java.util.*;

class Passcode_Derivation {
	public static void main(String[] args) {
		String[] login = new String[50];	// array to hold all values from keylog.txt
		boolean[] contains = new boolean[10];	// boolean array for which numbers are used
		Arrays.fill(contains, Boolean.FALSE);	// set all values in boolean array to false

		Scanner scan = new Scanner(System.in);	// scanner

		for(int attempt = 0; attempt < 50; attempt++) {	// scan in all values
			String value = scan.nextLine();	// scan next line

			for(int i = 0; i < value.length(); i++) {
				int index = Integer.parseInt(Character.toString(value.charAt(i)));
				contains[index] = true;	// set boolean flag to true for number
			}

			login[attempt] = value;	// save value into string array
		}

		StringBuilder passcode = new StringBuilder();	// StringBuilder to hold passcode
		boolean[] current = new boolean[10];	// boolean array for which numbers are used so far
		Arrays.fill(current, Boolean.FALSE);	// set all values in boolean array to false

		char first = login[0].charAt(0);	// find first value
		char last = login[0].charAt(2);	// find last value

		for(int index = 1; index < 50; index++) {	// iterate through all password attempts
			String value = login[index];	// get saved login attempt

			if(value.charAt(1) == first) {	// if first value is current middle
				first = value.charAt(0);	// set first value as current first
			} else if(value.charAt(1) == last) {	// if last value is current middle
				last = value.charAt(2);	// set last value as current last
			}
		}

		passcode.append(first);	// append first value
		passcode.append(2);	// append 2
		passcode.append(last);	// append last value

		while(!Arrays.equals(contains, current)) {	// iterate until we have found all numbers
			for(int index = 0; index < passcode.length()-1; index++) {	// iterate through all index values
				int firstNumber = Integer.parseInt(Character.toString(passcode.charAt(index)));	// find first number
				int secondNumber = Integer.parseInt(Character.toString(passcode.charAt(index + 1)));	// find second number
				current[firstNumber] = true;	// set current as true
				current[secondNumber] = true;	// set current as true

				for(int i = 0; i < 50; i++) {	// iterate 0...50
					String value = login[i];	// find saved string value

					int valueFirst = Integer.parseInt(Character.toString(value.charAt(0)));	// find first character
					int valueThird = Integer.parseInt(Character.toString(value.charAt(2)));	// find third character

					if(valueFirst == firstNumber && valueThird == secondNumber) {	// if 1.2. = 1.3.
						passcode.insert(index+1, value.charAt(1));	// insert the middle value between 1 and 2
						break;	// end loop
					}
				}
			}
		}

		System.out.println("The passcode is: " + passcode);
	}
}