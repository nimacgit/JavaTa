package bp.java.ta.controlls;

import bp.java.ta.models.Blank;
import bp.java.ta.models.Snake;
import bp.java.ta.models.World;

import java.io.IOException;
import java.util.logging.Level;

public class NewLevel implements Runnable {
    @Override
    public void run() {

        int x,y;
        for(int i = 0; i < Start.snake.bodies.size(); i++)
        {
            x = Start.snake.bodies.get(i).posX;
            y = Start.snake.bodies.get(i).posY;
            World.getInstance().world[y][x] = new Blank(x, y);
            Start.gameFrame.updateCell(x,y);
        }

        x = Start.snake.head.posX;
        y = Start.snake.head.posY;
        World.getInstance().world[y][x] = new Blank(x, y);
        Start.gameFrame.updateCell(x,y);

        x = Start.snake.tail.posX;
        y = Start.snake.tail.posY;
        World.getInstance().world[y][x] = new Blank(x, y);
        Start.gameFrame.updateCell(x,y);
        try {
            DataBase.readLevelServer(World.getInstance().level);
        } catch (IOException e) {
            System.out.println("cant load level");
        }
        Start.snake = new Snake(20,20,19,20, 1);
        //DataBase.readLevel(World.getInstance().level);

    }
}
