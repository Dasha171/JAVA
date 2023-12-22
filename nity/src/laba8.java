import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class laba8 {
    private JFrame frame;
    private JTextField lengthField;
    private JButton createVectorsButton;
    private List<JTextField> vector1Fields;
    private List<JTextField> vector2Fields;
    private JButton calculateScalarButton;
    private JButton calculateSumButton;

    private List<Double> vector1 = new ArrayList<>();
    private List<Double> vector2 = new ArrayList<>();

    public laba8() {
        frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        lengthField = new JTextField(5);
        createVectorsButton = new JButton("Создать вектор");
        createVectorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createVectors();
            }
        });

        vector1Fields = new ArrayList<>();
        vector2Fields = new ArrayList<>();

        calculateScalarButton = new JButton("Рассчитать скаляр");
        calculateScalarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateScalarProduct();
            }
        });

        calculateSumButton = new JButton("Рассчитать сумму");
        calculateSumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateVectorSum();
            }
        });

        frame.add(new JLabel("Введите длину вектора:"));
        frame.add(lengthField);
        frame.add(createVectorsButton);
        frame.add(new JLabel("Вектор 1:"));
        frame.add(createVectorFields(vector1Fields));
        frame.add(new JLabel("Вектор 2:"));
        frame.add(createVectorFields(vector2Fields));
        frame.add(calculateScalarButton);
        frame.add(calculateSumButton);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createVectorFields(List<JTextField> fields) {
        JPanel panel = new JPanel();
        for (int i = 0; i < vector1.size(); i++) {
            JTextField field = new JTextField(5);
            fields.add(field);
            panel.add(field);
        }
        return panel;
    }

    private void createVectors() {
        int length = Integer.parseInt(lengthField.getText());
        vector1Fields.clear();
        vector2Fields.clear();
        vector1.clear();
        vector2.clear();

        for (int i = 0; i < length; i++) {
            JTextField field1 = new JTextField(5);
            JTextField field2 = new JTextField(5);
            vector1Fields.add(field1);
            vector2Fields.add(field2);
            vector1.add(0.0);
            vector2.add(0.0);
        }

        frame.getContentPane().removeAll();
        frame.add(new JLabel("Введите длину вектора:"));
        frame.add(lengthField);
        frame.add(createVectorsButton);
        frame.add(new JLabel("Вектор 1:"));
        frame.add(createVectorFields(vector1Fields));
        frame.add(new JLabel("Вектор 2:"));
        frame.add(createVectorFields(vector2Fields));
        frame.add(calculateScalarButton);
        frame.add(calculateSumButton);
        frame.pack();
        frame.setVisible(true);
    }

    private void calculateScalarProduct() {
        try {
            double scalarProduct = 0;
            for (int i = 0; i < vector1Fields.size(); i++) {
                String value1Text = vector1Fields.get(i).getText();
                String value2Text = vector2Fields.get(i).getText();

                if (!value1Text.isEmpty() && !value2Text.isEmpty()) {
                    double value1 = Double.parseDouble(value1Text);
                    double value2 = Double.parseDouble(value2Text);
                    scalarProduct += value1 * value2;
                }
            }

            JOptionPane.showMessageDialog(frame, "Ответ скаляр: " + scalarProduct);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Ошибка при парсинге чисел. Проверьте введенные значения.");
        }
    }

    private void calculateVectorSum() {
        try {
            List<Double> sumVector = new ArrayList<>();
            for (int i = 0; i < vector1Fields.size(); i++) {
                String value1Text = vector1Fields.get(i).getText();
                String value2Text = vector2Fields.get(i).getText();

                if (!value1Text.isEmpty() && !value2Text.isEmpty()) {
                    double value1 = Double.parseDouble(value1Text);
                    double value2 = Double.parseDouble(value2Text);
                    sumVector.add(value1 + value2);
                }
            }

            if (sumVector.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Нет чисел для сложения.");
            } else {
                JOptionPane.showMessageDialog(frame, "Ответ суммы: " + sumVector);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Ошибка при парсинге чисел. Проверьте введенные значения.");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new laba8();
            }
        });
    }
}
