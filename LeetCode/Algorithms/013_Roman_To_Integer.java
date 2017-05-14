public class Solution {
    public int getValue(char letter) {
		switch (letter) {
			case 'I':	return 1;
			case 'V':	return 5;
			case 'X':	return 10;					
			case 'L':	return 50;
			case 'C':	return 100;
			case 'D':	return 500;
			case 'M':	return 1000;
			default:	return 0;
		}
	}
    
    public int romanToInt(String s) {
        int number = 0;
		int lastValue = 0;

		for(int i = 0; i < s.length(); i++) {
			int value = getValue(s.charAt(i));

			if(i != 0 && value > lastValue) {
				number -= (2 * lastValue);
			}

			number += value;
			lastValue = value;
		}

		return number;
    }
}