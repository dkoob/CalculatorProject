package com.dylan.calculator.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CalculatorController {

    @FXML
    private TextField mainText;

    @FXML
    public void initialize() {
        mainText.setText("");
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        Button btn = (Button) event.getSource();
        mainText.appendText(btn.getText());
    }

    @FXML
    private void handleDivision(ActionEvent event) {
        System.out.println("Did something");
    }

    @FXML
    private void handleMultiplication(ActionEvent event) {
        System.out.println("Did something");
    }

    @FXML
    private void handleSubtraction(ActionEvent event) {
        System.out.println("Did something");
    }

    @FXML
    private void handleAddition(ActionEvent event) {
        System.out.println("Did something");
    }

    @FXML
    private void handleCalculate(ActionEvent event) {
        System.out.println("Did something");
    }
}
