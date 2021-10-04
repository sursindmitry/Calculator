package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CalcPanel extends JPanel {
    private JPanel panel = new JPanel();
    private boolean start;
    private String lastCommand;
    private JButton display;
    private double result;

    public CalcPanel(){
        super();
        start = true;
        lastCommand = "=";
        result = 0;

        setLayout(new BorderLayout());
        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        InsertAction insert = new InsertAction();
        ComandAction command = new ComandAction();

        addButton("7",insert);
        addButton("8",insert);
        addButton("9",insert);
        addButton("/",command);

        addButton("4",insert);
        addButton("5",insert);
        addButton("6",insert);
        addButton("*",command);

        addButton("1",insert);
        addButton("2",insert);
        addButton("3",insert);
        addButton("-",command);

        addButton("0",insert);
        addButton(".",insert);
        addButton("=",command);
        addButton("+",command);


        add(panel,BorderLayout.CENTER);

    }

    private  void addButton(String lable, ActionListener listener){
        JButton button = new JButton(lable);
        button.addActionListener(listener);
        panel.add(button);
    }
    
    private class InsertAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            String input = ae.getActionCommand();
            if(start){
                display.setText("");
                start=false;
            }
            if (!Objects.equals(input, ".") || !display.getText().contains("."))
                display.setText(display.getText() + input);

        }
    }

    private class ComandAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){

            String command = ae.getActionCommand();
            if (start){
                lastCommand = command;
            }
            else{
                calc(Double.parseDouble(display.getText()));
                lastCommand = command;
                start=true;
            }
        }

        public void calc(double x){
            switch (lastCommand) {
                case "+":
                    result += x;
                    break;
                case "-":
                    result -= x;
                    break;
                case "*":
                    result *= x;
                    break;
                case "/":
                    result /= x;
                    break;
                case "=":
                    result = x;
                    break;
            }
            display.setText("" + result);
        }
    }

}
