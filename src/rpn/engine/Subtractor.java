package rpn.engine;

import rpn.gui.CalculatorGui;

import java.util.EmptyStackException;
import java.util.Stack;

public class Subtractor {
    Stack<Double> st;

    public Subtractor(Stack<Double> st) {
        this.st = st;
    }

    public void operate() {
        try {
            Double d = (Double)this.st.pop();
            this.st.push((Double)this.st.pop() - d);
        }
        catch (EmptyStackException ex) {
            CalculatorGui.display.setText("Not enough operands!");
        }
    }
}
