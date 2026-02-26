package com.dylan.calculator;

import com.dylan.calculator.util.calculations.BasicCalculation;
import com.dylan.calculator.util.Token;

import javafx.application.Application;
import javafx.stage.Stage;



public class CalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dylan/calculator/CalculatorLayout.fxml"));
        //primaryStage.setScene(new Scene(loader.load()));
        //primaryStage.setTitle("Calculator");
        //primaryStage.show();

        String input = "6+87^2";
        BasicCalculation newCalc = new BasicCalculation(input);
        newCalc.lex();
        for (Token token : newCalc.getTokenList()) {
            System.out.println(token);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
