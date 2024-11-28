import java.io.*;
import java.net.*;
git add .
git commit -m "Initial commit with all project files"


public class PrimeServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started and listening on port 5000.");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String numberStr;
                while ((numberStr = in.readLine()) != null) {
                    int number = Integer.parseInt(numberStr);
                    boolean isPrime = checkPrime(number);
                    String response = isPrime ? "The number is a prime number." : "The number is NOT a prime number.";
                    out.println(response);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
