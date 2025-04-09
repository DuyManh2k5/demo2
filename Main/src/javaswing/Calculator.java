
package javaswing;
import javaswing.OperationAdd;
import javaswing.OperationSub;
import javaswing.OperationMul;
import javaswing.OperationDiv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;

public class Calculator extends JFrame {
    private JTextField input1, input2, result;

    public Calculator() {
        setTitle("Mini Calculator");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Số thứ 1:"));
        input1 = new JTextField();
        add(input1);

        add(new JLabel("Số thứ 2:"));
        input2 = new JTextField();
        add(input2);

        JButton btnAdd = new JButton("+");
        JButton btnSub = new JButton("-");
        JButton btnMul = new JButton("*");
        JButton btnDiv = new JButton("/");

        add(btnAdd); add(btnSub);
        add(btnMul); add(btnDiv);

        add(new JLabel("Kết quả:"));
        result = new JTextField();
        result.setEditable(false);
        add(result);

        btnAdd.addActionListener(e -> calculate("add"));
        btnSub.addActionListener(e -> calculate("sub"));
        btnMul.addActionListener(e -> calculate("mul"));
        btnDiv.addActionListener(e -> calculate("div"));
    }

    private void calculate(String operation) {
        try {
            double a = Double.parseDouble(input1.getText());
            double b = Double.parseDouble(input2.getText());
            double res = 0;

            switch (operation) {
                case "add":
                    res = OperationAdd.add(a, b);
                    break;
                case "sub":
                    res = OperationSub.subtract(a, b);
                    break;
                case "mul":
                    res = OperationMul.multiply(a, b);
                    break;
                case "div":
                    res = OperationDiv.divide(a, b);
                    break;
            }

            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            result.setText("Lỗi nhập số");
        } catch (Exception ex) {
            result.setText("Lỗi tính toán");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
    }
}