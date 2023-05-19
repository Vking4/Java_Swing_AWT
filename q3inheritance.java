import java.awt.*;

public class q3inheritance extends Frame {
    private Label label;
    private TextField textField;

    public q3inheritance() {
        super("My Window");
        setLayout(new FlowLayout());
        setSize(300, 100);

        label = new Label("Enter your name:");
        add(label);

        textField = new TextField(20);
        add(textField);

        setVisible(true);
    }

    public static void main(String[] args) {
        q3inheritance window = new q3inheritance();
    }
}
