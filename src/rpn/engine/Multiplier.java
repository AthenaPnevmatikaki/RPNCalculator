package rpn.engine;

import rpn.gui.CalculatorGui;

import java.util.EmptyStackException;
import java.util.Stack;

public class Multiplier {
    Stack<Double> st;

    public Multiplier(Stack<Double> st) {
        this.st = st;
    }

    public void operate() {
        try {
            this.st.push(this.st.pop() * this.st.pop());
        }
        catch (EmptyStackException ex) {
            CalculatorGui.display.setText("Not enough operands!");
        }
    }
}
