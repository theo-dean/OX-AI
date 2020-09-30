package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private Server server;

    ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }


    @Override
    public void run() {
        System.out.println("Connected: " + socket);
        try {
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            while (in.hasNextLine()) {
                String input = in.nextLine();
                String[] parsed = input.split(" ");
                switch (parsed[0].toLowerCase()) {
                    case "solve": //Finds next best move for AI in the given state
                        System.out.println("SOLVE Request");    //Testing (delete me)
                        try {
                            int[] grid = Arrays.stream(parsed[1].split(""))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
                            //TODO Process grid, output resulting move
                            break;
                        } catch (Exception e) {
                            System.out.println("Reply Exception");
                            e.printStackTrace();
                        }
                }
            }
        } catch (Exception e) {
            System.out.println("Client Handler Exception:");
            e.printStackTrace();
        } finally {
            System.out.println("Client Disconnected");
        }
    }
}
