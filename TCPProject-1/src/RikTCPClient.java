
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author nihar
 */
public class RikTCPClient {

    static Socket clientSocket;

    public static void main(String[] args) {
        try {
            /* Step -1 : Connection Establishment - Start*/
            clientSocket = new Socket(InetAddress.getLocalHost(), 2205);
            System.out.println("Client is Connected to server");
            /* Step -1 : Connection Establishment - End*/

            //read stream from server
            /*
            #Recommended way of using io stream: BufferedReader - has external buffer 
             and we can read more data and also read line by line.
            #BufferedReader is a charecter oriented stream, but socket is byte oriented stream,
             we need to use a InputStreamReader.
            #i.e, generally socket accepts byte oriented data,which we have to convert to charecter 
             oriented data for BufferReader, for which we have to use InputStreamReader(converts bytes to charc)
             */
            BufferedReader buffer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while (true) {
                String serverOutput = buffer.readLine();
                System.out.println("Client: Data from server\n" + serverOutput);
            }
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
        } finally {
            try {
                System.out.println(
                        "\n* Closing connection... *");
                clientSocket.close();					//Step 4.
            } catch (IOException ioEx) {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}
