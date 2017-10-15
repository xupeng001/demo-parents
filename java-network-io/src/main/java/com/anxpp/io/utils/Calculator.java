package com.anxpp.io.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public final class Calculator {
    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

    public static Object cal(String expression) throws ScriptException {
        return jse.eval(expression);
    }

    public static void main(String[] args) {
        try {
            System.out.println(cal("1+2%3"));
        } catch (ScriptException e) {
        }
    }
}
