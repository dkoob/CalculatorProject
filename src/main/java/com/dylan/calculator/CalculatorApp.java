package com.dylan.calculator;

import com.dylan.calculator.util.Lexer;
import com.dylan.calculator.util.Token;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class CalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dylan/calculator/CalculatorLayout.fxml"));
        //primaryStage.setScene(new Scene(loader.load()));
        //primaryStage.setTitle("Calculator");
        //primaryStage.show();

        String input = "6+87^2";
        Lexer newLexer = new Lexer(input);
        List<Token> tokenList = newLexer.tokenize();
        for (Token token : tokenList) {
            System.out.println(token);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
