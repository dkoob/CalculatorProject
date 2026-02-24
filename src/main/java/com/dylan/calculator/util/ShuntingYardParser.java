package com.dylan.calculator.util;

import com.dylan.calculator.util.enums.Operator;

import java.util.HashMap;
import java.util.Map;

public class ShuntingYardParser {
    public String parseInfixExpression(Calculation calculation) {
        return "a";
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