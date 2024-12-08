import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Client extends JFrame{
    JTextField fieldX, fieldY;

    public Client(){
        super("Laba7 Client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        fieldX = new JTextField(5);
        fieldX.setToolTipText("Введите количество строк");
        fieldY = new JTextField(5);
        fieldY.setToolTipText("Введите количество столбцов");
        
        JPanel panel = new JPanel();
        panel.add(fieldX);
        panel.add(fieldY);
        setSize(400, 300);
        setContentPane(panel);
        setVisible(true);
    }
    public static void main(String[] args){
        new Client();
        // Socket clientSocket = null;
        // ObjectOutputStream out = null;
        // BufferedReader in = null;
        // Matrix m = new Matrix(4, 4);
        // try{
        //     clientSocket = new Socket("localhost", 4000);
        //     out = new ObjectOutputStream(clientSocket.getOutputStream());
        //     in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //     out.writeObject(m);

        //     String odd = in.readLine();
        //     System.out.println(odd);
        // }
        // catch(IOException e){
        //     System.err.println(e);
        //     System.exit(1);
        // }
        // finally{
        //     clientSocket.close();
        //     out.close();
        //     in.close();
        // }
    }

    
}
