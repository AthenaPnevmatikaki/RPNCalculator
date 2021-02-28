package rpn;

import rpn.engine.*;
import rpn.gui.CalculatorGui;

import java.util.Stack;

public class Calc {

    public static Stack<Double> stack = new Stack<>();

    public static void main(String[] args){
        Adder adder = new Adder(stack);
        Subtractor subtractor = new Subtractor(stack);
        Multiplier multiplier = new Multiplier(stack);
        Divider divider = new Divider(stack);
        ResultPresenter resultPresenter = new ResultPresenter(stack);
        Operand operand = new Operand(stack);

        new CalculatorGui(operand, adder, subtractor, multiplier, divider, resultPresenter);
    }
}
