package com.dylan.calculator.util;
import com.dylan.calculator.util.enums.TokenType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public class Lexer {
    private String input;
    private int currentPosition;
    private String[] untokenizedList;

    public Lexer(String input) {
        this.input = input;
        this.currentPosition = 0;
        untokenizedList = input.split(" ");
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (currentPosition < untokenizedList.length) {
            Token token = findToken();
            if (token != null) {
                tokens.add(token);
            } else {
                throw new RuntimeException(
                        "Unknown token: " + untokenizedList[currentPosition]
                );
            }
        }
        return tokens;
    }

    private Token findToken() {
        if (currentPosition >= untokenizedList.length) {
            return null;
        }

        String lexeme = untokenizedList[currentPosition];

        for (TokenType type : TokenType.values()) {
            Matcher matcher = type.getPattern().matcher(lexeme);
            if (matcher.matches()) {
                currentPosition++;
                if (type == TokenType.NUMBER) {
                    return new Token(type, lexeme, Double.parseDouble(lexeme));
                }
                return new Token(type, lexeme);
            }
        }
        return null;
    }
}