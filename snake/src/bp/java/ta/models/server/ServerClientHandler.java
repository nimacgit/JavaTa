package bp.java.ta.models.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;

public class ServerClientHandler implements Runnable {

    protected Socket socket;

    public ServerClientHandler(Socket clientSocket) {
        this.socket = clientSocket;
    }

    @Override
    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("cant run handeler inside");
            return;
        }
        System.out.println(socket.getInetAddress());
        String level;
//        ServerDataBase.readName();
        while (true) {
            try {
                level = brinp.readLine();
                if(level == null)
                    return;
                System.out.println(level);
                if (level.equals("-1")) {
                    socket.close();
                    return;
                } else if(level != null){
                    ServerDataBase.readLevel(out, Integer.valueOf(level));
                }

            } catch (IOException e) {
                System.out.println("Cant handle client");
                return;
            }
        }
    }
}
