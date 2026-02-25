package com.dylan.calculator.util;

import com.dylan.calculator.util.enums.Operator;
import com.dylan.calculator.util.enums.TokenType;

public class Token {
    private final TokenType type;
    private final String text;
    private final double value;
    private final Operator operator;

    public Token(TokenType type, String text) {
        this(type, text, Double.NaN, null);
    }

    public Token(TokenType type, String text, double value) {
        this(type, text, value, null);
    }

    public Token(TokenType type, String text, Operator operator) {
        this(type, text, Double.NaN, operator);
    }

    public Token(TokenType type, String text, double value, Operator operator) {
        this.type = type;
        this.text = text;
        this.value = value;
        this.operator = operator;
    }

    public TokenType getType() {
        return this.type;
    }

    public String getText() {
        return this.text;
    }

    public double getValue() {
        return this.value;
    }

    public Operator getOperator() {
        return this.operator;
    }

    @Override
    public String toString() {
        return "TokenType: " + getType() + " String " + getText() + " Value: " + getValue() + " " + (getOperator() == null ? "Operator: null" : getOperator().toString());
    }
}

