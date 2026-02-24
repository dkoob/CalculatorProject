package com.dylan.calculator.util.enums;

import java.util.regex.Pattern;

public enum TokenType {
    NUMBER("\\d+(\\.\\d+)?"),
    OPERATOR("[+\\-*/^]"),
    FUNCTION("[a-zA-Z_][a-zA-Z0-9_]*"),
    LEFT_PAREN("\\("),
    RIGHT_PAREN("\\)"),
    COMMA(",");

    private final Pattern pattern;

    TokenType(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public Pattern getPattern() {
        return pattern;
    }
}
