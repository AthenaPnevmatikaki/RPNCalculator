package rpn.gui;

import java.awt.*;
import java.awt.event.*;

import rpn.engine.*;


public class CalculatorGui extends Frame
{
    public static Operand op;
    public static Adder add;
    public static Subtractor sub;
    public static Multiplier mult;
    public static Divider div;
    public static ResultPresenter rp;
    public static Frame window;
    public static TextField display;

    private Button addButton(String name, int x, int y, int width, Color color, ActionListener listener) {
        Button button = new Button(name);
        button.setBounds(x, y, width, 28);
        button.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        button.setForeground(color);
        button.addActionListener(listener);
        CalculatorGui.window.add(button);
        return button;
    }

    public CalculatorGui(Operand op, Adder add, Subtractor sub, Multiplier mult, Divider div, ResultPresenter rp)
    {
        CalculatorGui.op = op;
        CalculatorGui.add = add;
        CalculatorGui.sub = sub;
        CalculatorGui.mult = mult;
        CalculatorGui.div = div;
        CalculatorGui.rp = rp;

        window = new Frame("CALC Activity 4");

        window.setLayout(null);
        window.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        window.setBackground(Color.blue);

        addButton("0", 64, 265, 35, Color.blue, new ButtonDigitHandler('0'));
        addButton("1", 64, 232, 35, Color.blue, new ButtonDigitHandler('1'));
        addButton("2", 104, 232, 35, Color.blue, new ButtonDigitHandler('2'));
        addButton("3", 144, 232, 35, Color.blue, new ButtonDigitHandler('3'));
        addButton("4", 64, 199, 35, Color.blue, new ButtonDigitHandler('4'));
        addButton("5", 104, 199, 35, Color.blue, new ButtonDigitHandler('5'));
        addButton("6", 144, 199, 35, Color.blue, new ButtonDigitHandler('6'));
        addButton("7", 64, 166, 35, Color.blue, new ButtonDigitHandler('7'));
        addButton("8", 104, 166, 35, Color.blue, new ButtonDigitHandler('8'));
        addButton("9", 144, 166, 35, Color.blue, new ButtonDigitHandler('9'));
        addButton("ENTER", 204, 100, 56, Color.white, new ButtonEnterHandler()).setBackground(Color.red);
        addButton("BackSpace", 64, 100, 75, Color.red, new ButtonBackSpaceHandler());
        addButton("C", 144, 133, 35, Color.red, new ButtonClearAllHandler());
        addButton("CE", 144, 100, 35, Color.red, new ButtonClearHandler());
        addButton("+", 195, 265, 35, Color.blue, new ButtonPlusHandler());
        addButton("-", 195, 232, 35, Color.blue, new ButtonMinusHandler());
        addButton("*", 195, 232-33, 35, Color.blue, new ButtonMultHandler());
        addButton("/", 195, 232-66, 35, Color.blue, new ButtonDivHandler());
        addButton("=", 235, 265, 35, Color.blue, new ButtonResultPresenterHandler());

        //D  I  S  P  L  A  Y     S  E  T  T  I  N  G  S
        display = new TextField("0");
        display.setEditable(false);
        display.setBounds(13, 55, 257, 30);

        //W  I  N  D  O  W     S  E  T  T  I  N  G  S
        window.add(display);
        window.setSize(283,320);
        window.setLocation(40,80);
        //window.show();
        window.setVisible(true);
        window.setResizable(false);
        window.addWindowListener(new CloseWindowAndExit());

    }
}


class CloseWindowAndExit extends WindowAdapter
{
    public void windowClosing(WindowEvent closeWindowAndExit)
    {
        System.exit(0);
    }
}


class ButtonDigitHandler implements ActionListener {
    private final char digit;

    public ButtonDigitHandler(char digit) {
        this.digit = digit;
    }

    public void actionPerformed(ActionEvent pushingButton0)
    { CalculatorGui.op.addDigit(digit); }
}


class ButtonEnterHandler implements ActionListener
{
    public ButtonEnterHandler() { }

    public void actionPerformed(ActionEvent pushingButtonEnter)
    { CalculatorGui.op.complete(); }
}


class ButtonBackSpaceHandler implements ActionListener
{
    public ButtonBackSpaceHandler() { }

    public void actionPerformed(ActionEvent pushingButtonBackSpace)
    { CalculatorGui.op.deleteLastDigit(); }
}


class ButtonClearAllHandler implements ActionListener
{
    public ButtonClearAllHandler() { }

    public void actionPerformed(ActionEvent pushingButtonClearAll)
    {
        CalculatorGui.op.reset();
        rpn.Calc.stack.removeAllElements();
    }
}


class ButtonClearHandler implements ActionListener
{
    public ButtonClearHandler() { }

    public void actionPerformed(ActionEvent pushingButtonClear)
    { CalculatorGui.op.reset(); }
}


class ButtonPlusHandler implements ActionListener
{
    public ButtonPlusHandler() { }

    public void actionPerformed(ActionEvent pushingButtonPlus)
    { CalculatorGui.add.operate(); }
}


class ButtonMinusHandler implements ActionListener
{
    public ButtonMinusHandler() { }

    public void actionPerformed(ActionEvent pushingButtonMinus)
    { CalculatorGui.sub.operate(); }
}


class ButtonMultHandler implements ActionListener
{
    public ButtonMultHandler() { }

    public void actionPerformed(ActionEvent pushingButtonPlus)
    { CalculatorGui.mult.operate(); }
}


class ButtonDivHandler implements ActionListener
{
    public ButtonDivHandler() { }

    public void actionPerformed(ActionEvent pushingButtonPlus)
    { CalculatorGui.div.operate(); }
}


class ButtonResultPresenterHandler implements ActionListener
{
    public ButtonResultPresenterHandler() { }

    public void actionPerformed(ActionEvent pushingButtonResultPresenter)
    { CalculatorGui.rp.operate(); }
}



