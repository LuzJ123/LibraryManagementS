import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PrimeClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a number to check if it's prime (type 'exit' to quit):");
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                out.println(input);
                String response = in.readLine();
                System.out.println("Response from server: " + response);
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
