import java.awt.*;

public class  q1inheritance extends Frame {
    public q1inheritance() {
        super("Hello, VIT");
        Label label = new Label("Hello, VIT");
        add(label);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new q1inheritance();
    }
}
