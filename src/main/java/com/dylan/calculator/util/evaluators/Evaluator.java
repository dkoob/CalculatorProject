package com.dylan.calculator.util.evaluators;

import com.dylan.calculator.util.Token;
import com.dylan.calculator.util.results.Result;
import java.util.List;

public abstract class Evaluator {
    public abstract Result evaluate(List<Token> postfixTokens);
}
