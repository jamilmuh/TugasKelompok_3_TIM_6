import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarnaDanPosisi extends JFrame implements ActionListener {
    private JLabel textLabel;
    private JButton moveLeftButton, moveRightButton;
    private JRadioButton redRadioButton, yellowRadioButton, blackRadioButton, orangeRadioButton, greenRadioButton;

    private int currentPosition;

    public WarnaDanPosisi() {
        setTitle("Text Color and Position Changer");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        textLabel = new JLabel("Programming is fun");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        textLabel.setForeground(Color.BLACK); // Default text color
        textPanel.add(textLabel);

        add(textPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        moveLeftButton = new JButton("<=");
        moveRightButton = new JButton("=>");

        moveLeftButton.addActionListener(this);
        moveRightButton.addActionListener(this);

        buttonPanel.add(moveLeftButton);
        buttonPanel.add(moveRightButton);

        add(buttonPanel, BorderLayout.SOUTH);

        redRadioButton = createColorRadioButton("Red", Color.RED);
        yellowRadioButton = createColorRadioButton("Yellow", Color.YELLOW);
        blackRadioButton = createColorRadioButton("Black", Color.BLACK);
        orangeRadioButton = createColorRadioButton("Orange", Color.ORANGE);
        greenRadioButton = createColorRadioButton("Green", Color.GREEN);

        ButtonGroup colorButtonGroup = new ButtonGroup();
        colorButtonGroup.add(redRadioButton);
        colorButtonGroup.add(yellowRadioButton);
        colorButtonGroup.add(blackRadioButton);
        colorButtonGroup.add(orangeRadioButton);
        colorButtonGroup.add(greenRadioButton);
        blackRadioButton.setSelected(true);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        radioPanel.add(redRadioButton);
        radioPanel.add(yellowRadioButton);
        radioPanel.add(blackRadioButton);
        radioPanel.add(orangeRadioButton);
        radioPanel.add(greenRadioButton);

        add(radioPanel, BorderLayout.NORTH);
    }

    private JRadioButton createColorRadioButton(String text, Color color) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.addActionListener(e -> textLabel.setForeground(color));
        return radioButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentPosition = textLabel.getLocation().x;
        if (e.getSource() == moveLeftButton) {
            if (currentPosition >= 10) {
                currentPosition -= 10; // Adjust the value as needed
            } else if (currentPosition < 10 && currentPosition > 0) {
                currentPosition = 0;
            }
            textLabel.setLocation(currentPosition, textLabel.getY());
        } else if (e.getSource() == moveRightButton) {
            int rightPosition = (currentPosition + textLabel.getWidth() + 10);
            if (rightPosition < (getWidth() - 10)) {
                currentPosition += 10; // Adjust the value as needed
            } else if (rightPosition > (getWidth() - 10) && rightPosition < getWidth()) {
                currentPosition += getWidth() - rightPosition - 3; // Adjust the value as needed
            }
            textLabel.setLocation(currentPosition, textLabel.getY());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WarnaDanPosisi warnaDanPosisi = new WarnaDanPosisi();
            warnaDanPosisi.setVisible(true);
        });
    }
}
