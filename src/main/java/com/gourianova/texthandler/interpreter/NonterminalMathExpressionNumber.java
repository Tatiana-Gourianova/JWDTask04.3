package com.gourianova.texthandler.interpreter;


public class NonterminalMathExpressionNumber extends AbstractMathExpression {

    private int number;
    public NonterminalMathExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(RPNContext context) {
        context.pushValue(number);
    }
}
