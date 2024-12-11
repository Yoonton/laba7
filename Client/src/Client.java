import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Client extends JFrame{
    private JTextField fieldX, fieldY;
    private JButton sendButton;
    private Socket clientSocket = null;
    private ObjectOutputStream out = null;
    private BufferedReader in = null;
    private Matrix m = null;
    private JLabel labelX, labelY, answerLabel, matrixLabel, headerLabel;

    public Client() {
        super("Laba7 Client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        headerLabel = new JLabel("Клиент", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(headerLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        labelX = new JLabel("Введите X:");
        labelY = new JLabel("Введите Y:");
        fieldX = new JTextField(10);
        fieldX.setToolTipText("Введите количество строк");
        fieldY = new JTextField(10);
        fieldY.setToolTipText("Введите количество столбцов");
        sendButton = new JButton("Отправить");

        matrixLabel = new JLabel("", JLabel.CENTER);
        matrixLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
        matrixLabel.setForeground(Color.BLUE);

        answerLabel = new JLabel("Полученный ответ: ", JLabel.CENTER);
        answerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        answerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(labelX, gbc);

        gbc.gridx = 1;
        inputPanel.add(fieldX, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(labelY, gbc);

        gbc.gridx = 1;
        inputPanel.add(fieldY, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        inputPanel.add(sendButton, gbc);

        add(inputPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.add(matrixLabel, BorderLayout.NORTH);
        footerPanel.add(answerLabel, BorderLayout.SOUTH);
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(footerPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tryIntParse(fieldX.getText()) <= 0 || tryIntParse(fieldY.getText()) <= 0) {
                        fieldX.setText("");
                        fieldY.setText("");
                        matrixLabel.setText("Введены неверные значения");
                    } else {
                        m = new Matrix(tryIntParse(fieldX.getText()), tryIntParse(fieldY.getText()));
                        matrixLabel.setText(m.toString());
                        send(m);
                    }
                } catch (Exception exception) {
                    System.err.println(exception);
                }
            }
        });

        setSize(600, 400);
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
