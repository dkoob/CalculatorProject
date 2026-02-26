package com.dylan.calculator.util.calculations;

import com.dylan.calculator.util.Lexer;
import com.dylan.calculator.util.ShuntingYardParser;
import com.dylan.calculator.util.Token;
import com.dylan.calculator.util.results.Result;
import java.util.List;

public class BasicCalculation extends Calculation {
    private List<Token> infixTokens;

    public BasicCalculation(String expression) {
        super(expression);
    }

    public void lex() {
        Lexer lexer = new Lexer(expression);
        this.infixTokens = lexer.tokenize();
    }

    public String getExpression() {
        return this.expression;
    }
    public List<Token> getInfixTokens() {
        return this.infixTokens;
    }

    @Override
    public Result evaluate() {
        ShuntingYardParser parser = new ShuntingYardParser(infixTokens);
        List<Token> postfixTokens = parser.parseInfixExpression(infixTokens);
    }
}