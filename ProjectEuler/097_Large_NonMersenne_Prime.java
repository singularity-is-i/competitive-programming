/*
The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the form 26972593−1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2p−1, have been found which contain more digits.

However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433×27830457+1.

Find the last ten digits of this prime number.
*/

import java.io.*;
import java.util.*;

class Large_NonMersenne_Prime {
	public static void main(String[] args) {
		long value = 28433;	// starting value

		for(long i = 0; i < 7830457; i++) {	// iterate 2^7830457 many times
			value *= 2;	// multiply by 2

			String stringValue = Long.toString(value);	// convert to string

			if(stringValue.length() > 10) {	// if string length is greater than 10, truncate
				value = Long.parseLong(stringValue.substring(stringValue.length()-10, stringValue.length()));
			}
		}

		value++;	// add 1 to value

		System.out.println("The last ten digits of 28433 * 2^7830457 + 1 is: " + value);
	}
}