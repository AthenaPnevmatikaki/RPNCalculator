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
            this.st.push((Double) this.st.pop() + (Double) this.st.pop());
        }
        catch (EmptyStackException ex) {
            CalculatorGui.display.setText("Not enough operands!");
        }
    }
}