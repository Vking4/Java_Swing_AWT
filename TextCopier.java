import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextCopier extends JFrame implements ActionListener {
    private JTextField textField1;
    private JTextField textField2;
    private JButton button;

    public TextCopier() {
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        button = new JButton("Copy");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(textField1);
        panel.add(button);
        panel.add(textField2);

        add(panel);
        setTitle("Text Copier");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String text = textField1.getText();
            textField2.setText(text);
        }
    }

    public static void main(String[] args) {
        new TextCopier();
    }
}
