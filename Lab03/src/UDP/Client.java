package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    private static int SERVER_PORT = 5000;
    private static int CLIENT_PORT = 5001;
    private static DatagramSocket socket;

    public static void main(String[] args) throws Exception {
        System.out.println("Connected to server on port " + SERVER_PORT);
        socket = new DatagramSocket(CLIENT_PORT);
        InetAddress serverAddress = InetAddress.getByName("localhost");
        Scanner scanner = new Scanner(System.in);

        //create a new thread to listen for incoming messages
        new Thread(() -> {
            while (true) {
                try {
                    byte[] buffer = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);

                    String message = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Server: " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //create a new thread to send the message
        new Thread(() -> {
            while (true) {
                String message = scanner.nextLine();
                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, SERVER_PORT);
                try {
                    socket.send(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
