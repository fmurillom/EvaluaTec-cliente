package Server;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Stack;

public class Server implements Runnable{
    static final int QueueSize = 6;
    private Stack<String> messages = new Stack<>();

    /**
     * Function to run the server, in charge of all interchange between server and
     * client
     */
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
            while(true){
                if(messages.empty()) this.wait();
                toServer.println(messages.pop());
                String line = fromServer.readLine();
                //Aqui van los if de lo que retorne el servidor
            }

        }
        catch(UnknownHostException ex) {
            ex.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds new parameters to the stack
     * @param toAdd parameter to be added
     */
    public void addQueue(String toAdd){
        notify();
        messages.push(toAdd);
    }
}
