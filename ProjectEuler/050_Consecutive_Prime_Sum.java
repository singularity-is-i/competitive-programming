/*
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/

import java.io.*;
import java.util.*;
import java.math.*;

class Consecutive_Prime_Sum {
    public static boolean[] primeSieve(int n) {
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor*factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }

        return isPrime;
    }

    public static void main(String[] args) { 
        boolean[] primeValues = primeSieve(10000000);    // find all primes < 1,000,000

        long longestSum = 0;     // longest sum
        int longestChain = 0;   // longest chain

        for(int startNumber = 2; startNumber < 1000000; startNumber++) {
            if(primeValues[startNumber]) {

                long currentSum = 0;     // current sum
                int currentChain = 0;   // current chain

                int currentNumber = startNumber;

                while(currentSum <= 1000000) {
                    while(!primeValues[currentNumber]) {
                        currentNumber++;
                    }

                    currentSum += currentNumber;
                    currentChain++;

                    System.out.println(currentNumber);
                    
                    if(primeValues[(int) currentSum]) {
                        if(currentChain >= longestChain && currentSum <= 1000000) {
                            longestSum = currentSum;
                            longestChain = currentChain;
                        }
                    }

                    currentNumber++;
                }
            }
        }

        System.out.println("The largest chain of prime numbers is: " + longestChain + ", with a sum of:" + longestSum);
    }
}
