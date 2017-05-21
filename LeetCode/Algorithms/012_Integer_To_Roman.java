public class Solution {
    public String intToRoman(int num) {
        String stringNumber = Integer.toString(num);	// convert number to string
		int length = stringNumber.length();	// get value of length of string

		if(length <= 4) {	// if number is less than 4 characters long
			StringBuilder simplifyString = new StringBuilder();

			for(int currentChar = length - 1; currentChar >= 0; currentChar--) {	// iterate through all numbers
				int currentValue = Integer.parseInt(Character.toString(stringNumber.charAt(currentChar)));	// get current number

				switch (length - currentChar) {	// length - currentChar can only be... 1, 2, 3, 4
					// ones place
					case 1:		if(currentValue == 9) {	// IX
									simplifyString.insert(0,'X');
									simplifyString.insert(0,'I');
								} else if(currentValue >= 5) {	// VI...
									for(int i = 0; i < currentValue - 5; i++) {
										simplifyString.insert(0,'I');
									}

									simplifyString.insert(0,'V');
								} else if(currentValue == 4) {	// IV
									simplifyString.insert(0,'V');
									simplifyString.insert(0,'I');
								} else {	// I...
									for(int i = 0; i < currentValue; i++) {
										simplifyString.insert(0,'I');
									}
								}

								break;
					// tens place
					case 2:		if(currentValue == 9) {	// XC
									simplifyString.insert(0,'C');
									simplifyString.insert(0,'X');
								} else if(currentValue >= 5) {	// LX...
									for(int i = 0; i < currentValue - 5; i++) {
										simplifyString.insert(0,'X');
									}

									simplifyString.insert(0,'L');
								} else if(currentValue >= 4) {	// XL
									simplifyString.insert(0,'L');
									simplifyString.insert(0,'X');
								} else {	// X...
									for(int i = 0; i < currentValue; i++) {
										simplifyString.insert(0,'X');
									}
								}

								break;
					// hundreds place
					case 3:		if(currentValue == 9) {	// CM
									simplifyString.insert(0,'M');
									simplifyString.insert(0,'C');
								} else if(currentValue >= 5) {	// DC...
									for(int i = 0; i < currentValue - 5; i++) {
										simplifyString.insert(0,'C');
									}

									simplifyString.insert(0,'D');
								} else if(currentValue >= 4) {	// CD
									simplifyString.insert(0,'D');
									simplifyString.insert(0,'C');
								} else {	// C...
									for(int i = 0; i < currentValue; i++) {
										simplifyString.insert(0,'C');
									}
								}

								break;
					// thousands place
					case 4:		for(int i = 0; i < currentValue; i++) {	// M...
									simplifyString.insert(0,'M');
								}

								break;
					// error
					default:	System.out.println("Error.");	// this should never occur.
								break;
				}
			}

			return simplifyString.toString();
		} else {	// otherwise error
			System.out.println("ERROR: The value was greater than 9999");
			return "";	// error
		}
    }
}