import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)throws IOException{
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        ObjectInputStream in = null;
        PrintWriter out = null;
        try{
            serverSocket = new ServerSocket(4000);
            clientSocket = serverSocket.accept();
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            Matrix m = (Matrix)in.readObject();

            out.println(MatrixOddSum.getOddSum(m));
        }
        catch(IOException e){
            System.err.println(e.toString());
        }
        catch(ClassNotFoundException e){
            System.err.println(e);
        }
        finally{
            serverSocket.close();
            clientSocket.close();
            in.close();
            out.close();
        }
    }
}
