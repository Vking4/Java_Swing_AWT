import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColorTest2 {
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

    public ColorTest2() {
        frame = new JFrame("Color Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        colorLabel = new JLabel();
        colorLabel.setFont(new Font("Arial", Font.BOLD, 24));
        colorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        option1 = new JButton();
        option1.addActionListener(e -> checkAnswer(option1));

        option2 = new JButton();
        option2.addActionListener(e -> checkAnswer(option2));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new FlowLayout());
        optionsPanel.add(option1);
        optionsPanel.add(option2);

        frame.add(colorLabel, BorderLayout.CENTER);
        frame.add(optionsPanel, BorderLayout.SOUTH);

        timer = new Timer(1000, e -> {
            timeRemaining--;
            if (timeRemaining <= 0) {
                endTest();
            }
            updateTimerLabel();
        });
    }

    public void startTest() {
        score = 0;
        questionCount = 0;
        timeRemaining = 60;
        updateTimerLabel();
        showNextQuestion();
        timer.start();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showNextQuestion() {
        if (questionCount >= 10) {
            endTest();
            return;
        }
    
        Random random = new Random();
        int colorIndex;
        int fontColorIndex;
        do {
            colorIndex = random.nextInt(COLORS.length);
            fontColorIndex = random.nextInt(FONT_COLORS.length);
        } while (colorIndex == fontColorIndex);
    
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

    private void checkAnswer(JButton button) {
        if (button.getText().equals(getColorName(colorLabel.getForeground()))) {
            score++;
        }
        showNextQuestion();
    }

    private void endTest() {
        timer.stop();
        JOptionPane.showMessageDialog(frame, "Test ended!\nScore: " + score + "/10");
        frame.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorTest2().startTest());
    }
}