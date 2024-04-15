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
        int port = 1234;
        Socket client = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        for (int i = 0; i < 5; i++) {
            client = new Socket(host.getHostName(), port);
            // write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(client.getOutputStream());
            System.out.println("Send request to Socket Server");
            if (i == 4)
                oos.writeObject("exit");
            else
                oos.writeObject("" + i);

            // read the server response message
            ois = new ObjectInputStream(client.getInputStream());
            String message = (String) ois.readObject();
            System.out.println(message);
            oos.close();
            ois.close();
            Thread.sleep(100);
        }
        client.close();
    }
}
