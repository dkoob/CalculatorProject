package com.dylan.calculator.util.enums;

public enum Operator {
    ADD("+", 1, 2, Associativity.LEFT),
    SUBTRACT("-", 1, 2, Associativity.LEFT),
    MULTIPLY("*", 2, 2, Associativity.LEFT),
    DIVIDE("/", 2, 2, Associativity.LEFT),
    NEG("NEG", 3, 1, Associativity.RIGHT),
    POWER("^", 4, 2, Associativity.RIGHT),
    SIN("SIN", 5, 1, Associativity.RIGHT),
    COS("COS", 5, 1, Associativity.RIGHT),
    TAN("TAN", 5, 1, Associativity.RIGHT),
    SQRT("SQRT", 5, 1, Associativity.RIGHT),
    LOG("LOG", 5, 1, Associativity.RIGHT);


    public final String symbol;
    public final int precedence;
    public final int arity;
    public final Associativity associativity;

    Operator(String symbol, int precedence, int arity, Associativity associativity) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.arity = arity;
        this.associativity = associativity;
    }

    @Override
    public String toString() {
        return "Operator: {Symbol: " + this.symbol + " Precedence: " + this.precedence + " Arity: " + this.arity + " Associativity: " + this.associativity + "}";
    }
}
