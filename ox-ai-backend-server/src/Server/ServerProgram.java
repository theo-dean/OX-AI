package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProgram {

    private static final int port = 8888;

    public static void main(String[] args){
        runServer();
    }


    private static void runServer() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for Client...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected");
                new Thread(new ClientHandler(socket, new Server())).start();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
