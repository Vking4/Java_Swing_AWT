import java.awt.*;

public class q4simple {
    private Frame frame;
    private Label label;
    private Choice choice;

    public q4simple() {
        frame = new Frame("My Window");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 100);

        label = new Label("Choose your favorite programming language:");
        frame.add(label);

        choice = new Choice();
        choice.add("Java");
        choice.add("Python");
        choice.add("C#");
        choice.add("C/C++");
        frame.add(choice);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        q4simple window = new q4simple();
    }
}
