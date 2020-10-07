import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
}

class Client {
    private static final int port = 8888;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", port);
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("solve 010200112");
            System.out.println(scanner.nextLine());
            System.out.println("DONE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}