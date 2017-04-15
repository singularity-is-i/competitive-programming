import java.io.*;
import java.util.*;

class Ratatouille {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int totalCases = scan.nextInt();

		for(int currentCase = 0; currentCase < totalCases; currentCase++) {
			int numIngredients = scan.nextInt();
			int numPackages = scan.nextInt();

			int[] ingredientRate = new int[numIngredients];

			for(int i  = 0; i < numIngredients; i++) {
				ingredientRate[i] = scan.nextInt();
			}

			int[][] items = new int[numIngredients][numPackages];

			for(int x = 0; x < numIngredients; x++) {
				int[] tempArray = new int[numPackages];
				for(int y = 0; y < numPackages; y++) {
					tempArray[y] = scan.nextInt();
				}

				Arrays.sort(tempArray);

				for(int y = 0; y < numPackages; y++) {
					items[x][y] = tempArray[y];
				}
			}

			int count = 0;

			for(int y = 0; y < numPackages; y++) {
				int[] currentIngredient = new int[numIngredients];
				int[] ingredientRates = ingredientRate;
				for(int x = 0; x < numIngredients; x++) {
					currentIngredient[x] = items[x][y];
				}

				boolean done = false;
				boolean first = true;
				int multiplier = 1;

				while(ingredientRates[0]*1.1 <= currentIngredient[0] && !done) {
					done = true;

					for(int i = 0; i < numIngredients; i++) {
						if(!first) {
							ingredientRates[i] /= multiplier;
							multiplier++;
							ingredientRates[i] *= multiplier;
						} else {
							first = false;
						}

						if(ingredientRates[i]*0.9 > currentIngredient[i]) {
							done = false;
							break;
						}
					}

					if(done) {
						count++;
					}
				}
			}


			System.out.println("Case #" + (currentCase+1) + ": " + count);
		}
	}
}