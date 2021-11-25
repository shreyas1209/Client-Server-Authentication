import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener{

    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JTextField textField; 

    public GUI() {
        frame = new JFrame();
        textField = new JTextField("Enter Server IP address");
        textField.setBounds(20, 25, 200 ,30);

        JButton button = new JButton("Send Request");
        button.addActionListener(this);
        button.setBounds(2000, 500, 200, 30);

        label = new JLabel("Number of CLicks: 0"); 

        //panel = new JPanel();
        frame.add(textField);
        frame.add(button);
        frame.add(label);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Client Server Authentication");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        count++;
        label.setText("Number of CLicks: " +count);
    }
    
}
