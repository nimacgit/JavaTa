package bp.java.ta.models.server;


import bp.java.ta.models.Apple;
import bp.java.ta.models.World;
import bp.java.ta.controlls.Start;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ServerDataBase {
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
            System.out.println("cant close namefile");
        }
    }
    public static void readLevel(DataOutputStream out, int l)
    {

        try {
            inputLevel = new FileReader(dataStorage + LEVEL_FILE_NAME + Integer.toString(l));
        } catch (FileNotFoundException e) {
            System.out.println("cant open Level");
        }
        Scanner inp = new Scanner(inputLevel);
        for(;inp.hasNext();)
        {
            String s = inp.next();
            try {
                System.out.println(s);
                out.writeBytes(s + "\n");
            } catch (IOException e) {
                System.out.println("cant send to client");
            }
            try {
                out.flush();
            } catch (IOException e) {
                System.out.println("cant flush");
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
            System.out.println("cant close Levels");
        }
    }


}
