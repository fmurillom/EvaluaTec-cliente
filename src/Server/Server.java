package Server;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;

public class Server implements Runnable{
    static final int QueueSize = 6;
    private Queue<String> messages = new LinkedList<>();
    public void run() {
        try {

            int serverPort = 1235;
            InetAddress host = InetAddress.getByName("localhost");

            Socket socket = new Socket(host,serverPort);

            System.out.println("Connection to the server has been established");
            PrintWriter toServer =
                    new PrintWriter(socket.getOutputStream(),true);
            BufferedReader fromServer =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            toServer.println("Conexion");
            String line = fromServer.readLine();
            while(!line.contentEquals("--0--")){

            }
            System.out.println("Server shutting Down");
            toServer.close();
            fromServer.close();
            socket.close();
        }
        catch(UnknownHostException ex) {
            ex.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
