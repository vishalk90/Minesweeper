package com.games.minesweeper;

import java.util.Scanner;

public class Minesweeper {


	
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		double  z = 0.1;
		
		boolean [][] bomb = new boolean[x+2][y+2];

		
		for(int i=1; i<=x; i++)
		{
			for (int j = 1; j <= y; j++) {
				bomb[i][j] = Math.random() < z; 
			}
		}

/*	char disp [][] = new char[x+2][y+2];
 		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				if(bomb[i][j]) disp[i][j] = '*';
				else disp[i][j] = '0';
			}
		}*/
 		
 		for (int i = 1; i <= (x); i++) {
			for (int j = 1; j <= (y); j++) {
				if(bomb[i][j]) System.out.print("@ ");
				else System.out.print(". ");
			}
			System.out.println(	);
		
 		}
 	int sol[][] = new int[x+2][y+2];
		for (int i = 1; i <= (x); i++) {
			for (int j = 1; j <= (y); j++) {
				if(bomb[i][j]) sol[i][j]=-9; // marking all the bombs as - integer
				for(int ii = i-1; ii <=i+1; ii++){
					for (int jj = j-1; jj <= j+1; jj++) {
						if(bomb[ii][jj] ) sol[i][j]++;
					}
				}
			}
			
		}
		System.out.println();
 		for (int i = 1; i <= (x+1); i++) {
			for (int j = 1; j <= (y+1); j++) {
				if(bomb[i][j])System.out.print("@ ");
				else if(j>y && i!=j) System.out.print(" :"+i);
				else if(i>x && i!=j) System.out.print(j+" ");
				else if(i>x && j>y && i==j) System.out.println(" ");
				else if(sol[i][j] == 0 ){System.out.print(". "); }
				else System.out.print(sol[i][j]+" ");
				
			}
			System.out.println(	);
		
 		}
 		// displaying sol[][]
 		for (int i = 1; i < sol.length-1; i++) {
			for (int j = 1; j < sol.length-1; j++) {
				if (sol[i][j]<0)System.out.print(sol[i][j]);
				else System.out.print(" " + sol[i][j] );
			}
			System.out.println();
		}
 		
 		/*
 		boolean flag = true;
 		int xx;
 		int yy;
 	 	int disp[][] = new int[x+2][y+2];
 		while(flag)
 		{
 			// getting x and y coordinates from user
 	 		Scanner in = new Scanner(System.in);
 	 		System.out.println("Enter the block's X co-ordinate ");
 	 		xx = in.nextInt();
 	 		System.out.println("Enter the block's Y co-ordinate ");
 	 		yy = in.nextInt();
 	 		
 	 		// display board as per users input
 	 		
 	 		for(int k =0; k<4; k++)
 	 		{
 	 			int i=xx+1;
 	 			stop: while(i<11)
 	 			{
 	 				int j = yy+1;
 	 				while(j<11)
 	 				{
 	 					if(sol[i][j]=='@')
 	 					{
 	 						
 	 					}
 	 				}
 	 			}
 	 		}
 	 		
 		}
 	
 		
 		
 		*/
 		
 		
	}

}
