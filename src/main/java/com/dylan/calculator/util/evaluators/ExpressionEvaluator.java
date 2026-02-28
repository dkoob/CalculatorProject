package com.dylan.calculator.util.evaluators;

import com.dylan.calculator.util.Token;
import com.dylan.calculator.util.enums.Operator;
import com.dylan.calculator.util.enums.TokenType;
import com.dylan.calculator.util.results.RealResult;
import com.dylan.calculator.util.results.Result;
import java.util.ArrayList;
import java.util.List;

public class ExpressionEvaluator extends Evaluator {
    @Override
    public Result evaluate(List<Token> postfixTokens) {
        List<Token> stack = new ArrayList<>();
        for (Token token : postfixTokens) {
            switch (token.getType()) {

                case NUMBER, NEGATIVE_NUMBER -> {
                    stack.add(token);
                }

                case OPERATOR, FUNCTION, NEGATIVE_OPERATOR -> {
                    System.out.println(token.toString());
                    int arity = token.getOperator().arity;
                    switch (arity) {

                        case 1 -> {
                            Token a = stack.removeLast();
                            Token result = handleUnaryOperation(a, token.getOperator());
                            stack.add(result);
                        }

                        case 2 -> {
                            Token b = stack.removeLast();
                            Token a = stack.removeLast();
                            Token result = handleBinaryOperation(a, b, token.getOperator());
                            stack.add(result);
                        }
                    }
                }
            }
        }
        return new RealResult(stack.getFirst().getValue());
    }

    Token handleUnaryOperation(Token a, Operator b) {
        String symbol = b.symbol;
        double value = a.getValue();
        double result;

        switch (symbol) {
            case "NEG" -> result = -value;
            case "SIN" -> result = Math.sin(value);
            case "COS" -> result = Math.cos(value);
            case "TAN" -> result = Math.tan(value);
            case "SQRT" -> result = Math.sqrt(value);
            case "LOG" -> result = Math.log(value);
            default -> throw new IllegalArgumentException("Unknown operator: " + symbol);
        }

        return new Token(TokenType.NUMBER, result);
    }

    Token handleBinaryOperation(Token a, Token b, Operator c) {
        String symbol = c.symbol;
        double aValue = a.getValue();
        double bValue = b.getValue();
        double result;

        switch (symbol) {
            case "+" -> result = aValue + bValue;
            case "-" -> result = aValue - bValue;
            case "*" -> result = aValue * bValue;
            case "/" -> result = aValue / bValue;
            case "^" -> result = Math.pow(aValue, bValue);
            default -> throw new IllegalArgumentException("Unknown operator: " + symbol);
        }

        return new Token(TokenType.NUMBER, result);
    }
}
