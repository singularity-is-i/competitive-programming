public class Solution {
    public boolean isPalindrome(int x) {
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
}