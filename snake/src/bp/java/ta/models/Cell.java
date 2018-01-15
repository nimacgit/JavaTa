package bp.java.ta.models;

public abstract class Cell {
    String iconPath;
    public int posX, posY;
    Cell(int x, int y)
    {
        posX = x;
        posY = y;
    }
    public abstract String getIconPath();

}
