package bp.java.ta.controlls;


import bp.java.ta.Main;
import bp.java.ta.models.Apple;
import bp.java.ta.models.World;
import bp.java.ta.models.client.Client;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class DataBase {
    final static String dataStorage = "src/bp/java/ta/db/";
    static FileReader inputName;
    static FileReader inputLevel;
    static FileWriter outputName;
    static FileWriter outputLevel;
    final static String statusFileName = "status";
    final static String LEVEL_FILE_NAME = "level";

    public static String readName() {
        try {
            inputName = new FileReader(dataStorage + statusFileName);
        } catch (FileNotFoundException e) {
            return "";
        }
        try {
            return new BufferedReader(inputName).readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public static void writeName(String name) {
        try {
            outputName = new FileWriter(dataStorage + statusFileName);
        }
        catch (IOException e) {
            try {
                Files.createFile(Paths.get(dataStorage + statusFileName));
                outputName = new FileWriter(dataStorage + statusFileName);
            } catch (IOException e1) {
                System.out.println("WTF?");
            }
        }
        try {
            outputName.write(name);
            outputName.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("cant close namefile");
        }
    }
    public static void readLevel(int l)
    {
        boolean[][] world = new boolean[World.getInstance().MAXY][World.getInstance().MAXX];
        try {
            inputLevel = new FileReader(dataStorage + LEVEL_FILE_NAME + Integer.toString(l));
        } catch (FileNotFoundException e) {
            System.out.println("cant open Level");
        }
        Scanner inp = new Scanner(inputLevel);
        int j = 0;
        for(;inp.hasNext();)
        {
            String s = inp.next();
            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i) == '1') {
                    World.getInstance().world[j][i] = new Apple(i, j);
                    System.out.println(i+ " " +j);
                    Start.gameFrame.updateCell(i, j);
                }
            }
            j++;
        }
    }

    public static void readLevelServer(int l) throws IOException {
        try {
            Main.client.outToServer.writeBytes(Integer.toString(l)+"\n");
        } catch (FileNotFoundException e) {
            System.out.println("cant open Level");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int j = 0; j < World.MAXY; j++)
        {
            String s = Main.client.inFromServer.readLine();
            System.out.println(s);
            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i) == '1') {
                    World.getInstance().world[j][i] = new Apple(i, j);
                    System.out.println(i+ " " +j);
                    Start.gameFrame.updateCell(i, j);
                }
            }
        }
    }

    public static void writeLevel() {
        try {
            outputName = new FileWriter(dataStorage + LEVEL_FILE_NAME + "1");
        }
        catch (IOException e) {
                System.out.println("cant write level");
        }
        try {
            for(int i = 0; i < World.getInstance().MAXY; i++)
            {
                for(int j = 0; j < World.getInstance().MAXX; j++)
                {
                    outputName.write("0");
                }
                outputName.write('\n');
            }
            outputName.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("cant close Levels");
        }
    }


}
