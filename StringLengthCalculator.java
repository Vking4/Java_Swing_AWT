import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StringLengthCalculator extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField textField;
    private JButton button;

    public StringLengthCalculator() {
        label = new JLabel("Enter a string:");
        textField = new JTextField(10);
        button = new JButton("Calculate");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        add(panel);
        setTitle("String Length Calculator");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String text = textField.getText();
            int length = text.length();
            JOptionPane.showMessageDialog(this, "The length of the string you entered is: " + length);
        }
    }

    public static void main(String[] args) {
        new StringLengthCalculator();
    }
}
