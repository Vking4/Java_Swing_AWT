import java.awt.*;
import java.awt.event.*;

public class q2simple {
    private Frame frame;
    private TextField textField1, textField2;
    private Button button;

    public q2simple() {
        frame = new Frame("My Window");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 150);

        Label label1 = new Label("Text Field 1:");
        frame.add(label1);

        textField1 = new TextField(20);
        frame.add(textField1);

        Label label2 = new Label("Text Field 2:");
        frame.add(label2);

        textField2 = new TextField(20);
        frame.add(textField2);

        button = new Button("Click Me");
        frame.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text1 = textField1.getText();
                String text2 = textField2.getText();
                System.out.println("Text Field 1: " + text1);
                System.out.println("Text Field 2: " + text2);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        q2inheritance window = new q2inheritance();
    }
}
