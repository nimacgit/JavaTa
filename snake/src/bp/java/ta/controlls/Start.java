package bp.java.ta.controlls;


import bp.java.ta.models.Snake;
import bp.java.ta.models.World;
import bp.java.ta.views.GameFrame;

import java.io.IOException;


public class Start {
    public static GameFrame gameFrame;
    public static Snake snake;
    public static Thread t;

    public static void Start()
    {
        World.getInstance();
        gameFrame = new GameFrame();
        try {
            DataBase.readLevelServer(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        snake = new Snake(20,20,19,20, 1);
        t = new Thread(new Continiu());
        t.start();
    }
}
