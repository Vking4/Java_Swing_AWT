import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FunkySwing extends JPanel implements ActionListener {
    private int x, y, dx, dy;
    private Timer timer;

    public FunkySwing() {
        x = 100;
        y = 100;
        dx = 5;
        dy = 5;
        timer = new Timer(10, this);
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, 50, 50);
    }

    public void actionPerformed(ActionEvent e) {
        x += dx;
        y += dy;
        if (x < 0 || x > getWidth() - 50) {
            dx = -dx;
        }
        if (y < 0 || y > getHeight() - 50) {
            dy = -dy;
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FunkySwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new FunkySwing());
        frame.setVisible(true);
    }
}
