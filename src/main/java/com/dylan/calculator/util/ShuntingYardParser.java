package com.dylan.calculator.util;

import java.util.HashMap;
import java.util.Map;

public class ShuntingYardParser {
    public String parseInfixExpression(Calculation calculation) {
        return "a";
    }
}

enum Associativity {
    LEFT,
    RIGHT
}

enum Operator {
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

class Operators {
    public static final Map<String, Operator> BY_SYMBOL = new HashMap<>();

    static {
        for (Operator op : Operator.values()) {
            BY_SYMBOL.put(op.symbol, op);
        }
    }
}