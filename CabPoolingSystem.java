import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CabPoolingSystem implements ActionListener {
    JFrame frame;
    JLabel nameLabel, regNoLabel, dateLabel, timeLabel, carTypeLabel, priceLabel;
    JTextField nameTextField, regNoTextField, priceTextField;
    JComboBox<String> timeComboBox, carTypeComboBox;
    JButton submitButton, resetButton;

    String[] times = { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00",
            "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00",
            "21:00", "22:00", "23:00" };
    String[] carTypes = { "4 seater", "7 seater" };

    public CabPoolingSystem() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Cab Pooling System");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 20);
        nameLabel.setFont(new Font("Instagram", Font.PLAIN, 14));
        frame.getContentPane().add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(150, 50, 200, 20);
        frame.getContentPane().add(nameTextField);

        regNoLabel = new JLabel("Student Registration No.:");
        regNoLabel.setBounds(50, 100, 150, 20);
        regNoLabel.setFont(new Font("Instagram", Font.PLAIN, 14));
        frame.getContentPane().add(regNoLabel);

        regNoTextField = new JTextField();
        regNoTextField.setBounds(200, 100, 150, 20);
        frame.getContentPane().add(regNoTextField);

        dateLabel = new JLabel("Date:");
        dateLabel.setBounds(50, 150, 100, 20);
        dateLabel.setFont(new Font("Instagram", Font.PLAIN, 14));
        frame.getContentPane().add(dateLabel);



        timeLabel = new JLabel("Time:");
        timeLabel.setBounds(50, 320, 100, 20);
        timeLabel.setFont(new Font("Instagram", Font.PLAIN, 14));
        frame.getContentPane().add(timeLabel);

        timeComboBox = new JComboBox<>(times);
        timeComboBox.setBounds(150, 320, 100, 20);
        frame.getContentPane().add(timeComboBox);

        carTypeLabel = new JLabel("Car Type:");
        carTypeLabel.setBounds(50, 370, 100, 20);
        carTypeLabel.setFont(new Font("Instagram", Font.PLAIN, 14));
        frame.getContentPane().add(carTypeLabel);

        carTypeComboBox = new JComboBox<>(carTypes);
        carTypeComboBox.setBounds(150, 370, 100, 20);
        frame.getContentPane().add(carTypeComboBox);
        priceLabel = new JLabel("Price:");
        priceLabel.setBounds(50, 420, 100, 20);
        priceLabel.setFont(new Font("Instagram", Font.PLAIN, 14));
        frame.getContentPane().add(priceLabel);
    
        priceTextField = new JTextField();
        priceTextField.setBounds(150, 420, 100, 20);
        priceTextField.setEditable(false);
        frame.getContentPane().add(priceTextField);
    
        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 470, 100, 30);
        submitButton.addActionListener(this);
        frame.getContentPane().add(submitButton);
    
        resetButton = new JButton("Reset");
        resetButton.setBounds(300, 470, 100, 30);
        resetButton.addActionListener(this);
        frame.getContentPane().add(resetButton);
    
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameTextField.getText();
            String regNo = regNoTextField.getText();
         String time = (String) timeComboBox.getSelectedItem();
            String carType = (String) carTypeComboBox.getSelectedItem();
    
            int price = 0;
            if (carType.equals("4 seater")) {
                price = 500;
            } else if (carType.equals("7 seater")) {
                price = 800;
            }
    
            priceTextField.setText(String.valueOf(price));
        } else if (e.getSource() == resetButton) {
            nameTextField.setText("");
            regNoTextField.setText("");
            priceTextField.setText("");
        }
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CabPoolingSystem window = new CabPoolingSystem();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
    