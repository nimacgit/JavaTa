package bp.java.ta.models;

public class World {
    public final static int MAXY = 50;
    public final static int MAXX = 50;
    public final static Cell[][] world = new Cell[MAXY][MAXX];
    private static World instance;
    public static int level = 1;

    private World()
    {
        for(int i = 0; i < MAXY; i++)
            for(int j = 0; j < MAXY; j++)
                world[i][j] = new Blank(j, i);
    }
    public static World getInstance()
    {
        if(instance == null)
            instance = new World();
        return instance;
    }


}
