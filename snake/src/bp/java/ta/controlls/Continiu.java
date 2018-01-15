package bp.java.ta.controlls;

import bp.java.ta.models.*;

public class Continiu implements Runnable {
    public Continiu() {

    }

    @Override
    public void run() {
        boolean isLevel = false;
        while (true) {
            int oldposx = Start.snake.head.posX , oldposy = Start.snake.head.posY;
            int x = (Start.snake.head.posX + MovableThings.getDirX(Start.snake.head.dir) + World.getInstance().MAXX)%World.getInstance().MAXX
                    , y = (Start.snake.head.posY + MovableThings.getDirY(Start.snake.head.dir)+ World.MAXY)%World.MAXY;
            Cell nextCell = World.getInstance().world[y][x];
            if (nextCell instanceof Apple) {
                World.getInstance().world[y][x] = new Blank(x, y);
                Start.gameFrame.updateCell(x,y);
                Start.snake.grow();
            } else if (nextCell instanceof Body || nextCell instanceof Tail) {
                return;
            } else {
                Start.snake.head.move();
                MovableThings mv = Start.snake.tail;
                World.getInstance().world[mv.posY][mv.posX] = new Blank(x, y);
                Start.gameFrame.updateCell(mv.posX, mv.posY);

                for (; mv.next != null; mv = mv.next) {
                    mv.move();
                    mv.dir = mv.next.dir;
                    World.getInstance().world[mv.posY][mv.posX] = mv;
                    Start.gameFrame.updateCell(mv.posX, mv.posY);
                }
                World.getInstance().world[Start.snake.head.posY][Start.snake.head.posX] = Start.snake.head;
                Start.gameFrame.updateCell(Start.snake.head.posX, Start.snake.head.posY);
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
