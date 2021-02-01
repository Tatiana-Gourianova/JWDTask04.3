package com.gourianova.texthandler.interpreter;


public class TerminalExpressionPlus extends AbstractMathExpression {
    @Override
    public void interpret(RPNContext context) {
        context.pushValue(context.popValue() + context.popValue());
    }
}
