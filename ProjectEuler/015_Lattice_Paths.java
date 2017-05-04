/*
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?
*/

import java.io.*;
import java.util.*;

class Lattice_Paths {
	public static int gridSize = 20;	// grid size

	public static long[][] pathArray = new long[gridSize+1][gridSize+1];	// array for memoization

	public static long numPaths(int x, int y) {	// recursion to find all potential paths
		if(pathArray[x][y] != 0) {	// if we already have the value stored via memoization
			return pathArray[x][y];
		} else {	// otherwise calculate value via recursion
			long sum;

			if(x == gridSize && y == gridSize) {	// if we are at 20/20
				sum = 1;	// return a value of 1
			} else if (x < gridSize && y < gridSize) {	// if both x and y are less than 20
				sum = numPaths(x+1, y) + numPaths(x, y+1);	// fork to find both potential paths
			} else if (x < gridSize && y == gridSize) {	// if only x is less than 20
				sum = numPaths(x+1, y);	// add one to x
			} else if (x == gridSize && y < gridSize) {	// if only y is less than 20
				sum = numPaths(x, y+1);	// add one to y
			} else {	// this should never occur
				System.out.println("ERROR: This should never occur.");
				return 0;
			}

			pathArray[x][y] = sum;	// store value via memoization for future use
			return sum;	// return sum
		}
	}

	public static void main(String[] args) {
		System.out.println("The total number of routes is: " + numPaths(0,0));
	}
}