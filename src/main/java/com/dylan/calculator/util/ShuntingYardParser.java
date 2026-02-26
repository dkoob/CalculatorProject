package com.dylan.calculator.util;

import com.dylan.calculator.util.calculations.BasicCalculation;
import java.util.List;

public class ShuntingYardParser {
    List<Token> infixTokens;
    List<Token> postfixTokens;

    public ShuntingYardParser(List<Token> infixTokens) {
        this.infixTokens = infixTokens;
    }

    public List<Token> parseInfixExpression(List<Token> infixTokens) {

        return postfixTokens;
    }
}