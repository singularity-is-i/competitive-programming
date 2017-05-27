/*
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
*/

import java.io.*;
import java.util.*;

class Digit_Cancelling_Fractions {
	public static void main(String[] args) {
		for(double denominator = 11; denominator < 99; denominator++){
			for(double numerator = 11; numerator < denominator; numerator++) {
				if(numerator % 10 != 0 && denominator % 10 != 0) {
					String stringNum = Double.toString(numerator);
					String stringDen = Double.toString(denominator);
					char newNum = '0';
					char newDen = '0';
					boolean valueFound = true;

					if(stringNum.charAt(0) == stringDen.charAt(0)) {
						newNum = stringNum.charAt(1);
						newDen = stringDen.charAt(1);
					} else if(stringNum.charAt(0) == stringDen.charAt(1)) {
						newNum = stringNum.charAt(1);
						newDen = stringDen.charAt(0);
					} else if(stringNum.charAt(1) == stringDen.charAt(0)) {
						newNum = stringNum.charAt(0);
						newDen = stringDen.charAt(1);
					} else if(stringNum.charAt(1) == stringDen.charAt(1)) {
						newNum = stringNum.charAt(0);
						newDen = stringDen.charAt(0);
					} else {
						valueFound = false;
					}

					if(valueFound) {
						double quotient1 = Double.parseDouble(Character.toString(newNum))/Double.parseDouble(Character.toString(newDen));
						double quotient2 = numerator/denominator;

						if(quotient1 == quotient2) {
							System.out.println("FOUND: " + newNum + " / " + newDen);
						}
					}
				}
			}
		}
	}
}