
import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author nihar
 */
public class RikTCPServer {

    static Socket connection;

    public static void main(String[] args) {

        try {
            /* Step -1 : Connection Establishment*/
            ServerSocket serverSocket = new ServerSocket(2205);
            System.out.println("Waiting for Client");
            connection = serverSocket.accept();
            System.out.println("Server Connected to Client");
            /* Step -1 : Connection Establishment - End*/
            //Send data from server to client
            Scanner scanner = new Scanner(System.in);
            //Open Stream from Socket
            PrintWriter pw = new PrintWriter(connection.getOutputStream()); //To write data to Socket

            while (true) {
                System.out.println("Input Data");
                String userInput = scanner.nextLine();
                pw.println("Sent from Server : " + userInput);
                pw.flush();
            }
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
        } finally {
            try {
                System.out.println(
                        "\n* Closing connection... *");
                connection.close();				    //Step 5.
            } catch (IOException ioEx) {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }

}
