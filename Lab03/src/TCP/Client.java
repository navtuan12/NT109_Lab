package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args)
            throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
       
        InetAddress host = InetAddress.getLocalHost();
        Socket client = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        int port = 1234;
        for (int i = 0; i < 5; i++) {
          
            client = new Socket(host.getHostName(), port);

            // write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(client.getOutputStream());
            System.out.println("Sending request to Socket Server"); 

            if (i == 4) oos.writeObject("exit");
            else oos.writeObject("" + i);

            // read the server response message
            ois = new ObjectInputStream(client.getInputStream());
            String message = (String) ois.readObject();
            System.out.println(message);

            // close resources
            ois.close();
            oos.close();
            Thread.sleep(100);
        }
    }
}
