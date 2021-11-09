package gb.ru;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JLabel display;

    public static void main(String[] args) {
        new Calculator();
    }

    public Calculator() {
        setTitle("");
        setBounds(300,300,500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String text = source.getText();
                String displayText = display.getText();
                if (".".equals(text) && displayText.contains(".")) {
                    return;
                }
                if ("0".equals(displayText)) {
                    displayText = "";
                }
                displayText += text;
                display.setText(displayText);
            }
        };

        final JPanel numberPanel = new JPanel();
        final GridLayout numberLayout = new GridLayout (4, 3, 10, 10);
        numberPanel.setLayout(numberLayout);

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(actionListener);
            numberPanel.add(button);
        }
        numberPanel.add(new JButton("."));
        numberPanel.add(new JButton("+/-"));

        JPanel buttonPanel = new JPanel();
        GridLayout buttonLayout = new GridLayout(2, 3, 10, 10);
        buttonPanel.setLayout(buttonLayout);


        for (char c : "+-*/C=".toCharArray()) {
            buttonPanel.add(new JButton(String.valueOf(c)));
        }

        display = new JLabel("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 17));
        add(display, BorderLayout.NORTH);
        add(numberPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);


        setVisible(true);

    }
}
