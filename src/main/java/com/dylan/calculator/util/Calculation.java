package com.dylan.calculator.util;

import com.dylan.calculator.util.enums.CalculationType;

public class Calculation {

    private final String expression;
    private final CalculationType calculationType;

    public Calculation(String expression, CalculationType type) {
        this.expression = expression;
        this.calculationType = type;
    }

    public String getExpression() {
        return this.expression;
    }

    public CalculationType getCalculationType() {
        return this.calculationType;
    }
}