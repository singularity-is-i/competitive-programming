/*
The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Distinct_Prime_Factors {
	public static boolean isPrime(long value) {
		boolean isPrime = true;	// flag for whether value is prime

		for(long i = 2; i <= Math.sqrt(value); i++) {	// iterate from 2..sqrt(value)
			if(value % i == 0) {	// if divisible
				isPrime = false;	// is not prime
				break;
			}
		}

		return isPrime;
	}

	public static void main(String[] args) {
		boolean[] previousPrime = new boolean[4];	// boolean array keeping track of previous consecutive primes
		Arrays.fill(previousPrime, Boolean.FALSE);	// fill all values as false

		long value = 646;	// start check at 646

		while(!previousPrime[3]) {	// while fourth boolean value is false
			int count = 0;	// count of distinct primes

			for(long i = 2; i <= value; i++) {	// iterate 2...value
				if(value % i == 0) {	// if divisible
					if(isPrime(i)){	// if prime
						count++;	// add to count
					}

					if(count == 4) {	// end search if we find 4 distinct primes
						break;
					}
				}
			}

			if(count == 4) {	// if count is equal to 4
				int place = 0;	// value to iterate through boolean array

				while(previousPrime[place]) {	// iterate through each value of boolean array until we find a false
					place++;
				}

				previousPrime[place] = true;	// set value as true;
			} else {
				Arrays.fill(previousPrime, Boolean.FALSE);	// fill all values as false
			}

			value++;
		}

		System.out.println("The first of the four numbers that are consecutive integers with at least 4 distinct prime factors is: " + (value-4));
	}
}