package bp.java.ta;

import bp.java.ta.controlls.Greeting;
import bp.java.ta.controlls.Start;
import bp.java.ta.models.client.Client;


public class Main {
    public static Client client;

    public static void main(String[] args) {
        client = new Client();
        Greeting.GetName();
        Start.Start();



    }
}
