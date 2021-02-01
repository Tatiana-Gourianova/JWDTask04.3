package com.gourianova.texthandler.interpreter;

import java.util.ArrayDeque;


public class RPNContext {
    private ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    public Integer popValue(){
        return contextValues.pop();
    }

    public void pushValue(Integer value){
        contextValues.push(value);
    }


}
