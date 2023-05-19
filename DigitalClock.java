import java.awt.*;
import java.text.*;
import java.time.*;
import javax.swing.*;
import java.time.format.DateTimeFormatter;


public class DigitalClock extends JFrame {

    private JLabel clockLabel = new JLabel();
    private JTextField bdayField = new JTextField();
    private JButton setButton = new JButton("Set");

    private boolean bdaySet = false;
    private Instant bdayInstant;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DigitalClock() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setTitle("Instagram Theme Digital Clock with Birthday Reminder");
        setLayout(new GridLayout(4, 1));

        clockLabel.setHorizontalAlignment(JLabel.CENTER);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 48));
        clockLabel.setForeground(new Color(254, 102, 102));
        add(clockLabel);

        JLabel bdayLabel = new JLabel("Enter your birthdate and time (yyyy-MM-dd HH:mm:ss): ");
        bdayLabel.setHorizontalAlignment(JLabel.CENTER);
        bdayLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        bdayLabel.setForeground(new Color(128, 128, 128));
        add(bdayLabel);

        bdayField.setHorizontalAlignment(JTextField.CENTER);
        bdayField.setFont(new Font("Arial", Font.PLAIN, 16));
        bdayField.setForeground(new Color(128, 128, 128));
        add(bdayField);

        setButton.addActionListener(e -> {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
LocalDateTime bdayDateTime = LocalDateTime.parse(bdayField.getText(), formatter);
                JOptionPane.showMessageDialog(this, "Birthday reminder set.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid date/time format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        setButton.setFont(new Font("Arial", Font.PLAIN, 16));
        setButton.setForeground(new Color(254, 102, 102));
        setButton.setBackground(new Color(252, 175, 69));
        add(setButton);

        Timer t = new Timer(1000, e -> {
            Instant now = Instant.now();
            clockLabel.setText(sdf.format(now));

            if (bdaySet && now.equals(bdayInstant)) {
                JOptionPane.showMessageDialog(this, "Happy Birthday!", "Birthday Reminder", JOptionPane.PLAIN_MESSAGE);
            }
        });
        t.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}
