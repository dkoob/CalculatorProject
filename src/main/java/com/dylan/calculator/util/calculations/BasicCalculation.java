package com.dylan.calculator.util.calculations;

import com.dylan.calculator.util.Lexer;
import com.dylan.calculator.util.ShuntingYardParser;
import com.dylan.calculator.util.Token;
import com.dylan.calculator.util.evaluators.Evaluator;
import com.dylan.calculator.util.evaluators.ExpressionEvaluator;
import com.dylan.calculator.util.results.Result;
import java.util.List;

public class BasicCalculation extends Calculation {
    private List<Token> infixTokens;
    private Result result;

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
        ShuntingYardParser parser = new ShuntingYardParser();
        Evaluator eval = new ExpressionEvaluator();
        System.out.println();
        return this.result = eval.evaluate(parser.parseInfixExpression(infixTokens));
    }
}
