package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {
    private static DatagramSocket socket;
    private static int PORT = 5000;
    public static InetAddress address;
    public static int port;

    public static void main(String[] args) throws IOException {
        socket = new DatagramSocket(PORT);
        System.out.println("Server started on port " + PORT);
        Scanner scanner = new Scanner(System.in);
        
        //create a new thread to listen for incoming messages
        new Thread(() -> {
            while(true){
                try {
                    byte[] buffer = new byte[1024];
                    DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
                    socket.receive(incoming);

                    // bind client address and port
                    address = incoming.getAddress();
                    port = incoming.getPort();
                    
                    // print the message
                    String message = new String(incoming.getData(), 0, incoming.getLength());
                    System.out.println("Client: " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //create a new thread to send the message
        new Thread(() -> {
            while(true){
                String message = scanner.nextLine();

                byte[] buffer = message.getBytes();
                if(address != null && port != 0){
                    DatagramPacket packet = new DatagramPacket(buffer,buffer.length,address,port);
                    try{
                        socket.send(packet);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                } else continue;
            }
        }).start();
    }
}
