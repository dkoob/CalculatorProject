package com.dylan.calculator.util;
import com.dylan.calculator.util.enums.Operator;
import com.dylan.calculator.util.enums.TokenType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Lexer {
    private String input;
    private int currentPosition;
    private ArrayList<String> untokenizedList = new ArrayList<>();

    public Lexer(String input) {
        this.input = input;
        this.currentPosition = 0;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isWhitespace(ch)) {
                continue;
            }

            if (Character.isDigit(ch) || ch == '.') {
                buffer.append(ch);
                while (i + 1 < input.length() && (Character.isDigit(input.charAt(i + 1)) || input.charAt(i + 1) == '.')) {
                    buffer.append(input.charAt(++i));
                }
                untokenizedList.add(buffer.toString());
                buffer.setLength(0);
                continue;
            }

            if (Character.isLetter(ch)) {
                buffer.append(ch);
                while (i + 1 < input.length() && Character.isLetterOrDigit(input.charAt(i + 1))) {
                    buffer.append(input.charAt(++i));
                }
                untokenizedList.add(buffer.toString());
                buffer.setLength(0);
                continue;
            }

            if (ch == '-' && (Character.isDigit(input.charAt(i + 1)) || input.charAt(i + 1) == '.')) {
                buffer.append(ch);
                while (i + 1 < input.length() && (Character.isDigit(input.charAt(i + 1)) || input.charAt(i + 1) == '.')) {
                    buffer.append(input.charAt(++i));
                }
                int peekIndex = i + 1;
                while (peekIndex < input.length() && Character.isWhitespace(input.charAt(peekIndex))) {
                    peekIndex++;
                }
                if (i + 2 < input.length() && input.charAt(peekIndex) == '^') {
                    String digit = buffer.toString().replace("-", "");
                    buffer.setLength(0);
                    untokenizedList.add("NEG");
                    buffer.append(digit);
                    untokenizedList.add(buffer.toString());
                    buffer.setLength(0);
                    continue;
                }
                untokenizedList.add(buffer.toString());
                buffer.setLength(0);
                continue;
            }

            if (ch == '-' && (i == 0 || input.charAt(i - 2) == '(' || !Character.isLetterOrDigit(input.charAt (i - 2)))) {
                untokenizedList.add("NEG");
                continue;
            }

            untokenizedList.add(String.valueOf(ch));
        }
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (currentPosition < untokenizedList.size()) {
            Token token = findToken();
            if (token != null) {
                tokens.add(token);
            } else {
                throw new RuntimeException("Unknown token: " + untokenizedList.get(currentPosition));
            }
        }
        return tokens;
    }

    private Token findToken() {
        if (currentPosition >= untokenizedList.size()) {
            return null;
        }

        String lexeme = untokenizedList.get(currentPosition);

        if (lexeme.equals("NEG")) {
            currentPosition++;
            return new Token(TokenType.NEGATIVE_OPERATOR, lexeme, Operator.NEG);
        }

        for (TokenType type : TokenType.values()) {
            Matcher matcher = type.getPattern().matcher(lexeme);
            if (matcher.matches()) {
                currentPosition++;

                if (type == TokenType.OPERATOR || type == TokenType.FUNCTION) {
                    Operator op = Operators.BY_SYMBOL.get(lexeme);
                    if (op == null) {
                        throw new RuntimeException("Unknown operator: " + lexeme);
                    }
                    return new Token(type, lexeme, op);
                }

                if (type == TokenType.NUMBER) {
                    return new Token(type, Double.parseDouble(lexeme));
                }
                return new Token(type, lexeme);
            }
        }
        return null;
    }
}