package Server;
import java.io.*;
import java.net.*;

public class Sender{

    public static void sendFile(int port, String filePath, String ip) throws IOException
    {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        ServerSocket servsock = null;
        Socket sock = null;
        try {
            //servsock = new ServerSocket(SOCKET_PORT);
            while (true) {
                System.out.println("Waiting...");
                try {
                    sock = new Socket(ip, port);
                    System.out.println("Accepted connection : " + sock);
                    // send file
                    File myFile = new File (filePath);
                    byte [] mybytearray  = new byte [(int)myFile.length()];
                    fis = new FileInputStream(myFile);
                    bis = new BufferedInputStream(fis);
                    bis.read(mybytearray,0,mybytearray.length);
                    os = sock.getOutputStream();
                    System.out.println("Sending " + filePath + "(" + mybytearray.length + " bytes)");
                    os.write(mybytearray,0,mybytearray.length);
                    os.flush();
                    System.out.println("Done.");
                    break;
                }
                finally {
                    if (bis != null) bis.close();
                    if (os != null) os.close();
                    if (sock!=null) sock.close();
                }
            }
        }
        finally {
            if (servsock != null) servsock.close();
        }
    }

    public static void main(String[] args) throws IOException {
        sendFile(8080, "Cursos.xml", "localhost");
    }
}
