package com.dylan.calculator.util.results;

public class RealResult implements Result {
    private final double result;

    public RealResult(double result) {
        this.result = result;
    }

    public double  getResult() {
        return result;
    }

    @Override
    public String toString() {
        return Double.toString(result);
    }
}
