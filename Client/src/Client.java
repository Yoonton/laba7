import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Client extends JFrame{
    private JTextField fieldX, fieldY;
    private JButton sendButton;
    private Socket clientSocket = null;
    private ObjectOutputStream out = null;
    private BufferedReader in = null;
    private Matrix m = null;
    private JLabel labelX, labelY, answerLabel, errorLabel, matrixLabel;

    public Client(){
        super("Laba7 Client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelX = new JLabel("Введите X");
        labelY = new JLabel("Введите Y");
        answerLabel = new JLabel("Полученный ответ: ");
        errorLabel = new JLabel("");
        matrixLabel = new JLabel("");
        sendButton = new JButton("Отправить");
        fieldX = new JTextField(5);
        fieldX.setToolTipText("Введите количество строк");
        fieldY = new JTextField(5);
        fieldY.setToolTipText("Введите количество столбцов");

        sendButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    if(tryIntParse(fieldX.getText()) <= 0 || tryIntParse(fieldY.getText()) <= 0){
                        fieldX.setText("");
                        fieldY.setText("");
                        errorLabel.setText("<html> <font color='red'>Введены неверное значения</font></html>");
                    }
                    else{
                        errorLabel.setText("");
                        m = new Matrix(tryIntParse(fieldX.getText()), tryIntParse(fieldY.getText()));
                        matrixLabel.setText(m.toString());
                        send(m);
                    }
                }
                catch(Exception exception){

                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(labelX);
        panel.add(fieldX);
        panel.add(labelY);
        panel.add(fieldY);
        panel.add(sendButton);
        panel.add(errorLabel);
        panel.add(matrixLabel);
        panel.add(answerLabel);
        setSize(800, 600);
        setContentPane(panel);
        setVisible(true);
    }
    public static void main(String[] args) throws IOException{
        new Client();
        
        
    }    
    public int tryIntParse(String value){
        try{
            return Integer.parseInt(value);
        }
        catch(NumberFormatException e){
            return -1;
        }
    }
    public void send(Matrix mat) throws IOException{
        try{
            clientSocket = new Socket("localhost", 4000);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.writeObject(mat);

            String odd = in.readLine();
            System.out.println(odd);
            answerLabel.setText("Полученный ответ: " + odd);
        }
        catch(IOException exception){
            System.err.println(exception);
            System.exit(1);
        }
        finally{
            clientSocket.close();
            out.close();
            in.close();
        }
    }
    
}
