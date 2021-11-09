package gb.ru;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Calculator extends JFrame {

    public static void main(String[] args) {
        new Calculator();
    }

    public Calculator() {
        setTitle("");
        setBounds(300,300,500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        final JPanel numberPanel = new JPanel();
        final GridLayout numberLayout = new GridLayout (4, 3, 10, 10);
        numberPanel.setLayout(numberLayout);

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
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


        add(numberPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);

    }
}
