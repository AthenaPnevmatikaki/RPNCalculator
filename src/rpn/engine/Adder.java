package rpn.engine;

import rpn.gui.CalculatorGui;

import java.util.EmptyStackException;
import java.util.Stack;

public class Adder {
    Stack<Double> st;

    public Adder(Stack<Double> st) {
        this.st = st;
    }

    public void operate() {
        try {
            this.st.push(this.st.pop() + this.st.pop());
        }
        catch (EmptyStackException ex) {
            CalculatorGui.display.setText("Not enough operands!");
        }
    }
}