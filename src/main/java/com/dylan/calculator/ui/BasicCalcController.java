package com.dylan.calculator.ui;

import com.dylan.calculator.util.calculations.BasicCalculation;
import com.dylan.calculator.util.results.Result;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.Objects;

public class BasicCalcController {
    StringBuilder expression = new StringBuilder();

    @FXML
    private TextField mainDisplay;
    @FXML
    private TextField inputBox;

    @FXML
    public void initialize() {
        inputBox.setOnAction((ActionEvent e) -> runCalculation());
    }

    private void runCalculation() {
        System.out.println(expression.toString());
        BasicCalculation newCalc = new BasicCalculation(expression.toString());
        newCalc.lex();
        Result result = newCalc.evaluate();
        mainDisplay.setText(result.toString());
        expression = new StringBuilder();
        inputBox.clear();
    }

    @FXML
    public void handleButtonPress(ActionEvent event) {
        Button button = (Button) event.getSource();
        String symbolSelected = button.getText();
        inputBox.setText(inputBox.getText() + symbolSelected);
        expression.append(symbolSelected);
    }
}
