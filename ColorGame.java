import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ColorGame extends JFrame implements ActionListener {

    private Map<String, String> colors;
    private JLabel colorNameLabel, colorBoxLabel;
    private JButton colorButton1, colorButton2;
    private int score;

    public ColorGame() {
        super("Color Game");

        // Initialize color names and corresponding RGB values
        colors = new HashMap<>();
        colors.put("red", "#FF0000");
        colors.put("green", "#00FF00");
        colors.put("blue", "#0000FF");
        colors.put("yellow", "#FFFF00");
        colors.put("purple", "#800080");
        colors.put("orange", "#FFA500");

        // Create GUI components
        colorNameLabel = new JLabel();
        colorBoxLabel = new JLabel();
        colorButton1 = new JButton();
        colorButton2 = new JButton();
        JButton startButton = new JButton("Start");

        // Set component properties
        colorNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        colorBoxLabel.setOpaque(true);
        colorBoxLabel.setPreferredSize(new Dimension(200, 200));
        colorButton1.addActionListener(this);
        colorButton2.addActionListener(this);
        startButton.addActionListener(this);

        // Add components to GUI
        JPanel topPanel = new JPanel();
        topPanel.add(colorNameLabel);
        topPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        topPanel.add(colorBoxLabel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(colorButton1);
        bottomPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        bottomPanel.add(colorButton2);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel startPanel = new JPanel(new FlowLayout());
        startPanel.add(startButton);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(mainPanel, BorderLayout.CENTER);
        contentPane.add(startPanel, BorderLayout.SOUTH);
        setContentPane(contentPane);

        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Start the game when the Start button is clicked
        if (e.getActionCommand().equals("Start")) {
            startGame();
        }
        // Check if the user selected the correct color name
        else if (e.getSource() == colorButton1 || e.getSource() == colorButton2) {
            JButton buttonClicked = (JButton) e.getSource();
            String selectedColorName = buttonClicked.getText().toLowerCase();
            String correctColorName = colorNameLabel.getText().toLowerCase();
            if (selectedColorName.equals(correctColorName)) {
                JOptionPane.showMessageDialog(this, "Correct!");
                score++;
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect!");
            }
            startGame();
        }
    }

    private void startGame() {
        // Generate a random color and corresponding color name
        Random random = new Random();
        String[] colorNames = colors.keySet().toArray;
        String randomColorName = colorNames[random.nextInt(colorNames.length)];
        String randomColorValue = colors.get(randomColorName);
    
        // Display the color name and color box
        colorNameLabel.setText(randomColorName);
        colorBoxLabel.setBackground(Color.decode(randomColorValue));
    
        // Generate two random color names for the buttons
        String[] buttonColorNames = new String[2];
        buttonColorNames[0] = randomColorName;
        do {
            buttonColorNames[1] = colorNames[random.nextInt(colorNames.length)];
        } while (buttonColorNames[1].equals(randomColorName));
    
        // Shuffle the array and assign the button text
        for (int i = buttonColorNames.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = buttonColorNames[i];
            buttonColorNames[i] = buttonColorNames[j];
            buttonColorNames[j] = temp;
        }
        colorButton1.setText(buttonColorNames[0]);
        colorButton2.setText(buttonColorNames[1]);
    
        // Disable the buttons until a new game is started
        colorButton1.setEnabled(false);
        colorButton2.setEnabled(false);
    
        // Enable the buttons after a short delay
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorButton1.setEnabled(true);
                colorButton2.setEnabled(true);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    public static void main(String[] args) {
        new ColorGame();
    }
}
    