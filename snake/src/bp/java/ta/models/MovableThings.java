package bp.java.ta.models;

public abstract class MovableThings extends Cell{
    public int dir;
    //0 up / 1 right / 2 down / 3 left
    public MovableThings next, prev;

    public MovableThings(int x, int y, int d)
    {
        super(x,y);
        next = null;
        prev = null;
        posX = x;
        posY = y;
        dir = d;
    }
    public void move()
    {
        switch (dir)
        {
            case 0:
                posY = (posY - 1 + World.MAXY)%World.MAXY;
                break;
            case 1:
                posX = (posX + 1)%World.MAXX;
                break;
            case 2:
                posY = (posY + 1)%World.MAXY;
                break;

            case 3:
                posX = (posX - 1 + World.MAXX)%World.MAXX;
                break;
        }
    }

    public static int getDirX(int d)
    {
        if(d == 1)
            return 1;
        if(d == 3)
            return -1;
        return 0;
    }
    public static int getDirY(int d)
    {
        if(d == 2)
            return 1;
        if(d == 0)
            return -1;
        return 0;
    }




}
