import java.awt.*;

public class q4inheritance extends Frame {
    private Label label;
    private Choice choice;

    public q4inheritance() {
        super("My Window");
        setLayout(new FlowLayout());
        setSize(300, 100);

        label = new Label("Choose your favorite programming language:");
        add(label);

        choice = new Choice();
        choice.add("Java");
        choice.add("Python");
        choice.add("C#");
        choice.add("C/C++");
        add(choice);

        setVisible(true);
    }

    public static void main(String[] args) {
        q4inheritance window = new q4inheritance();
    }
}
