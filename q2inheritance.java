import java.awt.*;
import java.awt.event.*;

public class q2inheritance extends Frame implements ActionListener {
    TextField textField1, textField2;
    Button button;

    public q2inheritance() {
        super("My Window");
        setLayout(new FlowLayout());
        setSize(300, 150);

        Label label1 = new Label("Text Field 1:");
        add(label1);

        textField1 = new TextField(20);
        add(textField1);

        Label label2 = new Label("Text Field 2:");
        add(label2);

        textField2 = new TextField(20);
        add(textField2);

        button = new Button("Click Me");
        add(button);
        button.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String text1 = textField1.getText();
            String text2 = textField2.getText();
            System.out.println("Text Field 1: " + text1);
            System.out.println("Text Field 2: " + text2);
        }
    }

    public static void main(String[] args) {
        q2inheritance window = new q2inheritance();
    }
}
