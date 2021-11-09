package gb.ru;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JLabel display;
    private Double leftOperand;
    private Double rightOperand;
    private String operation;

    private Double dAngle;
    private int sum;
    private int sum1;

    public static void main(String[] args) {
        new Calculator();
    }

    public Calculator() {
        setTitle("");
        setBounds(300,300,500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ActionListener numberactionListener = new ActionListener() {
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

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String text = source.getText();
                if ("=".equals(text)) {
                    rightOperand = Double.parseDouble(display.getText());
                    if (leftOperand != null) {
                        switch (operation) {
                            case "+":
                                display.setText(String.valueOf(leftOperand + rightOperand));
                                break;
                            case "-":
                                display.setText(String.valueOf(leftOperand - rightOperand));
                                break;
                            case "*":
                                display.setText(String.valueOf(leftOperand * rightOperand));
                                break;
                            case "/":
                                display.setText(String.valueOf(leftOperand / rightOperand));
                                break;
                            case "^":
                                sum = 0;
                                display.setText(String.valueOf(sum = sum + (int)Math.pow(leftOperand, rightOperand)));
                                break;
                            case "√":
                                sum1 = 0;
                                display.setText(String.valueOf(sum1 = sum1 +(int)Math.pow(leftOperand, 1/rightOperand)));
                                break;
                            case "s":
                                dAngle = Math.toRadians(leftOperand);
                                display.setText((String.valueOf(Math.sin(dAngle))));
                                break;
                            case "c":
                                dAngle = Math.toRadians(leftOperand);
                                display.setText((String.valueOf(Math.cos(dAngle))));
                                break;
                            case "t":
                                dAngle = Math.toRadians(leftOperand);
                                display.setText((String.valueOf(Math.tan(dAngle))));
                                break;
                        }
                        leftOperand = Double.parseDouble(display.getText());
                        rightOperand = null;
                        operation = null;
                    }
                    return;
                }
                leftOperand = Double.parseDouble(display.getText());
                display.setText("0");
                operation = text;
            }
        };
        final JPanel numberPanel = new JPanel();
        final GridLayout numberLayout = new GridLayout (4, 3, 10, 10);
        numberPanel.setLayout(numberLayout);

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(numberactionListener);
            numberPanel.add(button);
        }
        JButton pointButton = new JButton(".");
        numberPanel.add(pointButton);
        pointButton.addActionListener(numberactionListener);

        numberPanel.add(new JButton("+/-"));

        JPanel buttonPanel = new JPanel();
        GridLayout buttonLayout = new GridLayout(2, 3, 10, 10);
        buttonPanel.setLayout(buttonLayout);


        for (char c : "+-*/C=^√sct".toCharArray()) {
            JButton button = new JButton(String.valueOf(c));
            button.addActionListener(actionListener);
            buttonPanel.add(button);

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