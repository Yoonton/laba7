import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelServer {
    public static void main(String[] args) throws Exception {
        ParallelServer server = new ParallelServer();
        server.ruuuuuuuuuuuuuuun();
    }

    public static void calculator(Socket socket) {

    }

    public void ruuuuuuuuuuuuuuun() throws IOException {
        ObjectInputStream in = null;
        PrintWriter out = null;
        ExecutorService pool = Executors.newFixedThreadPool(20);
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(4000)) {
                try (Socket clientSocket = serverSocket.accept()) {
                    in = new ObjectInputStream(clientSocket.getInputStream());
                    out = new PrintWriter(clientSocket.getOutputStream(), true);

                    pool.execute(() -> calculator(clientSocket));

                    Matrix m = (Matrix) in.readObject();

                    out.println(Matrix.getOddSum(m));
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println(e.toString());
                } finally {
                    in.close();
                    out.close();

                }

            }
        }
    }
}
