package bp.java.ta.models.client;
import java.io.*;
import java.net.*;

public class Client {
    static final int PORT = 2020;
    public static DataOutputStream outToServer;
    public static BufferedReader inFromServer;
    public Client()
    {

        Socket clientSocket = null;
        try {
            clientSocket = new Socket("localhost", PORT);
        } catch (IOException e) {
            System.out.println("cant connet to server");
        }
        try {
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("cant send to server");
        }
        try {
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("cant recive from servver");
        }
        //outToServer.writeBytes("hi" + '\n');
        //System.out.println(inFromServer.readLine());
        //clientSocket.close();
    }
}
