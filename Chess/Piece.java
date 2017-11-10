package Chess;

public class Piece{
	public int x = -1, y = -1;
	public boolean isdead = false;
	public boolean color = false;
	//false mean white;
	protected String name = "";
	

	public Piece(boolean col, int x, int y, String name)
	{
		this.color = col;
		this.x = x;
		this.y = y;
		this.name = name;
	}
}
