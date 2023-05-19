import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColorTest implements ActionListener {
    private JFrame frame;
    private JLabel colorLabel;
    private JButton option1;
    private JButton option2;
    private Timer timer;
    private int timeRemaining;
    private int score;
    private int questionCount;

    private static final String[] COLORS = {"RED", "BLUE", "GREEN", "YELLOW", "PURPLE", "ORANGE"};
    private static final Color[] FONT_COLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.ORANGE};

    public ColorTest() {
        frame = new JFrame("Color Test");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        colorLabel = new JLabel();
        colorLabel.setFont(new Font("Arial", Font.BOLD, 24));
        colorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        option1 = new JButton();
        option1.addActionListener(this);

        option2 = new JButton();
        option2.addActionListener(this);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new FlowLayout());
        optionsPanel.add(option1);
        optionsPanel.add(option2);

        frame.add(colorLabel, BorderLayout.CENTER);
        frame.add(optionsPanel, BorderLayout.SOUTH);

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                if (timeRemaining <= 0) {
                    endTest();
                }
                updateTimerLabel();
            }
        });
    }

    public void startTest() {
        score = 0;
        questionCount = 0;
        timeRemaining = 60;
        updateTimerLabel();
        showNextQuestion();
        timer.start();
        frame.setVisible(true);
    }

    private void showNextQuestion() {
        if (questionCount >= 10) {
            endTest();
            return;
        }

        Random random = new Random();
        int colorIndex = random.nextInt(COLORS.length);
        int fontColorIndex = random.nextInt(FONT_COLORS.length);

        colorLabel.setText(COLORS[colorIndex]);
        colorLabel.setForeground(FONT_COLORS[fontColorIndex]);

        option1.setText(COLORS[colorIndex]);
        option2.setText(getColorName(FONT_COLORS[fontColorIndex]));

        questionCount++;
    }

    private String getColorName(Color color) {
        for (int i = 0; i < FONT_COLORS.length; i++) {
            if (color.equals(FONT_COLORS[i])) {
                return COLORS[i];
            }
        }
        return "";
    }

    private void updateTimerLabel() {
        frame.setTitle("Color Test - Time Remaining: " + timeRemaining + "s");
    }

    private void endTest() {
        timer.stop();
        JOptionPane.showMessageDialog(frame, "Test ended!\nScore: " + score + "/10");
        frame.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().equals(getColorName(colorLabel.getForeground()))) {
            score++;
        }
        showNextQuestion();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ColorTest().startTest();
            }
        });
    }
}