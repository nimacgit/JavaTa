import java.util.Scanner;
import static java.lang.System.out;


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

		//01234567
		//01234567
		//........
		//........
		//........
		//........
		//01234567
		//01234567
		// pos[0][i] = pos[1][i] = Black , pos[2][i] = pos[3][i] = White
		// who is show which thing is on that place
		public Pair[][] WhoIs = new Pair[8][8];
		//winner is if the game finish or not: 0 = not finish , 1 = white won , 2 = black won
		public int winner = 0;
		//turn = who should go . false = white , true = black
		public boolean Turn = false;
		//is kish show if any one is kish or not
		public boolean[] IsKish = new boolean[2];

		//01234567
		//01234567
		//........
		//........
		//........
		//........
		//01234567
		//01234567
		// pos[0][i] = pos[1][i] = Black , pos[2][i] = pos[3][i] = White
		public void Models()
		{
			IsKish[0] = IsKish[1] = false;
			for(int i = 0; i < 8; i++)
			{
				WhoIs[0][i] = new Pair(0, i);
				WhoIs[1][i] = new Pair(1, i);
				WhoIs[2][i] = new Pair(-1, -1);
				WhoIs[3][i] = new Pair(-1, -1);
				WhoIs[4][i] = new Pair(-1, -1);
				WhoIs[5][i] = new Pair(-1, -1);
				WhoIs[6][i] = new Pair(2, i);
				WhoIs[7][i] = new Pair(3, i);
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner inp = new Scanner(System.in);

	}

}
