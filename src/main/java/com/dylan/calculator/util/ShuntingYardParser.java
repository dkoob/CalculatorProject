package com.dylan.calculator.util;

import com.dylan.calculator.util.enums.Associativity;
import com.dylan.calculator.util.enums.TokenType;
import java.util.ArrayList;
import java.util.List;

public class ShuntingYardParser {
    List<Token> infixTokens;
    List<Token> postfixTokens;

    public ShuntingYardParser(List<Token> infixTokens) {
        this.infixTokens = infixTokens;
    }

    public List<Token> parseInfixExpression(List<Token> infixTokens) {
        List<Token> queue = new ArrayList<>();
        List<Token> stack = new ArrayList<>();
        for (Token token : infixTokens) {
            TokenType type = token.getType();
            switch (type) {
                case TokenType.NUMBER, TokenType.NEGATIVE_NUMBER -> {
                    queue.add(token);
                }
                case TokenType.FUNCTION, TokenType.LEFT_PAREN -> {
                    stack.add(token);
                }
                case TokenType.RIGHT_PAREN -> {
                    while (!stack.isEmpty() && stack.getLast().getType() != TokenType.LEFT_PAREN) {
                        queue.add(stack.removeLast());
                    }
                    if (!stack.isEmpty() && stack.getLast().getType() == TokenType.LEFT_PAREN) {
                        stack.removeLast();
                    }
                    if (!stack.isEmpty() && stack.getLast().getType() == TokenType.NEGATIVE_OPERATOR) {
                        queue.add(stack.removeLast());
                    }
                }
                case TokenType.OPERATOR, TokenType.NEGATIVE_OPERATOR -> {
                    if (stack.isEmpty()) {
                        stack.add(token);
                    } else if (token.getType() == TokenType.NEGATIVE_OPERATOR) {
                        stack.add(token);
                    } else {
                        while (!stack.isEmpty()
                                && stack.getLast().getType() == TokenType.OPERATOR
                                && stack.getLast().getType() != TokenType.LEFT_PAREN
                                && (stack.getLast().getOperator().precedence > token.getOperator().precedence
                                || (stack.getLast().getOperator().precedence == token.getOperator().precedence
                                && token.getOperator().associativity == Associativity.LEFT))) {
                            if (stack.getLast().getType() == TokenType.LEFT_PAREN) {
                                stack.removeLast();
                            } else {
                                queue.add(stack.removeLast());
                            }
                        }
                        if (!stack.isEmpty() && stack.getLast().getType() == TokenType.FUNCTION) {
                            queue.add(stack.removeLast());
                        }
                        stack.add(token);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            if (stack.getLast().getType() == TokenType.LEFT_PAREN) {
                stack.removeLast();
            } else {
                queue.add(stack.removeLast());
            }
        }
        this.postfixTokens = queue;
        return postfixTokens;
    }
}