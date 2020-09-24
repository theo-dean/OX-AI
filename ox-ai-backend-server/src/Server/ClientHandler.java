package Server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    private final Socket socket;
    private Server server;

    ClientHandler(Socket socket, Server server){
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String input = scanner.nextLine();
                String[] parsed = input.split(" ");

                switch(parsed[0].toLowerCase()){
                    case "solve": //Finds next best move for AI in the given state
                        try {
                            int[] grid = Arrays.stream(parsed[1].split(""))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
                            System.out.println(grid);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
