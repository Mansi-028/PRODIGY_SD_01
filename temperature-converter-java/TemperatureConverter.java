/*
 * Task 01 - Temperature Converter (Java Swing version)
 * Prodigy InfoTech - Software Development Internship
 * Author: Mansi (B.Tech)
 *
 * How to run:
 *   javac TemperatureConverter.java
 *   java  TemperatureConverter
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {

    // ui fields
    private JTextField tempField;
    private JComboBox<String> unitBox;
    private JLabel celsiusLabel;
    private JLabel fahrenheitLabel;
    private JLabel kelvinLabel;
    private JLabel messageLabel;

    public TemperatureConverter() {
        setTitle("Temperature Converter - Task 01");
        setSize(420, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setLayout(new BorderLayout(10, 10));

        add(buildHeader(), BorderLayout.NORTH);
        add(buildForm(), BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);
    }

    private JPanel buildHeader() {
        JPanel p = new JPanel();
        p.setBackground(new Color(67, 56, 202));
        JLabel title = new JLabel("Temperature Converter");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        p.add(title);
        return p;
    }

    private JPanel buildForm() {
        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Temperature input
        c.gridx = 0; c.gridy = 0;
        form.add(new JLabel("Temperature:"), c);

        tempField = new JTextField(10);
        c.gridx = 1; c.gridy = 0;
        form.add(tempField, c);

        // Unit dropdown
        c.gridx = 0; c.gridy = 1;
        form.add(new JLabel("From unit:"), c);

        String[] units = { "Celsius", "Fahrenheit", "Kelvin" };
        unitBox = new JComboBox<>(units);
        c.gridx = 1; c.gridy = 1;
        form.add(unitBox, c);

        // Buttons
        JButton convertBtn = new JButton("Convert");
        JButton resetBtn = new JButton("Reset");

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnPanel.add(convertBtn);
        btnPanel.add(resetBtn);

        c.gridx = 0; c.gridy = 2; c.gridwidth = 2;
        form.add(btnPanel, c);

        // Result labels
        celsiusLabel = new JLabel("Celsius: -");
        fahrenheitLabel = new JLabel("Fahrenheit: -");
        kelvinLabel = new JLabel("Kelvin: -");

        c.gridy = 3; form.add(celsiusLabel, c);
        c.gridy = 4; form.add(fahrenheitLabel, c);
        c.gridy = 5; form.add(kelvinLabel, c);

        // Message label (for errors)
        messageLabel = new JLabel(" ");
        messageLabel.setForeground(Color.RED);
        c.gridy = 6;
        form.add(messageLabel, c);

        // wire up actions
        convertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doConvert();
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doReset();
            }
        });

        return form;
    }

    private JPanel buildFooter() {
        JPanel p = new JPanel();
        JLabel l = new JLabel("Made by Mansi - Prodigy InfoTech Internship");
        l.setForeground(Color.GRAY);
        l.setFont(new Font("SansSerif", Font.PLAIN, 11));
        p.add(l);
        return p;
    }

    // main conversion logic
    private void doConvert() {
        messageLabel.setText(" ");
        String raw = tempField.getText().trim();

        if (raw.isEmpty()) {
            messageLabel.setText("Please enter a temperature value.");
            return;
        }

        double value;
        try {
            value = Double.parseDouble(raw);
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid number.");
            return;
        }

        String unit = (String) unitBox.getSelectedItem();

        double celsius = 0, fahrenheit = 0, kelvin = 0;

        // convert input -> celsius first, then derive others
        if (unit.equals("Celsius")) {
            celsius = value;
            fahrenheit = (value * 9.0 / 5.0) + 32;
            kelvin = value + 273.15;
        } else if (unit.equals("Fahrenheit")) {
            celsius = (value - 32) * 5.0 / 9.0;
            fahrenheit = value;
            kelvin = celsius + 273.15;
        } else if (unit.equals("Kelvin")) {
            celsius = value - 273.15;
            fahrenheit = (celsius * 9.0 / 5.0) + 32;
            kelvin = value;
        }

        // cannot be below absolute zero
        if (kelvin < 0) {
            messageLabel.setText("Temperature is below absolute zero!");
            return;
        }

        celsiusLabel.setText("Celsius: " + round2(celsius) + " \u00B0C");
        fahrenheitLabel.setText("Fahrenheit: " + round2(fahrenheit) + " \u00B0F");
        kelvinLabel.setText("Kelvin: " + round2(kelvin) + " K");
    }

    private void doReset() {
        tempField.setText("");
        unitBox.setSelectedIndex(0);
        celsiusLabel.setText("Celsius: -");
        fahrenheitLabel.setText("Fahrenheit: -");
        kelvinLabel.setText("Kelvin: -");
        messageLabel.setText(" ");
    }

    // simple round to 2 decimal places
    private double round2(double num) {
        return Math.round(num * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverter().setVisible(true);
            }
        });
    }
}
