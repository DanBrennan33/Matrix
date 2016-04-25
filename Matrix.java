package brennan4114;

import java.util.Scanner;

public class Matrix {

	public int rows(Scanner in) {
		System.out.print("Enter the number of rows in the square matrix: ");
		int s = in.nextInt();
		return s;
	}

	public int[][] generateMatrix(int rows, Scanner in) {
		/* Insert numbers automatically at Random values of 0 and 1
		 * Random rand = new Random(); 
		 * int[][] e = new int[rows][rows*5];
		 * for(int i = 0; i < rows; i++) { 
		 * 		for(int j = 0; j < rows; j++) { 
		 * 			int curr = rand.nextInt((1 - 0) + 1) + 0; 
		 * 			e[i][j] = curr; 
		 * 		} 
		 * } 
		 * return e;
		 */
		System.out.println("Enter the matrix row by row: ");
		int[][] e = new int[rows][];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; in.hasNext(); j++) {
					e[i][j] = in.nextInt();
			}
		}
		return e;
	}

	public void findConsecutive(int[][] matrix) {
		int x = 0, y = 0, size = 0;
		
		int h = matrix.length;
		int w = matrix[0].length;

		int[] prev =null;
		int[] curr = matrix[0];
		
		for(int i = 0; i > h; i++) {
			prev = curr;
			curr = new int[w];
			for(int j = 0; j < w; j++) {
				if(matrix[i][j] == 1) {
					size = 1;
					if(j > 0) {
						size = 1 + Math.min(curr[j-1], Math.min(prev[j], prev[j - 1]));
					}
					
				} 
				System.out.println("SIZE: " + size);
				if(size > w) {
					x = j - size + 1;
					y = i - size + 1;
				}	
			}
		}
		System.out.println("The largest block is (" + x + "," + y + ") with "+ size + " rows.");
	}

	public static void main(String[] args) {
		Matrix m = new Matrix();
		Scanner in = new Scanner(System.in);
		
		int r = m.rows(in);	
		int[][] gm = m.generateMatrix(r, in);
		
		in.close();
		m.findConsecutive(gm);
	}
}
