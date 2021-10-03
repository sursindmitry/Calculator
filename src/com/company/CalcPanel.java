package com.company;

import javax.swing.*;
import java.awt.*;

public class CalcPanel extends JPanel {
    JPanel panel = new JPanel();

    public CalcPanel(){
        super();
        setLayout(new BorderLayout());
        JButton dispaly = new JButton("0");
        dispaly.setEnabled(false);
        add(dispaly, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        addButton("7");
        addButton("8");
        addButton("9");
        addButton("/");

        addButton("4");
        addButton("5");
        addButton("6");
        addButton("*");

        addButton("1");
        addButton("2");
        addButton("3");
        addButton("-");

        addButton("0");
        addButton(".");
        addButton("=");
        addButton("+");


        add(panel,BorderLayout.CENTER);

    }

    private  void addButton(String lable){
        JButton button = new JButton(lable);
        panel.add(button);
    }

}
