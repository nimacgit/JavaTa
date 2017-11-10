package Chess;

import java.util.Scanner;
import static java.lang.System.out;
import Chess.*;


public class Mvc{

	public static class Pair
	{
		public int left;
		public int right;
		public Pair(int left, int right) 
		{
			this.left = left;
			this.right = right;
		}
	}


	public class Models
	{

		public Piece[][] Board = new Piece[8][8];
		//winner is if the game finish or not: 0 = not finish , 1 = white won , 2 = black won
		public int winner = 0;
		//turn = who should go . false = white , true = black
		public boolean Turn = false;
		//is kish show if any one is kish or not
		public boolean[] IsKish = new boolean[2];


		public void Models()
		{
			IsKish[0] = IsKish[1] = false;
			Board[0][0] = new Rokh(false, 0, 0);
			Board[0][1] = new Asb(false,0, 1);
			Board[0][2] = new Fil(false,0, 2);
			Board[0][3] = new Vaz(false,0, 3);
			Board[0][4] = new Queen(false,0, 4);
			Board[0][5] = new Fil(false,0, 5);
			Board[0][6] = new Asb(false,0, 6);
			Board[0][7] = new Rokh(false,0, 7);
			for(int i = 0; i < 8; i++)
				Board[0][i] = new Sold(false,0, i);

			Board[7][0] = new Rokh(true, 7, 0);
			Board[7][1] = new Asb(true,7, 1);
			Board[7][2] = new Fil(true,7, 2);
			Board[7][3] = new Vaz(true,7, 3);
			Board[7][4] = new Queen(true,7, 4);
			Board[7][5] = new Fil(true,7, 5);
			Board[7][6] = new Asb(true,7, 6);
			Board[7][7] = new Rokh(true,7, 7);
			for(int i = 0; i < 8; i++)
				Board[7][i] = new Sold(true,7, i);
		}
	}

	public static void main(String[] args)
	{
		Scanner inp = new Scanner(System.in);

	}

}
