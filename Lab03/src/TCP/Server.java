package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private ServerSocket server;

    public Server(int port) throws IOException {
        server = new ServerSocket(port);
        //server.setSoTimeout(10000);
    }

    public void run(){
        while (true) {
           try{
            System.out.println("Waiting for the client request ...");
            Socket socket = server.accept();
            ObjectInputStream objI = new ObjectInputStream(socket.getInputStream());
            String message = (String) objI.readObject();
            System.out.println("ClientToServer: "+ message);
            ObjectOutputStream objO = new ObjectOutputStream(socket.getOutputStream());

            // write object to Socket
            objO.writeObject("ServerToClient: "+ message);
            
            // close resources
            objI.close();
            objO.close();
            socket.close();

            // terminate the server if client sends exit request
            if (message.equalsIgnoreCase("exit")){
                System.out.println("Shutting down Socket server!!");
                server.close();
                break;
            }
           } catch (IOException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
        }
    }

    public static void main(String args[]) throws IOException {
        int port = 1234;
        try{
            Thread t = new Server(port);
            t.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
