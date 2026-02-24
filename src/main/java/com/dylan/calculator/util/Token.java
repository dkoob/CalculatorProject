package com.dylan.calculator.util;

import com.dylan.calculator.util.enums.TokenType;

public class Token {
    private final TokenType type;
    private final String text;
    private final double value;

    public Token(TokenType type, String text) {
        this(type, text, Double.NaN);
    }

    public Token(TokenType type, String text, double value) {
        this.type = type;
        this.text = text;
        this.value = value;
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

    @Override
    public String toString() {
        return "TokenType: " + getType() + " String " + getText() + " Value: " + getValue();
    }
}

