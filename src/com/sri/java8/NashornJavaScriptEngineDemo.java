package com.sri.java8;

/**
 * Copyright (c) 2024 Srikanth Pula. All rights reserved.
 *
 * @author Srikanth Pula
 * Date: 26-08-2024
 */

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Demonstrates the usage of the Nashorn JavaScript Engine in Java.
 *
 * Nashorn is a JavaScript engine that was introduced in Java 8. It allows you to execute JavaScript code
 * directly from your Java application. Nashorn is a replacement for the older Rhino engine and provides
 * better performance and support for ECMAScript 5.1.
 *
 * Note: Nashorn has been deprecated in Java 11 and removed in Java 15.
 */
public class NashornJavaScriptEngineDemo {

    public static void main(String[] args) {
        // Create a ScriptEngineManager to manage script engines
        ScriptEngineManager manager = new ScriptEngineManager();

        // Get the Nashorn JavaScript engine
        ScriptEngine engine = manager.getEngineByName("nashorn");

        // Check if Nashorn engine is available
        if (engine == null) {
            System.out.println("Nashorn JavaScript Engine not found. Please ensure you're running this on a Java 8-14 environment.");
            return;
        }

        // 1. Evaluating JavaScript code
        /**
         * Example 1: Evaluating simple JavaScript code.
         * The eval() method is used to execute JavaScript code passed as a string.
         */
        try {
            engine.eval("print('Hello from JavaScript')");
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        // 2. JavaScript with variables
        /**
         * Example 2: Executing JavaScript code with variables.
         * JavaScript code can interact with variables defined in the script.
         */
        String script = "var x = 10; var y = 20; var result = x + y; print('Result: ' + result);";
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        // 3. Using Java objects in JavaScript
        /**
         * Example 3: Using Java objects within JavaScript code.
         * You can pass Java objects to JavaScript and use them in the script.
         */
        engine.put("message", "Hello, Nashorn!");
        try {
            engine.eval("print(message);");
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        // 4. Returning values from JavaScript
        /**
         * Example 4: Returning values from JavaScript to Java.
         * JavaScript code can return values that can be captured in Java.
         */
        String scriptReturn = "var x = 10; var y = 30; x + y;";
        try {
            Object result = engine.eval(scriptReturn);
            System.out.println("Result from JavaScript: " + result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        // 5. Invoking JavaScript functions
        /**
         * Example 5: Defining and invoking a JavaScript function.
         * JavaScript functions can be defined in the script and then invoked from Java.
         */
        String functionScript = "function greet(name) { return 'Hello, ' + name; }";
        try {
            engine.eval(functionScript);
            Object result = engine.eval("greet('World')");
            System.out.println("Greeting from JavaScript: " + result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}

