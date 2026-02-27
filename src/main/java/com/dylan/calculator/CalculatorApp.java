package com.dylan.calculator;

import java.util.List;
import com.dylan.calculator.util.calculations.BasicCalculation;
import com.dylan.calculator.util.Token;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dylan/calculator/CalculatorLayout.fxml"));
        //primaryStage.setScene(new Scene(loader.load()));
        //primaryStage.setTitle("Calculator");
        //primaryStage.show();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter expression");
            String input = sc.nextLine();
            BasicCalculation newCalc = new BasicCalculation(input);
            newCalc.lex();
            List<Token> postFixList = newCalc.evaluate();
            for (Token token : postFixList) {
                System.out.println(token.toString());
                System.out.print(token.getText() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
