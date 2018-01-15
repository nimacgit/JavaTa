package bp.java.ta.models;

import bp.java.ta.controlls.NewLevel;
import bp.java.ta.controlls.Start;

import java.util.ArrayList;

public class Snake {
    public Head head;
    public Tail tail;
    public ArrayList<Body> bodies;
    public static int eated;

    public Snake(int headX, int headY, int tailX, int tailY, int dir)
    {
        head = new Head(headX, headY, dir);
        tail = new Tail(tailX, tailY, dir);
        tail.next = head;
        head.prev = tail;
        bodies = new ArrayList<Body>();
        World.getInstance().world[headY][headX] = head;
        World.getInstance().world[tailY][tailX] = tail;
        Start.gameFrame.updateCell(headX, headY);
        Start.gameFrame.updateCell(tailX, tailY);
    }
    public void grow()
    {
        eated++;
        if(eated == World.getInstance().level)
        {
            World.getInstance().level++;
            eated = 0;
            Thread t = new Thread(new NewLevel());
            t.start();
            try {
                Start.t.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            Body body = new Body(head.posX, head.posY, head.dir);
            World.getInstance().world[head.posY][head.posX] = body;
            Start.gameFrame.updateCell(head.posX, head.posY);
            head.move();
            World.getInstance().world[head.posY][head.posX] = head;
            Start.gameFrame.updateCell(head.posX, head.posY);
            bodies.add(body);
            body.next = head;
            body.prev = head.prev;
            head.prev.next = body;
            head.prev = body;
        }
    }
}
