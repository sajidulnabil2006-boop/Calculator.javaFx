package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField display;

    private double firstNumber = 0;
    private String operator = "";

    @FXML
    private void handleButtonClick(javafx.event.ActionEvent event) {

        Button button = (Button) event.getSource();
        String value = button.getText();

        if (value.matches("[0-9]")) {
            display.appendText(value);
        }
        else if (value.matches("[+\\-*/]")) {
            firstNumber = Double.parseDouble(display.getText());
            operator = value;
            display.clear();
        }
        else if (value.equals("=")) {
            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
            }

            display.setText(String.valueOf(result));
        }
        else if (value.equals("C")) {
            display.clear();
            operator = "";
            firstNumber = 0;
        }
    }
}