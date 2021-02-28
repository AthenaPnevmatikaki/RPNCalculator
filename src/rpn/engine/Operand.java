package rpn.engine;

import rpn.gui.CalculatorGui;

import java.util.Stack;

public class Operand {
    Stack<Double> st;
    private StringBuffer sb = new StringBuffer();

    public Operand(Stack<Double> st) {
        this.st = st;
    }

    private void showVal() {
        System.out.println(this.sb);
        CalculatorGui.display.setText(this.sb.toString());
    }

    public void addDigit(char digit) {
        this.sb.append(digit);
        this.showVal();
    }

    public void deleteLastDigit() {
        if (this.sb.length() > 0) {
            this.sb.deleteCharAt(this.sb.length() - 1);
            this.showVal();
        }

    }

    public void reset() {
        this.sb.setLength(0);
        this.showVal();
        this.st.removeAllElements();
    }

    public void complete() {
        if (this.sb.length() > 0) {
            this.st.push(Double.parseDouble(this.sb.toString()));
            this.sb.delete(0, this.sb.length());
            this.showVal();
        }

    }
}
