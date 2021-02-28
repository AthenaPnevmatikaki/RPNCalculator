package rpn.engine;

import rpn.gui.CalculatorGui;

import java.util.EmptyStackException;
import java.util.Stack;

public class ResultPresenter {
    Stack<Double> st;

    public ResultPresenter(Stack<Double> st) {
        this.st = st;
    }

    public void operate() {
        try {
            String str = ((Double)this.st.pop()).toString();
            System.out.println(str);
            CalculatorGui.display.setText(str);
        }
        catch (EmptyStackException ex){
            CalculatorGui.display.setText("Nothing to display!");
        }
    }
}