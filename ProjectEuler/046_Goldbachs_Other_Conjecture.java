/*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×12
15 = 7 + 2×22
21 = 3 + 2×32
25 = 7 + 2×32
27 = 19 + 2×22
33 = 31 + 2×12

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Goldbachs_Other_Conjecture {
	public static boolean isConjecture(long number) {
		boolean isConjecture = false;	// flag to hold whether the number follows conjecture

		for(long i = 2; i < number; i++) {	// loop 2...number
			if(!isComposite(i)) {	// if not composite (if prime)
				long value = number - i;	// subtract prime from number

				value /= 2;	// divide value by 2

				double sqrt = Math.sqrt(value);	// squareroot the number

				int answer = (int) sqrt;	// convert number to int

				if(Math.pow(sqrt, 2) == Math.pow(answer, 2)) {	// if the square of int and the square of double are the smallest
					isConjecture = true;	// perfect square = conjecture is true
					break;	// break loop
				}
			}
		}

		return isConjecture;
	}

	public static boolean isComposite(long number) {
		boolean isComposite = false;	// flag to hold whether the number is composite

		for(int i = 2; i <= Math.sqrt(number); i++) {	// iterate 2... sqrt(number)
			if(number % i == 0) {	// if number is divisible by i
				isComposite = true;	// value is composite
				break;	// end loop
			}
		}

		return isComposite;
	}

	public static void main(String[] args) {
		boolean found = false;	// flag to loop until found

		long currentNumber = 1;	// current number we are checking

		while(!found) {	// loop until found
			currentNumber += 2;	// add 2 to current number (only checking odds)

			if(isComposite(currentNumber) && !isConjecture(currentNumber)) {	// if the odd number is composite and does not follow the conjecture
				found = true;	// flag = true
			}
		}

		System.out.println("The smallest odd composite that cannot be written as the sum of a prime and twice a square is: " + currentNumber);
	}
}