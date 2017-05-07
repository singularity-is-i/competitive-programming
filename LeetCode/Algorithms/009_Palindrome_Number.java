import java.io.*;
import java.util.*;

class Palindrome_Number {
	public static boolean isPalindrome(int x) {
		boolean isPalindrome = true;

		String value = Integer.toString(x);

		int firstIndex = 0;
		int lastIndex = value.length() - 1;

		while(firstIndex < lastIndex) {
			if(value.charAt(firstIndex) != value.charAt(lastIndex)) {
				isPalindrome = false;
				break;
			}

			firstIndex++;
			lastIndex--;
		}

		return isPalindrome;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(23322));
	}
}