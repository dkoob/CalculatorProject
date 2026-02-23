package com.dylan.calculator.util;

public class Calculation {

    private final String expression;
    private final String calculationType;

    public Calculation(String expression, String calculationType) {
        this.expression = expression;
        this.calculationType = calculationType;
    }

    public String getExpression() {
        return this.expression;
    }

    public String getCalculationType() {
        return this.calculationType;
    }
}
