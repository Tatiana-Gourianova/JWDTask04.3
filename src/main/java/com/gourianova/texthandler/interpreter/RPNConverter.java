package com.gourianova.texthandler.interpreter;

import java.util.ArrayDeque;


public class RPNConverter {

    public String convert(String expression, int x, int y) {
        expression = expression.replaceAll("i\\-\\-", String.valueOf(x));
        expression = expression.replaceAll("\\-\\-i", String.valueOf(x - 1));
        expression = expression.replaceAll("j\\-\\-", String.valueOf(y));
        expression = expression.replaceAll("\\-\\-j", String.valueOf(y - 1));
        expression = expression.replaceAll("i\\+\\+", String.valueOf(x));
        expression = expression.replaceAll("\\+\\+i", String.valueOf(x + 1));
        expression = expression.replaceAll("j\\+\\+", String.valueOf(y));
        expression = expression.replaceAll("\\+\\+j", String.valueOf(y + 1));

        StringBuilder output = new StringBuilder("");
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            Character currentChar = expression.charAt(i);

            if (Character.isDigit(currentChar)) {
                output.append(currentChar);
            } else if (currentChar.equals('-')) {
                if (i == 0 || expression.charAt(i - 1) == '(') {
                    output.append("0 ");
                }
                output.append(' ');
                while (!stack.isEmpty() && (stack.peekFirst().equals('*') || stack.peekFirst().equals('/')
                        || stack.peekFirst().equals('+'))) {
                    output.append(stack.pop());
                    output.append(' ');
                }
                stack.push(currentChar);
            } else if (currentChar.equals('+')) {
                output.append(' ');
                while (!stack.isEmpty() && (stack.peekFirst().equals('*') || stack.peekFirst().equals('/')
                        || stack.peekFirst().equals('-'))) {
                    output.append(stack.pop());
                    output.append(' ');
                }
                stack.push(currentChar);
            } else if (currentChar.equals('(')) {
                stack.push(currentChar);
            } else if (currentChar.equals('/')) {
                output.append(' ');
                while (!stack.isEmpty() && stack.peekFirst().equals('*')) {
                    output.append(stack.pop());
                    output.append(' ');
                }
                stack.push(currentChar);
            } else if (currentChar.equals('*')) {
                output.append(' ');
                while (!stack.isEmpty() && stack.peekFirst().equals('/')) {
                    output.append(stack.pop());
                    output.append(' ');
                }
                stack.push(currentChar);
            } else if (currentChar.equals(')')) {
                output.append(' ');
                while (!stack.peekFirst().equals('(')) {
                    output.append(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            output.append(' ');
            output.append(stack.pop());
        }

        return output.toString();
    }


}
