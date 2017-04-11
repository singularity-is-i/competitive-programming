/*
A googol (10100) is a massive number: one followed by one-hundred zeros; 100100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Powerful_Digit_Sum {
	public static void main(String[] args) {
		int largestSum = 0;	// value to hold maximum digital sum

		for(int a = 2; a < 100; a++) {	// a
			for(int b = 2; b < 100; b++) {	// b
				BigInteger power = BigInteger.valueOf(a).pow(b);	// power = a^b
				String value = power.toString();	// convert to string

				int sum = 0;	// current sum

				for(int currentChar = 0; currentChar < value.length(); currentChar++) {	// iterate through each char
					sum += Integer.parseInt(Character.toString(value.charAt(currentChar)));	// add to sum
				}

				if(sum > largestSum) {	// if sum is greater than largest sum
					largestSum = sum;	// set largest sum to sum
				}
			}
		}

		System.out.println("The maximum digital sum is: " + largestSum);
	}
}