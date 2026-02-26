package com.dylan.calculator.util.calculations;

import com.dylan.calculator.util.Lexer;
import com.dylan.calculator.util.Token;
import com.dylan.calculator.util.enums.CalculationType;
import java.util.List;

public class BasicCalculation {

    private final String expression;
    private final CalculationType calculationType;
    private List<Token> tokenList;

    public BasicCalculation(String expression, CalculationType type) {
        this.expression = expression;
        this.calculationType = type;
    }

    public String getExpression() {
        return this.expression;
    }

    public CalculationType getCalculationType() {
        return this.calculationType;
    }

    public void lex() {
        Lexer lexer = new Lexer(expression);
        this.tokenList = lexer.tokenize();
    }

    public List<Token> getTokenList() {
        return this.tokenList;
    }
}