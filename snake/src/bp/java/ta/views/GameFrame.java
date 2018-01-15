package bp.java.ta.views;

import bp.java.ta.controlls.Start;
import bp.java.ta.models.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements KeyListener {
    static JLabel[][] label = new JLabel[World.MAXY][World.MAXX];


    public GameFrame() {
        super("NiSnake");
        setLayout(new FlowLayout());
        for(int i = 0; i < World.MAXY; i++)
            for(int j = 0; j < World.MAXX; j++) {
                label[i][j] = new JLabel(new ImageIcon(getClass().getResource(World.getInstance().world[i][j].getIconPath())), SwingConstants.CENTER);
                add(label[i][j]);
            }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 1300);
        setVisible(true);
        addKeyListener(this);
    }
    public void updateCell(int x, int y)
    {
        label[y][x].setIcon(new ImageIcon(getClass().getResource( World.getInstance().world[y][x].getIconPath())));
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println(String.format("Key pressed: %s", KeyEvent.getKeyText(e.getKeyCode())));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String key = KeyEvent.getKeyText(e.getKeyCode());
        if(key.equals("Up"))
        {
            Start.snake.head.dir = 0;
        }
        else if(key.equals("Down"))
        {
            Start.snake.head.dir = 2;
        }
        else if(key.equals("Right"))
        {
            Start.snake.head.dir = 1;
        }
        else if(key.equals("Left"))
        {
            Start.snake.head.dir = 3;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
