import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Calculator extends JFrame {
    private JTextField display;
    private double result = 0;
    private String operator = "";
    private String equation = "";

    public Calculator() {
        setTitle("Kalkulator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+"};
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if ("0123456789".contains(command)) {
                display.setText(display.getText() + command);
                equation += command;
            } else if ("+-*/".contains(command)) {
                result = Double.parseDouble(display.getText());
                operator = command;
                equation += " " + operator + " ";
                display.setText("");
            } else if ("=".equals(command)) {
                double secondOperand = Double.parseDouble(display.getText());
                equation += secondOperand;
                switch (operator) {
                    case "+": result += secondOperand; break;
                    case "-": result -= secondOperand; break;
                    case "*": result *= secondOperand; break;
                    case "/": result /= secondOperand; break;
                }
                display.setText(String.valueOf(result)+" Wynik zapisano w bazie");
                DatabaseManager.saveCalculation(equation, operator, result);
                System.out.println("Wynik to: "+result);
                equation = "";
            } else if ("C".equals(command)) {
                display.setText("");
                equation = "";
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
    }
}
