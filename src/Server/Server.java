package Server;
import logic.Globals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class Server implements Runnable{


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
                while(Globals.qEmpty()) {TimeUnit.SECONDS.sleep(1);}
                System.out.printf("Sending to server \n");
                toServer.println(Globals.popQ());
                //Read line from server
                String line = fromServer.readLine();
                System.out.println("Response: "+line);
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
}
