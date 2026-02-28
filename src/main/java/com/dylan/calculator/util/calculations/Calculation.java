package com.dylan.calculator.util.calculations;

import com.dylan.calculator.util.Token;
import com.dylan.calculator.util.results.Result;
import javafx.animation.ScaleTransition;

import java.util.List;

abstract class Calculation {
    protected String expression;

    public Calculation(String expression) {
        this.expression = expression;
    }

    public abstract Result evaluate();
}