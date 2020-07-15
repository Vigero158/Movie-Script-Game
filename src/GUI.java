import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    public int wordAmount = 1;
    public JLabel label;
    public JFrame frame;
    private final JPanel panel;
    public JLabel wordText;
    private final JLabel blankSpace;
    public String enteredText = "";
    public JTextField userText;


    public GUI() {
        GridLayout gridLayout = new GridLayout(4, 0);
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel();
        wordText = new JLabel();
        blankSpace = new JLabel();
        userText = new JTextField();
        blankSpace.setText(" ");

        wordText.setText("Word: ");
        label.setText("Number of words shown: " + wordAmount);
        JButton button = new JButton("Submit Guess");
        button.addActionListener(this);
        userText.addActionListener(this);
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
        label.setPreferredSize(new Dimension(220, 0));
        panel.setLayout(gridLayout);
        panel.add(wordText);
        panel.add(userText);
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Movie Script Game");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        enteredText = userText.getText().toLowerCase().replaceAll(" ", "");
    }
}
