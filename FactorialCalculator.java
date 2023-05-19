import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FactorialCalculator extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField textField;
    private JButton button;

    public FactorialCalculator() {
        label = new JLabel("Enter a number:");
        textField = new JTextField(10);
        button = new JButton("Calculate");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        add(panel);
        setTitle("Factorial Calculator");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            int number = Integer.parseInt(textField.getText());
            int factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            JOptionPane.showMessageDialog(this, "The factorial of the number you entered is: " + factorial);
        }
    }

    public static void main(String[] args) {
        new FactorialCalculator();
    }
}
