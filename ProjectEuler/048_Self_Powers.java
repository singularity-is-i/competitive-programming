/*
The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Self_Powers {
	public static void main(String[] args) {
		BigInteger sum = BigInteger.valueOf(0);	// sum of all powers

		for(int i = 1; i <= 1000; i++) {
			BigInteger value = new BigInteger(Integer.toString(i));	// create the base 

			value = value.pow(i);	// find i^i

			sum = sum.add(value);	// add to sum
		}

		String answer = sum.toString();	// convert to string

		answer = answer.substring(answer.length()-10);	// get last 10 digits

		System.out.println("The last 10 digits of the result of the series is: " + answer);
	}
}