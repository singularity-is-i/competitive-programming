import java.io.*;
import java.util.*;

class Alphabet_Cake {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int totalCases = scan.nextInt();

		for(int currentCase = 0; currentCase < totalCases; currentCase++) {
			int r = scan.nextInt();
			int c = scan.nextInt();

			char[][] cake = new char[r][c];
			int[][] cakeValid = new int[r][c];

			scan.nextLine();

			for(int i = 0; i < r; i++) {
				String value = scan.nextLine();
				
				for(int j = 0; j < c; j++) {
					if(value.charAt(j) != '?') {
						cake[i][j] = value.charAt(j);
						cakeValid[i][j] = 0;	// 0 = set. can use.
					} else {
						cakeValid[i][j] = -1;	// -1 = empty.
					}
				}
			}

			boolean isDone = true;

			for(int x = 0; x < r; x++) {
				for(int y = 0; y < c; y++) {
					if(cakeValid[x][y] == -1) {
						int change = 0;
						boolean done = false;
						while(x-change >= 0 && !done) {
							if(cakeValid[x-change][y] == 0 || cakeValid[x-change][y] == 1) {
								for(int z = 0; z <= change; z++) {
									cake[x-z][y] = cake[x-change][y];
									cakeValid[x-z][y] = 1; // row only movement
								}
								cakeValid[x-change][y] = 1; // row only movement
								done = true;
							} else if(cakeValid[x-change][y] == 2) {
								break;
							}
							change++;
						}

						change = 0;
						while(x+change < r && !done) {
							if(cakeValid[x+change][y] == 0 || cakeValid[x+change][y] == 1) {
								for(int z = 0; z <= change; z++) {
									cake[x+z][y] = cake[x+change][y];
									cakeValid[x+z][y] = 1; // row only movement
								}
								cakeValid[x+change][y] = 1; // row only movement
								done = true;
							} else if(cakeValid[x+change][y] == 2) {
								break;
							}
							change++;
						}

						if(cakeValid[x][y] == -1) {
							isDone = false;
							cake[x][y] = '?';
						// 	change = 0;
						// 	while(y-change >= 0 && !done) {
						// 		if(cakeValid[x][y-change] == 0 || cakeValid[x][y-change] == 2) {
						// 			for(int z = 0; z < change; z++) {
						// 				cake[x][y-z] = cake[x][y-change];
						// 				cakeValid[x][y-z] = 2; // column only movement
						// 			}
						// 			cakeValid[x][y-change] = 2; // column only movement
						// 			done = true;
						// 		} else if(cakeValid[x][y-change] == 1) {
						// 			break;
						// 		}
						// 		change++;
						// 	}

						// 	change = 0;
						// 	while(y+change < c && !done) {
						// 		if(cakeValid[x][y+change] == 0 || cakeValid[x][y+change] == 2) {
						// 			for(int z = 0; z < change; z++) {
						// 				cake[x][y+z] = cake[x][y+change];
						// 				cakeValid[x][y+z] = 2; // column only movement
						// 			}
						// 			cakeValid[x][y+change] = 2; // column only movement
						// 			done = true;
						// 		} else if(cakeValid[x][y+change] == 1) {
						// 			break;
						// 		}
						// 		change++;
						// 	}
						// 	if(cakeValid[x][y] == -1) {
						// 		isDone = false;
						// 		cake[x][y] = '?';
						// 	}
						}
					}
				}
			}

			if(!isDone) {
				for(int x = 0; x < r; x++) {
					boolean isEmpty = true;
					for(int y = 0; y < c; y++) {
						if(cakeValid[x][y] != -1) {
							isEmpty = false;
						}
					}

					if(isEmpty) {
						int change = 0;
						boolean done = false;
						while(x-change >= 0 && !done) {
							if(cakeValid[x-change][0] != -1) {
								for(int y = 0; y < c; y++) {
									cake[x][y] = cake[x-change][y];
									cakeValid[x][y] = 3; // last minute fix
									cakeValid[x-change][y] = 3; // last minute fix
								}
								done = true;
							}
							change++;
						}

						change = 0;
						while(x+change < r && !done) {
							if(cakeValid[x+change][0] != -1) {
								for(int y = 0; y < c; y++) {
									cake[x][y] = cake[x+change][y];
									cakeValid[x][y] = 3; // last minute fix
									cakeValid[x+change][y] = 3; // last minute fix
								}
								done = true;
							}
							change++;
						}
					}
				}

				for(int y = 0; y < c; y++) {
					boolean isEmpty = true;
					for(int x = 0; x < r; x++) {
						if(cakeValid[x][y] != -1) {
							isEmpty = false;
						}
					}

					if(isEmpty) {
						int change = 0;
						boolean done = false;
						while(y-change >= 0 && !done) {
							if(cakeValid[0][y-change] != -1) {
								for(int x = 0; x < r; x++) {
									cake[x][y] = cake[x][y-change];
									cakeValid[x][y] = 3; // last minute fix
									cakeValid[x][y-change] = 3; // last minute fix
								}
								done = true;
							}
							change++;
						}

						change = 0;
						while(y+change < c && !done) {
							if(cakeValid[0][y+change] != -1) {
								for(int x = 0; x < r; x++) {
									cake[x][y] = cake[x][y+change];
									cakeValid[x][y] = 3; // last minute fix
									cakeValid[x][y+change] = 3; // last minute fix
								}
								done = true;
							}
							change++;
						}
					}
				}
			}

			System.out.println("Case #" + (currentCase+1) + ":");

			for(int x = 0; x < r; x++) {
				for(int y = 0; y < c; y++) {
					System.out.print(cake[x][y]);
				}
				System.out.println();
			}
		}
	}
}