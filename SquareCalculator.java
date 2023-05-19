import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SquareCalculator extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField textField;
    private JButton button;

    public SquareCalculator() {
        label = new JLabel("Enter a number:");
        textField = new JTextField(10);
        button = new JButton("Calculate");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        add(panel);
        setTitle("Square Calculator");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                int num = Integer.parseInt(textField.getText());
                int square = num * num;
                JOptionPane.showMessageDialog(this, "The square of the number you entered is: " + square);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        new SquareCalculator();
    }
}
