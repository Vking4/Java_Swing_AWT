import java.awt.*;

public class q3simple{
    private Frame frame;
    private Label label;
    private TextField textField;

    public q3simple() {
        frame = new Frame("My Window");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 100);

        label = new Label("Enter your name:");
        frame.add(label);

        textField = new TextField(20);
        frame.add(textField);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        q3simple window = new q3simple();
    }
}

