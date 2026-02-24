package com.dylan.calculator.util.enums;

public enum Operator {
    ADD("+", 1, Associativity.LEFT),
    SUBTRACT("-", 1, Associativity.LEFT),
    MULTIPLY("*", 2, Associativity.LEFT),
    DIVIDE("/", 2, Associativity.LEFT),
    POWER("^", 3, Associativity.RIGHT);

    public final String symbol;
    public final int precedence;
    public final Associativity associativity;

    Operator(String symbol, int precedence, Associativity associativity) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.associativity = associativity;
    }
}
