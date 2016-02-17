package com.games.minesweeper;

import java.util.Scanner;

public class Minesweeper {
	

	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		double z = 0.1;

		boolean[][] bomb = new boolean[x + 2][y + 2];

		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				bomb[i][j] = Math.random() < z;
			}
		}

		/*
		 * char disp [][] = new char[x+2][y+2]; for (int i = 1; i <= x; i++) {
		 * for (int j = 1; j <= y; j++) { if(bomb[i][j]) disp[i][j] = '*'; else
		 * disp[i][j] = '0'; } }
		 */

		// live problem display
		
		/*for (int i = 1; i <= (x); i++) {
			for (int j = 1; j <= (y); j++) {
				if (bomb[i][j])
					System.out.print("@ ");
				else
					System.out.print(". ");
			}
			System.out.println();

		}*/
		
		
		int sol[][] = new int[x + 2][y + 2];
		
		for (int i = 1; i <= (x); i++) {
			for (int j = 1; j <= (y); j++) {
				if (bomb[i][j])
					sol[i][j] = -9; // marking all the bombs as - integer
				for (int ii = i - 1; ii <= i + 1; ii++) {
					for (int jj = j - 1; jj <= j + 1; jj++) {
						if (bomb[ii][jj])
							sol[i][j]++;
					}
				}
			}

		}
		
		

		// displaying sol[][]
		// for (int i = 1; i < sol.length-1; i++) {
		// for (int j = 1; j < sol.length-1; j++) {
		// if (sol[i][j]<0)System.out.print(sol[i][j]);
		// else System.out.print(" " + sol[i][j] );
		// }
		// System.out.println();
		// }

		// user interaction logic for game play

		boolean flag = true;

		int disp[][] = new int[x + 2][y + 2];
		
		
		
		for (int i1 = 1; i1 <= x+1; i1++) {
			for (int j1 = 1; j1 <= y+1; j1++) {
				
				if (j1 > y && i1 != j1)
					System.out.print(" :" + i1);
				else if (i1 > x && i1 != j1)
					System.out.print(j1 + " ");
				else if (i1 > x && j1 > y && i1 == j1)
					System.out.println(" ");
				 else System.out.print("■ ");
			}
			System.out.println();
		}
		
		
		

		
		while (flag) {
			int xx = 0;
			int yy = 0;

			// getting x and y coordinates from user

			Scanner in = new Scanner(System.in);
			System.out.println("Enter the block's X co-ordinate ");
			xx = in.nextInt();
			System.out.println("Enter the block's Y co-ordinate ");
			yy = in.nextInt();

			// display board as per users input

			for (int k = 0; k < 4; k++) {
				
				int i = xx;
				int j = yy;
				stop: while (i < 11 && i > 0) {
					
						
					while (j < 11 && j >0) {
						
						if((i>=1 && i<=10) && (j>=1 && j<=10)){
						if (bomb[i][j]) {
							disp[i][j] = -1;
							flag = false;
							break stop;

						} 
						else if (sol[i][j] > 0) {
							disp[i][j] = sol[i][j];
							//flag = false;
							if(j==yy)
							{ 
								break stop;
							}
							break;
							
						} else if (sol[i][j] == 0) {
							disp[i][j] = -2;
						}
						
					}
						if (k == 0 || k == 1 && (j<=10 && j>=1)) {
							j++;
						} else if (k == 2 || k == 3 && (j<=10 && j>=1)) {
							j--;
						}
					}
					j = yy;
					if (k == 0 || k == 3 && (i<=10 && i>=1)) {
						i++;
					} else if (k == 1 || k == 2 && (i<=10 && i>=1)) {
						i--;
					}
				}
				
/*				System.out.println("Value of K =" + k);
				for (int i1 = 1; i1 < disp.length - 1; i1++) {
					for (int j1 = 1; j1 < disp.length - 1; j1++) {
						if (disp[i1][j1] < 0)
							System.out.print("@" + " ");
						else
							System.out.print(disp[i1][j1] + " ");
					}
					System.out.println();
				}*/

			}

			// displaying disp[][]
			System.out.println("OUTPUT:");

			for (int i1 = 1; i1 <= x+1; i1++) {
				for (int j1 = 1; j1 <= y+1; j1++) {
					
					if (j1 > y && i1 != j1)
						System.out.print(" :" + i1);
					else if (i1 > x && i1 != j1)
						System.out.print(j1 + " ");
					else if (i1 > x && j1 > y && i1 == j1)
						System.out.println(" ");
					 else
					
					if (disp[i1][j1] == -1)
						System.out.print("@" + " ");
					else if (disp[i1][j1] >0)
						System.out.print(disp[i1][j1] + " ");
					else if (disp[i1][j1]== -2)
						System.out.print("□ ");
					else System.out.print("■ ");
				}
				System.out.println();
			}
			System.out.println("--------------------------------");

		}
		
		System.out.println("///////////GAME OVER///////////");
		// -----------
		System.out.println("--------------------------------");
		
		System.out.println();
		System.out.println("Solution Matrix");
		System.out.println();
		for (int i = 1; i <= (x + 1); i++) {
			for (int j = 1; j <= (y + 1); j++) {
				if (bomb[i][j])
					System.out.print("@ ");
				else if (j > y && i != j)
					System.out.print(" :" + i);
				else if (i > x && i != j)
					System.out.print(j + " ");
				else if (i > x && j > y && i == j)
					System.out.println(" ");
				else if (sol[i][j] == 0) {
					System.out.print(". ");
				} else
					System.out.print(sol[i][j] + " ");

			}
			System.out.println();

		}
		

	}

}

